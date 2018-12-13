<%@ page language="java" contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>EL 연습 2</title>
</head>
<body>

<h4> Param에 저장된 map</h4>
key값이 name인 param(없으면 null이 아닌 빈문자열) : <br>
${ param.name } <br>
${ param["name"] }<br>

<h4> ParamValues에 저장된 map (여러개)</h4>
${ paramValues.hobby[0] } <br>
${ paramValues.hobby[1] } <br>

<h4> header 정보가 저장된 map </h4>
${ header['user-agent'] } <br> <!-- 브라우저 정보 -->

<h4> header values : header정보가 하나의 이름에 값이 여러개로 들어오는 경우 배열로 받을 수 있음 </h4>
${ headerValues['xxx'] } <br> <!-- 브라우저 정보 -->

<h4> cookie 정보가 저장된 map </h4>
${ cookie.loginId.name } <br> <!-- 쿠키.이 쿠키의 이름. -->
${ cookie.loginId.value } <br>

<h4> EL 에서는 request에 pageContext로 접근  (pageContext는 유일하게 map이 아닌 객체)</h4>
<%= request.getMethod() %> <br> 
같은 뜻 : ${ pageContext.request.method } <br>

<h4>pageContext에 저장된 attribute들의 map</h4> 
${pageScope}  
<br>
<h4> Request에 저장된 attribute들의 map</h4>
${requestScope }
<br>
<h4> session 에 저장된 attribute들의 map</h4> 
${sessionScope}  
<br>
<h4> application에 저장된 attribute들의 map</h4>
${applicationScope }
<br>



</body>
</html>