<%@ page language="java" contentType="text/html; charset=utf-8" %>

<%--  web.xml에 등록했으므로 이거 안써도 됨
<%@ page errorPage="errorHandlingPage.jsp" %>
--%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>

<h2> 올바른 예외 처리 </h2>
<%
  String name= null;
  name.length();
  //여기서 에러가 발생하면 errorPage로 이동한다 
%>


</body>
</html>