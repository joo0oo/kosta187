package kr.or.kosta.reservationmall.individual.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import kr.or.kosta.reservationmall.common.controller.Controller;
import kr.or.kosta.reservationmall.common.controller.ModelAndView;
import kr.or.kosta.reservationmall.common.factory.XMLObjectFactory;
import kr.or.kosta.reservationmall.individual.dto.ReservationInfo;
import kr.or.kosta.reservationmall.individual.dto.Review;
import kr.or.kosta.reservationmall.individual.service.ReservationService;
import kr.or.kosta.reservationmall.individual.service.ReservationServiceImpl;
import kr.or.kosta.reservationmall.individual.service.ReviewService;
import kr.or.kosta.reservationmall.individual.service.ReviewServiceImpl;
import kr.or.kosta.reservationmall.individual.service.UserService;
import kr.or.kosta.reservationmall.individual.service.UserServiceImpl;


public class WriteReviewController implements Controller {
	
	private ReviewService reviewService;
	Logger logger = Logger.getLogger(Controller.class);
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		ModelAndView mav = new ModelAndView();
		
		XMLObjectFactory factory = (XMLObjectFactory)request.getServletContext().getAttribute("objectFactory");
		
		
		reviewService = (ReviewService)factory.getBean(ReviewServiceImpl.class);
		
		logger.debug("WriteReviewController start");
		int reservation_id= Integer.parseInt((String)request.getParameter("write-review_res_id"));
		
		Review review= new Review();
		int review_service_rate= Integer.parseInt(request.getParameter("review_service_rate"));
		int review_food_rate= Integer.parseInt(request.getParameter("review_food_rate"));
		int review_clean_rate= Integer.parseInt(request.getParameter("review_clean_rate"));
		int review_location_rate= Integer.parseInt(request.getParameter("review_location_rate"));
		int review_price_rate= Integer.parseInt(request.getParameter("review_price_rate"));
		String review_content= request.getParameter("review_content");
		
		review.setReview_content(review_content);
		review.setReview_service_rate(review_service_rate);
		review.setReview_food_rate(review_food_rate);
		review.setReview_clean_rate(review_clean_rate);
		review.setReview_location_rate(review_location_rate);
		review.setReview_price_rate(review_price_rate);
		
		try {
			
			reviewService.writeReview(reservation_id,review);
			mav.addObject("writingReviewRes", "success");
		} catch (Exception e) {
			throw new ServletException(e.getMessage(),e);
		}
		mav.setView("/WEB-INF/view/individual/mypage.jsp");
		
		return mav;

	}

}
