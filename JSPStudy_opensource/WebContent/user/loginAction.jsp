<%@page import="kr.or.kosta.shoppingmall.common.dao.User"%>
<%@page import="kr.or.kosta.shoppingmall.common.dao.UserDao"%>
<%@page import="kr.or.kosta.shoppingmall.common.dao.JdbcDaoFactory_pre"%>
<%@page import="kr.or.kosta.shoppingmall.common.dao.DaoFactory"%>
<%@ page contentType="text/html; charset=utf-8" %>

<%
	//request.setCharacterEncoding("utf-8");
String id = request.getParameter("userid");
String pw = request.getParameter("userpw");
if(id == null || pw == null){
  return; 
}

//UserDao를 이용한 회원 가입여부 체크
DaoFactory factory = new JdbcDaoFactory_pre();
UserDao dao = factory.getUserDao();
User user = dao.certify(id, pw);
if(user != null){
	Cookie cookie = new Cookie("loginId", user.getId());
	cookie.setPath("/");
	response.addCookie(cookie);
	response.sendRedirect(application.getContextPath()+"/index.jsp");
}else{
%>
<script>
alert("회원이 아닌가벼....");
history.back();
</script>

<%  
}
%>







