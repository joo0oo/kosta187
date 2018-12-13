<%@ page language="java" contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>EL 연습</title>
</head>
<body>

${ "김기정" }
${ '김기정' }
${ 512 }
${ null }
${ false }
${ true }
<br>


<%= 10+20 %>
${10 + 20 }
<br>
<%= 10+"20" %>
${10 + "20" }
<br>
<%-- 에러 :
<%= 10*"20" %>   --%>
${10 * "20" }
<br>
${true && false } <!--  결과 false -->
${true and false } <!--  같은 결과 -->

${empty null }  <!--  결과 true -->
${empty  ""}  <!--  결과 true (빈 문자열) -->

</body>
</html>