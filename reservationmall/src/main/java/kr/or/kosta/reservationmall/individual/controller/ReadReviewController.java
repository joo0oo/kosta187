package kr.or.kosta.reservationmall.individual.controller;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;

import kr.or.kosta.reservationmall.common.controller.Controller;
import kr.or.kosta.reservationmall.common.controller.ModelAndView;
import kr.or.kosta.reservationmall.common.factory.XMLObjectFactory;
import kr.or.kosta.reservationmall.individual.dto.Review;
import kr.or.kosta.reservationmall.individual.service.ReviewService;
import kr.or.kosta.reservationmall.individual.service.ReviewServiceImpl;
import kr.or.kosta.reservationmall.individual.service.UserService;
import kr.or.kosta.reservationmall.individual.service.UserServiceImpl;
import kr.or.kosta.reservationmall.login.dto.User;

/**
 * 회원 탈퇴 처리 
 * @author 송주현
 *
 */
public class ReadReviewController implements Controller {
	
	private ReviewService reviewService;
	Logger logger = Logger.getLogger(Controller.class);

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		ModelAndView mav = new ModelAndView();
		XMLObjectFactory factory = (XMLObjectFactory)request.getServletContext().getAttribute("objectFactory");
		reviewService = (ReviewService)factory.getBean(ReviewServiceImpl.class);
		
		logger.debug("ReadReviewController start");
		
		String rId= (String) request.getParameter("reservation_id");
		logger.debug(" !!! ---- "+rId);
		int reservation_id= Integer.parseInt(rId);
	//	String res= "";
		Review review = new Review();
		response.setContentType("text/plain; charset=utf-8");
	//	response.setContentType("application/x-json charset=UTF-8");
		

		PrintWriter out = null;
		
		JSONObject jObj= new JSONObject();
		
		
		try {
			//결과 전달
			out = response.getWriter();
			review=reviewService.searchReviewByResId(reservation_id);
			
			String content= review.getReview_content();
       //     content= content.replace("\r\n","<br>");
            
            jObj.put("review_content", content);
			jObj.put("review_date", review.getReview_date());
			
			jObj.put("review_service_rate", review.getReview_service_rate());
			jObj.put("review_food_rate", review.getReview_food_rate());
			jObj.put("review_clean_rate", review.getReview_clean_rate());
			jObj.put("review_location_rate", review.getReview_location_rate());
			jObj.put("review_price_rate", review.getReview_price_rate());
			
			jObj.put("review_helpful_count", review.getReview_helpful_count());
			jObj.put("review_report_count", review.getReview_report_count());
			
			
		//	res="withdrawalSuccess";
			
		} catch (Exception e) {
		//	res="withdrawalFail";
			throw new ServletException(e.getMessage(),e);
		}
		
		out.println(jObj);
		return null;
	}

}
