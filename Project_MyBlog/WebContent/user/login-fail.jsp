<%@ page language="java" contentType="text/html; charset=utf-8" %>

<!DOCTYPE html>
<html lang="utf-8">

  <head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title> 로그인 </title>

    <!-- Bootstrap core CSS-->
    <link href="<%=application.getContextPath()%>/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template-->
    <link href="<%=application.getContextPath()%>/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

    <!-- Custom styles for this template-->
    <link href="<%=application.getContextPath()%>/css/sb-admin.css" rel="stylesheet">

  </head>

  <body class="bg-dark">

  <%-- 탑메뉴 시작 --%>
  <jsp:include page="/include/navbar.jsp" />
  <%-- 탑메뉴 종료 --%>
  <div id="wrapper">
    <%-- 사이드메뉴 시작 --%>
    <jsp:include page="/include/sidebar.jsp" />
    <%-- 사이드메뉴 종료 --%>

    <div class="container">
      <div class="card card-login mx-auto mt-5">
        <div class="card-header">로그인 실패</div>
        <div class="card-body">
          <form action="login-action.jsp" method="post">
            <div class="form-group">
            <p>로그인에 실패했습니다</p>
            <p>아이디와 비밀번호를 확인하세요</p>
            </div>
            <a type="submit" class="btn btn-primary btn-block"
            href="<%=application.getContextPath()%>/user/login.jsp">
            돌아가기
            </a>
          </form>
          
          <div class="text-center">
            <a class="d-block small mt-3"
              href="<%=application.getContextPath()%>/user/register.jsp">
              회원
              가입</a> 
              <a class="d-block small"
              href="<%=application.getContextPath()%>/index.jsp">
              홈으로</a>
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
