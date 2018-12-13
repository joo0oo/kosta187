package kr.or.kosta.reservationmall.hotel.service;



import java.util.List;
import java.util.Map;

import kr.or.kosta.reservationmall.hotel.dto.HotelInfo;
import kr.or.kosta.reservationmall.hotel.dto.HotelSearchParam;
import kr.or.kosta.reservationmall.hotel.dto.HotelSearchResult;
import kr.or.kosta.reservationmall.room.dto.Room;


/**
 * 로그인 관련 처리 
 * 로그인, 회원가입 등
 * @author 허재혁
 */
public interface HotelService {
	

	public List<HotelSearchResult> searchHotelListsByLocation(HotelSearchParam hotelSearchParam) throws Exception;

	public List<HotelSearchResult> searchHotelListsByHotel(HotelSearchParam hotelSearchParam) throws Exception;

	public Room getRoomInfo(String hotelId, String roomName) throws Exception;

	/**
	 * 호텔 이미지들을 Map<String,List<String>>으로 key 값은 호텔 아이디. 그에 해당 하는 value는 호텔 이미지 주소 List<String>.
	 * @param hotelIds 호텔 아이디 ( 1, 2, 3 )으로 입력
	 * @return
	 * @throws Exception
	 */
	public Map<String,List<String>> getHotelImages(String hotelIds) throws Exception;
	
	public List<String> getRoomImages(int hotelId, String roomName) throws Exception;
	
	public List<HotelInfo> getHotelInfos(Map<String, Object> paramMap, String userId) throws Exception;

}
