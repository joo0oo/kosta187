package pattern2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class JdbcUserDao implements UserDao {


	private static final int List = 0;
	
	@Override
	public void create(User user) throws Exception {
		Connection con= null;
		PreparedStatement pstmt= null;
		String sql="INSERT INTO users \r\n" + 
				   "VALUES      (?, \r\n" + 
				   "             ?, \r\n" + 
				   "             ?, \r\n" + 
				   "             ?, \r\n" + 
				   "             sysdate) ";
		
		try {
			con= getConnection();
			pstmt= con.prepareStatement(sql);
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getName());
			pstmt.setString(3, user.getPasswd());
			pstmt.setString(4, user.getEmail());
			
			pstmt.executeUpdate();
		} finally {
			try {
				
				if( pstmt!= null)
					pstmt.close();
				if( con!= null)
					//con.close(); //이제 이렇게 하면 안됨
					//UserConnectionPool.getInstance().releaseConnection(con); //이렇게 한다
					con.close(); //아파치 사용한 경우 이렇게 써도됨
				
			} catch (Exception e) { 	}
		}	
	}

	@Override
	public User read(String id) throws Exception {
		Connection con= null;
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		String sql="SELECT * \r\n" + 
				   "FROM   users \r\n" + 
				   "WHERE  id = ? ";
		
		try {
			con= getConnection();
			pstmt= con.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs= pstmt.executeQuery();
			
			User res= new User();
			if(rs.next()) {
				res.setId(rs.getString("id"));
				res.setName(rs.getString("name"));
				res.setPasswd(rs.getString("passwd"));
				res.setEmail(rs.getString("email"));
				res.setRegdate(rs.getString("regdate"));
			} else {
				return null;
			}
						
			return res;

		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
				
			}
		}
		
		//return null;
	}

	@Override
	public void update(User user) throws Exception {
		Connection con= null;
		PreparedStatement pstmt= null;
		String sql="UPDATE users \r\n" + 
				"SET    NAME = ?, \r\n" + 
				"       passwd = ?, \r\n" + 
				"       email = ? \r\n" + 
				"WHERE  id = ? ";
		
		try {
			con= getConnection();
			
			if(read (user.getId()) == null) {
				throw new Exception("해당 사용자 없음");
			}
			
			pstmt= con.prepareStatement(sql);
			
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getPasswd());
			pstmt.setString(3, user.getEmail());
			pstmt.setString(4, user.getId());
			
			pstmt.executeUpdate();
		} finally {
			try {
				
				if( pstmt!= null)
					pstmt.close();
				if( con!= null)
					con.close();
			} catch (Exception e) { 	}
		}	

	}

	@Override
	public void delete(String id) throws Exception {
		Connection con= null;
		PreparedStatement pstmt= null;
		String sql="DELETE FROM users \r\n" + 
				"WHERE  id = ? ";
		
		try {
			con= getConnection();
			
			if(read (id) == null) {
				throw new Exception("해당 사용자 없음");
			}
			
			pstmt= con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		} finally {
			try {
				
				if( pstmt!= null)
					pstmt.close();
				if( con!= null)
					con.close();
			} catch (Exception e) { 	}
		}	
		
	}

	@Override
	public List<User> listAll() throws Exception {
		List<User> list= new ArrayList<User>();
		
		Connection con= null;
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		String sql="SELECT * FROM users";
		
		try {
			con= getConnection();
			pstmt= con.prepareStatement(sql);
			rs= pstmt.executeQuery();
			
			while(rs.next()) {
				User res= new User();
				res.setId(rs.getString("id"));
				res.setName(rs.getString("name"));
				res.setPasswd(rs.getString("passwd"));
				res.setEmail(rs.getString("email"));
				res.setRegdate(rs.getString("regdate"));
				
				
				list.add(res);
			}
			
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
				
			}
		}
		return list;
	}

	@Override
	public User certify(String id, String passwd) throws Exception {
		User res=read(id);
		if(res==null) {
			System.out.println("없는 id");
			return null;
		} else {
			if( !res.getPasswd().equals(passwd)) {
				System.out.println("틀린 비밀번호");
				return null;
			}
			return res;
		}
	}
	

	@Override
	public List<Map<String, String>> employeeList() throws Exception{
		Connection con= null;
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		List list=null;
		
		String sql= "SELECT e.employee_id     eid, \r\n" + 
				"       e.last_name       ename, \r\n" + 
				"       e.salary          salary, \r\n" + 
				"       d.department_name dname, \r\n" + 
				"       l.city            city, \r\n" + 
				"       e2.last_name      mname \r\n" + 
				"FROM   employees e \r\n" + 
				"       LEFT OUTER JOIN departments d \r\n" + 
				"                    ON e.department_id = d.department_id \r\n" + 
				"       LEFT OUTER JOIN locations l \r\n" + 
				"                    ON d.location_id = l.location_id \r\n" + 
				"       LEFT OUTER JOIN employees e2 \r\n" + 
				"                    ON e.manager_id = e2.employee_id \r\n" + 
				"ORDER  BY eid ASC";
		
		try {
			con= getConnection();
			pstmt= con.prepareStatement(sql);
			rs= pstmt.executeQuery();
			list= new ArrayList<Map<String, String>>();
			ResultSetMetaData rsd= rs.getMetaData();
			
			
			while(rs.next()) {
				Map<String, String> row= new HashMap<String, String>();
				int columnCount= rsd.getColumnCount();
				for (int i=1; i<=columnCount; i++) {
					String columnName= rsd.getColumnLabel(i);
					String columnVal= rs.getString(i);
					
					row.put(columnName, columnVal);
				}
				list.add(row);
			
			}
			
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
				
			}
		}
		
		return list;
	}

	// getConnection() 메서드를 구현하지 않음 -> 이 클래스를 abstract로 바꾸고 하위클래스에서 구현하게 한다

}
