<%@ page contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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
	<title>관리자 모드</title>
	<!-- Bootstrap core CSS -->
	
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	<!-- Custom styles for this template -->
	<link href="/reservationmall/resources/css/template/owl.carousel.css" rel="stylesheet">
	<link href="/reservationmall/resources/css/template/owl.theme.default.min.css"  rel="stylesheet">
	<link href="/reservationmall/resources/css/template/style.css" rel="stylesheet">
	<link href="/reservationmall/resources/bootstrap/css/bootstrap.css" rel="stylesheet">
	
</head>
<body>
	<!-- top 네비게이션 -->
	<jsp:include page="/WEB-INF/view/main/main_top.jsp"></jsp:include>
		<div class="container">
			<div style="height:150px"></div>	
		</div>
	<div class="container">
		<div class="panel panel-primary">
		  	<div class="panel-heading">결제성공</div>
		  	<div class="panel-body">
		    	결제에 성공했습니다.<br>
				<span class="label label-primary" onclick="location.href='/reservationmall/individual/mypage.mall'">예약정보 확인</span>
				<span class="label label-success" onclick="location.href='/reservationmall/index.jsp'">홈으로</span>
		  	</div>
		</div>
	</div>

	<!-- bottom네비게이션 -->
	<jsp:include page="/WEB-INF/view/main/main_bottom.jsp"></jsp:include>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>
	<script src="/reservationmall/resources/js/template/bootstrap.min.js"></script>
	<script src="/reservationmall/resources/js/template/owl.carousel.min.js"></script>
	<script src="/reservationmall/resources/js/template/cbpAnimatedHeader.js"></script>
	<script src="/reservationmall/resources/js/template/jquery.appear.js"></script>
	<script src="/reservationmall/resources/js/template/SmoothScroll.min.js"></script>
	<script src="/reservationmall/resources/js/template/mooz.themes.scripts.js"></script>
</body>
</html>