package kr.or.kosta.reservationmall.hotel.service;

import kr.or.kosta.reservationmall.hotel.dao.HotelPaymentDao;
import kr.or.kosta.reservationmall.hotel.dao.HotelStatisDao;
import kr.or.kosta.reservationmall.hotel.dto.HotelRateAvg;
import kr.or.kosta.reservationmall.hotel.dto.HotelRoomAvg;

public class HotelPaymentServiceImpl implements HotelPaymentService {

	private HotelPaymentDao hotelPaymentDao;

	public HotelPaymentDao getHotelPaymentDao() {
		return hotelPaymentDao;
	}

	public void setHotelPaymentDao(HotelPaymentDao hotelPaymentDao) {
		this.hotelPaymentDao = hotelPaymentDao;
	}

	@Override
	public boolean checkHotelReserve(String hotel_id, String room_name, String reservation_start_day,
			String reservation_end_day, int count) throws Exception {
		boolean check = hotelPaymentDao.checkHotelReserve(hotel_id, room_name, reservation_start_day, reservation_end_day, count);
		System.out.println(check);
		return check;
	}

	@Override
	public boolean addHotelPayment(String type_value, int total_price) throws Exception {
		// TODO Auto-generated method stub
		return hotelPaymentDao.addHotelPayment(type_value, total_price);
	}

	@Override
	public boolean addHotelReserve(String reservation_start_day, String reseravation_end_day, String user_id,
			int payment_id, String room_name, int hotel_id) throws Exception {
		// TODO Auto-generated method stub
		return hotelPaymentDao.addHotelReserve(reservation_start_day, reseravation_end_day, user_id, payment_id, room_name, hotel_id);
	}

	@Override
	public String getPaymentId(String type_value) throws Exception {
		// TODO Auto-generated method stub
		return hotelPaymentDao.getPaymentId(type_value);
	}

	

	
}
