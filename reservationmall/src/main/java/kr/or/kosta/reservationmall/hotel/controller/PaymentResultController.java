package kr.or.kosta.reservationmall.hotel.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import kr.or.kosta.reservationmall.common.controller.Controller;
import kr.or.kosta.reservationmall.common.controller.ModelAndView;

public class PaymentResultController implements Controller{
	Logger logger = Logger.getLogger(Controller.class);
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		ModelAndView mav = new ModelAndView();
				
		mav.setView("/WEB-INF/view/payment/success.jsp");

		return mav;
	}
}
