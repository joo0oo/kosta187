<%@page import="kr.or.kosta.blog.user.User"%>
<%@page import="kr.or.kosta.blog.dao.DaoFactory"%>
<%@page import="kr.or.kosta.blog.user.UserDao"%>
<%@ page language="java" contentType="text/html; charset=utf-8" %>
<% 
request.setCharacterEncoding("utf-8");
String name= request.getParameter("name");
String email= request.getParameter("email");

DaoFactory factory= (DaoFactory)application.getAttribute("factory");
UserDao dao= factory.getUserDao();

boolean isCheck= false;
String userId= null;
User user= dao.findID(name, email);
if(user != null){
	 isCheck= true;
   userId= user.getId();
} else{
	 isCheck= false; 
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
            <h4>아이디 찾기</h4>
            <% 
            if(isCheck== true){
             %>
            <h5>아이디는 다음과 같습니다</h5>
            <h5><%=userId %> </h5>
          </div>

          <%
          	} else {
          %>
            <h5>아이디를 찾을 수 없습니다</h5>
            <h5> 이름과 이메일을 확인하세요 </h5>
          </div> 
            <%   
            }
            %>
          
          <div class="text-center">
            <a class="d-block small mt-3" href="<%=application.getContextPath()%>/user/login.jsp">로그인</a>
            <a class="d-block small"  href="<%=application.getContextPath()%>/index.jsp">
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
