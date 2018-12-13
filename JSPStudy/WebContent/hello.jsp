<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%@ page import="java.util.Calendar" %> 
<%@ include file="jspf/common.jspf" %>

<%-- 
<%! //선언문 : 인스턴스 변수 -> 초기화 하려면 init()을 오버라이딩 해야한다 
int count; 

public void jspInit() {
  //jsp에서는 httpServlet의 init()이 아니라 init을 한번더 상속받은 _jspInit()을 사용하므로 이것을 오버라이딩 
  count= 0;
}

public void jspDestroy() {
  count= 0;
}
%>
 --%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title> </title>
</head>
<body>

<h2> 구구단 </h2>
<table border="1" width="80%">
<%
for(int i=2; i<10; i++){
%>
<tr>
<% 
for(int j=1; j<10; j++){
  %>
   <td> <%= i %>* <%= j %> = <%= i*j %> </td>
  <%
}
%>
 
</tr>
<% 
}
%>
</table>

<h2> 당신은 <%= ++count %> 번째 방문자 입니다 </h2>
<h2> <%= request.getParameter("name") %>, <%= request.getParameter("age")%> </h2>
</body>
</html>