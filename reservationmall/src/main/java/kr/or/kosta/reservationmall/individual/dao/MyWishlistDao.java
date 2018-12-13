package kr.or.kosta.reservationmall.individual.dao;

import java.util.List;

import kr.or.kosta.reservationmall.individual.dto.ReservationInfo;
import kr.or.kosta.reservationmall.login.dto.User;




/**
 * 마이페이지 위시리스트 조회
 * @author 송주현
 *
 */
public interface MyWishlistDao {
	
	/**
	 * 해당 유저의 위시리스트 리턴 
	 * @param user_id
	 * @return hotel_id :List
	 * @throws Exception
	 */
	public List<Integer> getWishlist(String user_id) throws Exception;
	
	//위시리스트 삭제
	public void deleteWishlist(String user_id, int hotel_id) throws Exception;

}
