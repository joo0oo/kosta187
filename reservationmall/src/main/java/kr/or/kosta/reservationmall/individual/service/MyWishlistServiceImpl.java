package kr.or.kosta.reservationmall.individual.service;



import java.util.List;

import kr.or.kosta.reservationmall.individual.dao.AddWishlistDao;
import kr.or.kosta.reservationmall.individual.dao.MyWishlistDao;


public class MyWishlistServiceImpl implements MyWishlistService {

	private MyWishlistDao myWishlistDao;


	public MyWishlistDao getMyWishlistDao() {
		return myWishlistDao;
	}

	public void setMyWishlistDao(MyWishlistDao myWishlistDao) {
		this.myWishlistDao = myWishlistDao;
	}

	@Override
	public List<Integer> getWishlist(String user_id) throws Exception {
		return myWishlistDao.getWishlist(user_id);
	}

	@Override
	public void deleteWishlist(String user_id, int hotel_id) throws Exception {
		myWishlistDao.deleteWishlist(user_id, hotel_id);
	}

}





