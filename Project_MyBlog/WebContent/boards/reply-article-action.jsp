<%@page import="kr.or.kosta.blog.article.Article"%>
<%@page import="kr.or.kosta.blog.dao.JdbcDaoFactory"%>
<%@page import="kr.or.kosta.blog.dao.DaoFactory"%>
<%@page import="kr.or.kosta.blog.article.ArticleDao"%>
<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>

<jsp:useBean id="article" class="kr.or.kosta.blog.article.Article"  scope="page" />
<jsp:setProperty property="*" name="article" />

<%
	DaoFactory factory = (JdbcDaoFactory) application.getAttribute("factory");
	ArticleDao dao = factory.getArticleDao();
	int parent_id= Integer.parseInt(request.getParameter("parent_id"));
    Article parentArticle = dao.read(parent_id);
    
    String isReply= request.getParameter("isReply"); //원글이 답글이었는지 확인
    if(isReply.equals("false")){ //원글이었다면 이 글이 첫 답글임
    	dao.createReply(parentArticle.getGroupNum(), article);
    } else if (isReply.equals("true")){ //답변글이었다면 이 글은 2번재 이상 답글임
      dao.addParentOrderNum(parent_id);  
      dao.createSubReply(parent_id, parentArticle.getGroupNum(), article); //답글의 답글 
    }
    
  if(article.getBoard_id()==1){
	  response.sendRedirect("/boards/free-board.jsp");
  } else if(article.getBoard_id()==2){
	  response.sendRedirect("/boards/review-board.jsp");
  }
	
%>