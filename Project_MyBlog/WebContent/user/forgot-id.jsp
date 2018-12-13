<%@ page language="java" contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html lang="utf-8">

  <head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title> 아이디 찾기 </title>

    <!-- Bootstrap core CSS-->
    <link href="<%=application.getContextPath()%>/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template-->
    <link href="<%=application.getContextPath()%>/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

    <!-- Custom styles for this template-->
    <link href="<%=application.getContextPath()%>/css/sb-admin.css" rel="stylesheet">

  </head>

  <body class="bg-dark">

  <!-- 상단 메뉴 -->
  <jsp:include page="/include/navbar.jsp"/>
  <div id="wrapper">
  <!-- 좌측 메뉴 -->
  <jsp:include page="/include/sidebar.jsp"/>
    <div class="container">
      <div class="card card-login mx-auto mt-5">
        <div class="card-header"> 아이디 찾기 </div>
        <div class="card-body">
          <div class="text-center mb-4">
            <h4> 아이디 찾기 </h4>
            <p> 회원가입시 입력한 이름과 이메일을 입력하세요 </p>
          </div>
          
          <form action="forgot-id-result.jsp" method="post">
          <div class="form-group">
              <div class="form-label-group">
                <input type="text" id="name" class="form-control" name="name" placeholder="name" required="required">
                <label for="name">이름</label>
              </div>
            </div>
            
           <div class="form-group">
              <div class="form-label-group">
                <input type="email" id="inputEmail" class="form-control" name="email" placeholder="Email address" required="required">
                <label for="inputEmail">이메일</label>
              </div>
            </div> 
           
          <div class="text-center">
            <button type="submit" id="regist-btn" class="btn btn-primary btn-block" >찾기</button>
            <a class="d-block small"  href="<%=application.getContextPath()%>/index.jsp">
              홈으로</a>
          </div>
          </form>
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
