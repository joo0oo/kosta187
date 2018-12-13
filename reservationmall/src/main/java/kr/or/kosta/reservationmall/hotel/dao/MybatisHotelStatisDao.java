package kr.or.kosta.reservationmall.hotel.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.kosta.reservationmall.hotel.dto.HotelRateAvg;
import kr.or.kosta.reservationmall.hotel.dto.HotelRoomAvg;

public class MybatisHotelStatisDao implements HotelStatisDao {

	private static final String NAMESPACE = "kr.or.kosta.reservationmall.statis.";

	private SqlSessionFactory sqlSessionFactory;

	public SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}

	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public HotelRateAvg getHotelRateAvg() throws Exception {
		HotelRateAvg hotelRateAvg = new HotelRateAvg();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		System.out.println("여기오니?1");
		hotelRateAvg = sqlSession.selectOne(NAMESPACE + "getHotelRateAvg");
		System.out.println("여기오니?2");
		sqlSession.close();
		return hotelRateAvg;
	}

	@Override
	public HotelRoomAvg getHotelRoomAvg() throws Exception {
		HotelRoomAvg hotelRoomAvg = new HotelRoomAvg();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		System.out.println("여기오니?1ravg");
		hotelRoomAvg = sqlSession.selectOne(NAMESPACE + "getHotelRoomAvg");
		System.out.println("여기오니?ravg");
		sqlSession.close();
		return hotelRoomAvg;
	}

	
}
