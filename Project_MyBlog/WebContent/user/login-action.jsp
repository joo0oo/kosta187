<%@page import="kr.or.kosta.blog.user.UserDao"%>
<%@page import="kr.or.kosta.blog.user.User"%>
<%@page import="kr.or.kosta.blog.dao.JdbcDaoFactory"%>
<%@page import="kr.or.kosta.blog.dao.DaoFactory"%>
<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%
    System.out.println(" login ");
		// 로그인 처리 
	String id = request.getParameter("id");
	String pw = request.getParameter("passwd");
    String rememberId= request.getParameter("remember-id");
    
        if(id==null || pw==null){
          return;  
        }
        
		//UserDao를 이용한 회원 가입 여부 체크
		DaoFactory factory = new JdbcDaoFactory();
		UserDao dao = factory.getUserDao();
		User user = dao.certify(id, pw);
		if (user != null) {
            //회원임
			Cookie cookie = new Cookie("id", id);
			cookie.setPath("/");
			response.addCookie(cookie);
      
			Cookie rememberCookie; //아이디 저장시 사용
            if(rememberId != null){
            	rememberCookie = new Cookie("rememberId", id);
            	
            } else{
            	rememberCookie = new Cookie("rememberId", null);
            }
            rememberCookie.setPath("/");
        	rememberCookie.setMaxAge(60*60*24*30); //유효 시간 (초단위)
            response.addCookie(rememberCookie);
			
			response.sendRedirect("/index.jsp");
		} else {
            //회원 아님 : alert()말고 다른 방법으로 구현하기 
            response.sendRedirect("/user/login-fail.jsp");
  %>
<%
		}

%>