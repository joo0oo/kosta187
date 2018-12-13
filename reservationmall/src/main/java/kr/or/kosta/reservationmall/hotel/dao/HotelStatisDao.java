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
 * Dao 패턴 적용을 위한 인터페이스 선언
 * 
 * @author 김기정
 *
 */
public interface HotelStatisDao {

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
