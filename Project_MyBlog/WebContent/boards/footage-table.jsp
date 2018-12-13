<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="kr.or.kosta.blog.footage.Footage"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.kosta.blog.footage.FootageDao"%>
<%@page import="kr.or.kosta.blog.dao.DaoFactory"%>
<%@page import="kr.or.kosta.blog.dao.JdbcDaoFactory"%>
<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%-- 
<%@ include file="/boards/footage-action.jsp" %>
--%>
<!--  방명록 테이블 -->
<div class="card-body">
  <div class="table-responsive">
    <table class="table table-bordered" id="dataTable" width="100%"
      cellspacing="0">
      <thead>
        <tr>
          <th>작성자</th>
          <th>내용</th>
          <th>날짜</th>
        </tr>
      </thead>
      <tbody>
        <%
        DaoFactory factory = (DaoFactory)application.getAttribute("factory");
    	FootageDao daoF = factory.getFootageDao();
    	 System.out.println(" footageleDao factory created ");
      List<Footage> list= daoF.listAll();
        for( Footage footage : list){
        %>
          <tr class="footage">
            <td>
            <%= footage.getUserID() %>
            </td>
            <td>
            <%= footage.getContents()  %>
            </td>
            <td>
            <%= footage.getRegdate() %>
            </td>
          </tr>
        <%
        }
        %>
      </tbody>
    </table>
  </div>
</div>
