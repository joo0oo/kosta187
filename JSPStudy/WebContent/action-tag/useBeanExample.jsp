<%@page import="kr.or.kosta.jsp.Account"%>
<%@ page language="java" contentType="text/html; charset=utf-8" %>
<% 
//java식 객체 생성
Account account2 = new Account("111-222","김기정",111,10000); //정적 생성
//jsp에서는 이렇게 객체 생성
Class.forName("kr.or.kosta.jsp.Account").newInstance(); //동적 생성
%>

<%-- jsp에서 java 객체 생성  --%>
<jsp:useBean id="account" class="kr.or.kosta.jsp.Account" scope="request"> </jsp:useBean>
<jsp:setProperty name="account" property="accountNum" value="9999-1212" />
<jsp:setProperty name="account" property="accountOwner" value="김기정" />
<jsp:setProperty name="account" property="passwd" value="1212" />
<jsp:setProperty name="account" property="restMoney" value="120000" />

<jsp:forward page="useBeanExample2.jsp"></jsp:forward>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>

계좌번호 : <%= account.getAccountNum() %> <br>
예금주명 : <%= account.getAccountOwner() %> <br>
비밀번호 : <%= account.getPasswd() %> <br>
잔액 : <%= account.getRestMoney() %> <br>

<%-- 클래스 내부의 getter/setter 메소드 대신 이렇게 사용 --%>
계좌번호 : <jsp:getProperty property="accountNum" name="account"/> <br>
예금주명 : <jsp:getProperty property="accountOwner" name="account"/> <br>
비밀번호 : <jsp:getProperty property="passwd" name="account"/> <br>
잔액 : <jsp:getProperty property="restMoney" name="account"/> <br>

</body>
</html>