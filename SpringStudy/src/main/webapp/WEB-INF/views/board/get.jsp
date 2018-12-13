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
        
          
          <div class="form-group">
            <label>BNO</label>
            <input class="form-control" name="bno" value="<c:out value='${board.bno}'/>" readonly="readonly">
          </div>
          <div class="form-group">
            <label>Title</label>
            <input class="form-control" name="title" value="<c:out value='${board.title}'/>" readonly="readonly">
          </div>
          <div class="form-group">
            <label>Text area</label>
            <textarea class="form-control" name="content" rows="3" readonly="readonly"><c:out value="${board.content}"/></textarea>
          </div>
          <div class="form-group">
            <label>Writer</label>
            <input class="form-control" name="writer" value="<c:out value='${board.writer}'/>" readonly="readonly">
          </div>
          
          <button data-oper="modify" class="btn btn-default">
            Modify
          </button>
          <button data-oper="list" class="btn btn-info">
            List
          </button>
          
          <form id="operForm" action="/spring/board/modify" method="get">
            <input type="hidden" id="bno" name="bno" value="<c:out value='${board.bno}'/>">
            <input type="hidden" name="pageNum" value="<c:out value='${cri.pageNum}'/>">
            <input type="hidden" name="amount" value="<c:out value='${cri.amount}'/>">
            <input type='hidden' name='keyword' value='<c:out value="${cri.keyword}"/>'>
            <input type='hidden' name='type' value='<c:out value="${cri.type}"/>'> 
          </form>
      
      </div>
      <!-- /.panel-body -->
    </div>
    <!-- /.panel -->
  </div>
  <!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<div class='row'>
  <div class="col-lg-12">

    <!-- /.panel -->
    <div class="panel panel-default">
      <!--       <div class="panel-heading">
        <i class="fa fa-comments fa-fw"></i> Reply
      </div> -->

      <div class="panel-heading">
        <i class="fa fa-comments fa-fw"></i> Reply
        <button id='addReplyBtn' class='btn btn-primary btn-xs pull-right'>New Reply</button>
      </div>

      <!-- /.panel-heading -->
      <div class="panel-body">
        <ul class="chat">
        </ul>
        <!-- ./ end ul -->
      </div>
      <!-- /.panel .chat-panel -->
      <div class="panel-footer"></div>
    </div>
  </div>
  <!-- ./ end row -->
</div>


<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title" id="myModalLabel">REPLY MODAL</h4>
      </div>
      <div class="modal-body">
        <div class="form-group">
          <label>Reply</label> 
          <input class="form-control" name='reply' value='New Reply!!!!'>
        </div>
        <div class="form-group">
          <label>Replyer</label> 
          <input class="form-control" name='replyer' value='replyer'>
        </div>
        <div class="form-group">
          <label>Reply Date</label> 
          <input class="form-control" name='replyDate' value='2018-01-01 13:13'>
        </div>

      </div>
      <div class="modal-footer">
        <button id='modalModBtn' type="button" class="btn btn-warning">Modify</button>
        <button id='modalRemoveBtn' type="button" class="btn btn-danger">Remove</button>
        <button id='modalRegisterBtn' type="button" class="btn btn-primary">Register</button>
        <button id='modalCloseBtn' type="button" class="btn btn-default">Close</button>
      </div>
    </div>
    <!-- /.modal-content -->
  </div>
  <!-- /.modal-dialog -->
</div>
<!-- /.modal -->


