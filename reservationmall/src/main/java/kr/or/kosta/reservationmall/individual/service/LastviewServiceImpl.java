package kr.or.kosta.reservationmall.individual.service;



import java.util.List;

import kr.or.kosta.reservationmall.individual.dao.AddWishlistDao;
import kr.or.kosta.reservationmall.individual.dao.MyWishlistDao;
import kr.or.kosta.reservationmall.individual.dao.LastviewDao;
import kr.or.kosta.reservationmall.individual.dto.Lastview;


public class LastviewServiceImpl implements LastviewService {

	private LastviewDao lastviewDao;

	public LastviewDao getLastviewDao() {
		return lastviewDao;
	}

	public void setLastviewDao(LastviewDao lastviewDao) {
		this.lastviewDao = lastviewDao;
	}

	@Override
	//해당 user_id의 최근 조회 항목 3가지 리턴
	public List<Lastview> getMyLastview(String user_id) throws Exception {
		return lastviewDao.getMyLastview(user_id);
	}
}





