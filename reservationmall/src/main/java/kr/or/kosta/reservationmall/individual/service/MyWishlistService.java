package kr.or.kosta.reservationmall.individual.service;

import java.util.List;

import kr.or.kosta.reservationmall.individual.dto.ReservationInfo;

/**
 * 마이페이지 위시리스트 
 * @author 송주현
 */
public interface MyWishlistService {

	/**
	 * 해당 유저의 위시리스트 리턴 
	 * @param user_id
	 * @return hotel_id :List
	 * @throws Exception
	 */
	public List<Integer> getWishlist(String user_id) throws Exception;
	
	
	//위시리스트에서 제거
	public void deleteWishlist(String user_id, int hotel_id) throws Exception; 

}
