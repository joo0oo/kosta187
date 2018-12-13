<%@page import="kr.or.kosta.reservationmall.note.dto.Notes"%>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="utf-8">
	
<!-- 쪽지 등록 성공 모달 -->
  <div class="modal fade" id="boxes" role="dialog">
    <div id="dialog" class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">×</button>
          <h4 class="modal-title">쪽지 등록 확인 알람</h4>
        </div>
        <div class="modal-body">
          <p>쪽지 등록에 성공하셨습니다.</p>
          <p>문의사항에 대한 빠른 답변을 위해 노력하는 요기조아 YOGIZOA가 되겠습니다. </p>
          <p>답변은 해당 이메일을 통해 전송 예정입니다. </p>
          <p>요기조아 YOGIZOA를 이용해 주셔서 감사합니다. :-)</p>
        </div>
        <div class="modal-footer">
          <a class="agree" style="color: red;" href='/reservationmall'>취소</a>
        </div>
      </div>
    </div>
  </div>

</html>