<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%
//로그인 확인
String userID=null;
  Cookie[] cookies = request.getCookies();
  if (cookies != null) {
    for (Cookie cookie : cookies) {
      if (cookie.getName().equals("id")) {
        cookie.setPath("/");
        userID= cookie.getValue();
        break;
      }
    }
  }
  
  int board_id;
  board_id=Integer.parseInt(request.getParameter("board_id"));
  
  String board_name="";
  switch(board_id){
  case 1:
    board_name="자유게시판";
    break;
  case 2:
    board_name="리뷰게시판";
    break;
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
            <li class="breadcrumb-item active"><%=board_name %></li>
          <li class="breadcrumb-item active">글쓰기</li>
        </ol>

        <div class="card mb-3">
          <div class="card-header">
            <i class="fas fa-table"></i> <%=board_name %>
          </div>

          <!-- 글쓰기 폼 -->
          <form action="/boards/write-article-action.jsp" method="post">
          <div class="form-group">
            <div class=" article-input">
              <label for="article-title">글제목 </label> 
              <input type="text" id="article-title" class="form-control article-info-full"
                placeholder=" 글 제목 " required="required"
                autofocus="autofocus" name="subject">
            </div>

            <div class="article-input article-group">
              <div class="article-info-left">
                <label for="article-writer">작성자 </label> 
                <input type="text" id="article-writer" class="form-control "
                  placeholder=" 작성자 " required="required"
                  autofocus="autofocus" disabled="disabled"
                  value="<%=userID%>">
              </div>
              <div class="article-info-right">
                <label for="article-pw">비밀번호 </label> 
                <input type="password" id="article-pw" class="form-control "
                  placeholder=" 비밀번호 " required="required"
                  autofocus="autofocus" name="passwd">
              </div>
            </div>

            <div class=" article-input">
              <label for="article-text"> </label> 
              <textarea  id="article-text" class="form-control article-text article-info-full"
               required="required" rows="20" cols="50"
               autofocus="autofocus" name="content"></textarea>
            </div>
            <button type="submit" class="btn btn-primary btn-board">글쓰기</button>
            
            <input type="hidden" name="board_id" value="<%=board_id%>">
            <input type="hidden" name="writer" value="<%= userID %>">
            <input type="hidden" name="ip" value="<%= request.getRemoteAddr() %>">
            <input type="hidden" name="levelNum" value="0">
            <input type="hidden" name="orderNum" value="0">
            
          </div>
          </form>

          <div class="card-footer small text-muted">Updated
            yesterday at 11:59 PM</div>
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
    <script src="<%=application.getContextPath()%>/js/demo/chart-area-demo.js"></script>-->

  </body>

</html>
