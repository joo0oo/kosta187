package kr.or.kosta.reservationmall.hotel.service;

import kr.or.kosta.reservationmall.hotel.dao.HotelDao;
import kr.or.kosta.reservationmall.hotel.dao.HotelStatisDao;
import kr.or.kosta.reservationmall.hotel.dto.HotelRateAvg;
import kr.or.kosta.reservationmall.hotel.dto.HotelRoomAvg;

public class HotelStatisServiceImpl implements HotelStatisService {

	private HotelStatisDao hotelStatisDao;

	public HotelStatisDao getHotelStatisDao() {
		return hotelStatisDao;
	}

	public void setHotelStatisDao(HotelStatisDao hotelStatisDao) {
		this.hotelStatisDao = hotelStatisDao;
	}

	@Override
	public HotelRateAvg getHotelRateAvg() throws Exception {
		return hotelStatisDao.getHotelRateAvg();
	}

	@Override
	public HotelRoomAvg getHotelRoomAvg() throws Exception {
		return hotelStatisDao.getHotelRoomAvg();
	}
	
	
	

	
}
