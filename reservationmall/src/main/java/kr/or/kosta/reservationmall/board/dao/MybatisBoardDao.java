package kr.or.kosta.reservationmall.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.kosta.reservationmall.board.dto.Board;

public class MybatisBoardDao implements BoardDao {
	
	private static final String NAMESPACE = "kr.or.kosta.reservationmall.board.";
	
	private SqlSessionFactory sqlSessionFactory;

	public SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}

	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}


	@Override
	public void create_hr(Board board) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Board read_hr(String id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Board> listAll_hr() throws Exception {
		 List<Board> list = null;
		 SqlSession sqlSession = sqlSessionFactory.openSession();
		 list = sqlSession.selectList(NAMESPACE + "listAll_hr");
		 sqlSession.close();
		return list;
	}
	
}










