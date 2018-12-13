import java.sql.Connection;
import java.sql.Date;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import oracle.jdbc.OracleDriver;

public class DQLExample {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
	
		//Class 클래스를 이용한 동적 객체 생성
		String driver="oracle.jdbc.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String userName="hr";
		String passWd="hr";
		
		String sql= "SELECT e.employee_id     id, \r\n" + 
					"       e.last_name       ename, \r\n" + 
					"       e.salary          salary, \r\n" + 
					"       TO_CHAR(hire_date,'YYYY-MM-DD HH24:MI:SS') hiredate, \r\n" + 
					"       d.department_name dname \r\n" + 
					"FROM   employees e \r\n" + 
					"       JOIN departments d \r\n" + 
					"         ON e.department_id = d.department_id "; 
		
		Class.forName(driver).newInstance();
		
		// #.2 DBMS 연결
		Connection con= null;
		Statement stmt= null;
		ResultSet rs=null;
		con= DriverManager.getConnection(url,userName,passWd);
		
		stmt= con.createStatement();
		rs= stmt.executeQuery(sql);
		
		while(rs.next()) {
			String employeeID= rs.getString("id");
			String lastName= rs.getString("ename");
			int salary= rs.getInt("salary");
			String hiredate= rs.getString("hiredate");
			String dname= rs.getString("dname");
			
			System.out.println(employeeID+", "+lastName+", "+salary+", "+hiredate+", "+dname);
		}
		
		rs.close();
		stmt.close();
		con.close();
		
	}

}
