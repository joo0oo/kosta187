package kr.or.kosta.reservationmall.individual.controller;

import java.io.IOException;
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
 * 아이디와 이메일 중복확인
 * @author 송주현
 *
 */
public class RegistValidationController implements Controller {
	private UserService userService;
	Logger logger = Logger.getLogger(Controller.class);

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		ModelAndView mav = new ModelAndView();
		XMLObjectFactory factory = (XMLObjectFactory)request.getServletContext().getAttribute("objectFactory");
		userService = (UserService)factory.getBean(UserServiceImpl.class);
		
		System.out.println("RegistValidationController start");
		
		String res= "";
		response.setContentType("text/plain; charset=utf-8");
		PrintWriter out = null;
		
		String user_id=request.getParameter("user_id");
		if(user_id != null) {
			//id 중복 검사
			try {
				User user = userService.searchById(user_id);
				if (user == null) {
					// 없는 아이디
					res = "newId";
				} else {
					// 존재하는 아이디
					res = "usedId";
				}
			} catch (Exception e) {
				System.out.println(" * userService.searchById() 에러");
			}
		}
		
		
		String user_email=request.getParameter("email"); 
		if( user_email != null) {
			//이메일 중복 검사
			try {
				User user= userService.searchByEmail(user_email);
				if(user == null) {
					//없는 이메일
					res= "newEmail";
				} else {
					// 존재하는 이메일
					res= "usedEmail";
					/*
					String editing_tatus = request.getParameter("editing_tatus");
					if(editing_tatus.equals("editing")) {
						
						if(user_email.equals(userService.searchById(user_id).getUser_email())) {
							//기존 이메일을 수정하지 않은 경우 그대로 업데이트
							res= "myEmail";
						}
						
					} else {
						res= "usedEmail";
					}
					*/
				}
			} catch (Exception e) {
				System.out.println(" * userService.searchByEmail() 에러");
			}
		}
		
		
		try {
			//결과 전달
			response.setContentType("text/plain; charset=utf-8");
			out = response.getWriter();
			out.println(res);
		} catch (Exception e) {
			throw new ServletException(e.getMessage(),e);
		}
		
		
		/*
		try {
			System.out.println(user);
			userService.createUser(user);
			mav.addObject("registResult", "success");
		} catch (Exception e) {
			mav.addObject("registResult", "fail");
		}
		*/
		//가입 확인 페이지로 
		//mav.setView("/WEB-INF/view/login/regist_form.jsp");
		
		return null; //ajax 통신은 mav 사용하지 않음
	}
	
	

}
