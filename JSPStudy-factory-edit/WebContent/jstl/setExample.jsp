<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
String message="jstl <연습>입니다";
request.setAttribute("message", message);
%>

<c:set var="message" value="jstl <연습>입니다" scope="page"/> <%-- 같은뜻 --%>
<c:set target="${dog}" property="name" value="뽀삐"></c:set>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
</head>
<body>
${message}
<br>
<c:out value="김기정"> </c:out> <!-- 정적 데이터 출력 (excape처리 못함) -->
<br>
<c:out value=" ${message}" default="디폴트 메세지"/> <!-- 동적 데이터 출력 (escape 처리 자동으로 됨)-->

강아지 이름 : ${dog.name}

</body>
</html>