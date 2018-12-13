<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%--
<%@ page isELIgnored="true" %> :이 문서 내용을 일반 텍스트로 취급
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>EL 연습 3 </title>
</head>
<body>
<h3>  EL은 지역변수에 접근하는게 아니라 scope객체에 저장된 데이터에 접근하기 위한 방법임</h3>
<%
//테스트를 위한 Scope 객체에 데이터 저장
String today= String.format("%1tF %1$tT", Calendar.getInstance());
request.setAttribute("today", today);
session.setAttribute("id", "bangry");
String[] names= {"김기정" , "박기정", "최기정"};

%>

<%= request.getAttribute("today") %><br> <%-- 이 방법 말고 다른 방법을 사용하자 --%>
${ requestScope.today }<br> <%-- 같은뜻 --%>
${ today }<br> <%-- 같은뜻 --%>

<%= pageContext.findAttribute("id") %><br>  
${ id }<br> <%-- 같은뜻 --%>

${names[0]} ${names[1]} ${names[2]}  <br> <%-- names는 지역변수라서 안나옴 --%>



<jsp:useBean id="myDog" class="kr.or.kosta.jsp.el.Dog" scope="page" />
<jsp:setProperty property="name" name="myDog" value="Jack"/>

<jsp:useBean id="student" class="kr.or.kosta.jsp.el.Student" scope="page" />
<jsp:setProperty property="name" name="student" value="Hugh"/>
<%-- <jsp:setProperty property="dog" name="student" value="myDog"/> --%> 
<%-- 이렇게 하면 student의 dog멤버에 myDog객체가 아니라 "myDog"라는 문자열이 들어감 --%>
<jsp:setProperty property="dog" name="student" value="${myDog}"/> <%-- 이렇게 해야 위에서 만든 myDog객체를 넣을수 있음 --%>

<br>
<jsp:getProperty property="id" name="student"/> <%-- student 객체의 id 멤버변수 --%>
<jsp:getProperty property="name" name="student"/> <%-- student 객체의 name 멤버변수 --%>
<jsp:getProperty property="dog" name="student"/> <%-- student 객체의 dog멤버(객체)를 호출하고 싶은데 이러면 객체 자체가 아니라 toString이 호출 --%>
<br>
${student.id } <%-- student 객체의 id 멤버변수 --%>
${student.name } <%-- student 객체의 name 멤버변수 --%>
${student.dog } <%-- student 객체의 dog멤버(객체)호출 가능 --%>
<br>
${student.setName("기정") }
${student.getName() }
${student.name }

</body>
</html>