package kr.or.kosta.reservationmall.individual.service;

import java.util.List;

import kr.or.kosta.reservationmall.individual.dto.ReservationInfo;

/**
 * 예약 내역 조회 
 * @author 송주현
 */
public interface GetWishlistService {

	/**
	 * 해당 유저의 위시리스트 리턴 
	 * @param user_id
	 * @return hotel_id :List
	 * @throws Exception
	 */
	public List<Integer> getWishlist(String user_id) throws Exception;

}
