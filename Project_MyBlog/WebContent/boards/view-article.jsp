<%@page import="kr.or.kosta.blog.article.Article"%>
<%@page import="kr.or.kosta.blog.dao.JdbcDaoFactory"%>
<%@page import="kr.or.kosta.blog.article.ArticleDao"%>
<%@page import="kr.or.kosta.blog.dao.DaoFactory"%>
<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%-- 
<jsp:useBean id="article" class="kr.or.kosta.blog.article.Article" scope="request"/>
--%>
<%
request.setCharacterEncoding("utf-8");
int article_id= Integer.parseInt(request.getParameter("article_id"));


DaoFactory factory = (JdbcDaoFactory) application.getAttribute("factory");
ArticleDao dao = factory.getArticleDao();
Article article= dao.read(article_id);


//삭제된 게시글인지 확인
boolean isDeleted= false;
String[] strs= article.getSubject().split("\\^DEL%ETE\\^");
if(strs.length >1){
isDeleted= true; //삭제된 게시글임 
}

String isReply= "false";//이 글이 원글인지 답변글인지 확인 
if(isDeleted == false){ //삭제되지 않은 게시글이면 
	if (article.getLevelNum()==0) { //원글임
	 isReply= "false";
	} else{
	 isReply= "true";// 답변글임 -> 이 글의 답변글은 처리 필요 
	}
}
// 조회수 늘리기
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

if(userID != null){ //로그인중
  if(!userID.equals(article.getWriter())){ //글 작성자가 아님
  	dao.updateHitCount(article_id);
  }
} else{ //게스트
	dao.updateHitCount(article_id);
}


//request.setAttribute("article", article);
%>

<script>
function back(){
	history.back();
}
</script>

<!--  게시글 상세보기  -->
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
          <a href="<%=application.getContextPath()%>/index.jsp">Dashboard</a>
          </li>
          <li class="breadcrumb-item active">게시판</li>

        </ol>

        <div class="card mb-3">
          <div class="card-header">
            <i class="fas fa-table"></i> 게시판 읽기
          </div>

          <!-- 게시글 읽기-->
        <!-- 
          <form action="/boards/edit-article.jsp" method="post">
         -->
          <div class="article-view">
            <div class="article-info-full">
              글 제목 : <%= article.getSubject() %>
            </div>
            <div class="article-group">
              <div class="article-info-left">
              작성자 : <%= article.getWriter() %>
              </div>
              <div class="article-info-right">
              작성일 : <%= article.getRegdate() %>
              </div>
            </div>
            <div class="article-group">
              <div class="article-info-left">
              <p>작성자아이피 : <%= article.getIp() %></p>
              </div>
              <div class="article-info-right">
              <p>조회수 : <%= article.getHitCount() %></p>
              </div>
            </div>
            <div class="article-text article-info-full">
            <p>[글내용]</p>
            <%
            String content= article.getContent();
            content= content.replace("\r\n","<br>");
            %>
            <%= content %>
            </div>
            <!-- 
            <input type="hidden" name="article_id" value="<%= article.getArticle_id() %>"/>
             -->
              <div class="board-btns">
              <%
              if(article.getBoard_id()==1){
               %>
                <a class="btn btn-primary btn-board" 
              href="<%=application.getContextPath()%>/boards/free-board.jsp">
              목록  </a>
              <!--  
              <a class="btn btn-primary btn-board pointer"  onclick="back();">
              목록  </a>
              -->
               <%
              } else if(article.getBoard_id()==2){
            %>
             <a class="btn btn-primary btn-board" 
              href="<%=application.getContextPath()%>/boards/review-board.jsp">
              목록 
              </a>
            <%
              }
              %>
              
              <%
               if (userID != null) { //로그인중
              %>
              <form action="/boards/reply-article.jsp" method="post" class="inline-form">
                 <input type="hidden" name="article_id" value="<%= article.getArticle_id() %>"/>
                 <input type="hidden" name="isReply" value="<%=isReply%>"/>
                 <button class="btn btn-primary btn-board">답글</button>
              </form>
              <%
              if (!userID.equals(article.getWriter()) ) { //글 작성자가 아님
                 //더이상 보여줄 버튼 없음 
              } else { //글 작성자임
                %>
                 <form action="/boards/delete-article.jsp" method="post" class="inline-form">
                   <input type="hidden" name="article_id" value="<%= article.getArticle_id() %>"/>
                  <button class="btn btn-primary btn-board">삭제</button>
                </form>
                 <form action="/boards/edit-article.jsp" method="post" class="inline-form">
                   <input type="hidden" name="article_id" value="<%= article.getArticle_id() %>"/>
                   <button type="submit" class="btn btn-primary btn-board">수정</button> 
                </form>
                <%
                	}
                	}
                %>

              </div>
              <!--  
              </form>
              -->
          <div class="card-footer small text-muted"> 주현 블로그 </div>
        </div>

      </div>
      <!-- /.container-fluid -->

     <%-- footer 
      <jsp:include page="/include/footer.jsp" />  --%>
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
