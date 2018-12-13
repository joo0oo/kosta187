<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%
String reason= request.getParameter("reason");
%>
<!DOCTYPE html>
<html lang="utf-8">

  <head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title> 알림 </title>

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
        <div class="card-header">회원가입 실패</div>
        <div class="card-body">
        <div> 
        <% 
        if(reason.equals("pw")){
          //비밀번호 불일치
        %>
        <p>비밀번호가 일치하지 않습니다</p>
        <% 
        } else if(reason.equals("id")){
          //아이디 중복
        %>
        <p>중복된 아이디 입니다 </p>
        <%
        } else if (reason.equals("email")){
        %>
        <p>중복된 이메일 입니다 </p>
        <%  
        } else if (reason.equals("kid")){
         %>
         <p>아이디는 영어 또는 숫자만 가능합니다 </p>
       <%  
       } else if( reason.equals("noreason")){
    	   %>
           <p> 회원 가입이 불가능한 정보입니다  </p>
         <%     
       }
       %>
        
        </div>
        
          <div class="text-center">
            <button class="btn btn-primary btn-block"" onclick="goBack();">
              돌아가기
            </button> 
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
  <script>
  function goBack(){
	  history.back();
  }
  </script>
</html>
