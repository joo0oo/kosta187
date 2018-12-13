<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%

int age= 400;
%>

<jsp:forward page="hello.jsp">
  <jsp:param value="Steve" name="name"/>
  <jsp:param value="<%=age %>" name="age"/>

</jsp:forward>

<%
 //request.setAttrbute("name", "value");
 // application.getRequestDispatcher().forward(request,response);
%>