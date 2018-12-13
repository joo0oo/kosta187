<%@page import="kr.or.kosta.blog.footage.Footage"%>
<%@page import="kr.or.kosta.blog.footage.FootageDao"%>
<%@page import="kr.or.kosta.blog.dao.DaoFactory"%>
<%@page import="kr.or.kosta.blog.dao.JdbcDaoFactory"%>
<%@ page language="java" contentType="text/html; charset=utf-8" %>

<%
request.setCharacterEncoding("utf-8");
	String footageTXT = request.getParameter("contents");
    if(footageTXT != null){
    	String userID = null;
    	Cookie[] cookies = request.getCookies();
    	if (cookies != null) {
    		for (Cookie cookie : cookies) {
    			if (cookie.getName().equals("id")) {
    				cookie.setPath("/");
    				userID = cookie.getValue();
    				break;
    			}
    		}
    	}
      
    	System.out.println(userID);
      if(userID != null){
        if(application.getAttribute("factory") == null){
        }
    	DaoFactory factory= (DaoFactory) application.getAttribute("factory");
    	FootageDao dao = factory.getFootageDao();
        dao.create(new Footage(1,userID,footageTXT,"SYSDATE"));
      }
      
    }
    response.sendRedirect("/boards/footage-board.jsp");
    
%>