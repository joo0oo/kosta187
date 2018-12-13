<%@page import="kr.or.kosta.blog.footage.FootageDao"%>
<%@page import="kr.or.kosta.blog.article.ArticleDao"%>
<%@page import="kr.or.kosta.blog.dao.JdbcDaoFactory"%>
<%@page import="kr.or.kosta.blog.dao.DaoFactory"%>
<%@ page language="java" contentType="text/html; charset=utf-8"%>

<%
  DaoFactory factory = (JdbcDaoFactory) application.getAttribute("factory");
  ArticleDao dao = factory.getArticleDao();
  int freeArticleCNT= dao.countTodayArticle(1);
  int reviewArticleCNT= dao.countTodayArticle(2);
  
  FootageDao fDao= factory.getFootageDao();
  int footageCNT= fDao.countTodayArticle();
  //System.out.println(freeArticleCNT);
%>
<div class="row">
  <div class="col-xl-3 col-sm-6 mb-3">
    <div class="card text-white bg-primary o-hidden h-100">
      <div class="card-body">
        <div class="card-body-icon">
          <i class="fas fa-fw fa-comments"></i>
        </div>
        <div class="mr-5">
        <p>방명록</p>
        오늘의 새글 <%= footageCNT%>개
        </div>
      </div>
      <a class="card-footer text-white clearfix small z-1" 
      href="/boards/footage-board.jsp">
        <span class="float-left">바로가기</span> 
        <span
        class="float-right"> 
        <i class="fas fa-angle-right"></i>
      </span>
      </a>
    </div>
  </div>
  <div class="col-xl-3 col-sm-6 mb-3">
    <div class="card text-white bg-warning o-hidden h-100">
      <div class="card-body">
        <div class="card-body-icon">
          <i class="fas fa-fw fa-list"></i>
        </div>
        <div class="mr-5">
        <p>자유게시판</p>
        오늘의 새글 <%= freeArticleCNT%>개
        </div>
      </div>
      <a class="card-footer text-white clearfix small z-1" 
      href="/boards/free-board.jsp">
        <span class="float-left">바로가기</span> 
        <span
        class="float-right"> 
        <i class="fas fa-angle-right"></i>
      </span>
      </a>
    </div>
  </div>
  <div class="col-xl-3 col-sm-6 mb-3">
    <div class="card text-white bg-success o-hidden h-100">
      <div class="card-body">
        <div class="card-body-icon">
          <i class="fas fa-fw fa-list"></i>
        </div>
        <div class="mr-5">
        <p>리뷰게시판</p>
        오늘의 새글 <%= reviewArticleCNT%>개
        </div>
      </div>
      <a class="card-footer text-white clearfix small z-1"
      href="/boards/review-board.jsp">
        <span class="float-left">바로가기</span> 
        <span
        class="float-right"> <i class="fas fa-angle-right"></i>
      </span>
      </a>
    </div>
  </div>
  <div class="col-xl-3 col-sm-6 mb-3">
    <div class="card text-white bg-danger o-hidden h-100">
      <div class="card-body">
        <div class="card-body-icon">
          <i class="fas fa-fw fa-life-ring"></i>
        </div>
        <div class="mr-5">영화 예매하기</div>
      </div>
      
      <a class="card-footer text-white clearfix small z-1" 
      href="http://www.cgv.co.kr/culture-event/event/?menu=2#1">
        <span class="float-left">CGV</span> 
        <span
        class="float-right"> <i class="fas fa-angle-right"></i>
      </span>
      </a>
      <a class="card-footer text-white clearfix small z-1" 
      href="http://www.megabox.co.kr/?show=booking&p=step1">
        <span class="float-left">메가박스</span> 
        <span
        class="float-right"> <i class="fas fa-angle-right"></i>
      </span>
      </a>
    </div>
  </div>
</div>