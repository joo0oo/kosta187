<%@ page language="java" contentType="text/html; charset=utf-8" %>

<%
String userID=null;
	Cookie[] cookies = request.getCookies();
	if (cookies != null) {
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("id")) {
				cookie.setPath("/");
				userID= cookie.getValue();
			//	cookie.setMaxAge(0); //해당 쿠키 삭제 (유효시간 0) -> 빈 쿠키 됨
			//	response.addCookie(cookie); //빈 쿠키로 업데이트
				break;
			}
		}
	}
%>
    <nav class="navbar navbar-expand navbar-dark bg-dark static-top">

      <a class="navbar-brand mr-1" href="/index.jsp"> 영화 블로그 </a>

      <button class="btn btn-link btn-sm text-white order-1 order-sm-0" id="sidebarToggle" href="#">
        <i class="fas fa-bars"></i>
      </button>

      <!-- Navbar Search -->
      <form class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0">
        <div class="input-group">
        <!-- ì상단바 검색창
          <input type="text" class="form-control" placeholder="Search for..." aria-label="Search" aria-describedby="basic-addon2">
          <div class="input-group-append">
            <button class="btn btn-primary" type="button">
              <i class="fas fa-search"></i>
            </button>
          </div>
           -->
        </div>
      </form>

      <!-- Navbar -->
      <ul class="navbar-nav ml-auto ml-md-0">
        <li class="nav-item dropdown no-arrow">
          <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            <%
            if(userID != null){
            %>
            	<%=userID %>
            <% 
            } else{
            %>
            	GUEST
            <% 
            }
            %> 
            <i class="fas fa-user-circle fa-fw"> </i> 
          </a>
          <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">
          <!-- 
            <a class="dropdown-item" href="#">Settings</a>
            <a class="dropdown-item" href="#">Activity Log</a>
             -->
            <div class="dropdown-divider"></div>
            <%
            if(userID != null){
            %>
              <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">로그아웃</a>
            <% 
            } else{
            %>
               <a class="dropdown-item" href="<%=application.getContextPath()%>/user/login.jsp">로그인</a>
            <% 
            }
            %> 
             </div>
        </li>
      </ul>
      
    </nav>

