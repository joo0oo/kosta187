<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="score" value="85" scope="request" />
<html>
<head>
<meta charset="utf-8">
<title></title>
</head>
<body>
<%
String url="https://www.naver.com";
%>
<a href="<%=url%>"> 이동 </a>

<c:url var="url" value="https://www.naver.com"> 
  <c:param name="id" value="bangry" />
  <c:param name="name" value="김기정" />
</c:url>

</body>
</html>