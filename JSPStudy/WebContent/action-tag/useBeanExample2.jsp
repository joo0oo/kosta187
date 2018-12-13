<%@page import="kr.or.kosta.jsp.Account"%>
<%@ page language="java" contentType="text/html; charset=utf-8" %>
<% 
%>

<%-- jsp에서 java 객체 생성  --%>
<jsp:useBean id="account" class="kr.or.kosta.jsp.Account" scope="request"> </jsp:useBean>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title> 이미 만들어진 javaBean 객체 검색해서 불러오기 </title>
</head>
<body>

<h2> 이미 만들어진 javaBean 객체 검색해서 불러오기 </h2>

<%-- 클래스 내부의 getter/setter 메소드 대신 이렇게 사용 --%>
계좌번호 : <jsp:getProperty property="accountNum" name="account"/> <br>
예금주명 : <jsp:getProperty property="accountOwner" name="account"/> <br>
비밀번호 : <jsp:getProperty property="passwd" name="account"/> <br>
잔액 : <jsp:getProperty property="restMoney" name="account"/> <br>

</body>
</html>