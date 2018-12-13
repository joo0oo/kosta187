package kr.or.kosta.blog.footage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import kr.or.kosta.blog.user.User;

public class JdbcFootageDao implements FootageDao {
	
	private DataSource dataSource; //DB 연결을 위해 반드시 필요
	
	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	/**
	 * 새 방명록 쓰기
	 */
	public void create(Footage footage) throws Exception {
		Connection con =  null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO guestbook \r\n" + 
					 "            (guestbook_id, \r\n" + 
					 "             user_id, \r\n" + 
					 "             CONTENTS) \r\n" + 
					 "values (guestbook_seq.NEXTVAL, \r\n" + 
					 "        ?, \r\n" + 
					 "        ?)";
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, footage.getUserID());
			pstmt.setString(2, footage.getContents());
			pstmt.executeUpdate();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null)   con.close();
			}catch (Exception e) {}
		}
	}

	@Override
	/**
	 * 사용자 id로 방명록 검색
	 */
	public Footage read(String id) throws Exception {
		Connection con= null;
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		String sql="SELECT guestbook_id, \r\n" + 
					"       user_id, \r\n" + 
					"       contents, \r\n" + 
					"       To_char(regdate, 'YYYY/MM/DD HH24:MI DAY') regdate \r\n" + 
					"FROM   guestbook \r\n" + 
					"WHERE  user_id = ? \r\n" + 
					"ORDER  BY guestbook_id DESC";
		
		try {
			con= dataSource.getConnection();
			pstmt= con.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs= pstmt.executeQuery();
			
			Footage res= new Footage();
			if(rs.next()) {
				res= createFootage(rs);
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
	/**
	 * 모든 방명록 리턴
	 */
	public List<Footage> listAll() throws Exception {
		List<Footage> list= null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql="SELECT guestbook_id, \r\n" + 
				"       user_id, \r\n" + 
				"       contents, \r\n" + 
				"       To_char(regdate, 'YYYY/MM/DD HH24:MI DAY') regdate \r\n" + 
				"FROM   guestbook \r\n" + 
				"ORDER  BY guestbook_id DESC";
		
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			list = new ArrayList<Footage>();
			while(rs.next()) {
				Footage footage = createFootage(rs);
				list.add(footage);
			}
		} finally {
			try {
				if(rs != null)    rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null)   con.close();
			}catch (Exception e) {}
		}
		return list;
	}
	
	private Footage createFootage(ResultSet rs) throws SQLException{
		Footage footage = new Footage();
		footage.setGestbook_id(rs.getInt("guestbook_id"));
		footage.setUserID(rs.getString("user_id"));
		footage.setContents(rs.getString("contents"));
		footage.setRegdate(rs.getString("regdate"));
		return footage;
	}

	@Override
	/**
	 * 오늘의 방명록 개수 세기
	 */
	public int countTodayArticle() throws Exception {
		int count=0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql="SELECT Count(guestbook_id) count \r\n" + 
				"FROM   guestbook \r\n" + 
				"WHERE  To_char(regdate, 'yyyy-mm-dd') = To_char(sysdate, 'yyyy-mm-dd')";
		
		
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				count = rs.getInt("count");
			}
		} finally {
			try {
				if(rs != null)    rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null)   con.close();
			}catch (Exception e) {}
		}
		return count;
	}
	
}










