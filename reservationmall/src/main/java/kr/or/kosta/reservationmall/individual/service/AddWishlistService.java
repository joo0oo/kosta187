package kr.or.kosta.reservationmall.individual.service;

import java.util.List;

import kr.or.kosta.reservationmall.individual.dto.ReservationInfo;

/**
 * 예약 내역 조회 
 * @author 송주현
 */
public interface AddWishlistService {
	/**
	 * 해당 호텔의 위시리스트 등록 여부 확인
	 * @param hotel_id
	 * @param user_id
	 * @return
	 * @throws Exception
	 */
	public boolean existWishCheck(int hotel_id, String user_id) throws Exception;
	
	/**
	 * 위시리스트 등록 
	 * @param hotel_id
	 * @param user_id
	 * @return
	 * @throws Exception
	 */
	public boolean addWishlist(int hotel_id, String user_id) throws Exception;
}
