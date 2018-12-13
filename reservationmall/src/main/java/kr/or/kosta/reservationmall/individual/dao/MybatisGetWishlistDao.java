package kr.or.kosta.reservationmall.individual.dao;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.kosta.reservationmall.individual.dto.Wishlist;



public class MybatisGetWishlistDao implements GetWishlistDao {
	
	private static final String NAMESPACE = "kr.or.kosta.reservationmall.mywishlist.";
	
	private SqlSessionFactory sqlSessionFactory;

	public SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}

	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public List<Integer> getWishlist(String user_id) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<Integer> wishlist= new ArrayList<Integer>();
		wishlist=sqlSession.selectList(NAMESPACE+"getMyWishlist",user_id);
		sqlSession.close();
		return wishlist;
	}
	
	
}










