package kr.or.kosta.reservationmall.individual.service;



import java.util.List;

import kr.or.kosta.reservationmall.individual.dao.ReservationDao;
import kr.or.kosta.reservationmall.individual.dto.ReservationInfo;


public class ReservationServiceImpl implements ReservationService {

	private ReservationDao reservationDao;

	
	public ReservationDao getReservationDao() {
		return reservationDao;
	}

	public void setReservationDao(ReservationDao reservationDao) {
		this.reservationDao = reservationDao;
	}

	@Override
	/* 예약 번호로 예약 내역 찾기  (1개) */
	public ReservationInfo searchResById(String reservation_id) throws Exception {
		return reservationDao.searchResById(reservation_id);
	}

	@Override
	/* 사용자 아이디로 예약 내역 리스트 리턴 */
	public List<ReservationInfo> listAllReservations(String user_id) throws Exception {
		return reservationDao.listAllReservations(user_id);
	}

	@Override
	public boolean cacellationRes(int reservation_id) throws Exception {
		// 예약 번호로 예약 취소
		return reservationDao.cacellationRes(reservation_id);
	}

}





