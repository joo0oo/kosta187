package kr.or.kosta.reservationmall.individual.controller;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import kr.or.kosta.reservationmall.common.controller.Controller;
import kr.or.kosta.reservationmall.common.controller.ModelAndView;
import kr.or.kosta.reservationmall.common.factory.XMLObjectFactory;
import kr.or.kosta.reservationmall.individual.service.AddWishlistService;
import kr.or.kosta.reservationmall.individual.service.AddWishlistServiceImpl;

public class AddWishlistController implements Controller {
	private AddWishlistService addWishlistService;
	Logger logger = Logger.getLogger(Controller.class);
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		
		int hotel_id = Integer.parseInt(request.getParameter("hotel_id"));
		String user_id = request.getParameter("user_id");
		logger.debug("hotel_id:" + hotel_id);
		logger.debug("user_id:" + user_id);
		
		PrintWriter out = null;
		String resultType = null;
		
		XMLObjectFactory factory = (XMLObjectFactory)request.getServletContext().getAttribute("objectFactory");
		addWishlistService = (AddWishlistService)factory.getBean(AddWishlistServiceImpl.class);
		try {
			boolean existCheck = (boolean)addWishlistService.existWishCheck(hotel_id, user_id);
			if(existCheck) {
				resultType="exist";
			}else {
				boolean addCheck = addWishlistService.addWishlist(hotel_id, user_id);
				if(addCheck) {
					resultType="success";
				}else {
					resultType="fail";
				}
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		response.setContentType("text/plain; charset=utf-8");
		try {
			out = response.getWriter();
			out.println(resultType);
		} catch (Exception e) {
			throw new ServletException(e.getMessage(),e);
		}
		
		return null;
	}
	
}
