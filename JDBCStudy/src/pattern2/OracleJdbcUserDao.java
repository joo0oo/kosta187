package pattern2;

import java.sql.Connection;
import java.sql.DriverManager;

import org.apache.commons.dbcp2.BasicDataSource;

public class OracleJdbcUserDao extends JdbcUserDao {
	//클래스 캡슐화
	private static final String driver="oracle.jdbc.OracleDriver";
	private static final String url="jdbc:oracle:thin:@localhost:1521:xe";
	private static final String userName="hr";
	private static final String passWd="hr";
	
	@Override
	public Connection getConnection() throws Exception {
		//이 DB에 맞는 방법으로 Conenction을 생성
		// 커넥션 풀 적용
	//	Class.forName(driver).newInstance();
	//	return DriverManager.getConnection(url, userName, passWd);
		
	//	return UserConnectionPool.getInstance().getConnection();
		
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(driver);
		dataSource.setUrl(url);
		dataSource.setUsername(userName);
		dataSource.setPassword(passWd);
		dataSource.setInitialSize(5);
		dataSource.setMaxTotal(10);
		dataSource.setMaxIdle(7);
		
		return dataSource.getConnection();
	}

}
