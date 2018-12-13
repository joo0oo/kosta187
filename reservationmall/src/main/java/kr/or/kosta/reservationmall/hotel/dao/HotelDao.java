package kr.or.kosta.reservationmall.hotel.dao;

import java.util.List;
import java.util.Map;

import kr.or.kosta.reservationmall.common.web.Params;
import kr.or.kosta.reservationmall.hotel.dto.Hotel;
import kr.or.kosta.reservationmall.hotel.dto.HotelSearchParam;
import kr.or.kosta.reservationmall.hotel.dto.HotelSearchResult;
import kr.or.kosta.reservationmall.room.dto.Room;

/**
 * Dao 패턴 적용을 위한 인터페이스 선언
 * 
 * @author 김기정
 *
 */
public interface HotelDao {

	/**
	 * 검색 정보를 통해 해당하는 호텔 고유 번호(hotelId)와 방 고유 번호(roomIds)를 Map<String, String> 형태로 받아오는 기능
	 * @param hotelSearchParam
	 * @return
	 * @throws Exception
	 */
	public List<HotelSearchResult> searchHotelListsByLocation(HotelSearchParam hotelSearchParam) throws Exception;

	public List<HotelSearchResult> searchHotelListsByHotel(HotelSearchParam hotelSearchParam) throws Exception;

	public Room getRoomInfo(String hotelId, String roomName) throws Exception;

	public List<Map<String,String>> getHotelImages(String hotelIds) throws Exception;

	public List<String> getRoomImages(int hotelId, String roomName) throws Exception;
}
