package kr.or.kosta.blog.article;

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

import kr.or.kosta.blog.footage.Footage;
import kr.or.kosta.blog.user.User;

public class JdbcArticleDao implements ArticleDao {
	
	private DataSource dataSource; //DB 연결을 위해 반드시 필요
	
	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	/**
	 * 새 게시글 쓰기
	 */
	public void create(Article article) throws Exception {
		Connection con =  null;
		PreparedStatement pstmt = null;
		String sql =  "INSERT INTO article \r\n" + 
					  "            (article_id, \r\n" + 
					  "             board_id, \r\n" + 
					  "             writer, \r\n" + 
					  "             subject, \r\n" + 
					  "             content, \r\n" + 
					  "             ip, \r\n" + 
					  "             passwd, \r\n" + 
					  "             group_no, \r\n" + 
					  "             level_no, \r\n" + 
					  "             order_no) \r\n" + 
					  "VALUES      (article_id_seq.nextval, \r\n" + 
					  "             ?, \r\n" + 
					  "             ?, \r\n" + 
					  "             ?, \r\n" + 
					  "             ?, \r\n" + 
					  "             ?, \r\n" + 
					  "             ?, \r\n" + 
					  "             article_id_seq.currval, \r\n" + 
					  "             ?, \r\n" + 
					  "             ?) ";
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, article.getBoard_id());
			pstmt.setString(2, article.getWriter());
			pstmt.setString(3, article.getSubject());
			pstmt.setString(4, article.getContent());
			pstmt.setString(5, article.getIp());
			pstmt.setString(6, article.getPasswd());
		//	pstmt.setInt(7, article.getGroupNum());
			pstmt.setInt(7, article.getLevelNum());
			pstmt.setInt(8, article.getOrderNum());
			pstmt.executeUpdate();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null)   con.close();
			}catch (Exception e) {}
		}
		
	}

	@Override
	public Article read(String searchStr) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override 
	/**
	 * 글 고유번호로 글 검색
	 */
	public Article read(int article_id) throws Exception {
		Article  article = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT article_id, \r\n" + 
				"       board_id, \r\n" + 
				"       writer, \r\n" + 
				"       subject, \r\n" + 
				"       content, \r\n" + 
				"       To_char(regdate, 'yyyy-mm-dd') regdate, \r\n" + 
				"       hitcount, \r\n" + 
				"       ip, \r\n" + 
				"       passwd, \r\n" + 
				"       attach_file, \r\n" + 
				"       group_no, \r\n" + 
				"       level_no, \r\n" + 
				"       order_no \r\n" + 
				"FROM   article \r\n" + 
				"WHERE  article_id = ?";
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, article_id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				article = createArticle(rs);
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
		return article;
	}

	@Override
	/**
	 * 조회수 늘리기
	 */
	public void update(Article article) throws Exception {
		Connection con =  null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE article \r\n" + 
					"SET    subject = ?, \r\n" + 
					"       content = ? \r\n" + 
					"WHERE  article_id = ?";
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, article.getSubject());
			pstmt.setString(2, article.getContent());
			pstmt.setInt(3, article.getArticle_id());
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
	 * 게시글 삭제하기 (제목과 내용을 '삭제된 게시글'로 업데이트)
	 */
	public void delete(int article_id) throws Exception {
		Connection con= null;
		PreparedStatement pstmt= null;
		String sql = "UPDATE article \r\n" + 
					"SET    subject = ?, \r\n" + 
					"       content = ? \r\n" + 
					"WHERE  article_id = ?";
		
		try {
			con= dataSource.getConnection();
			if(read (article_id) == null) {
				throw new Exception("해당 글 없음");
			}
			pstmt= con.prepareStatement(sql);
			pstmt.setString(1, "^DEL%ETE^[삭제된 게시글] ");
			pstmt.setString(2, "^DEL%ETE^[삭제된 게시글 입니다] ");
			pstmt.setInt(3, article_id);
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
	/**
	 * 전체 게시글 목록 리턴
	 */
	public List<Article> listAll(int board_id) throws Exception {
		List<Article> list= null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql="SELECT article_id, \r\n" + 
					"       subject, \r\n" + 
					"       writer, \r\n" + 
					"       regdate, \r\n" + 
					"       ip, \r\n" + 
					"       hitcount, \r\n" + 
					"       group_no, \r\n" + 
					"       level_no, \r\n" + 
					"       order_no \r\n" + 
					"FROM   article \r\n" + 
					"WHERE  board_id = ? \r\n" + 
					"ORDER  BY group_no DESC, \r\n" + 
					"          order_no ASC";
		
		
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, board_id);
			rs = pstmt.executeQuery();
			list = new ArrayList<Article>();
			while(rs.next()) {
				Article article= new Article();
				article.setArticle_id(rs.getInt("article_id"));
				article.setWriter(rs.getString("writer"));
				article.setSubject(rs.getString("subject"));
				article.setRegdate(rs.getString("regdate"));
				article.setHitCount(rs.getInt("hitcount"));
				article.setIp(rs.getString("ip"));
				article.setGroupNum(rs.getInt("group_no"));
				article.setLevelNum(rs.getInt("level_no"));
				article.setOrderNum(rs.getInt("order_no"));
				
				list.add(article);
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
	
	

	@Override
	/**
	 * 게시글 삭제를 위해 
	 * 작성자 id와 비밀번호 일치 여부 확인하기
	 */
	public Article certify(int article_id, String passwd) throws Exception {
		Article res=read(article_id);
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

	
	private Article createArticle(ResultSet rs) throws SQLException {
		Article article= new Article();
		article.setArticle_id(rs.getInt("article_id"));
		article.setBoard_id(rs.getInt("board_id"));
		article.setWriter(rs.getString("writer"));
		article.setSubject(rs.getString("subject"));
		article.setContent(rs.getString("content"));
		article.setRegdate(rs.getString("regdate"));
		article.setHitCount(rs.getInt("hitcount"));
		article.setIp(rs.getString("ip"));
		article.setPasswd(rs.getString("passwd"));
		article.setAttachFile(rs.getString("attach_file"));
		article.setGroupNum(rs.getInt("group_no"));
		article.setLevelNum(rs.getInt("level_no"));
		article.setOrderNum(rs.getInt("order_no"));
		return article;
	}

	@Override
	/**
	 * 조회수 늘리기
	 */
	public void updateHitCount(int article_id) throws Exception {
		Connection con =  null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE article \r\n" + 
					"SET    hitcount = (SELECT hitcount \r\n" + 
					"                   FROM   article \r\n" + 
					"                   WHERE  article_id = ?) \r\n" + 
					"                  + 1 \r\n" + 
					"WHERE  article_id = ? ";
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, article_id);
			pstmt.setInt(2, article_id);
			pstmt.executeUpdate();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null)   con.close();
			}catch (Exception e) {}
		}
	}

	public List<Article> listByPage(int board_id, Params params) throws Exception {
		return listByPage(board_id, params.getPage(), params.getListSize(),  params.getSearchType(), params.getSearchValue());
	}

	@Override
	/** 선택페이지에 따른 게시글 목록 반환 */	
	public List<Article> listByPage(int board_id, int page) throws Exception {
		//선택페이지에 따른 목록 반환
		System.out.println("listbypage board_id, page");
		List<Article> list = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql ="SELECT article_id, \r\n" + 
				"       board_id, \r\n" + 
				"       writer, \r\n" + 
				"       subject, \r\n" + 
				"       content, \r\n" + 
				"       regdate, \r\n" + 
				"       hitcount, \r\n" + 
				"       ip, \r\n" + 
				"       passwd, \r\n" + 
				"       attach_file, \r\n" + 
				"       group_no, \r\n" + 
				"       level_no, \r\n" + 
				"       order_no \r\n" + 
				"FROM   (SELECT Ceil(rownum / 10) request_page, \r\n" + 
				"               article_id, \r\n" + 
				"               board_id, \r\n" + 
				"               writer, \r\n" + 
				"               subject, \r\n" + 
				"               content, \r\n" + 
				"               regdate, \r\n" + 
				"               hitcount, \r\n" + 
				"               ip, \r\n" + 
				"               passwd, \r\n" + 
				"               attach_file, \r\n" + 
				"               group_no, \r\n" + 
				"               level_no, \r\n" + 
				"               order_no \r\n" + 
				"        FROM   (SELECT article_id, \r\n" + 
				"                       board_id, \r\n" + 
				"                       writer, \r\n" + 
				"                       subject, \r\n" + 
				"                       content, \r\n" + 
				"                       To_char(regdate, 'yyyy-mm-dd') regdate, \r\n" + 
				"                       hitcount, \r\n" + 
				"                       ip, \r\n" + 
				"                       passwd, \r\n" + 
				"                       attach_file, \r\n" + 
				"                       group_no, \r\n" + 
				"                       level_no, \r\n" + 
				"                       order_no \r\n" + 
				"                FROM   article \r\n" + 
				"                WHERE  board_id=? \r\n" + 
				"                ORDER  BY group_no DESC, \r\n" + 
				"                		   order_no ASC)) \r\n" + 
				"WHERE  request_page = ?";
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, board_id);
			pstmt.setInt(2, page);
			rs = pstmt.executeQuery();
			list = new ArrayList<Article>();
			while(rs.next()) {
				Article article = createArticle(rs);
				list.add(article);
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

	@Override
	/** 선택페이지, 조회 목록개수에 따른 게시글 목록 반환 */
	public List<Article> listByPage(int board_id, int page, int listSize) throws Exception {
		//선택페이지와 리스트 사이즈에 따른 목록 반환
		List<Article> list = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql ="SELECT article_id, \r\n" + 
				"       board_id, \r\n" + 
				"       writer, \r\n" + 
				"       subject, \r\n" + 
				"       content, \r\n" + 
				"       regdate, \r\n" + 
				"       hitcount, \r\n" + 
				"       ip, \r\n" + 
				"       passwd, \r\n" + 
				"       attach_file, \r\n" + 
				"       group_no, \r\n" + 
				"       level_no, \r\n" + 
				"       order_no \r\n" + 
				"FROM   (SELECT Ceil(rownum / ?) request_page, \r\n" + 
				"               article_id, \r\n" + 
				"               board_id, \r\n" + 
				"               writer, \r\n" + 
				"               subject, \r\n" + 
				"               content, \r\n" + 
				"               regdate, \r\n" + 
				"               hitcount, \r\n" + 
				"               ip, \r\n" + 
				"               passwd, \r\n" + 
				"               attach_file, \r\n" + 
				"               group_no, \r\n" + 
				"               level_no, \r\n" + 
				"               order_no \r\n" + 
				"        FROM   (SELECT article_id, \r\n" + 
				"                       board_id, \r\n" + 
				"                       writer, \r\n" + 
				"                       subject, \r\n" + 
				"                       content, \r\n" + 
				"                       To_char(regdate, 'yyyy-mm-dd') regdate, \r\n" + 
				"                       hitcount, \r\n" + 
				"                       ip, \r\n" + 
				"                       passwd, \r\n" + 
				"                       attach_file, \r\n" + 
				"                       group_no, \r\n" + 
				"                       level_no, \r\n" + 
				"                       order_no \r\n" + 
				"                FROM   article \r\n" + 
				"                WHERE  board_id=? \r\n" + 
				"                ORDER  BY group_no DESC, \r\n" + 
				"                		   order_no ASC)) \r\n" +  
				"WHERE  request_page = ?";
		
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, listSize);
			pstmt.setInt(2, board_id);
			pstmt.setInt(3, page);
			rs = pstmt.executeQuery();
			list = new ArrayList<Article>();
			while(rs.next()) {
				Article article = createArticle(rs);
				list.add(article);
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

	@Override
	/** 선택페이지, 조회 목록개수, 
	 * 검색유형, 검색값에 따른 사용자 목록 반환 */	
	public List<Article> listByPage(int board_id, int page, int listSize, String searchType, String searchValue) throws Exception {
		
		List<Article> list = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT article_id, \r\n" + 
					"       board_id, \r\n" + 
					"       writer, \r\n" + 
					"       subject, \r\n" + 
					"       content, \r\n" + 
					"       regdate, \r\n" + 
					"       hitcount, \r\n" + 
					"       ip, \r\n" + 
					"       passwd, \r\n" + 
					"       attach_file, \r\n" + 
					"       group_no, \r\n" + 
					"       level_no, \r\n" + 
					"       order_no \r\n" + 
					"FROM   (SELECT Ceil(rownum / ?) request_page, \r\n" + 
					"               article_id, \r\n" + 
					"               board_id, \r\n" + 
					"               writer, \r\n" + 
					"               subject, \r\n" + 
					"               content, \r\n" + 
					"               regdate, \r\n" + 
					"               hitcount, \r\n" + 
					"               ip, \r\n" + 
					"               passwd, \r\n" + 
					"               attach_file, \r\n" + 
					"               group_no, \r\n" + 
					"               level_no, \r\n" + 
					"               order_no \r\n" + 
					"        FROM   (SELECT article_id, \r\n" + 
					"                       board_id, \r\n" + 
					"                       writer, \r\n" + 
					"                       subject, \r\n" + 
					"                       content, \r\n" + 
					"                       To_char(regdate, 'yyyy-mm-dd') regdate, \r\n" + 
					"                       hitcount, \r\n" + 
					"                       ip, \r\n" + 
					"                       passwd, \r\n" + 
					"                       attach_file, \r\n" + 
					"                       group_no, \r\n" + 
					"                       level_no, \r\n" + 
					"                       order_no \r\n" + 
					"                FROM   article \r\n" + 
					"                WHERE  board_id=? \r\n" ;
		

		// 검색 유형별 WHERE 절 동적 추가
		if (searchType != null) {
			switch (searchType) {
			case "writer":
				sql += "AND  writer = ? \r\n";
				break;
			case "subject":
				sql += " AND  subject LIKE ? \r\n";
				searchValue = "%" + searchValue + "%";
				break;
			case "content":
				sql += " AND  content LIKE ? \r\n";
				searchValue = "%" + searchValue + "%";
				break;
			}
		}
		sql += 	"                ORDER  BY group_no DESC, \r\n" + 
				"                		   order_no ASC)) \r\n" + 
				"WHERE  request_page = ?";
		
		/*
		sql += "                ORDER BY regdate DESC)) \r\n" + 
				"WHERE  request_page = ?";
		*/
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, listSize);

			// 전체검색이 아닌경우 경우
			if (searchType != null) {
				pstmt.setInt(2, board_id);
				pstmt.setString(3, searchValue);
				pstmt.setInt(4, page);
			} else {// 전체검색인 경우
				pstmt.setInt(2, board_id);
				pstmt.setInt(3, page);
			}

			rs = pstmt.executeQuery();
			list = new ArrayList<Article>();
			while (rs.next()) {
				Article article = createArticle(rs);
				list.add(article);
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
	/** 검색유형, 검색값에 따른 사용자 개수 반환 - 
	 * 페이징 처리 시 필요 */
	public int countBySearch(int board_id, String searchType, String searchValue) throws Exception {
		
		int count = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql ="SELECT COUNT(article_id) count\r\n" + 
					"FROM   article\r\n"+
					"                WHERE  board_id=? \r\n";
		
		// 검색 유형별 WHERE 절 동적 추가
		if(searchType != null){
			switch (searchType) {
				case "writer":
					sql += "AND  writer = ? \r\n";
					break;
				case "subject":
					sql += " AND  subject LIKE ? \r\n";
					searchValue = "%" + searchValue + "%";
					break;
				case "content":
					sql += " AND  content LIKE ? \r\n";
					searchValue = "%" + searchValue + "%";
					break;
			}
		}
		//sql += "                WHERE  board_id=? \r\n";
		
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			
			// 전체검색이 아닌경우 경우
			if(searchType != null){
				pstmt.setInt(1, board_id);
				pstmt.setString(2, searchValue);
			} else {
				pstmt.setInt(1, board_id);
			}
			System.out.println(sql);
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

	@Override
	public int countBySearch(int board_id, Params params) throws Exception {
		return countBySearch(board_id, params.getSearchType(), params.getSearchValue());
	}

	@Override
	public void createReply(int groupNum, Article article) throws Exception {
		//답변글 달기
		Connection con =  null;
		PreparedStatement pstmt = null;
		String sql =  "INSERT INTO article \r\n" + 
					"            (article_id, \r\n" + 
					"             board_id, \r\n" + 
					"             writer, \r\n" + 
					"             subject, \r\n" + 
					"             content, \r\n" + 
					"             ip, \r\n" + 
					"             passwd, \r\n" + 
					"             group_no, \r\n" + 
					"             level_no, \r\n" + 
					"             order_no) \r\n" + 
					"VALUES      (article_id_seq.nextval, \r\n" + 
					"             ?, \r\n" + //boardId
					"             ?, \r\n" + //writer
					"?, \r\n" + //subject
					"?, \r\n" + //content
					"?, \r\n" + //ip
					"?, \r\n" + //passwd
					"?, \r\n" + //group num
					"1, \r\n" + //level num
					"(SELECT Max(order_no) + 1 \r\n" +  //ordernum
					" FROM   article \r\n" + 
					" WHERE  board_id = ? \r\n" + 
					"        AND group_no = ?)) ";//group num
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, article.getBoard_id());
			pstmt.setString(2, article.getWriter());
			pstmt.setString(3, article.getSubject());
			pstmt.setString(4, article.getContent());
			pstmt.setString(5, article.getIp());
			pstmt.setString(6, article.getPasswd());
			pstmt.setInt(7, groupNum);
			pstmt.setInt(8, article.getBoard_id());
			pstmt.setInt(9, groupNum);
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
	 * 답글 순서를 고려한 게시글 목록 리턴
	 */
	public List<Article> listAllforReply() throws Exception {
		List<Article> list= null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql="SELECT article_id, \r\n" + 
					"       board_id, \r\n" + 
					"       writer, \r\n" + 
					"       subject, \r\n" + 
					"       content, \r\n" + 
					"       To_char(regdate, 'yyyy-mm-dd') regdate, \r\n" + 
					"       hitcount, \r\n" + 
					"       ip, \r\n" + 
					"       passwd, \r\n" + 
					"       attach_file, \r\n" + 
					"       group_no, \r\n" + 
					"       level_no, \r\n" + 
					"       order_no \r\n" + 
					"FROM   article \r\n" + 
					"WHERE  board_id = 1 \r\n" + 
					"ORDER  BY group_no DESC, \r\n" + 
					"          order_no ASC ";
		
		
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			list = new ArrayList<Article>();
			while(rs.next()) {
				Article article= createArticle(rs);
				list.add(article);
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
	
	/**
	 * /답변글에 대한 답변글을 달기 위해 부모 글 순서 변경
	 */
	public void addParentOrderNum(int parent_id) throws Exception {
		// 답변글의 답변글 달기위한 준비 
		Article parentArticle= read(parent_id);
		Connection con =  null;
		PreparedStatement pstmt = null;
		
		/*
		부모글의 article_id를 전달받아야 한다.(ex, article_id = 4) 
		등록전에 부모글보다 order_no이 큰  order_no을 1씩 증가시킨다
		*/
		String updateSql =  "UPDATE article \r\n" + 
							"SET    order_no = order_no + 1 \r\n" + 
							"WHERE  board_id = ? \r\n" + //부모글의 게시판번호
							"       AND group_no = ? \r\n" +  //부모글의 그룹번호
							"       AND order_no > (SELECT order_no \r\n" + 
							"                       FROM   article \r\n" + 
							"                       WHERE  article_id = ?) "; //부모글의 아이디
		
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(updateSql);
			pstmt.setInt(1, parentArticle.getBoard_id());
			pstmt.setInt(2, parentArticle.getGroupNum());
			pstmt.setInt(3, parent_id);
			
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
	 *  답변글의 답변글 달기
	 */
	public void createSubReply(int parent_id, int parent_group, Article article) throws Exception {
		
		Connection con =  null;
		PreparedStatement pstmt = null;
		
		/*
		답변글에 대한 답변글 등록
		*/
		String insertSql =  "INSERT INTO article \r\n" + 
							"            (article_id, \r\n" + 
							"             board_id, \r\n" + 
							"             writer, \r\n" + 
							"             subject, \r\n" + 
							"             content, \r\n" + 
							"             ip, \r\n" + 
							"             passwd, \r\n" + 
							"             group_no, \r\n" + 
							"             level_no, \r\n" + 
							"             order_no) \r\n" + 
							"VALUES      (article_id_seq.nextval, \r\n" + 
							"             ?, \r\n" + //게시판번호 
							"             ?, \r\n" + //이글의 작성자
							"             ?, \r\n" + //이글의 제목
							"             ?, \r\n" + //이글의 내용
							"             ?, \r\n" + //이 작성자의 아이피
							"             ?, \r\n" + //이 글의 비번
							"             ?, \r\n" + //이 글의 그룹번호=부모글 그룹
							"             2, \r\n" + //이 글의 레벨번호
							"             (SELECT order_no + 1 \r\n" + 
							"              FROM   article \r\n" + 
							"              WHERE  article_id = ?)) "; //부모글의 아이디
		
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(insertSql);
			pstmt.setInt(1, article.getBoard_id());
			pstmt.setString(2, article.getWriter());
			pstmt.setString(3, article.getSubject());
			pstmt.setString(4, article.getContent());
			pstmt.setString(5, article.getIp());
			pstmt.setString(6, article.getPasswd());
			pstmt.setInt(7, parent_group);//이 글의 그룹번호=부모글 그룹
			pstmt.setInt(8, parent_id);
			
			pstmt.executeUpdate();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null)   con.close();
			}catch (Exception e) {}
		}
	}

	/**
	 * 오늘의 게시글 개수 검색
	 */
	@Override
	public int countTodayArticle(int board_id) throws Exception {
		int count=0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql="SELECT Count(article_id) count \r\n" + 
				"FROM   article \r\n" + 
				"WHERE  board_id = ? \r\n" + 
				"       AND To_char(regdate, 'yyyy-mm-dd') = To_char(sysdate, 'yyyy-mm-dd')";
		
		
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, board_id);
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










