package kr.or.kosta.reservationmall.individual.dao;

import java.util.List;

import kr.or.kosta.reservationmall.individual.dto.ReservationInfo;
import kr.or.kosta.reservationmall.login.dto.User;




/**
 * Dao 패턴 적용을 위한 인터페이스 선언
 * @author 김기정
 *
 */
public interface ReservationDao {
	
	//예약 번호로 예약 내역 리턴
	public ReservationInfo searchResById(String reservation_id) throws Exception;
	
	//사용자 아이디로 예약 내역 리스트 리턴
	List<ReservationInfo> listAllReservations(String user_id) throws Exception;
	
	//예약 번호로 예약 취소
	public boolean cacellationRes(int reservation_id) throws Exception;
}
