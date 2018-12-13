<%@page import="kr.or.kosta.reservationmall.login.dto.User"%>
<%@page import="kr.or.kosta.reservationmall.note.dto.Notes"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
  <%
  User user = (User)request.getAttribute("user");
    String loginId = null;
    String rememId = null;
    Cookie[] cookies = null;
    if (request.getCookies() != null) {
      cookies = request.getCookies();
    }
    if (cookies != null) {
      for (Cookie cookie : cookies) {
        String cookieName = cookie.getName();
        if (cookieName.equals("loginId")) {
          loginId = cookie.getValue();
        }
        if (cookieName.equals("rememId")) {
          rememId = cookie.getValue();
        }
      }
    }
    
  %>
<c:set var="userId" value="<%=loginId%>" />

<form name="sendNotes" id="sendNotes" action="/reservationmall/note/controller.mall" method="post">

  <%
  	if (loginId == null) {
  		//로그인이 되어있지 않을 경우
  %>
  <div class="row">
    <div class="col-md-6">
      <div class="form-group">
        <input type="text" class="form-control" placeholder="아이디 입력 *"
          value="로그인 후 이용가능합니다." id="name" name="user_id" required=""
          data-validation-required-message="Please enter your name." readonly="readonly">
        <p class="help-block text-danger"></p>
      </div>
    </div>
    <div class="col-md-6">
      <div class="form-group">
        <input type="email" class="form-control" placeholder="이메일 입력 *"
          id="email" name="note_email" required="" value="로그인 후 이용가능합니다. "
          data-validation-required-message="Please enter your email address." readonly="readonly">
        <p class="help-block text-danger"></p>
      </div>
    </div>
  </div>
  <div class="row">
    <div class="col-md-12">
      <div class="form-group">
        <textarea class="form-control" placeholder="문의사항 입력 : 로그인 후 이용가능합니다."
          id="message" name="note_question" required=""
          data-validation-required-message="Please enter a message." readonly="readonly"></textarea>
        <p class="help-block text-danger"></p>
      </div>
    </div>
    <div class="clearfix"></div>
  </div>
  
    <div class="row">
    <div class="col-lg-12 text-center">
      <div id="success"></div>
      <button type="button" class="btn" id="sendnote" value="Send Message" disabled="disabled"></button>
    </div>
  </div>
  
  
  <%}else{
    //로그인 화면의 경우
   %>
     <div class="row">
    <div class="col-md-6">
      <div class="form-group">
        <input type="text" class="form-control" placeholder="아이디 입력 *"
          value="<%=loginId%>" id="name" name="user_id" required=""
          data-validation-required-message="Please enter your name.">
        <p class="help-block text-danger"></p>
      </div>
    </div>
    <div class="col-md-6">
      <div class="form-group">
        <input type="email" class="form-control" placeholder="이메일 입력 *"
          id="email" name="note_email" required=""
          data-validation-required-message="Please enter your email address.">
        <p class="help-block text-danger"></p>
      </div>
    </div>
  </div>
  
  <div class="row">
    <div class="col-md-12">
      <div class="form-group">
        <textarea class="form-control" placeholder="문의사항 입력 *"
          id="message" name="note_question" required=""
          data-validation-required-message="Please enter a message."></textarea>
        <p class="help-block text-danger"></p>
      </div>
    </div>
    <div class="clearfix"></div>
  </div>

  <div class="row">
    <div class="col-lg-12 text-center">
      <div id="success"></div>
      <button type="button" class="btn" id="sendnote_ck" >Send Message</button>
    </div>
  </div>
  
<%
  }
%>  
</form>