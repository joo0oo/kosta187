package kr.or.kosta.reservationmall.individual.dao;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.kosta.reservationmall.individual.dto.Wishlist;



public class MybatisMyWishlistDao implements MyWishlistDao {
	
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
		if(sqlSession.selectList(NAMESPACE+"getMyWishlist",user_id)!=null) {
			wishlist=sqlSession.selectList(NAMESPACE+"getMyWishlist",user_id);
		}else {
			wishlist=null;
		}
		sqlSession.close();
		return wishlist;
	}

	@Override
	public void deleteWishlist(String user_id, int hotel_id) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		Wishlist wishlist= new Wishlist();
		wishlist.setHotel_id(hotel_id);
		wishlist.setUser_id(user_id);
		if( sqlSession.delete(NAMESPACE+"deleteMyWishlist",wishlist) >0 ) {
			sqlSession.commit();
		}
		sqlSession.close();
	}
	
}










