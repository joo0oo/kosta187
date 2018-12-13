<%@page import="kr.or.kosta.blog.article.Article"%>
<%@page import="kr.or.kosta.blog.article.ArticleDao"%>
<%@page import="kr.or.kosta.blog.dao.JdbcDaoFactory"%>
<%@page import="kr.or.kosta.blog.dao.DaoFactory"%>
<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%
	request.setCharacterEncoding("utf-8");
int article_id= Integer.parseInt(request.getParameter("article_id"));
String passwd= request.getParameter("passwd");
boolean isDelete= false;


DaoFactory factory = (JdbcDaoFactory) application.getAttribute("factory");
ArticleDao dao = factory.getArticleDao();

Article article= dao.read(article_id);
// 로그인 확인
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

	if (userID != null) { //로그인중
		if (userID.equals(article.getWriter())) { //글 작성자임
    
			if (dao.certify(article_id, passwd) != null) {
				//비밀번호 검사 
				dao.delete(article_id);
				isDelete = true;
			} else {
				isDelete = false;
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

    <title> 게시글 삭제 </title>

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
    
    <%
    	if (isDelete == true) {
    %>

    <div class="container">
      <div class="card card-login mx-auto mt-5">
        <div class="card-header"> 게시글 삭제 완료 </div>
        <div class="card-body">
          삭제 완료되었습니다  
          <a class="btn btn-primary btn-block" href="free-board.jsp">확인 </a>
        </div>
      </div>
    </div>

    <%
    	} else if (isDelete == false) {
    %>

    <div class="container">
      <div class="card card-login mx-auto mt-5">
        <div class="card-header"> 게시글 삭제 불가 </div>
        <div class="card-body">
          삭제할 수 없습니다  
          <a class="btn btn-primary btn-block" href="view-article.jsp?article_id=<%=article_id%>"> 
            돌아가기
          </a>
        </div>
      </div>
    </div>

    <%
    	}
    %>
  </div>

  <!-- Bootstrap core JavaScript-->
    <script src="<%=application.getContextPath()%>/vendor/jquery/jquery.min.js"></script>
    <script src="<%=application.getContextPath()%>/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="<%=application.getContextPath()%>/vendor/jquery-easing/jquery.easing.min.js"></script>

  </body>

</html>
