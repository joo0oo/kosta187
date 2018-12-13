<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- 
<c:redirect url="https://www.daum.net"></c:redirect>
--%>

<%-- 
<c:redirect url="https://www.daum.net">
  <c:param name="id" value="bangry" />
  <c:param name="name" value="김기정" />
</c:redirect>
--%>

<%-- 
<c:redirect url="/user/list.jsp" />  이거 불가능 
--%>

<%-- url에는 path만 지정, context에 web app 이름 지정 --%>
<c:redirect url="/list.jsp"  context="/jsp" />
