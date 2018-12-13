<%@ page contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

    
<%
String rememId = null;
String loginId = null;
String loginCheck = null;
Cookie[] cookies = null;

if(request.getCookies()!=null){
	cookies = request.getCookies();
}
if(cookies != null) {
	for(Cookie cookie : cookies) {
		String cookieName = cookie.getName();
		if(cookieName.equals("loginId")) {
			loginId = cookie.getValue();
		}
		if(cookieName.equals("rememId")){
			rememId = cookie.getValue();
		}
	}
}
loginCheck = request.getParameter("loginCheck");
%>

<nav class="navbar navbar-default navbar-fixed-top">
	<div class="container">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header page-scroll">
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
			<span class="sr-only">Toggle navigation</span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand page-scroll" href="#page-top"><img src="/reservationmall/resources/images/template/logo.png" alt="Sanza theme logo"></a>
		</div>
		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav navbar-right">
				<li class="hidden">
					<a href="#page-top"></a>
				</li>
				<li>
					<a class="page-scroll" href="/reservationmall/">메인</a>
				</li>
				<li>
					<a class="page-scroll" href="#my-info">개인정보</a>
				</li>
				<li>
					<a class="page-scroll" href="#reservation">나의예약</a>
				</li>
				<li>
					<a class="page-scroll" href="#wishlist">위시리스트</a>
				</li>
				
				 <%
		          if(loginId == null){
				  %>
		         <li>
					<a class="page-scroll" data-toggle="modal" data-target="#loginModal">로그인</a>
				</li>            
		          <%
		          }else{
		          %>
		          	<%
		          	if(loginId.equals("admin")){
		          	%>
		          	<li>
					<a class="page-scroll" id="myPage" href="/reservationmall/admin/main_board.mall">관리자기능</a>
					</li>
		          	<%	
		          	}else{
		          	%>
		           <li>
					<a class="page-scroll" id="myPage" href="/reservationmall/individual/mypage.mall">MyPage</a>
					</li>
					<%
		          	}
					%>
		          <li><a class="page"><%=loginId %> 님</a></li>
		          <li><button type="button" class="btn btn-danger" id="logoutBtn">로그아웃</button></li>
		        
		          <%
		          }
		     	%>
				
				
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid -->
</nav>


 <!-- Modal -->
	<div class="modal fade" id="loginModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title" id="exampleModalLabel">로그인</h4>
					<span class="hiddenAlert" id='loginAlert' style="display:none; color:red"><u>로그인에 실패했습니다.</u></span>
				</div>
				<form action="/reservationmall/login/controller.mall" name="loginform" method="post">
				<div class="modal-body">
						<div class="form-group">
							<label for="message-text" class="control-label">아이디 :</label>
							<input type="text" class="form-control" name="user_id" id="login_id"
							<%
							if(rememId != null){
							%>
							value="<%=rememId %>"
							<%
							}
							%>	
							>
							<span class="hiddenAlert" id='idAlert' style="display:none; color:red"><u>아이디를 확인해주세요!</u></span>	
						</div>
						<div class="form-group">
							<label for="message-text" class="control-label">비밀번호 :</label>
							<input type="password" class="form-control" name="user_pw" id="login_pw">
							<span class="hiddenAlert" id='pwAlert' style="display:none; color:red"><u>비밀번호를 확인해주세요!</u></span>
						</div>
				</div>
				<div class="modal-footer">
					<div class="checkbox">
						<label> <input type="checkbox" name="rememId" value="true"
						<%
						if(rememId != null && rememId.length() != 0 ){
						%>
						checked="checked"
						<%
						}
						%>
						> 아이디를 기억합니다
						</label>
					</div>
					<input type="hidden" name="daoType" value="checkLogin">
					<button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
					<button type="submit" class="btn btn-primary" id="loginBtn">로그인</button>
					<button type="button" class="btn btn-info" id="registerBtn">회원가입</button>
				</div>
				</form>
			</div>
		</div>
	</div>
	<%
	if(loginCheck!=null && loginCheck.equals("fail")){
%>
<script
  src="http://code.jquery.com/jquery-3.3.1.slim.js"
  integrity="sha256-fNXJFIlca05BIO2Y5zh1xrShK3ME+/lYZ0j+ChxX2DA="
  crossorigin="anonymous"></script>
<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script>
$('#loginModal').modal({
	backdrop:false
});
document.getElementById("loginAlert").setAttribute("style", "display:block;");

</script>
<%
}
%>