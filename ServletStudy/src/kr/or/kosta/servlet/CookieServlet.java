package kr.or.kosta.servlet;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CookieServlet extends HttpServlet {

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id="bangry";
		String id2="방그리";
		
		id2= URLEncoder.encode(id2, "utf-8");
		Cookie cookie = new Cookie("loginId", id);
		cookie.setMaxAge(60*60*24*30); //유효 시간 (초단위)
//		cookie.setDomain("http://www.naver.com");
//		cookie.setPath("/"); //모든 위치에서 이 쿠키 사용
		response.addCookie(cookie); // addCookie() 가 알아서 형식 지정해서 헤더에 쿠키 밀어넣어줌
		
		
		response.sendRedirect("hello2");
	}
}
