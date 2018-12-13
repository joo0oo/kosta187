<%@page import="kr.or.kosta.jsp.dao.User"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
List<String> teams = new ArrayList<String>();
teams.add("한화");
teams.add("두산");
teams.add("SK");
request.setAttribute("teams", teams);

List<User> users= new ArrayList<User>();
users.add(new User("bangry1","김기정","1111","bb@naver.com","2002"));
users.add(new User("bangry2","김기정","1111","bb@naver.com","2002"));
users.add(new User("bangry3","김기정","1111","bb@naver.com","2002"));
users.add(new User("bangry4","김기정","1111","bb@naver.com","2002"));
request.setAttribute("users", users);
%>
<html>
<head>
<meta charset="utf-8">
<title></title>
</head>
<body>

<c:forEach var="i" begin="1" end="10" step="1"> 
<%-- 이때 i는 page scope에 저장됨 (key & value)
end값 포함해서 반복, step 생략하면 디폴트 1 --%>
${i} : 김기정입니다 <br>
</c:forEach>

<table border="1">
<c:forEach var="i" begin="2" end="9" step="1"> 
  <tr>
  <c:forEach var="j" begin="1" end="9">
    <td>${i} * ${j} = ${i*j}</td>
  </c:forEach>
  </tr>
</c:forEach>
</table>


<select>
  <c:forEach var="team" items="${teams}">
    <option> ${team} </option>
  </c:forEach>
</select>

<table border="1">
<tr>
  <th> 번호 </th>
  <th> 아이디 </th>
  <th> 이름</th>
  <th> 비밀번호 </th>
  <th> 이메일 </th>
  <th> 가입일자 </th>
</tr>
<c:choose>
  <c:when test="${not empty users}">
    <c:forEach var="user" items="${users}" varStatus="status">
      <tr>
        <td> ${status.count} </td>
        <td> ${user.id} </td>
        <td> ${user.name} </td>
        <td> ${user.passwd} </td>
        <td> ${user.email} </td>
        <td> ${user.regdate} </td>
      </tr>
    </c:forEach>
  </c:when>
  <c:otherwise>
    <tr>
      <td colspan="5">회원이 존재하지 않습니다</td>
    </tr>
  </c:otherwise>
</c:choose>
</table>

<% 
String ssn= "680313-1234567";
request.setAttribute("ssn", ssn);
%>

<c:forTokens var = "token" items="${ssn}" delims="-">
  ${token},
</c:forTokens>



</body>
</html>