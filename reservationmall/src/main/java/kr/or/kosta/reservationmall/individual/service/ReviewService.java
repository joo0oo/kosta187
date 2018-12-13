package kr.or.kosta.reservationmall.individual.service;

import java.util.List;

import kr.or.kosta.reservationmall.individual.dto.ReservationInfo;
import kr.or.kosta.reservationmall.individual.dto.Review;

/**
 * 마이페이지 리뷰 기능 처리 
 * @author 송주현
 */
public interface ReviewService {
	
	//리뷰 작성
	public void writeReview(int reservation_id, Review review) throws Exception;
	
	//리뷰 조회
	public Review searchReviewById(int review_id) throws Exception;
	
	//예약번호로 리뷰 조회
	public Review searchReviewByResId(int reservation_id) throws Exception;
	
	//리뷰 삭제
	public void deleteReview(int review_id) throws Exception;
	
	// 지원 1113 추가
	
	public List<String> isReviewLiked(String reviewIds, String userId) throws Exception;

	public List<String> isReviewHated(String reviewIds, String userId) throws Exception;

	public void likeReview(String reviewId, String userId) throws Exception;

	public void hateReview(String reviewId, String userId) throws Exception;

	public void deleteLikeReview(String reviewId, String userId) throws Exception;

	public void deleteHateReview(String reviewId, String userId) throws Exception;
	
	public String getReviewCountById(String reviewId) throws Exception;
	
}
