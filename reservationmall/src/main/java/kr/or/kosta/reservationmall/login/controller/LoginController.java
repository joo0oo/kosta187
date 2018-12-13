package kr.or.kosta.reservationmall.login.controller;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import kr.or.kosta.reservationmall.common.controller.Controller;
import kr.or.kosta.reservationmall.common.controller.ModelAndView;
import kr.or.kosta.reservationmall.common.factory.XMLObjectFactory;
import kr.or.kosta.reservationmall.login.service.LoginService;
import kr.or.kosta.reservationmall.login.service.LoginServiceImpl;

/**
 * /user/list.mall에 대한 요청 처리 컨트롤러
 * @author 김기정
 *
 */
public class LoginController implements Controller {
	private LoginService loginService;
	Logger logger = Logger.getLogger(Controller.class);

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		ModelAndView mav = new ModelAndView();
		
		XMLObjectFactory factory = (XMLObjectFactory)request.getServletContext().getAttribute("objectFactory");
		loginService = (LoginService)factory.getBean(LoginServiceImpl.class);
		
		boolean check = false;
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		String rememId = request.getParameter("rememId");
		
		
		String url = request.getParameter("daoType");
		switch(url) {
		case "checkLogin":
			try {
				check = loginService.checkLogin_hjh(user_id, user_pw);	
			} catch (Exception e) {
				throw new ServletException("UserService.list() 예외 발생", e);
			}
			if(check) {
				if(rememId != null) {
					Cookie remember = new Cookie("rememId", user_id);
					remember.setPath("/");
					remember.setMaxAge(7*24*60*60);//아이디 저장 시 일주일간 쿠키 보관
					response.addCookie(remember);
				}else {
					Cookie remember = new Cookie("rememId", "");
					remember.setPath("/");
					response.addCookie(remember);
				}
				Cookie cookie = new Cookie("loginId", user_id);
				cookie.setPath("/");
				cookie.setMaxAge(-1);
				response.addCookie(cookie);
				
				Cookie cookieLoginSuc = new Cookie("loginCheck", "success");
				cookieLoginSuc.setPath("/");
				cookieLoginSuc.setMaxAge(-1);
				response.addCookie(cookieLoginSuc);
			}else {
				Cookie cookieLoginFail = new Cookie("loginCheck", "fail");
				cookieLoginFail.setPath("/");
				cookieLoginFail.setMaxAge(-1);
				response.addCookie(cookieLoginFail);
			}
				mav.setView("redirect:/reservationmall/index.jsp");
			    return mav;
		case "hotelSearch":
			try {
				check = loginService.checkLogin_hjh(user_id, user_pw);
				check = loginService.checkLogin_hjh(user_id, user_pw);
			} catch (Exception e) {
				throw new ServletException("UserService.list() 예외 발생", e);
			}
			if (check) {
				if (rememId != null) {
					Cookie remember = new Cookie("rememId", user_id);
					remember.setPath("/");
					remember.setMaxAge(7 * 24 * 60 * 60);// 아이디 저장 시 일주일간 쿠키 보관
					response.addCookie(remember);
				} else {
					Cookie remember = new Cookie("rememId", "");
					remember.setPath("/");
					response.addCookie(remember);
				}
				Cookie cookie = new Cookie("loginId", user_id);
				cookie.setPath("/");
				cookie.setMaxAge(-1);
				response.addCookie(cookie);

				if (request.getSession().getAttribute("refreshPage") != null
						&& !((boolean) request.getSession().getAttribute("refreshPage"))) {
					request.getSession().removeAttribute("refreshPage");
				} else {
					mav.addObject("refreshPage", true);
				}
				mav.addObject("loginCheck", "success");
			} else {
				mav.addObject("loginCheck", "fail");
			}
			mav.setView("/hotel/searchhotel.mall");
			return mav;
		default:
				return null;
		}
	}
	
	

}
