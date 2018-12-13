<%@page import="kr.or.kosta.blog.user.UserDao"%>
<%@page import="kr.or.kosta.blog.user.User"%>
<%@page import="kr.or.kosta.blog.dao.JdbcDaoFactory"%>
<%@page import="kr.or.kosta.blog.dao.DaoFactory"%>
<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%
	System.out.println(" logout ");
	Cookie cookie = new Cookie("id", null);
	cookie.setPath("/");
	cookie.setMaxAge(0); //해당 쿠키 삭제 (유효시간 0) -> 빈 쿠키 됨
	response.addCookie(cookie); //빈 쿠키로 업데이트

	response.sendRedirect("/index.jsp");
%>