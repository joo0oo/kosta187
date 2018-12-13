<%@ page language="java" contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html lang="utf-8">

  <head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SB Admin - Register</title>

    <!-- Bootstrap core CSS-->
    <link href="<%=application.getContextPath()%>/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template-->
    <link href="<%=application.getContextPath()%>/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

    <!-- Custom styles for this template-->
    <link href="<%=application.getContextPath()%>/css/sb-admin.css" rel="stylesheet">

  </head>

  <body class="bg-dark modal-open">

  <%-- 탑메뉴 시작 --%>
  <jsp:include page="/include/navbar.jsp"/>
  <%-- 탑메뉴 종료 --%>
  
  <div id="wrapper">
  <%-- 사이드메뉴 시작 --%>
  <jsp:include page="/include/sidebar.jsp"/>
  <%-- 사이드메뉴 종료 --%>
  
    <div class="container">
      <div class="card card-register mx-auto mt-5">
        <div class="card-header"> 회원 가입 </div>
        <div class="card-body">
          <form action="register-action.jsp" method="post" id="regist-form">
            <div class="form-group">
              <div class="form-row">
                <div class="col-md-6">
                  <div class="form-label-group">
                    <input type="text" id="id" class="form-control" name="id" placeholder="ID" required="required" autofocus="autofocus">
                    <label for="id">아이디</label>
                  </div>
                </div>
                <div class="col-md-6">
                  <div class="form-label-group">
                    <input type="text" id="name" class="form-control" name="name" placeholder="name" required="required">
                    <label for="name">이름</label>
                  </div>
                </div>
              </div>
            </div>
            <div class="form-group">
              <div class="form-label-group">
                <input type="email" id="inputEmail" class="form-control" name="email" placeholder="Email address" required="required">
                <label for="inputEmail">이메일</label>
              </div>
            </div>
            <div class="form-group">
              <div class="form-row">
                <div class="col-md-6">
                  <div class="form-label-group">
                    <input type="password" id="passwd" class="form-control" name="passwd" placeholder="Password" required="required">
                    <label for="passwd">비밀번호</label>
                  </div>
                </div>
                <div class="col-md-6">
                  <div class="form-label-group">
                    <input type="password" id="passwd-confirm" class="form-control" name="passwd-confirm" placeholder="Confirm password" required="required">
                    <label for="passwd-confirm">비밀번호 확인</label>
                  </div>
                </div>
              </div>
            </div>
            <button type="submit" id="regist-btn" class="btn btn-primary btn-block" >등록</button>
          </form>
          <div class="text-center">
            <a class="d-block small mt-3" href="<%=application.getContextPath()%>/user/login.jsp">로그인</a>
            <a class="d-block small" href="<%=application.getContextPath()%>/user/forgot-id.jsp">아이디 찾기</a>
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
