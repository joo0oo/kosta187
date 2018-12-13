package pattern2;

import java.sql.*;
import java.util.*;
/**
 * 사용자 정의 ConnectionPooling 구현 클래스
 * Singleton 패턴 적용
 */
public class UserConnectionPool{
	
	private static final String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:XE";
	private static final String USER_ID = "hr";
	private static final String USER_PW = "hr";
	
	private static final int INITIAL_CONNECTIONS = 5; //최초에는 커넥션을 5개 만들기 위해
	private static final int INCREMENT = 2;
	
	private static Hashtable<Connection, Boolean> connections;

	private static UserConnectionPool instance;
	
	/** 직접 생성하지 못하도록 private 선언 : 싱글톤 패턴 */
	private UserConnectionPool() throws Exception{
		Class.forName(DB_DRIVER);
		connections = new Hashtable<Connection, Boolean>();		
		// 커넥션 생성 및 저장
		for(int i = 0; i < INITIAL_CONNECTIONS; i++){ //Connection 5개를 미리 만들어둔다
			connections.put(DriverManager.getConnection(DB_URL, USER_ID, USER_PW), Boolean.FALSE);
			//false = 아직 빌려가지 않은 상태
			//true = 이 Connection을 누가 빌려간 상태
		}
	}
	
	// 싱글톤 패턴이므로 생성자를 밖에서 부를수 없음-> 밖에서 이 클래스 조회하기 위한 static 메서드 선언
	public static UserConnectionPool getInstance() throws Exception{
		if(instance == null){ //아직 생성되지 않았으면 생성한다
			synchronized (UserConnectionPool.class) { //생성시 동시접근을 고려해서 synchronized처리
				instance = new UserConnectionPool();
			}
		}
		return instance;
	}

	/** 사용중이지 않는 Connection 반환 (Connection 빌려주기)*/
	public  Connection getConnection() throws SQLException{
		Enumeration<Connection> cons = connections.keys();		
		while(cons.hasMoreElements()){
			Connection con = cons.nextElement();
			Boolean use = connections.get(con);				
			// 사용중이지 않은 경우...
			if (use == Boolean.FALSE){
				connections.put(con, true); //사용중으로 표시 변경
				return con;
			}
		} 
		
		//if()에 걸리지 않고 while() 통과 -> 이미 모든 Connection이 사용중인 경우 
		// Connection 새로 만들기
		for(int i = 0; i < INCREMENT; i++){
			System.out.println("[디버깅] : 사용 가능한 커넥션이 없어서 새로운 Connection 생성>>");
			connections.put(DriverManager.getConnection(DB_URL, USER_ID, USER_PW), Boolean.FALSE);
		}
		// 재귀호출
		return getConnection();
	}


	/** 사용한 커넥션 반납 */
	public void releaseConnection(Connection usedConnection){
		Connection con = null;
		Enumeration<Connection> e = connections.keys();
		while (e.hasMoreElements()){
			con = (Connection)e.nextElement();			
			if (con == usedConnection){
				connections.put(con, Boolean.FALSE); //반납으로 표시 변경
				break;
			}
		}
	}

	/** 저장된 모든 Connection 닫기 */
	public void closeAll(){
		Enumeration<Connection> cons = connections.keys();		
		while(cons.hasMoreElements()){
			Connection con = (Connection)cons.nextElement();
			try{
				con.close();
			}
			catch(Exception e) {}
		}
	}
	
	/** 테스트 */
	public static void main(String[] args) throws Exception {
		//UserConnectionPool cp = new UserConnectionPool(); 에러
		UserConnectionPool cp = UserConnectionPool.getInstance(); //ConnectionPool은 한개만 존재하도록 한다
		// 커넥션 취득
		for(int i=0; i<10; i++) {
			Connection con = cp.getConnection();
			System.out.println(con);
			cp.releaseConnection(con);
		}
	}
}
