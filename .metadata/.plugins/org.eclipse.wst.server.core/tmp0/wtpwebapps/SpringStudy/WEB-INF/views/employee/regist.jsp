<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>

<h2>
사원등록 화면
</h2>

<form method="post">
사원번호 : <input type="number" name="employeeId"> <br>
이름 : <input type="text" name="firstName"> <br>
성 : <input type="text" name="lastName"> <br>
이메일 : <input type="text" name="email"> <br>
  <input type="submit" value="등록">
</form>


</body>
</html>