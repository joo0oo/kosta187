<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<link rel="shortcut icon" href="data:image/x-icon;," type="image/x-icon">
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
	<meta name="description" content="">
	<meta name="author" content="">
	<link rel="icon" href="favicon.ico">
	<title>Java - 아름다운 추억을 코딩하세요</title>
	<!-- Bootstrap core CSS -->
	<link href="/reservationmall/resources/css/template/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	<!-- Custom styles for this template -->
	<link href="/reservationmall/resources/css/template/owl.carousel.css" rel="stylesheet">
	<link href="/reservationmall/resources/css/template/owl.theme.default.min.css"  rel="stylesheet">
	<link href="/reservationmall/resources/css/template/style.css" rel="stylesheet">
	<link href="/reservationmall/resources/bootstrap/css/bootstrap.css" rel="stylesheet">
	<script type="text/javascript" src="/reservationmall/resources/js/common/jquery-3.3.1.js"></script>



    <!-- 송주현 스크립트 추가 -->
    <script type="text/javascript" src="/reservationmall/resources/js/sjh/ajax.js"></script>
    
    <!--  송주현 스크립트 추가 -->
    <c:choose>
    <c:when test="${requestScope.registResult eq 'success'}">
    <%--가입완료 보여주기 --%> 
    <script type="text/javascript">
      $(function(){ 
       // alert('success');
          $('#regist-result').html('회원가입에 성공했습니다');
          $('#regist-confirm-Modal').css('z-index', '1050'); //모달 위로 띄우기
          $('#regist-confirm-Modal').on('hide.bs.modal', function (e) {
          	location.href='/reservationmall/';
          });
          $('#regist-confirm-Modal').modal('show');
        })
    </script>
    </c:when>
    <c:when test="${requestScope.registResult eq 'fail'}">
     <script type="text/javascript">
      $(function(){ 
          $('#regist-result').html('회원가입에 실패했습니다');
          $('#regist-confirm-Modal').css('z-index', '1050'); //모달 위로 띄우기
          $('#regist-confirm-Modal').on('hidden.bs.modal', function (e) {
          	location.href='/reservationmall/';
          }); 
          $('#regist-confirm-Modal').modal('show');
        })
    </script>  
    </c:when>
  </c:choose>
</head>
<body>
    <!-- top 네비게이션 -->
    <jsp:include page="/WEB-INF/view/main/main_top.jsp"></jsp:include>
    
	<header style="background-image:'/reservationmall/resources/images/login/regist_main.jpg';">
			<div class="container">
				<div class="slider-container">
					<div class="intro-text">
						<div class="intro-lead-in">YogiZoa와 함께하세요</div>
						<div class="intro-heading">여러분의 입장에서 소중한 추억을 만들 수 있도록 노력하겠습니다.</div>
					</div>
				</div>
			</div>
	</header>
   <div style="height:50px"></div>
   <div id="ww">
    <div class="container">
  
      <jsp:include page="/WEB-INF/view/login/regist_form.jsp"></jsp:include>
      
    </div>
    <!-- /container -->
   </div>
   <!-- /ww -->  
   
	<div style="height:50px"></div>
	<!-- bottom네비게이션 -->
	<jsp:include page="/WEB-INF/view/main/main_bottom.jsp"></jsp:include>
	
    <%-- <jsp:include page="/WEB-INF/view/login/regist-confirm-Modal.jsp"></jsp:include> --%>
          
       <!--  회원가입 결과확인 모달  -->
         <div class="modal fade" id="regist-confirm-Modal" role="dialog" >
          <div class="modal-dialog">
            <div class="modal-content">
              <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">×</button>
                <h4 class="modal-title"> 회원가입 결과 </h4>
              </div>
              <div class="modal-body">
                <p id="regist-result">   </p>
              </div>
              <div class="modal-footer">
                <button type="button" class="btn btn-default" 
                data-dismiss="modal" id="edit-confirm-Modal-close">Close</button>
              </div>
            </div>
          </div>
        </div>
        <!--  회원가입 결과확인 모달  -->
        
  
		<!-- Bootstrap core JavaScript
		================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>
	<script src="/reservationmall/resources/js/template/bootstrap.min.js"></script>
	<script src="/reservationmall/resources/js/template/owl.carousel.min.js"></script>
	<script src="/reservationmall/resources/js/template/cbpAnimatedHeader.js"></script>
	<script src="/reservationmall/resources/js/template/jquery.appear.js"></script>
	<script src="/reservationmall/resources/js/template/SmoothScroll.min.js"></script>
	<script src="/reservationmall/resources/js/template/mooz.themes.scripts.js"></script>
  
  <!--  송주현 스크립트 추가  -->
  <script type="text/javascript" src="/reservationmall/resources/js/sjh/regist.js"></script>
  <!--  송주현 스크립트 추가  -->
</body>

</html>