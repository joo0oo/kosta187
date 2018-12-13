package kr.or.kosta.reservationmall.individual.dao;


import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.kosta.reservationmall.individual.dto.Wishlist;



public class MybatisAddWishlistDao implements AddWishlistDao {
	
	private static final String NAMESPACE = "kr.or.kosta.reservationmall.mywishlist.";
	
	private SqlSessionFactory sqlSessionFactory;

	public SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}

	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public boolean existWishCheck(int hotel_id, String user_id) throws Exception {
		boolean check = false;
		Wishlist wishlist = new Wishlist();
		wishlist.setHotel_id(hotel_id);
		wishlist.setUser_id(user_id);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int listSize = sqlSession.selectList(NAMESPACE+"existWishCheck",wishlist).size();
		if(listSize>0) {
			check = true;
		}
		sqlSession.close();
		return check;
	}

	@Override
	public boolean addWishlist(int hotel_id, String user_id) throws Exception {
		boolean check = false;
		Wishlist wishlist = new Wishlist();
		wishlist.setHotel_id(hotel_id);
		wishlist.setUser_id(user_id);
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		if(sqlSession.insert(NAMESPACE+"addWishlist",wishlist) >0) {
			check = true;
			sqlSession.commit();
		}
		return check;
	}

	


	
	
	
}










