  <%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
  
     <form name="registForm" id="registForm" action="/reservationmall/regist/regist.mall" method="post">
        
          <div class="form-group">
          <label for="exampleInputEmail1">아이디</label> 
          <input type="text" required="required"
            class="form-control" id="regist_id" name="user_id"
            placeholder="6~10자 영문자/숫자 가능" required="required">
          <input type="hidden" id="idCheckHidden" name="idCheckHidden" value="false">
          <span class="hiddenAlert" id="regist_idAlert" name="alertGroup" style="display:none; color:red">
            <u>중복된 아이디 입니다</u>
          </span>
           <span class="hiddenAlert" id="regist_idValidAlert" name="alertGroup" style="display:none; color:red">
            <u>유효하지 않은 아이디 입니다</u>
          </span>
          <span class="hiddenAlert" id="regist_idSuccess" name="alertGroup" style="display:none; color:green">
            <u>사용가능한 아이디 입니다</u>
          </span>
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
            class="form-control" id="regist_name" name="name" required="required">
          <span class="hiddenAlert" id='regist_nameAlert' name="alertGroup" style="display:none; color:red">
            <u>이름을 확인해주세요!</u>
          </span>
        </div>
        
        <div class="form-group">
          <label for="exampleInputEmail1">생년월일(나이)</label> 
          <input type="text" class="form-control" id="regist_age" name="user_age" 
          placeholder="주민번호 앞 6자리 숫자" required="required">
          <span class="hiddenAlert" id='regist_ageAlert' name="alertGroup" style="display:none; color:red">
            <u> 나이를 확인해주세요!</u>
          </span>
        </div>
        <div class="form-group">
          <label for="exampleInputEmail1">주소</label> 
          <input type="text" class="form-control" id="regist_address" name="user_address" required="required">
        </div>
        
        <div class="form-group">
          <label for="exampleInputEmail1">전화번호</label> 
          <input type="text"
            class="form-control" id="regist_phonnum" name="user_phonenum"
            placeholder="000-0000-0000 형태" required="required">
          <span class="hiddenAlert" id='regist_phonnumAlert' name="alertGroup" style="display:none; color:red">
            <u>전화번호를 확인해주세요!</u>
          </span>
        </div>
        
        
        <div class="form-group">
          <label for="exampleInputEmail1">이메일</label> 
          <input type="email"
            class="form-control" id="regist_email" name="email"
            placeholder="abc@yogizoa.com 형태" required="required">
          <span class="hiddenAlert" id='regist_emailAlert' name="alertGroup" style="display:none; color:red">
            <u>중복된 이메일입니다</u>
          </span>
        </div>
        
        <button type="submit" class="btn btn-success" id="registSubmitBtn">가입하기</button>
        <button type="reset" class="btn btn-danger" id="resetBtn">다시 입력</button>
      </form>
    
