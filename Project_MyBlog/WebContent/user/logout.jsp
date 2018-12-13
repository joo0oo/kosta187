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
  
  if(userID != null){
%>

<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">로그아웃 알림</h5>
        <button class="close" type="button" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">×</span>
        </button>
      </div>
      <div class="modal-body">정말 로그아웃 하시겠습니까?</div>
      <div class="modal-footer">
        <button class="btn btn-secondary" type="button"
          data-dismiss="modal">취소</button>
        <button type="submit" class="btn btn-primary" onclick="location.href='/user/logout-action.jsp'">로그아웃</button>
      </div>
    </div>
  </div>
</div>
<%
  }
%> 