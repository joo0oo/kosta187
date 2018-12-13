<%@page import="kr.or.kosta.blog.dao.JdbcDaoFactory"%>
<%@page import="kr.or.kosta.blog.dao.DaoFactory"%>
<%@ page language="java" contentType="text/html; charset=utf-8" %>

<%!

public void jspInit() {
	DaoFactory factory = new JdbcDaoFactory();
    getServletContext().setAttribute("factory", factory);
	System.out.println("! factory !");
}

%>