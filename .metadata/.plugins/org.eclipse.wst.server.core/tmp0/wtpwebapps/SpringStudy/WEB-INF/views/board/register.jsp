<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@include file="/WEB-INF/views/board/includes/header.jsp"%>

<div class="row">
  <div class="col-lg-12">
    <h1 class="page-header">Tables</h1>
  </div>
  <!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<div class="row">
  <div class="col-lg-12">
    <div class="panel panel-default">
      <div class="panel-heading">Board Register</div>
      <!-- /.panel-heading -->
      <div class="panel-body">
        
        <form role="form" action="/spring/board/register" method="post">
          <div class="form-group">
            <label>Title</label>
            <input type="text" class="form-control" name="title">
          </div>
          <div class="form-group">
            <label>Text area</label>
            <textarea class="form-control" name="content" rows="3"></textarea>
          </div>
          <div class="form-group">
            <label>Writer</label>
            <input class="form-control" name="writer">
          </div>
          
          <button type="submit" class="btn btn-default">Submit</button>
          <button type="reset" class="btn btn-default">reset</button>
        </form>
      
      </div>
      <!-- /.panel-body -->
    </div>
    <!-- /.panel -->
  </div>
  <!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<%@include file="/WEB-INF/views/board/includes/footer.jsp"%>