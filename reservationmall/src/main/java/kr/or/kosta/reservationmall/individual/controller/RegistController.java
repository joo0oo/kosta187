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
 * 실제 회원 가입 처리
 * @author 송주현
 *
 */
public class RegistController implements Controller {
	private UserService userService;
	Logger logger = Logger.getLogger(Controller.class);

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		ModelAndView mav = new ModelAndView();
		XMLObjectFactory factory = (XMLObjectFactory)request.getServletContext().getAttribute("objectFactory");
		userService = (UserService)factory.getBean(UserServiceImpl.class);
		
		System.out.println("RegistController start");
		
		String user_id=request.getParameter("user_id");
		String user_pw=request.getParameter("user_pw"); 
		String user_name=request.getParameter("name"); 
		String user_age=request.getParameter("user_age");
		String user_address=request.getParameter("user_address"); 
		String user_phonenum= request.getParameter("user_phonenum"); 
		String user_email=request.getParameter("email"); 
		//int user_rate = 4;
		
		User user= new User();
		user.setUser_id(user_id);
		user.setUser_pw(user_pw);
		user.setUser_email(user_email);
		user.setUser_name(user_name);
		user.setUser_age(user_age);
		user.setUser_address(user_address);
		user.setUser_phonenum(user_phonenum);
		//user.setUser_rate(user_rate);

		try {
			System.out.println(user);
			userService.createUser(user);
			mav.addObject("registResult", "success");
		} catch (Exception e) {
			mav.addObject("registResult", "fail");
		}
		
		//가입 확인 페이지로 
		mav.setView("/WEB-INF/view/login/regist.jsp");
		
		return mav;
	}
	
	

}
