<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title> hello.jsp </title>
</head>
<body>

<h2> hello . jsp  </h2>
<h2> 메세지 : ${requestScope.message } </h2>

<h2> 팀명 </h2>
<ul>
  <c:forEach var="team" items="${list} ">
   <li> ${team}</li>
  </c:forEach>
</ul>


</body>
</html>