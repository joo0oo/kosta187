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
      <div class="panel-heading">
        Board List Page
       <button id="regBtn" type="button" class="btn btn-xs pull-right">Register New Board</button>
      </div>
     
      <!-- /.panel-heading -->
      <div class="panel-body">
      
      
        <table class="table table-striped table-bordered table-hover"
          id="dataTables-example">
          <thead>
            <tr>
              <th>번호</th>
              <th>제목</th>
              <th>작성자</th>
              <th>작성일</th>
              <th>수정일</th>
            </tr>
          </thead>

          <c:forEach items="${list}" var="board">
            <tr>
              <td><c:out value="${board.bno}" /></td>
              <td>
              <a class="move" href="<c:out value="${board.bno}" />">
                <c:out value="${board.title}" />
                 <b>[  <c:out value="${board.replyCnt}" />  ]</b>
              </a>
              </td>
              <td><c:out value="${board.writer}" /></td>
              <td><c:out value="${board.regdate}" /></td>
              <td><c:out value="${board.updateDate}" /></td>
            </tr>
          </c:forEach>
        </table>
        
        <div class="row">
          <div class="col-lg-12">

            <form id='searchForm' action="/board/list" method='get'>
              <select name='type'>
                <option value=""
                  <c:out value="${pageMaker.cri.type == null?'selected':''}"/>>--
                </option>
                <option value="T"
                  <c:out value="${pageMaker.cri.type eq 'T'?'selected':''}"/>>제목
                </option>
                <option value="C"
                  <c:out value="${pageMaker.cri.type eq 'C'?'selected':''}"/>>내용
                </option>
                <option value="W"
                  <c:out value="${pageMaker.cri.type eq 'W'?'selected':''}"/>>작성자
                </option>
                <option value="TC"
                  <c:out value="${pageMaker.cri.type eq 'TC'?'selected':''}"/>>제목 or 내용
                </option>
                <option value="TW"
                  <c:out value="${pageMaker.cri.type eq 'TW'?'selected':''}"/>>제목 or 작성자
                </option>
                <option value="TWC"
                  <c:out value="${pageMaker.cri.type eq 'TWC'?'selected':''}"/>>
                  제목 or 내용 or 작성자
                </option>
              </select> 
              <input type='text' name='keyword' value='<c:out value="${pageMaker.cri.keyword}"/>' /> 
              <input type='hidden' name='pageNum' value='<c:out value="${pageMaker.cri.pageNum}"/>' /> 
              <input type='hidden' name='amount' value='<c:out value="${pageMaker.cri.amount}"/>' />
              <button class='btn btn-default'>Search</button>
            </form>
          </div>
        </div>
        
        <div class="pull-right">
          <ul class="pagination">
            <c:if test="${pageMarker.prev}">
              <li class="paginate_button previous"><a href="${pageMarker.startPage-1}">prev</a></li>
            </c:if>
            
            <c:forEach var="num" begin="${pageMarker.startPage}" end="${pageMarker.endPage}">
              <li class="paginate_button ${pageMarker.cri.pageNum== num? 'active':''}"><a href="${num}">${num}</a></li>
            </c:forEach>
            
            <c:if test="${pageMarker.next}">
              <li class="paginate_button next"><a href="${pageMarker.endPage+1}">next</a></li>
            </c:if>
          </ul>
        </div>
        
        <form id="pagingForm" action="/spring/board/list" method="get">
          <input type="hidden" name="pageNum" value="${pageMarker.cri.pageNum}">
          <input type="hidden" name="amount" value="${pageMarker.cri.amount}">
          <input type='hidden' name='type' value='<c:out value="${ pageMaker.cri.type }"/>'> 
          <input type='hidden' name='keyword' value='<c:out value="${ pageMaker.cri.keyword }"/>'>
        </form>
        
        <!-- Modal -->
        <div class="modal fade" id="myModal" tabindex="-1" role="dialog"
          aria-labelledby="myModalLabel" aria-hidden="true">
          <div class="modal-dialog">
            <div class="modal-content">
              <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">Modal title</h4>
              </div>
              <div class="modal-body"> 처리 완료 </div>
              <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary">Save changes</button>
              </div>
            </div>
            <!-- /.modal-content -->
          </div>
          <!-- /.modal-dialog -->
        </div>
        <!-- /.modal -->
        
        
      </div>
      <!-- /.panel-body -->
    </div>
    <!-- /.panel -->
  </div>
  <!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<script type="text/javascript">
	$(document).ready(function() {
//		var result = '<c:out value="${result}" />'; //BoardController의 register()에서 저장한 attribute 값
		var result = '${requestScope.result}'; //BoardController의 register()에서 저장한 attribute 값
	//	alert(result);
		checkModal(result);
		history.replaceState({},null,null); //뒤로가기 버튼 눌렀을 때 모달 다시 뜨지 않게 처리
	
		function checkModal(result){
			if(result==='' || history.state){ //뒤로가기 처리2
				return;
			}
			
			if(parseInt(result) > 0){
				$('.modal-body').html('게시글 '+parseInt(result)+' 번이 등록되었습니다');
			}
			
			$('#myModal').modal('show');
		}
		
		$('#regBtn').on('click',function(){
			self.location="/spring/board/register";
		})
		
		var pagingForm= $('#pagingForm');
		$('.paginate_button a').on('click',function(e){
			e.preventDefault();
			//alert('prevent');
			console.log('click');
			pagingForm.find('input[name="pageNum"]').val($(this).attr('href'));
			pagingForm.submit();
		});
		
		$('.move').on('click',function(e){
			e.preventDefault();
			pagingForm.append('<input type="hidden" name="bno" value="'+$(this).attr('href')+'">');
			pagingForm.attr('action','/spring/board/get');
			pagingForm.submit();
		});
		
		
		var searchForm = $("#searchForm");
		$("#searchForm button").on("click",function(e) {

			if (!searchForm.find("option:selected").val()) {
				alert("검색종류를 선택하세요");
				return false;
			}

			if (!searchForm.find("input[name='keyword']").val()) {
				alert("키워드를 입력하세요");
				return false;
			}

			searchForm.find("input[name='pageNum']").val("1");
			e.preventDefault();

			searchForm.submit();
		});
		
	});
</script>

<%@include file="/WEB-INF/views/board/includes/footer.jsp"%>