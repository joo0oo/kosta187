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
${title}
</h2>

<table borderl="1">
  
  <c:forEach items="${list}" var="employee">
  <tr>
    <td>${employee.employeeId}</td>
    <td>${employee.firstName}</td>
    <td>${employee.lastName}</td>
    <td>${employee.email}</td>
  </tr>
  </c:forEach>
</table>

</body>
</html>