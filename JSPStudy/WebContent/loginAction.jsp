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
		response.sendRedirect("index_cookie.jsp");

	} else {
    System.out.println(" login ");
		// 로그인 처리 
		String id = request.getParameter("userid");
		String pw = request.getParameter("userpw");

		//UserDao를 이용한 회원 가입 여부 체크
		/* 추후 구현 */

		Cookie cookie = new Cookie("userid", id);
		cookie.setPath("/");
		response.addCookie(cookie);

		Cookie isLoginCookie = new Cookie("isLogin", "true");
		isLoginCookie.setPath("/");
		response.addCookie(isLoginCookie);

		response.sendRedirect("index_cookie.jsp");
	}
%>