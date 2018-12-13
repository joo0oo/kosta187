import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

import oracle.jdbc.OracleDriver;
/**
 * 동적 SQL 실행
 * @author 송주현
 *
 */
public class ProcedureCallExample {
	String driver="oracle.jdbc.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:xe";
	String userName="hr";
	String passWd="hr";
	
	public void procedureCallSQL(int employeeID) {
		Connection con = null;
		CallableStatement cstmt = null;
		ResultSet rs = null;
		
		String sql="{call getEmployee(?,?,?,?)}";
		
		try {
			Class.forName(driver).newInstance();
			con = DriverManager.getConnection(url, userName, passWd);
			cstmt= con.prepareCall(sql); 
			
			cstmt.setInt(1, employeeID);
			cstmt.registerOutParameter(2, Types.INTEGER);
			cstmt.registerOutParameter(3, Types.VARCHAR);
			cstmt.registerOutParameter(4, Types.INTEGER);
			
			cstmt.execute();
			
			
			int employeeID2= cstmt.getInt(2);
			String firstName= cstmt.getString(3);
			int salary= cstmt.getInt(4);
			
			System.out.println(employeeID2+"\t"+firstName+"\t"+salary);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if( rs!= null)
					rs.close();
				if( cstmt!= null)
					cstmt.close();
				if( con!= null)
					con.close();
			} catch (Exception e) {
			
			}
		
		}
	}

	public static void main(String[] args) {
		
		ProcedureCallExample dyEx= new ProcedureCallExample();
		//String sql= "SELECT * from employees "; 
		dyEx.procedureCallSQL(207);
	}

}
