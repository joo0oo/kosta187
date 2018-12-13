<%@ page language="java" contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<h2> jsp가 제공하는 4개의 스코프(context) 객체들 </h2>

<%
// 이 문서의 jsp의 지역변수를 이 문서의 다른 jsp 영역에도 전달하고 싶으면 pageContext에 저장해서 공유한다
// 다른 서블릿(jsp)에서는 접근 불가능 
pageContext.setAttribute("message", "page~context~ 스코프~객체~");

//request를 사용하면 다른 서블릿(jsp문서)로 데이터를 공유할 수 있다, 단 forward()를 꼭 해야 함
request.setAttribute("message", "request~ 스코프~객체~");
//application.getRequestDispatcher("/scopeObject2.jsp").forward(request, response);

//session은 동일 브라우저를 사용하는 jsp문서들끼리 정보 공유 
session.setAttribute("message", "session~스코프~객체~");

//
application.setAttribute("message", "application~스코프~객체");
%>

<%= pageContext.getAttribute("message") %> <br>



<%= pageContext.findAttribute("message") %>

</body>
</html>