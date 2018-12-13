  <%@page import="kr.or.kosta.reservationmall.login.dto.User"%>
  <%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
  <%
  User user= (User)request.getAttribute("user");
  %>
     <form name="editForm" id="editForm" action="/reservationmall/individual/editUser.mall" method="post">
        
          <div class="form-group">
            <label for="exampleInputEmail1">아이디 (변경 불가)</label> 
             <input type="text" readonly="readonly"
            class="form-control" id="regist_id" name="user_id"
            value="${user.user_id}">
          </div>
        
        <div class="form-group">
          <label for="exampleInputEmail1">비밀번호</label> 
          <input type="password" 
            class="form-control" id="regist_pass" name="user_pw"
            placeholder="4~10자 사이로 입력해주세요" required="required">
          <span class="hiddenAlert" id='regist_pwAlert' name="alertGroup" style="display:none; color:red">
            <u>비밀번호를 확인해주세요!</u>
          </span>
        </div>
        <div class="form-group">
          <label for="exampleInputEmail1">비밀번호확인</label> 
           <input type="password" class="form-control" id="regist_passcheck" required="required">
          <span class="hiddenAlert" id='regist_pwAlertSec' name="alertGroup" style="display:none; color:red">
            <u>비밀번호를 한번 더 입력해주세요</u>
          </span>
          <span class="hiddenAlert" id='regist_pwChckAlert' name="alertGroup" style="display:none; color:red">
            <u>비밀번호가 일치 하지 않습니다.!</u>
          </span>
        </div>
        
        <div class="form-group">
          <label for="exampleInputEmail1">이름</label> 
          <input type="text"
            class="form-control" id="regist_name" name="name" required="required"
            value="${user.user_name}">
          <span class="hiddenAlert" id='regist_nameAlert' name="alertGroup" style="display:none; color:red">
            <u>이름을 확인해주세요!</u>
          </span>
        </div>
        
        <div class="form-group">
          <label for="exampleInputEmail1">생년월일(나이)</label> 
          <input type="text" class="form-control" id="regist_age" name="user_age" 
          placeholder="주민번호 앞 6자리 숫자" required="required"
          value="${user.user_age}">
          <span class="hiddenAlert" id='regist_ageAlert' name="alertGroup" style="display:none; color:red">
            <u> 나이를 확인해주세요!</u>
          </span>
        </div>
        <div class="form-group">
          <label for="exampleInputEmail1">주소</label> 
          <input type="text" class="form-control" id="regist_address" name="user_address" 
          required="required" value="${user.user_address}">
        </div>
        
        <div class="form-group">
          <label for="exampleInputEmail1">전화번호</label> 
          <input type="email"
            class="form-control" id="regist_phonnum" name="user_phonenum"
            placeholder="전화번호를 입력하세요" required="required"
            value="${user.user_phonenum}">
          <span class="hiddenAlert" id='regist_phonnumAlert' name="alertGroup" style="display:none; color:red">
            <u>전화번호를 확인해주세요!</u>
          </span>
        </div>
        
        
        <div class="form-group">
          <label for="exampleInputEmail1">이메일</label> 
          <input type="email"
            class="form-control" id="regist_email" name="email"
            placeholder="이메일을 입력하세요" required="required"
            value="${user.user_email}">
          <span class="hiddenAlert" id='regist_emailAlert' name="alertGroup" style="display:none; color:red">
            <u>중복된 이메일입니다</u>
          </span>
        </div>
        
        <div class="row">
            <button type="button" class="btn btn-success" id="editSubmitBtn">수정하기</button>
        </div>
      </form>
    
