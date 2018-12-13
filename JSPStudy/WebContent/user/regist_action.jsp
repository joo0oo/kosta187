<%-- DB 처리만 하는 문서 --%>
<%@page import="kr.or.kosta.shoppingmall.common.dao.UserDao"%>
<%@page import="kr.or.kosta.shoppingmall.common.dao.DaoFactory"%>
<%@page import="kr.or.kosta.shoppingmall.common.dao.JdbcDaoFactory_pre"%>
<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%
	request.setCharacterEncoding("utf-8");
%>

<%-- 디폴트 생성자 --%>
<jsp:useBean id="user"  class="kr.or.kosta.shoppingmall.dao.User" scope="request"/>

<%-- 모든 값 한번에 할당 --%>
<jsp:setProperty property="*" name="user"/>

<%
	DaoFactory factory = new JdbcDaoFactory_pre();
UserDao dao= factory.getUserDao();
dao.create(user);

//가입 결과창 jsp 문서로 디스패치
%>

<jsp:forward page="regist_result.jsp"/>