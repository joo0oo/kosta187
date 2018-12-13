<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%request.setCharacterEncoding("utf-8"); %>

<jsp:useBean id="account" class="kr.or.kosta.jsp.Account" scope="request"></jsp:useBean>
<%-- 
name인 객체의 모든 속성(변수)을 자동으로 설정
form 태그의 name과 Java Bean 객체의 속성 이름(멤버 변수 이름)이 같아야 작동함
--%>
<jsp:setProperty property="*" name="account"/>

<%-- 
이름이 다르면 그 값은 객체에 저장되지 않음: setProperty의 param 속성을 활용한다 
property : 객체의 변수명/ param: 폼의 name 값
 --%>
<jsp:setProperty property="accountNum" param="num" name="account" />

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title> </title>
</head>
<body>

계좌번호 : <jsp:getProperty property="accountNum" name="account"/> <br>
예금주명 : <jsp:getProperty property="accountOwner" name="account"/> <br>
비밀번호 : <jsp:getProperty property="passwd" name="account"/> <br>
잔액 : <jsp:getProperty property="restMoney" name="account"/> <br>


</body>
</html>