package kr.or.kosta.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class myCookie extends HttpServlet {

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int myCount=1;
		String counter=String.valueOf(myCount);
		
		Cookie cookie = new Cookie("myCount", counter);
		cookie.setMaxAge(60*60*24*30); //유효 시간 (초단위)
		response.addCookie(cookie); // addCookie() 가 알아서 형식 지정해서 헤더에 쿠키 밀어넣어줌
		response.sendRedirect("hello3");
		
		System.out.println(counter);
	}
}
