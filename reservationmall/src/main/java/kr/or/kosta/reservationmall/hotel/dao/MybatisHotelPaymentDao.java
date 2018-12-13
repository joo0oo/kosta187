package kr.or.kosta.reservationmall.hotel.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import kr.or.kosta.reservationmall.hotel.dto.HotelPayment;
import kr.or.kosta.reservationmall.hotel.dto.HotelReserve;
import kr.or.kosta.reservationmall.hotel.dto.HotelReserveCheck;

public class MybatisHotelPaymentDao implements HotelPaymentDao {

	private static final String NAMESPACE = "kr.or.kosta.reservationmall.reserve.";

	private SqlSessionFactory sqlSessionFactory;

	public SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}

	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public boolean checkHotelReserve(String hotel_id, String room_name, String reservation_start_day,
			String reservation_end_day, int count) throws Exception {
		boolean check = false;
		HotelReserveCheck hotelReserveCheck = new HotelReserveCheck();
		hotelReserveCheck.setHotel_id(Integer.parseInt(hotel_id));
		hotelReserveCheck.setRoom_name(room_name);
		hotelReserveCheck.setReservation_start_day(reservation_start_day);
		hotelReserveCheck.setReservation_end_day(reservation_end_day);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<Integer> tempValue = sqlSession.selectList(NAMESPACE + "checkHotelReserve",hotelReserveCheck);
		if(tempValue.size() >= count) {
			check = true;
		}
		return check;
	}

	@Override
	public boolean addHotelPayment(String type_value, int total_price) throws Exception {
		boolean check = false;
		
		HotelPayment hotelPayment = new HotelPayment();
		hotelPayment.setType_value(type_value);
		hotelPayment.setTotal_price(total_price);
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int checkNum = sqlSession.insert(NAMESPACE + "addHotelPayment", hotelPayment);
		if(checkNum > 0 ) {
			check = true;
			sqlSession.commit();
		}
		
		return check;
	}

	@Override
	public boolean addHotelReserve(String reservation_start_day, String reseravation_end_day, String user_id,
			int payment_id, String room_name, int hotel_id) throws Exception {
		boolean check = false;
		
		HotelReserve hotelReserve = new HotelReserve();
		hotelReserve.setPayment_id(payment_id);
		hotelReserve.setReservation_end_day(reseravation_end_day);
		hotelReserve.setReservation_start_day(reservation_start_day);
		hotelReserve.setRoom_name(room_name);
		hotelReserve.setUser_id(user_id);
		hotelReserve.setHotel_id(hotel_id);
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int checkNum = sqlSession.insert(NAMESPACE + "addHotelReserve", hotelReserve);
		if(checkNum > 0 ) {
			sqlSession.commit();
			check = true;
		}
		
		return check;
	}

	@Override
	public String getPaymentId(String type_value) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		return Integer.toString(sqlSession.selectOne(NAMESPACE + "getPaymentId",type_value));
	}

	

	

	
}
