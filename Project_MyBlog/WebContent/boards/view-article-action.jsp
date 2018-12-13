<%@page import="kr.or.kosta.blog.article.Article"%>
<%@page import="kr.or.kosta.blog.article.ArticleDao"%>
<%@page import="kr.or.kosta.blog.dao.JdbcDaoFactory"%>
<%@page import="kr.or.kosta.blog.dao.DaoFactory"%>
<%@ page language="java" contentType="text/html; charset=utf-8" %>

<jsp:useBean id="article" class="kr.or.kosta.blog.article.Article" scope="session"/>

<%
request.setCharacterEncoding("utf-8");
int article_id= Integer.parseInt(request.getParameter("clicked_id"));

DaoFactory factory = (JdbcDaoFactory) application.getAttribute("factory");
ArticleDao dao = factory.getArticleDao();

article= dao.read(article_id);
%>

<jsp:forward page="/boards/view-article.jsp"></jsp:forward>