package kr.or.kosta.reservationmall.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.kosta.reservationmall.board.dto.Article;
import kr.or.kosta.reservationmall.common.web.Params;

public class MybatisArticleDao implements ArticleDao {
	
	private static final String NAMESPACE = "kr.or.kosta.reservationmall.board.";
	
	private SqlSessionFactory sqlSessionFactory;

	public SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}

	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public void create_hr(Article article) throws Exception {
		
	}

	@Override
	public Article read_hr(String id) throws Exception {
		return null;
	}

	@Override
	public void update_hr(Article article) throws Exception {
		
	}

	@Override
	public void delete_hr(String id) throws Exception {
		
	}

	@Override
	public List<Article> listAll_hr() throws Exception {
		List<Article> list = null;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		list = sqlSession.selectList(NAMESPACE + "listAll_hr");
		sqlSession.close();
		return list;
	}

	@Override
	public List<Article> listByPage_hr(int page) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Article> listByPage_hr(int page, int listSize, String searchType, String searchValue) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Article> listByPage_hr(Params params) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countBySearch_hr(String searchType, String searchValue) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int countBySearch_hr(Params params) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void increaseHitCount_hr(String id) throws Exception {
		//조회수 증가 메서드
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.update(NAMESPACE+"increaseHitCount_hr");
		sqlSession.commit();
		sqlSession.close();
	}
	
}










