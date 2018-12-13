<%@page import="kr.or.kosta.shoppingmall.common.dao.User"%>
<%@page import="kr.or.kosta.shoppingmall.common.dao.UserDao"%>
<%@page import="kr.or.kosta.shoppingmall.common.dao.JdbcDaoFactory_pre"%>
<%@page import="kr.or.kosta.shoppingmall.common.dao.DaoFactory"%>
<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%
	if (request.getParameter("logout") != null) {
		//로그아웃 처리 
    System.out.println("  logout  ");
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
	for (Cookie cookie : cookies) {
		if (cookie.getName().equals("userid")) {
	cookie.setPath("/");
	cookie.setMaxAge(0); //해당 쿠키 삭제 (유효시간 0) -> 빈 쿠키 됨
	response.addCookie(cookie); //빈 쿠키로 업데이트
		} else if (cookie.getName().equals("isLogin")) {
	cookie.setPath("/");
	cookie.setMaxAge(0); //해당 쿠키 삭제 (유효시간 0) -> 빈 쿠키 됨
	response.addCookie(cookie); //빈 쿠키로 업데이트
	break;
		}
	}
		}
		response.sendRedirect("/jsp/index.jsp");

	} else {
    System.out.println(" login ");
		// 로그인 처리 
		String id = request.getParameter("userid");
		String pw = request.getParameter("userpw");

        if(id==null || pw==null){
          return;  
        }
        
		//UserDao를 이용한 회원 가입 여부 체크
		DaoFactory factory = new JdbcDaoFactory_pre();
		UserDao dao = factory.getUserDao();
		User user = dao.certify(id, pw);
		if (user != null) {
            //회원임
	Cookie cookie = new Cookie("userid", id);
	cookie.setPath("/");
	response.addCookie(cookie);

	Cookie isLoginCookie = new Cookie("isLogin", "true");
	isLoginCookie.setPath("/");
	response.addCookie(isLoginCookie);

	response.sendRedirect("/jsp/index.jsp");
		} else {
            //회원 아님 : alert()말고 다른 방법으로 구현하기
%>
  <script>
  alert("회원이 아님");
  history.back(); //뒤로가기 
  </script>
  <%
		}

	}
%>