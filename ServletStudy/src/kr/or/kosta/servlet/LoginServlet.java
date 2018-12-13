package kr.or.kosta.servlet;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

	
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//로그인 처리 
		String id= request.getParameter("userid");
		String pw= request.getParameter("userpw");

		//UserDao를 이용한 회원 가입 여부 체크
		/* 추후 구현 */
		
		Cookie cookie = new Cookie("loginId", id);
		cookie.setPath("/");
		response.addCookie(cookie);
		
		response.sendRedirect("index.html");
	}
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//로그아웃 처리 
		Cookie[] cookies= request.getCookies();
		if(cookies != null) {
			for (Cookie cookie : cookies) {
				if(cookie.getName().equals("loginId")) {
					cookie.setPath("/");
					cookie.setMaxAge(0); //해당 쿠키 삭제 (유효시간 0) -> 빈 쿠키 됨
					response.addCookie(cookie); //빈 쿠키로 업데이트
					break;
				}
			}
		}
		response.sendRedirect("index.html");
	}
}
