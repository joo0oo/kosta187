package kr.or.kosta.reservationmall.individual.dao;

import java.util.List;

import kr.or.kosta.reservationmall.individual.dto.ReservationInfo;
import kr.or.kosta.reservationmall.login.dto.User;




/**
 * Dao 패턴 적용을 위한 인터페이스 선언
 * @author 김기정
 *
 */
public interface AddWishlistDao {
	
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
