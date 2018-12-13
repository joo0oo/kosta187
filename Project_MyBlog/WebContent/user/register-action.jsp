<%-- 회원 가입 관련 DB 처리만 하는 문서 --%>
<%@page import="java.util.regex.Pattern"%>
<%@page import="kr.or.kosta.blog.dao.JdbcDaoFactory"%>
<%@page import="kr.or.kosta.blog.user.UserDao"%>
<%@page import="kr.or.kosta.blog.dao.DaoFactory"%>
<%@ page language="java" contentType="text/html; charset=utf-8" %>
<% request.setCharacterEncoding("utf-8"); %>

<%-- 디폴트 생성자 --%>
<jsp:useBean id="user"  class="kr.or.kosta.blog.user.User" scope="request" />

<%-- 모든 값 한번에 할당 --%>
<jsp:setProperty property="*" name="user"/>

<%
String inputPW= request.getParameter("passwd");
String confirmPW= request.getParameter("passwd-confirm");
if(!inputPW.equals(confirmPW)){
  //비밀번호 일치하지 않음
%>
<jsp:forward page="register-valid.jsp?reason=pw" />
<%
} else{
  
	DaoFactory factory= (DaoFactory)application.getAttribute("factory");
	UserDao dao= factory.getUserDao();
	boolean isKId= Pattern.matches("^[a-zA-Z0-9]*$", user.getId());
    
  if (dao.read(user.getId()) != null){
    //중복된 아이디 
      %>
      <jsp:forward page="register-valid.jsp?reason=id" />
      <%
  } else if(dao.isValidEmail(user.getEmail())!= null){
    //중복된 이메일
	  %>
      <jsp:forward page="register-valid.jsp?reason=email" />
      <%  
  } else if( !isKId ){
	 //한글이 포함된 아이디
	%>
	<jsp:forward page="register-valid.jsp?reason=kid" />
	<%  
  } else{
    try{
    	dao.create(user);
    } catch(Exception e){
    	%>
    	<jsp:forward page="register-valid.jsp?reason=noreason" />
    	<%   
    }
	
//가입 결과창 jsp 문서로 디스패치 
%>
<jsp:forward page="register-confirm.jsp" />
<%
  }
}
%>