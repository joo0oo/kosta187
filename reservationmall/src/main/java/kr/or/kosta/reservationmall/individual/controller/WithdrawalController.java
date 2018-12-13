package kr.or.kosta.reservationmall.individual.controller;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import kr.or.kosta.reservationmall.common.controller.Controller;
import kr.or.kosta.reservationmall.common.controller.ModelAndView;
import kr.or.kosta.reservationmall.common.factory.XMLObjectFactory;
import kr.or.kosta.reservationmall.individual.service.UserService;
import kr.or.kosta.reservationmall.individual.service.UserServiceImpl;
import kr.or.kosta.reservationmall.login.dto.User;

/**
 * 회원 탈퇴 처리 
 * @author 송주현
 *
 */
public class WithdrawalController implements Controller {
	private UserService userService;
	Logger logger = Logger.getLogger(Controller.class);

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		ModelAndView mav = new ModelAndView();
		XMLObjectFactory factory = (XMLObjectFactory)request.getServletContext().getAttribute("objectFactory");
		userService = (UserService)factory.getBean(UserServiceImpl.class);
		
		logger.debug("WithdrawalController start");
		String userId= (String) request.getAttribute("userId");
		
		String res= "";
		response.setContentType("text/plain; charset=utf-8");
		PrintWriter out = null;
		
		try {
			//결과 전달
			out = response.getWriter();
			userService.deleteUser(userId);
			res="withdrawalSuccess";
			
		} catch (Exception e) {
			res="withdrawalFail";
			throw new ServletException(e.getMessage(),e);
		}
		
		out.println(res);
		return null;
	}

}
