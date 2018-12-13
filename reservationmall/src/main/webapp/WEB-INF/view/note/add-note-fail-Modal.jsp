<%@page import="kr.or.kosta.reservationmall.note.dto.Notes"%>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="utf-8">

<!-- 쪽지 등록 실패 모달 -->
<div class="modal fade" id="boxesfail" role="dialog">
  <div id="dialog" class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">×</button>
        <h4 class="modal-title">쪽지 등록 확인 알람</h4>
      </div>
      <div class="modal-body">
        <p>쪽지 등록에 실패하셨습니다. 내용을 다시 확인해주세요.</p>
        <p>이메일과 양식을 올바르게 작성하지 않아, 오류가 발생하였습니다.</p>
        <p>이메일과 내용을 반드시 작성하셔야 등록 가능합니다.</p>
        <p>신속하고 빠른 서비스를 위해 노력하는 요기조아 YOGIZOA가 되겠습니다.</p>
        <p>요기조아 YOGIZOA를 이용해 주셔서 감사합니다. :-)</p>
      </div>
      <div class="modal-footer">
        <a class="agree" style="color: red;" href='/reservationmall'>취소</a>
      </div>
    </div>
  </div>
</div>


</html>