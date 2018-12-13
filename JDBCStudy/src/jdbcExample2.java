import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import oracle.jdbc.OracleDriver;

/**
 * driver 없이 
 * @author 송주현
 *
 */
public class jdbcExample2 {

	public static void main(String[] args) {
	
		String driver="oracle.jdbc.OracleDriver";
	

		/*
		try {
			Class.forName(driver);
			System.out.println("jdbc 드라이버 생성 완료");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		*/
		
		// DB연결에 필요한 세가지 : Connection/ Statement/ ResultSet
		Connection con= null;
		Statement stmt= null;
		ResultSet rs=null;
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String userName="hr";
		String passWd="hr";
		String sql="SELECT employee_id, last_name, salary\r\n" + 
				"FROM EMPLOYEES"; //java 코드 안에 sql 내장시키기 (java String을 DB가 query로 인식하지 못하기 때문에 Statement 거쳐야함)
		
		// #.2 DBMS 연결
		try {
			con= DriverManager.getConnection(url,userName,passWd);
			System.out.println("DBMS 연결 완료.."+con);
			
			// #.3 SQL 서버 전송 및 결과집합 수신
			stmt = con.createStatement(); 
			System.out.println(stmt);
			rs= stmt.executeQuery(sql); //java의 String을 SQL의 query로 보내기
			// executeQuery()는 결과값으로 query의 실행결과 리턴
			System.out.println(rs);
			
			while(rs.next()) {
//				rs.getString(1); //column의 index로 가져오는 방법은 권장사항은 아님 ->column 이름으로 가져오기
				String employeeID= rs.getString("employee_id");
				String lastName= rs.getString("last_name");
				int salary= rs.getInt("salary");
				
				System.out.println(employeeID+", "+lastName+", "+salary);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				//순서대로 close
				if( rs!= null)
					rs.close();
				if( stmt!= null)
					stmt.close();
				if( con!= null)
					con.close();
			} catch (Exception e) {
			
			}
		
		}
		
		
		
		

	}

}
