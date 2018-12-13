<%@page import="kr.or.kosta.shoppingmall.common.dao.User"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.kosta.shoppingmall.common.dao.UserDao"%>
<%@page import="kr.or.kosta.shoppingmall.common.dao.JdbcDaoFactory_pre"%>
<%@page import="kr.or.kosta.shoppingmall.common.dao.DaoFactory"%>
<%@ page language="java" contentType="text/html; charset=utf-8" %>

<%
	DaoFactory factory= new JdbcDaoFactory_pre();
UserDao dao = factory.getUserDao();
List<User> list= dao.listAll();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>  </title>
</head>
<body>
<h3> Dao 생성을 독립적인 클래스(팩토리)로 캡슐화 – 추상 팩토리 패턴 적용 </h3>

<table>
  <tr>
    <th>아이디</th>
    <th>이름</th>
    <th>이메일</th>
    <th>가입일</th>
  </tr>
  
  <%
  for(User user: list){
  %>
    <tr>
      <td> <%= user.getId() %></td>
      <td> <%= user.getName() %></td>
      <td> <%= user.getPasswd() %></td>
      <td> <%= user.getRegdate() %></td>
    </tr>
  <%
  }
  %>
  
  
</table>

</body>
</html>