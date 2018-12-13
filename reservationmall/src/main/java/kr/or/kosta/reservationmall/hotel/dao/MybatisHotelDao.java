package kr.or.kosta.reservationmall.hotel.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.kosta.reservationmall.hotel.dto.HotelSearchParam;
import kr.or.kosta.reservationmall.hotel.dto.HotelSearchResult;
import kr.or.kosta.reservationmall.room.dto.Room;

public class MybatisHotelDao implements HotelDao {

	private static final String NAMESPACE = "kr.or.kosta.reservationmall.hotel.";

	private SqlSessionFactory sqlSessionFactory;

	public SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}

	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public List<HotelSearchResult> searchHotelListsByLocation(HotelSearchParam hotelSearchParam) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<HotelSearchResult> result = sqlSession.selectList(NAMESPACE + "searchHotelListsByLocation", hotelSearchParam);
		sqlSession.close();
		return result;
	}
	
	@Override
	public List<HotelSearchResult> searchHotelListsByHotel(HotelSearchParam hotelSearchParam) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<HotelSearchResult> result = sqlSession.selectList(NAMESPACE + "searchHotelListsByHotel", hotelSearchParam);
		sqlSession.close();
		return result;
	}
	
	@Override
	public Room getRoomInfo(String hotelId, String roomName) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		Map<String, String> param = new HashMap<>();
		param.put("hotelId", hotelId);
		param.put("roomName", roomName);
		Room result = sqlSession.selectOne(NAMESPACE + "getRoomInfo", param);
		sqlSession.close();
		return result;
	}
	
	@Override
	public List<Map<String,String>> getHotelImages(String hotelIds) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<Map<String,String>> result = sqlSession.selectList(NAMESPACE + "getHotelImages", hotelIds);
		sqlSession.close();
		return result;
	}
	
	@Override
	public List<String> getRoomImages(int hotelId, String roomName) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		Map<String, Object> param = new HashMap<>();
		param.put("hotelId", hotelId);
		param.put("roomName", roomName);
		List<String> result = sqlSession.selectList(NAMESPACE + "getRoomImages", param);
		sqlSession.close();
		return result;
	}
}
