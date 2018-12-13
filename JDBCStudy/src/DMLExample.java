import java.sql.Connection;
import java.sql.Date;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

import oracle.jdbc.OracleDriver;

public class DMLExample {
   
   String driver="oracle.jdbc.OracleDriver";
   String url="jdbc:oracle:thin:@localhost:1521:xe";
   String userName="hr";
   String passWd="hr";
   
   public void create(String departmentName, int managerID, int locationID) {
	  String mID= "NULL"; 
	  String lID= "NULL";
	  if(managerID != 0) {
		  mID = String.valueOf(managerID);
	  }
	  if(locationID != 0) {
		  lID = String.valueOf(locationID);
	  }
	  
      String sql= "INSERT INTO departments \r\n" + 
            "            (department_id, \r\n" + 
            "             department_name, \r\n" + 
            "             manager_id, \r\n" + 
            "             location_id) \r\n" + 
            "VALUES     (departments_seq.nextval, \r\n" + 
            "            '"+departmentName+"', \r\n" + 
            "            "+mID+", \r\n" + 
            "            "+lID+") "; 
      
      Connection con= null;
      Statement stmt= null;
      
      try {
         Class.forName(driver).newInstance();
         con= DriverManager.getConnection(url,userName,passWd);
         con.setAutoCommit(false); //디폴트 true임 ->수행 후 바로 commit
         stmt= con.createStatement();
         int count= stmt.executeUpdate(sql); //변경된 행 갯수 리턴
         con.commit(); //commit은 try블록 안에서
         System.out.println(count+" 행이 추가됨");
      } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
         e.printStackTrace();
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         try {
            //순서대로 close
            if( stmt!= null)
               stmt.close();
            if( con!= null)
               con.close();
         } catch (Exception e) {
         
         }      
      }
   }

   // 좋은방법
   public void create2(String departmentName, int managerID, int locationID) {
		create2(new Department(0, departmentName, managerID, locationID)); 
	   
	   /*
	      String sql= "INSERT INTO departments \r\n" + 
	            "            (department_id, \r\n" + 
	            "             department_name, \r\n" + 
	            "             manager_id, \r\n" + 
	            "             location_id) \r\n" + 
	            "VALUES     (departments_seq.nextval, \r\n" + 
	            "            ?, \r\n" + 
	            "            ?, \r\n" + 
	            "            ?)"; 

		Connection con = null;
		PreparedStatement pstmt = null; // 바인딩 변수 처리하는 preparedStatement

		try {
			Class.forName(driver).newInstance();
			con = DriverManager.getConnection(url, userName, passWd);
			con.setAutoCommit(false); // 디폴트 true임 ->수행 후 바로 commit

			pstmt = con.prepareStatement(sql); // 바인딩 변수가 포함된 String을 서버에 전송하기 전에 전처리
			pstmt.setString(1, departmentName); // 첫번째 물음표(바인딩 변수) 값 할당

			if (managerID != 0) {
				pstmt.setInt(2, managerID);
			} else {
				pstmt.setNull(2, Types.INTEGER);
			}

			if (locationID != 0) {
				pstmt.setInt(3, locationID);
			} else {
				pstmt.setNull(3, Types.INTEGER);
			}

			int count = pstmt.executeUpdate(); // 여기서는 sql 안넘긴다
			con.commit();
			System.out.println(count + " 행이 추가됨");
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// 순서대로 close
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e) {

			}
		}
		*/
	}
   
   //인자를 객체로 받아보자
   public void create2(Department department) {
		 
	      String sql= "INSERT INTO departments \r\n" + 
	            "            (department_id, \r\n" + 
	            "             department_name, \r\n" + 
	            "             manager_id, \r\n" + 
	            "             location_id) \r\n" + 
	            "VALUES     (departments_seq.nextval, \r\n" + 
	            "            ?, \r\n" + 
	            "            ?, \r\n" + 
	            "            ?)"; 

		Connection con = null;
		PreparedStatement pstmt = null; // 바인딩 변수 처리하는 preparedStatement

		try {
			Class.forName(driver).newInstance();
			con = DriverManager.getConnection(url, userName, passWd);
			con.setAutoCommit(false); // 디폴트 true임 ->수행 후 바로 commit

			pstmt = con.prepareStatement(sql); // 바인딩 변수가 포함된 String을 서버에 전송하기 전에 전처리
			pstmt.setString(1, department.getDepartmentName()); // 첫번째 물음표(바인딩 변수) 값 할당

			if (department.getManagerID() != 0) {
				pstmt.setInt(2, department.getManagerID());
			} else {
				pstmt.setNull(2, Types.INTEGER);
			}

			if (department.getLocationID() != 0) {
				pstmt.setInt(3, department.getLocationID());
			} else {
				pstmt.setNull(3, Types.INTEGER);
			}

			int count = pstmt.executeUpdate();
			con.commit();
			System.out.println(count + " 행이 추가됨");
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// 순서대로 close
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e) {

			}
		}
	}
   
   public void delete (int departmentID) {
		String sql = "DELETE FROM departments \r\n" + 
					"WHERE  department_id = ?";

		Connection con = null;
		PreparedStatement pstmt = null; // 바인딩 변수 처리하는 preparedStatement

		try {
			Class.forName(driver).newInstance();
			con = DriverManager.getConnection(url, userName, passWd);
			con.setAutoCommit(false); // 디폴트 true임 ->수행 후 바로 commit

			pstmt = con.prepareStatement(sql); // 바인딩 변수가 포함된 String을 서버에 전송하기 전에 전처리
			pstmt.setInt(1, departmentID); // 첫번째 물음표(바인딩 변수) 값 할당

			int count = pstmt.executeUpdate();
			con.commit();
			System.out.println(count + " 행이 삭제됨");
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// 순서대로 close
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e) {

			}
		}
	}


   public static void main(String[] args) {
      /* commit이나 rollback 가능
      con.commit(); 
      con.rollback(); 
       */
	  DMLExample exam= new DMLExample();
      
	//  exam.create("코스타",0,0);
	//  exam.create2("코스타2",100,1700);
	//  exam.create2("코스타4",0,0);
	  
	  exam.delete(350);
   }
   
}