<%@ page language="java" contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<h2> jsp가 제공하는 4개의 스코프(context) 객체들 결과 </h2>

<!--  pageContext로는 다른 페이지간 공유가 불가능하므로 이 값은 null -->
현재 페이지 정보 : <%= pageContext.getAttribute("message") %> <br>

<!--  request를 forward()했으므로 다른 페이지간 공유가 가능 (forward없으면 null) -->
request 정보 : <%= request.getAttribute("message") %> <br>

<!--  동일한 브라우저 요청이라면 데이터가 공유됨 (다른 브라우저이면 X)  -->
session 정보 : <%= session.getAttribute("message") %><br>

<!--  다른 브라우저까지 데이터 공유됨 (가장 범위 넓음)  -->
application 정보 : <%= application.getAttribute("message") %><br>

</body>
</html>