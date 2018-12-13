<!DOCTYPE html>
<%@page import="java.util.Calendar"%>
<%@ page contentType="text/html; charset=utf-8" %>
<html>
<head>
<meta charset="utf-8">
<title> </title>
</head>
<body style="font-size:20pt">

<%-- jsp 주석입니다 --%>
<!--  html 주석 입니다  -->

JSP 테스트를 위한 페이지 입니당~ <!-- 정적인 html 내용은 out.write()로 자동으로 써짐 -->
-------------------------------<br> 
<%
/* 자바 코드를 쓴다 : jsp의 service 영역에 들어감 */
String mesage= "주현이의 친구보따리"; //지역변수가 된다 
Calendar today= Calendar.getInstance();
out.println(today.toString());
%>

-------------------------------<br> 
<%
out.println("jsp 입니다");
%>

-------------------------------<br> 
<%
out.println("jsp 입니다");
%>

-------------------------------<br> 

<%! 
// 선언문 : 전역변수가 된다 
int counter; 
public void printMessage(String message){
  System.out.println(message);
  //out.println(message); // out은 service()의 지역변수이므로 /% %/ 안에서만 사용 가능 
}
%>

<%
String msg= "쉬었다 합시다";
out.println(msg); //원래 jsp를 활용한 출력은 이렇게 써야한다
%>

간단한 출력문을 활용한 메세지 : <%= msg%> 입니다
<%-- 간단하게 html안에서 jsp 변수를 출력할때 이렇게 쓸 수 있다 --%>
</body>
</html>