<script type="text/javascript" src="/spring/resources/js/reply.js"> </script>
<script type="text/javascript">
$(document).ready(function(){
	var operForm=$('#operForm');
		
	$('button[data-oper="modify"]').on('click',function(e){
		//게시글 수정
		operForm.attr('action','/spring/board/modify').submit();
	});
		
	$('button[data-oper="list"]').on('click',function(e){
		//게시글 목록으로
		operForm.find('#bno').remove();
		operForm.attr('action','/spring/board/list');
		operForm.submit();
	});
		
	console.log(replyService);
	var bnoValue= '<c:out value="${board.bno}"/>';
	var replyUL = $(".chat");
	showList(1);
	    
    function showList(page){ //페이지에 따른 댓글 목록 출력
    	console.log("show list " + page);
        replyService.getList({bno:bnoValue,page: page|| 1 }, function(replyCnt, list) {
        console.log("replyCnt: "+ replyCnt );
        console.log("list: " + list);
        console.log(list);
    	    
        if(page == -1){ //새 댓글 등록한 경우
          pageNum = Math.ceil(replyCnt/10.0);
          showList(pageNum); //마지막(최신) 페이지로
          return;
        }
    	      
         var str="";
         if(list == null || list.length == 0){
           return;
         }
    	     
         for (var i = 0, len = list.length || 0; i < len; i++) {
           str +="<li class='left clearfix' data-rno='"+list[i].rno+"'>";
           str +="  <div><div class='header'><strong class='primary-font'>["
        	   +list[i].rno+"] "+list[i].replyer+"</strong>"; 
           str +="    <small class='pull-right text-muted'>"
               +replyService.displayTime(list[i].replyDate)+"</small></div>";
           str +="    <p>"+list[i].reply+"</p></div></li>";
         }
    	     
         replyUL.html(str);
         showReplyPage(replyCnt);
      });//end function
    }//end showList
	 
    var pageNum = 1;
    var replyPageFooter = $(".panel-footer");
    
    //댓글 총 개수로 페이징처리
    function showReplyPage(replyCnt){
            
      var endNum = Math.ceil(pageNum / 10.0) * 10;  
      var startNum = endNum - 9; 
      var prev = startNum != 1;
      var next = false;
            
      if(endNum * 10 >= replyCnt){
        endNum = Math.ceil(replyCnt/10.0);
      }
            
      if(endNum * 10 < replyCnt){
        next = true;
      }
            
      var str = "<ul class='pagination pull-right'>";
            
      if(prev){
        str+= "<li class='page-item'><a class='page-link' href='"+(startNum -1)+"'>Previous</a></li>";
      }
            
      for(var i = startNum ; i <= endNum; i++){
              
        var active = pageNum == i? "active":"";
        str+= "<li class='page-item "+active+" '><a class='page-link' href='"+i+"'>"+i+"</a></li>";
      }
            
      if(next){
        str+= "<li class='page-item'><a class='page-link' href='"+(endNum + 1)+"'>Next</a></li>";
      }
            
      str += "</ul></div>";
      console.log(str);
      replyPageFooter.html(str);
    }//댓글 페이징처리 끝
    	 
    replyPageFooter.on("click","li a", function(e){
    //footer에 댓글 페이징 번호 표시
    	e.preventDefault();
    	var targetPageNum = $(this).attr("href");
    	console.log("targetPageNum: " + targetPageNum);
    	pageNum = targetPageNum;
    	showList(pageNum); //해당 페이지에 해당하는 댓글 목록 보이기
    });     
        
    	
    /*댓글 새로쓰기/수정/삭제 관련 모달*/
    var modal = $(".modal");
    var modalInputReply = modal.find("input[name='reply']");
    var modalInputReplyer = modal.find("input[name='replyer']");
    var modalInputReplyDate = modal.find("input[name='replyDate']");
    	    
    var modalModBtn = $("#modalModBtn");
    var modalRemoveBtn = $("#modalRemoveBtn");
    var modalRegisterBtn = $("#modalRegisterBtn");
    	    
    $("#modalCloseBtn").on("click", function(e){
    	modal.modal('hide');
    });
    	    
    $("#addReplyBtn").on("click", function(e){
    	modal.find("input").val("");
    	modalInputReplyDate.closest("div").hide();
    	modal.find("button[id !='modalCloseBtn']").hide();
    	modalRegisterBtn.show();
    	$(".modal").modal("show");
    });
    	    

    modalRegisterBtn.on("click",function(e){
    	var reply = {
    		reply: modalInputReply.val(),
    	    replyer:modalInputReplyer.val(),
    	    bno:bnoValue
    	};
    	replyService.add(reply, function(result){
    		// alert(result);
    	    modal.find("input").val("");
    	    modal.modal("hide");

    	    //showList(1);
    	    showList(-1); //최신 목록으로 가기 위해 -1 보냄
    	});
    });
    	    
    //댓글 조회 클릭 이벤트 처리 
     $(".chat").on("click", "li", function(e){
    	      
     	var rno = $(this).data("rno");
    	      
    	replyService.get(rno, function(reply){
    		modalInputReply.val(reply.reply);
    	    modalInputReplyer.val(reply.replyer);
    	    modalInputReplyDate.val(replyService.displayTime( reply.replyDate)).attr("readonly","readonly");
    	    modal.data("rno", reply.rno);
    	        
    	    modal.find("button[id !='modalCloseBtn']").hide();
    	    modalModBtn.show();
    	    modalRemoveBtn.show();
    	    $(".modal").modal("show");
		});
	});
    	    
    //댓글 수정
    modalModBtn.on("click", function(e){
    	var reply = {rno:modal.data("rno"), reply: modalInputReply.val()};
    	replyService.update(reply, function(result){
    	//alert(result);
    	modal.modal("hide");
    	showList(pageNum);
    	});
    });

	//댓글 삭제
    modalRemoveBtn.on("click", function (e){
    	var rno = modal.data("rno");
    	replyService.remove(rno, function(result){
    	//alert(result);
    	modal.modal("hide");
    	showList(pageNum);
    	});
    });
    	     	
    	    
    	    
		/* replyService.add(
			{reply: 'JS test', replyer:'jstester', bno:bnoValue},
			function(result){ //ajax 전송 결과 처리하는 함수
				alert('result : '+result);
			}
		); */
		
/* 		
		replyService.getList({bno: bnoValue, page:1}, function(list){
			for(var i=0, len= list.length||0 ; i<len; i++){
				console.log(list[i]);
			}
		});
		
		replyService.remove(2,
				function(count){
					console.log(count);
					if(count === 'success'){
						alert('removed');
					}
			}, function(error){
				alert('remove error');
			}
		});
		
		replyService.update({
			rno:22,
			bno:bnoValue,
			reply: 'modified reply...'
		}, funtion(result){
			alert('수정완료');
		
		});
		
		replyService.get(10,function(data){
			console.log(data);
		});
		 */
		
	});
</script>

<%@include file="/WEB-INF/views/board/includes/footer.jsp"%>