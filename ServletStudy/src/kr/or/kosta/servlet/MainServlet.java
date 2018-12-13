package kr.or.kosta.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MainServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request,response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request,response);
	}

	public void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
	
		/*
		String userid= request.getParameter("userid"); //폼에서 입력한 값 (해당 태그의 name속성으로 접근)
		String passwd= request.getParameter("userpw");
		System.out.println(userid);
		
		Cookie cookie = new Cookie("userid", userid);
		cookie.setMaxAge(60*60*24*30); //유효 시간 (초단위)
		response.addCookie(cookie); // addCookie() 가 알아서 형식 지정해서 헤더에 쿠키 밀어넣어줌
		 */
		
		response.setContentType("text/html; charset=utf-8"); 
		PrintWriter out= response.getWriter(); //문자 출력 스트림
		
		String loginId=null;
		Cookie[] cookies= request.getCookies();
		if(cookies != null) {
			for (Cookie cookie : cookies) {
				System.out.println(cookie.getName()+" : "+cookie.getValue());
				if(cookie.getName().equals("loginId")) {
					loginId= cookie.getValue();
				}
			}
		}
		
		String loginFormHtml= 
				"        <form method=\"post\" action=\"login.do\" >\r\n" + 
				"          <input type=\"text\" id=\"userid\" name=\"userid\" placeholder=\"Identifier...\">\r\n" + 
				"          <input type=\"password\" id=\"userpw\" name=\"userpw\" placeholder=\"Password...\">\r\n" + 
				"          <input type=\"submit\" value=\"Login\">\r\n" + 
				"        </form>\r\n" ;
		
		String afterLoginHtml=
				"		<p>"+loginId+" 님 로그인중 </p>"+
				"          <button onclick=\"location.href='login.do';\"> Logout </button>" ;

		if(loginId== null) {
			out.println(printHtml(loginFormHtml));
		} else {
			out.println(printHtml(afterLoginHtml));
		}
		
	}
	
	public String printHtml(String html) {
		String indexHtml=
				"<!DOCTYPE html>\r\n" + 
				"<html>\r\n" + 
				"<head>\r\n" + 
				"<link rel=\"stylesheet\" type=\"text/css\" href=\"css/basic.css\">\r\n" + 
				"</head>\r\n" + 
				"<body>\r\n" + 
				"\r\n" + 
				"<div class=\"header\">\r\n" + 
				"  <h1>My Website</h1>\r\n" + 
				"  <p>Resize the browser window to see the effect.</p>\r\n" + 
				"</div>\r\n" + 
				"\r\n" + 
				"<div class=\"topnav\">\r\n" + 
				"  <a href=\"#\">Link</a>\r\n" + 
				"  <a href=\"#\">Link</a>\r\n" + 
				"  <a href=\"#\">Link</a>\r\n" + 
				"  <a href=\"#\" style=\"float:right\">Link</a>\r\n" + 
				"</div>\r\n" + 
				"\r\n" + 
				"<div class=\"row\">\r\n" + 
				"  <div class=\"leftcolumn\">\r\n" + 
				"    <div class=\"card\">\r\n" + 
				"      <h2>TITLE HEADING</h2>\r\n" + 
				"      <h5>Title description, Dec 7, 2017</h5>\r\n" + 
				"      <div class=\"fakeimg\" style=\"height:200px;\">Image</div>\r\n" + 
				"      <p>Some text..</p>\r\n" + 
				"      <p>Sunt in culpa qui officia deserunt mollit anim id est laborum consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco.</p>\r\n" + 
				"    </div>\r\n" + 
				"    <div class=\"card\">\r\n" + 
				"      <h2>TITLE HEADING</h2>\r\n" + 
				"      <h5>Title description, Sep 2, 2017</h5>\r\n" + 
				"      <div class=\"fakeimg\" style=\"height:200px;\">Image</div>\r\n" + 
				"      <p>Some text..</p>\r\n" + 
				"      <p>Sunt in culpa qui officia deserunt mollit anim id est laborum consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco.</p>\r\n" + 
				"    </div>\r\n" + 
				"  </div>\r\n" + 
				"  \r\n" + 
				"  <div class=\"rightcolumn\">\r\n" + 
				"    <div class=\"card\">\r\n" + 
				"      <div>\r\n" + 
				
				/* 로그인 여부에 따른 처리 */
				html+
				
				"      </div>\r\n" + 
				"      \r\n" + 
				"    </div>\r\n" + 
				"    \r\n" + 
				"    <div class=\"card\">\r\n" + 
				"      <h3>Popular Post</h3>\r\n" + 
				"      <div class=\"fakeimg\"><p>Image</p></div>\r\n" + 
				"      <div class=\"fakeimg\"><p>Image</p></div>\r\n" + 
				"      <div class=\"fakeimg\"><p>Image</p></div>\r\n" + 
				"    </div>\r\n" + 
				"    <div class=\"card\">\r\n" + 
				"      <h3>Follow Me</h3>\r\n" + 
				"      <p>Some text..</p>\r\n" + 
				"    </div>\r\n" + 
				"  </div>\r\n" + 
				"</div>\r\n" + 
				"\r\n" + 
				"<div class=\"footer\">\r\n" + 
				"  <h2>Footer</h2>\r\n" + 
				"</div>\r\n" + 
				"\r\n" + 
				"</body>\r\n" + 
				"</html>\r\n" + 
				"";
		
		return indexHtml;
	}
}
