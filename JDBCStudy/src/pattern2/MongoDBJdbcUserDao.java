package pattern2;

import java.sql.Connection;

public class MongoDBJdbcUserDao extends JdbcUserDao{

	@Override
	public Connection getConnection() throws Exception {
		// MongoDB에 맞게 Connection 생성 코드 
		
		return null;
	}

}
