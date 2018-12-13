<%@ page language="java" contentType="text/html; charset=utf-8" %>
<% 
String rememberID="";
  Cookie[] cookies = request.getCookies();
  if (cookies != null) {
    
    for (Cookie cookie : cookies) {
      if (cookie.getName().equals("rememberId")) {
        cookie.setPath("/");
        rememberID= cookie.getValue();
        break;
      }
    }
  }
%> 
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
        <div class="card-header">로그인</div>
        <div class="card-body">
          <form action="login-action.jsp" method="post">
            <div class="form-group">
              <div class="form-label-group">
                <input type="text" id="id" class="form-control"
                  name="id" 
                  <%
                  if(rememberID != null || rememberID.length() != 0 || rememberID=="" ){
                   %>
                   value="<%=rememberID %>"
                   <%  
                  }
                  %>
                  placeholder="ID" required="required"
                  autofocus="autofocus"> 
                  <label for="id">아이디</label>
              </div>
            </div>
            <div class="form-group">
              <div class="form-label-group">
                <input type="password" id="passwd" class="form-control"
                  name="passwd" placeholder="Password"
                  required="required"> 
                  <label for="passwd">비밀번호</label>
              </div>
            </div>
            <div class="form-group">
              <div class="checkbox">
                <label> 
                <input type="checkbox" name="remember-id" value="remember-me"> 
                아이디 기억
                </label>
              </div>
            </div>
            <button type="submit" class="btn btn-primary btn-block">로그인</button>
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
