<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%
String userID=null;
  Cookie[] cookies = request.getCookies();
  if (cookies != null) {
    for (Cookie cookie : cookies) {
      if (cookie.getName().equals("id")) {
        cookie.setPath("/");
        userID= cookie.getValue();
        break;
      }
    }
  }
  
%>

      <ul class="sidebar navbar-nav">
        
        <li class="nav-item active">
          <a class="nav-link" href="/index.jsp">
            <i class="fas fa-fw fa-tachometer-alt"></i>
            <span>대시보드</span>
          </a>
        </li>
        
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            <i class="fas fa-fw fa-folder"></i>
            <span>로그인 관리</span>
          </a>
          <div class="dropdown-menu" aria-labelledby="pagesDropdown">
            <h6 class="dropdown-header">로그인 관리:</h6>
            <% 
              if(userID!= null){ //로그인 상태
             %>
              <span class="dropdown-item" >
              <%=userID %>님 환영합니다
              </span>
               <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">
               로그아웃</a>
             <% 
              }else{ //게스트 상태
             %>
            <a class="dropdown-item" href="<%=application.getContextPath()%>/user/login.jsp">로그인</a>
            <a class="dropdown-item" href="<%=application.getContextPath()%>/user/register.jsp">회원가입</a>
            <a class="dropdown-item" href="<%=application.getContextPath()%>/user/forgot-id.jsp">아이디 찾기</a>
             <% 
              }
            %>
           
            <div class="dropdown-divider"></div>
          </div>
        </li>
        
         <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            <i class="fas fa-fw fa-table"></i>
            <span>게시판</span>
          </a>
          <div class="dropdown-menu" aria-labelledby="pagesDropdown">
            <h6 class="dropdown-header"> 게시판 :</h6>
            <a class="dropdown-item" href="<%=application.getContextPath()%>/boards/footage-board.jsp">방명록</a>
            <a class="dropdown-item" href="<%=application.getContextPath()%>/boards/free-board.jsp">자유게시판</a>
            <a class="dropdown-item" href="<%=application.getContextPath()%>/boards/review-board.jsp">리뷰게시판</a>
            <div class="dropdown-divider"></div>
          </div>
        </li>
        
        <!--  
        <li class="nav-item">
          <a class="nav-link" href="charts.jsp">
            <i class="fas fa-fw fa-chart-area"></i>
            <span>방문자 통계</span></a>
        </li> 
      -->
      </ul>
      
