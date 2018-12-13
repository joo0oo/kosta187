<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="score" value="85" scope="request" />
<html>
<head>
<meta charset="utf-8">
<title></title>
</head>
<body>

<%--  
<%
int score= (Integer)request.getAttribute("score");
if( score >= 50){
 %>
 <%= "통과" %>
 <%  
}
%>
 --%>
 
 <c:if test="${score >= 50}" >
 통과
 </c:if>
 
 <c:if test"${empty param }">
  <c:set var="page" value="1"> </c:set>
 </c:if>
 
</body>
</html>