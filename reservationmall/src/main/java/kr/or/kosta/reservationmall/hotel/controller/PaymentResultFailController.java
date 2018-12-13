package kr.or.kosta.reservationmall.hotel.controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import kr.or.kosta.reservationmall.common.controller.Controller;
import kr.or.kosta.reservationmall.common.controller.ModelAndView;
import kr.or.kosta.reservationmall.common.factory.XMLObjectFactory;
import kr.or.kosta.reservationmall.hotel.service.HotelPaymentService;
import kr.or.kosta.reservationmall.hotel.service.HotelPaymentServiceImpl;
import kr.or.kosta.reservationmall.login.service.LoginService;
import kr.or.kosta.reservationmall.login.service.LoginServiceImpl;

public class PaymentResultFailController implements Controller{
	Logger logger = Logger.getLogger(Controller.class);
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		ModelAndView mav = new ModelAndView();
				
		mav.setView("/WEB-INF/view/payment/fail.jsp");

		return mav;
	}
}
