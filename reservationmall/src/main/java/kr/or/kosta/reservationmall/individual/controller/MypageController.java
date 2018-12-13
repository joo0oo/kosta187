package kr.or.kosta.reservationmall.individual.controller;

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
 * 마이페이지로 forward
 * @author 송주현
 *
 */
public class MypageController implements Controller {
	private UserService userService;
	Logger logger = Logger.getLogger(Controller.class);

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		ModelAndView mav = new ModelAndView();
		XMLObjectFactory factory = (XMLObjectFactory)request.getServletContext().getAttribute("objectFactory");
		userService = (UserService)factory.getBean(UserServiceImpl.class);
		
		System.out.println("mypage controller");
		
		//마이 페이지로 
		mav.setView("/WEB-INF/view/individual/mypage.jsp");
		
		return mav;
	}
	
	

}
