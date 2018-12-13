<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%
  //조회수 늘리기용 로그인 확인
  String userID = null;
  Cookie[] cookies = request.getCookies();
  if (cookies != null) {
    for (Cookie cookie : cookies) {
      if (cookie.getName().equals("id")) {
        cookie.setPath("/");
        userID = cookie.getValue();
        break;
      }
    }
  }
%>
<!--  리뷰 게시판 -->
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
  <jsp:include page="/include/navbar.jsp" />
  <%-- 탑메뉴 종료 --%>
  <div id="wrapper">

    <%-- 사이드메뉴 시작 --%>
    <jsp:include page="/include/sidebar.jsp" />
    <%-- 사이드메뉴 종료 --%>

    <div id="content-wrapper">

      <div class="container-fluid">

        <!-- Breadcrumbs-->
        <ol class="breadcrumb">
          <li class="breadcrumb-item"><a
            href="<%=application.getContextPath()%>/index.jsp">Dashboard</a>
          </li>
          <li class="breadcrumb-item active">리 뷰 게 시 판</li>
        </ol>

        <div class="card mb-3">
          <div class="card-header">
            <i class="fas fa-table"></i> 영화 리뷰 게시판
          </div>
        

          <%-- 게시판 테이블 시작 --%>
          <jsp:include page="/boards/review-table.jsp" />
          <%-- 게시판 테이블 종료 --%>
          
        <%
        if (userID != null) { //로그인중
        %>
        <!-- 글쓰기 버튼 -->
          <div class="board-btns">
            <a class="btn btn-primary btn-board"
              href="<%=application.getContextPath()%>/boards/write-article.jsp?board_id=2">글쓰기</a>
          </div>
        <%
      } else { //게스트 
        
      }
        %>
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

    <%-- 로그아웃 --%>
    <jsp:include page="/user/logout.jsp"/>
    <%-- 로그아웃 --%>
    
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
