<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%
// 로그인 확인 
String userID=null;
  Cookie[] cookies = request.getCookies();
  if (cookies != null) {
    for (Cookie cookie : cookies) {
      if (cookie.getName().equals("id")) {
        cookie.setPath("/");
        userID= cookie.getValue();
      //  cookie.setMaxAge(0); //해당 쿠키 삭제 (유효시간 0) -> 빈 쿠키 됨
      //  response.addCookie(cookie); //빈 쿠키로 업데이트
        break;
      }
    }
  }
%>

<!--  방명록 -->
<!DOCTYPE html>
<html lang="utf-8">

  <head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SB Admin - Dashboard</title>

    <!-- Bootstrap core CSS-->
    <link href="<%=application.getContextPath()%>/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template-->
    <link href="<%=application.getContextPath()%>/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

    <!-- Page level plugin CSS-->
    <link href="<%=application.getContextPath()%>/vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="<%=application.getContextPath()%>/css/sb-admin.css" rel="stylesheet">

  </head>

  <body id="page-top">

  <%-- 탑메뉴 시작 --%>
  <jsp:include page="/include/navbar.jsp"/>
  <%-- 탑메뉴 종료 --%>
    <div id="wrapper">

    <%-- 사이드메뉴 시작 --%>
    <jsp:include page="/include/sidebar.jsp"/>
    <%-- 사이드메뉴 종료 --%>

    <div id="content-wrapper">

      <div class="container-fluid">

        <!-- Breadcrumbs-->
        <ol class="breadcrumb">
          <li class="breadcrumb-item">
            <a href="<%=application.getContextPath()%>/index.jsp">
            Dashboard</a>
          </li>
          <li class="breadcrumb-item active">방명록</li>
        </ol>

        <!-- DataTables Example -->
        <div class="card mb-3">
          <div class="card-header">
            <i class="fas fa-table"></i> 방명록
          </div>
          
          <% 
          if(userID != null){
          %>
          <div> 
          <h4 class="guest-info"><%=userID %> 님 환영합니다 </h4>
          </div>
          <form action="footage-action.jsp" method="post" >
          <div class="form-group">
            <div class="form-label-group input-footage">
              <input type="text" id="inputFootage" name="contents" class="form-control" placeholder=" 방명록 쓰기 " required="required" autofocus="autofocus"> 
              <label for="inputFootage">여기에 방명록 내용을 입력하세요 </label>
            </div>
            <button type="submit" class="btn btn-primary btn-board">등록</button>
          </div>
          </form>
          <%
          } else{
          %>
          <div> 방명록을 작성하려면 로그인해야 합니다 </div>
          <form method="post" >
          <div class="form-group">
            <div class="form-label-group input-footage">
              <input type="text" disabled="disabled" id="inputFootage" name="inputFootage" class="form-control" placeholder=" 방명록 쓰기 " required="required" autofocus="autofocus"> 
              <label for="inputFootage">여기에 방명록 내용을 입력하세요 </label>
            </div>
            <button class="btn btn-primary btn-board">등록</button>
          </div>
          </form>
          <%
          }
          %>

           <%-- 방명록 테이블 --%>
          <jsp:include page="/boards/footage-table.jsp" />
          <div class="card-footer small text-muted"> </div>
        </div>

      </div>
      <!-- /.container-fluid -->

     <%-- footer --%>
      <jsp:include page="/include/footer.jsp" />
      <%-- footer --%>
    </div>
    <!-- /.content-wrapper -->

  </div>
    <!-- /#wrapper -->

    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
      <i class="fas fa-angle-up"></i>
    </a>

    <%-- 로그아웃 모달 --%>
    <jsp:include page="/user/logout.jsp"/>
    <%-- 로그아웃 모달 --%>
    
       <!-- Bootstrap core JavaScript-->
    <script src="<%=application.getContextPath()%>/vendor/jquery/jquery.min.js"></script>
    <script src="<%=application.getContextPath()%>/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="<%=application.getContextPath()%>/vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Page level plugin JavaScript
    <script src="<%=application.getContextPath()%>/vendor/chart.js/Chart.min.js"></script>
    <script src="<%=application.getContextPath()%>/vendor/datatables/jquery.dataTables.js"></script>
    <script src="<%=application.getContextPath()%>/vendor/datatables/dataTables.bootstrap4.js"></script>
-->
    <!-- Custom scripts for all pages-->
    <script src="<%=application.getContextPath()%>/js/sb-admin.min.js"></script>

    <!-- Demo scripts for this page
    <script src="<%=application.getContextPath()%>/js/demo/datatables-demo.js"></script>
    <script src="<%=application.getContextPath()%>/js/demo/chart-area-demo.js"></script>
-->
  </body>

</html>
