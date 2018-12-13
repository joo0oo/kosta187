import java.sql.Connection;
import java.sql.Date;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import oracle.jdbc.OracleDriver;
/**
 * 동적 SQL 실행
 * @author 송주현
 *
 */
public class DynamicSQLExample {
	String driver="oracle.jdbc.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:xe";
	String userName="hr";
	String passWd="hr";
	
	public void executeSQL(String sql) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver).newInstance();
			// #.2 DBMS 연결
			con = DriverManager.getConnection(url, userName, passWd);
			pstmt= con.prepareStatement(sql); // sql을 위한 전처리
			boolean existRS= pstmt.execute(); //ResultSet이 존재하는지 여부리턴
			
			if(existRS) {
				//resultSet이 존재하면 sql은 select였음
				rs= pstmt.getResultSet(); 
				ResultSetMetaData rsm= rs.getMetaData(); //이 resultSet의 스키마(구조)를 리턴
				
				String resStr="";
				int resInt=0;
				
				/*
				for(int i=1; i<rsm.getColumnCount(); i++) {
					System.out.print(rsm.getColumnLabel(i)+"\t");
				}
				System.out.println();
				
				while(rs.next()) {
					
					for(int i=1; i<rsm.getColumnCount(); i++) {
						String col= rsm.getColumnLabel(i);
						System.out.print(rs.getString(col)+"\t");
					}
					System.out.println();
				}
				*/
				
				while(rs.next()) {
					
					for(int i=1; i <= rsm.getColumnCount(); i++) {
					
						String str= rsm.getColumnTypeName(i);
						rsm.getColumnName(i);
						
						switch(str) {
						case "String":
							resStr=rs.getString(i);
							System.out.print(resStr);
							break;
						case "Int":
							resInt=rs.getInt(i);
							System.out.print(resInt);
							break;
						default:
							System.out.print(rs.getString(i));
							break;
						}
						System.out.print(" , ");
											}
					System.out.println();
					
					
					/*
					String employeeID= rs.getString("id");
					String lastName= rs.getString("ename");
					int salary= rs.getInt("salary");
					String hiredate= rs.getString("hiredate");
					String dname= rs.getString("dname");
					
					System.out.println(employeeID+", "+lastName+", "+salary+", "+hiredate+", "+dname);
					*/
				}
				
			} else {
				//resultSet이 존재하지 않으면 sql은 insert/delete같은 작업이었음
				int count= pstmt.getUpdateCount(); 
				System.out.println(count+ " 행이 변경되었습니다");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				//순서대로 close
				if( rs!= null)
					rs.close();
				if( pstmt!= null)
					pstmt.close();
				if( con!= null)
					con.close();
			} catch (Exception e) {
			
			}
		
		}
	}

	public static void main(String[] args) {
		
		DynamicSQLExample dyEx= new DynamicSQLExample();
		String sql= "SELECT * from employees "; 
		dyEx.executeSQL(sql);
	}

}
