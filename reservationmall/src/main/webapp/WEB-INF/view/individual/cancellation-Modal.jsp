   <%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
   <!-- 예약취소 모달 -->
        <div class="modal fade" id="cancellation-Modal" role="dialog">
          <div class="modal-dialog">
            <div class="modal-content">
              <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">×</button>
                <h4 class="modal-title"> 예약취소 </h4>
              </div>
              <div class="modal-body">
                <p class="row">
                  예약 번호 
                  <span id="modal-cancellation-id"> </span>
                </p>
                <p class="row">
                  <span id="cancellation-hotel-name" class="alert alert-info"> </span>
                  <span id="cancellation-room-name" class="alert alert-info"> </span>
                </p>
                <p class="row">
                  체크인 :
                  <span id="cancellation-checkin" class="badge"> </span>
                  & 체크아웃 : 
                  <span id="cancellation-checkout" class="badge"> </span>
                </p>
                <p> 예약 취소 하시겠습니까? </p>
              </div>
              <div class="modal-footer">
                <form id="cancellationForm" action="/reservationmall/individual/cancellationRes.mall" method="post">
                  <input type="hidden" id="cancellation_res_id" name="cancellation_res_id" value=""/>
                  <button type="button" id="cancellationBtn" class="btn btn-danger" data-dismiss="modal" >취소하기</button>
                  <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                </form>
              </div>
            </div>
          </div>
        </div>
        <!-- 예약취소 모달 -->