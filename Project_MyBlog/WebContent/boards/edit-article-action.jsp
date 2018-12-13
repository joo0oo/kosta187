<%@page import="kr.or.kosta.blog.dao.JdbcDaoFactory"%>
<%@page import="kr.or.kosta.blog.dao.DaoFactory"%>
<%@page import="kr.or.kosta.blog.article.ArticleDao"%>
<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>

<jsp:useBean id="article" class="kr.or.kosta.blog.article.Article"
  scope="page" />
<jsp:setProperty property="*" name="article" />

<%
	DaoFactory factory = (JdbcDaoFactory) application.getAttribute("factory");
	ArticleDao dao = factory.getArticleDao();
	
    dao.update(article);
    
  System.out.println("board: "+article.getBoard_id());
	if(article.getBoard_id()==1){
		response.sendRedirect("/boards/free-board.jsp");
	} else if(article.getBoard_id()==2){
	 response.sendRedirect("/boards/review-board.jsp");
	}
%>