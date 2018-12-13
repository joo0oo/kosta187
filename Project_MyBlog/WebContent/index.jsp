<%@ page language="java" contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html lang="utf-8">

  <head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title> Dashboard</title>

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
          <li class="breadcrumb-item"><a href="index.jsp">Dashboard</a></li>
          <li class="breadcrumb-item active">Overview</li>
        </ol>

        <%-- 대시보드 아이콘 --%>
        <jsp:include page="/include/dashboard-icons.jsp"/>

        <div class="breadcrumb"> 오늘의 영화 차트 </div>
        <iframe id="megabox-movie" src="/include/movieChart.html" 
        width="100%" height="500px" frameborder="0" scrolling="no"
        ></iframe>

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


    <!-- Custom scripts for all pages-->
    <script src="<%=application.getContextPath()%>/js/sb-admin.min.js"></script>


  </body>
  <script>
  
  </script>

</html>
