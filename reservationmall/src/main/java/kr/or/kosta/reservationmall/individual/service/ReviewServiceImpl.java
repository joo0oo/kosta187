package kr.or.kosta.reservationmall.individual.service;



import java.util.List;

import kr.or.kosta.reservationmall.individual.dao.ReservationDao;
import kr.or.kosta.reservationmall.individual.dao.ReviewDao;
import kr.or.kosta.reservationmall.individual.dto.ReservationInfo;
import kr.or.kosta.reservationmall.individual.dto.Review;


public class ReviewServiceImpl implements ReviewService {

	private ReviewDao reviewDao;

	public ReviewDao getReviewDao() {
		return reviewDao;
	}

	public void setReviewDao(ReviewDao reviewDao) {
		this.reviewDao = reviewDao;
	}

	//리뷰 작성
	@Override
	public void writeReview(int reservation_id, Review review) throws Exception {
		reviewDao.writeReview(reservation_id, review);
	}

	//리뷰 조회
	@Override
	public Review searchReviewById(int review_id) throws Exception {
		return reviewDao.searchReviewById(review_id);
	}

	//리뷰 삭제
	@Override
	public void deleteReview(int review_id) throws Exception {
		reviewDao.deleteReview(review_id);
	}

	//예약번호로 리뷰 조회
	@Override
	public Review searchReviewByResId(int reservation_id) throws Exception {
		return reviewDao.searchReviewByResId(reservation_id);
	}
	
	@Override
	public List<String> isReviewLiked(String reviewIds, String userId) throws Exception {
		return reviewDao.isReviewLiked(reviewIds, userId);
	}

	@Override
	public List<String> isReviewHated(String reviewIds, String userId) throws Exception {
		return reviewDao.isReviewHated(reviewIds, userId);
	}

	@Override
	public void likeReview(String reviewId, String userId) throws Exception {
		reviewDao.likeReview(reviewId, userId);
	}

	@Override
	public void hateReview(String reviewId, String userId) throws Exception {
		reviewDao.hateReview(reviewId, userId);
	}

	@Override
	public void deleteLikeReview(String reviewId, String userId) throws Exception {
		reviewDao.deleteLikeReview(reviewId, userId);
	}

	@Override
	public void deleteHateReview(String reviewId, String userId) throws Exception {
		reviewDao.deleteHateReview(reviewId, userId);
	}
	
	@Override
	public String getReviewCountById(String reviewId) throws Exception {
		return reviewDao.getReviewCountById(reviewId);
	}

}





