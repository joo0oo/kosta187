package kr.or.kosta.reservationmall.hotel.service;



import kr.or.kosta.reservationmall.hotel.dto.HotelRateAvg;
import kr.or.kosta.reservationmall.hotel.dto.HotelRoomAvg;


/**
 * 호텔 통계 정보
 * @author 허재혁
 */
public interface HotelStatisService {

	/**
	 * 호텔 별점 통계정보
	 * @return
	 * @throws Exception
	 */
	public HotelRateAvg getHotelRateAvg() throws Exception;
	/**
	 * 호텔 방가격 평균
	 * @return
	 * @throws Exception
	 */
	public HotelRoomAvg getHotelRoomAvg() throws Exception;

}
