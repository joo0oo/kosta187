package kr.or.kosta.reservationmall.individual.controller;

import java.io.IOException;
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
import kr.or.kosta.reservationmall.individual.service.MyWishlistService;
import kr.or.kosta.reservationmall.individual.service.MyWishlistServiceImpl;

public class DeleteWishlistController implements Controller {
	private MyWishlistService myWishlistService;
	Logger logger = Logger.getLogger(Controller.class);
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		
		logger.debug(" DeleteWishlistController start ");
		
		XMLObjectFactory factory = (XMLObjectFactory)request.getServletContext().getAttribute("objectFactory");
		myWishlistService = (MyWishlistService)factory.getBean(MyWishlistServiceImpl.class);
		
		int hotel_id = Integer.parseInt(request.getParameter("hotel_id"));
		String user_id = request.getParameter("user_id");
		
		logger.debug("hotel_id:" + hotel_id);
		logger.debug("user_id:" + user_id);
		
		PrintWriter out = null;
		String res = null;
		response.setContentType("text/plain; charset=utf-8");
		
		try {
			myWishlistService.deleteWishlist(user_id, hotel_id);
			res="success";
		} catch (Exception e) {
			res="fail";
			e.printStackTrace();
		}
		
		try {
			out = response.getWriter();
			out.println(res);
		} catch (IOException e) {
			throw new ServletException(e.getMessage(),e);
		}
		
		return null;
	}
	
}
