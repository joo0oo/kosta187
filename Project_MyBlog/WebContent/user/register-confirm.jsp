<%@ page language="java" contentType="text/html; charset=utf-8" %>

<%-- 이미 생성된 user 객체를 찾아옴 --%>
<jsp:useBean id="user" class="kr.or.kosta.blog.user.User"  scope="request"/>


<!DOCTYPE html>
<html lang="utf-8">

  <head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title> 가입 확인 </title>

    <!-- Bootstrap core CSS-->
    <link href="<%=application.getContextPath()%>/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template-->
    <link href="<%=application.getContextPath()%>/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

    <!-- Custom styles for this template-->
    <link href="<%=application.getContextPath()%>/css/sb-admin.css" rel="stylesheet">

  </head>

  <body class="bg-dark">

  <%-- 탑메뉴 시작 --%>
  <jsp:include page="/include/navbar.jsp"/>
  <%-- 탑메뉴 종료 --%>
  
  <div id="wrapper">
  <%-- 사이드메뉴 시작 --%>
  <jsp:include page="/include/sidebar.jsp"/>
  <%-- 사이드메뉴 종료 --%>
  
    <div class="container">
      <div class="card card-register mx-auto mt-5">
        <div class="card-header"> 회원 가입 확인 </div>
        <div class="card-body">
         
          <form>
            <div class="form-group">
              <div class="form-label-group">회원가입이 정상적으로 완료되었습니다</div>
            </div>
            
            <div class="form-group">
              <div class="form-label-group">가입 정보</div>
            </div>
            
            <div class="form-group">
              <div class="form-label-group"> 아이디 : <%= user.getId() %></div>
            </div>
            
            <div class="form-group">
              <div class="form-label-group"> 이름 : <%= user.getName()  %></div>
            </div>

            <div class="form-group">
              <div class="form-label-group"> 이메일 : <%= user.getEmail() %></div>
            </div>
            <a class="btn btn-primary btn-block" href="<%=application.getContextPath()%>/user/login.jsp">로그인</a>
          </form>
          
          <div class="text-center">
            <a class="d-block small mt-3" href="<%=application.getContextPath()%>/index.jsp">홈으로</a>
          </div>
        </div>
      </div>
    </div>

    </div>
    <!-- Bootstrap core JavaScript-->
    <script src="<%=application.getContextPath()%>/vendor/jquery/jquery.min.js"></script>
    <script src="<%=application.getContextPath()%>/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="<%=application.getContextPath()%>/vendor/jquery-easing/jquery.easing.min.js"></script>

  </body>

</html>
