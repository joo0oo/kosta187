package kr.or.kosta.reservationmall.individual.service;



import java.util.List;

import kr.or.kosta.reservationmall.individual.dao.AddWishlistDao;
import kr.or.kosta.reservationmall.individual.dao.GetWishlistDao;


public class GetWishlistServiceImpl implements GetWishlistService {

	private GetWishlistDao getWishlistDao;


	public GetWishlistDao getGetWishlistDao() {
		return getWishlistDao;
	}

	public void setGetWishlistDao(GetWishlistDao getWishlistDao) {
		this.getWishlistDao = getWishlistDao;
	}


	@Override
	public List<Integer> getWishlist(String user_id) throws Exception {
		return getWishlistDao.getWishlist(user_id);
	}

}





