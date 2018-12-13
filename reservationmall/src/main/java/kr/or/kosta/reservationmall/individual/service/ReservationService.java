package kr.or.kosta.reservationmall.individual.service;

import java.util.List;

import kr.or.kosta.reservationmall.individual.dto.ReservationInfo;

/**
 * 예약 내역 조회 
 * @author 송주현
 */
public interface ReservationService {
	
	/* 예약 번호로 예약 내역 찾기  (1개) */
	public ReservationInfo searchResById(String reservation_id) throws Exception;
	
	/* 사용자 아이디로 예약 내역 리스트 리턴 */
	public List<ReservationInfo> listAllReservations(String user_id) throws Exception;
	
	/* 예약 번호로 예약 취소 */
	public boolean cacellationRes(int reservation_id) throws Exception;
}
