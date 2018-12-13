package kr.or.kosta.reservationmall.individual.service;



import kr.or.kosta.reservationmall.individual.dao.AddWishlistDao;


public class AddWishlistServiceImpl implements AddWishlistService {

	private AddWishlistDao addWishlistDao;

	
	public AddWishlistDao getAddWishlistDao() {
		return addWishlistDao;
	}

	public void setAddWishlistDao(AddWishlistDao addWishlistDao) {
		this.addWishlistDao = addWishlistDao;
	}

	@Override
	public boolean existWishCheck(int hotel_id, String user_id) throws Exception {
		return addWishlistDao.existWishCheck(hotel_id, user_id);
	}

	@Override
	public boolean addWishlist(int hotel_id, String user_id) throws Exception {
		return addWishlistDao.addWishlist(hotel_id, user_id);
	}

	

}





