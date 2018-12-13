package kr.or.kosta.reservationmall.hotel.dao;

import java.util.List;
import java.util.Map;

import kr.or.kosta.reservationmall.common.web.Params;
import kr.or.kosta.reservationmall.hotel.dto.Hotel;
import kr.or.kosta.reservationmall.hotel.dto.HotelRateAvg;
import kr.or.kosta.reservationmall.hotel.dto.HotelRoomAvg;
import kr.or.kosta.reservationmall.hotel.dto.HotelSearchParam;
import kr.or.kosta.reservationmall.hotel.dto.HotelSearchResult;
import kr.or.kosta.reservationmall.room.dto.Room;

/**
 * 호텔 결제하기 관련 처리
 * 
 * @author 허재혁
 *
 */
public interface HotelPaymentDao {

	/**
	 * 예약 가능 여부 체크
	 * @return
	 * @throws Exception
	 */
	public boolean checkHotelReserve(String hotel_id, String room_name, String reservation_start_day, String reservation_end_day, int count) throws Exception;
	/**
	 * payment 결제등록
	 * @return
	 * @throws Exception
	 */
	public boolean addHotelPayment(String type_value, int total_price) throws Exception;
	
	/**
	 * payment 예약정보 등록
	 * @return
	 * @throws Exception
	 */
	public boolean addHotelReserve(String reservation_start_day, String reseravation_end_day, String user_id, int payment_id, String room_name, int hotel_id) throws Exception;
	
	/**
	 * 결제정보 아이디값 호출
	 * @return
	 * @throws Exception
	 */
	public String getPaymentId(String type_value) throws Exception;

}
