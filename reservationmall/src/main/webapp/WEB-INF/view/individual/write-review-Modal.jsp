   <%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
      <!-- 리뷰쓰기 모달 -->
        <div class="modal fade" id="write-review-Modal" role="dialog">
          <div class="modal-dialog">
            <div class="modal-content">
              <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">×</button>
                <h4 class="modal-title"> 리뷰 쓰기 </h4>
              </div>
              <div class="modal-body">
                <p>
                  예약 번호 
                  <span id="modal-write-review-id"> </span>
                </p>
                <p>
                  <span id="write-review-hotel-name" class="alert alert-info"> </span>
                  <span id="write-review-room-name" class="alert alert-info"> </span>
                </p>
                <p>
                  체크인 
                  <span id="write-review-checkin" class="badge"> </span>
                  체크아웃  
                  <span id="write-review-checkout" class="badge"> </span>
                </p>
                <div>
                  <form id="writeReviewForm" action="/reservationmall/individual/writeReview.mall" method="post">
                    <div>
                    <div class="col-md-12">
                      <div class="col-md-6"> 
                        <span>가격</span> 
                        <span name="star-rating"> 
                          <span name="star-rating-1" class="fa fa-star unchecked-star"></span>
                          <span name="star-rating-2" class="fa fa-star unchecked-star"></span>
                          <span name="star-rating-3" class="fa fa-star unchecked-star"></span>
                          <span name="star-rating-4" class="fa fa-star unchecked-star"></span>
                          <span name="star-rating-5" class="fa fa-star unchecked-star"></span>
                          <input type="hidden" name="review_price_rate" value=""/>
                        </span>
                      </div>
                      <div class="col-md-6"> 
                        <span>서비스</span> 
                        <span name="star-rating"> 
                          <span name="star-rating-1" class="fa fa-star unchecked-star"></span>
                          <span name="star-rating-2" class="fa fa-star unchecked-star"></span>
                          <span name="star-rating-3" class="fa fa-star unchecked-star"></span>
                          <span name="star-rating-4" class="fa fa-star unchecked-star"></span>
                          <span name="star-rating-5" class="fa fa-star unchecked-star"></span>
                          <input type="hidden" name="review_service_rate" value=""/>
                        </span>
                      </div>
                    </div>
                    <div class="col-md-12">
                      <div class="col-md-6"> 
                        <span>음식</span> 
                        <span name="star-rating"> 
                          <span name="star-rating-1" class="fa fa-star unchecked-star"></span>
                          <span name="star-rating-2" class="fa fa-star unchecked-star"></span>
                          <span name="star-rating-3" class="fa fa-star unchecked-star"></span>
                          <span name="star-rating-4" class="fa fa-star unchecked-star"></span>
                          <span name="star-rating-5" class="fa fa-star unchecked-star"></span>
                          <input type="hidden" name="review_food_rate" value=""/>
                        </span>
                      </div>
                      <div class="col-md-6"> 
                        <span>청결</span> 
                        <span name="star-rating"> 
                          <span name="star-rating-1" class="fa fa-star unchecked-star"></span>
                          <span name="star-rating-2" class="fa fa-star unchecked-star"></span>
                          <span name="star-rating-3" class="fa fa-star unchecked-star"></span>
                          <span name="star-rating-4" class="fa fa-star unchecked-star"></span>
                          <span name="star-rating-5" class="fa fa-star unchecked-star"></span>
                          <input type="hidden" name="review_clean_rate" value=""/>
                        </span>
                      </div>
                      </div>
                    <div class="col-md-12">
                      <div class="col-md-6"> 
                        <span>위치</span> 
                        <span name="star-rating"> 
                          <span name="star-rating-1" class="fa fa-star unchecked-star"></span>
                          <span name="star-rating-2" class="fa fa-star unchecked-star"></span>
                          <span name="star-rating-3" class="fa fa-star unchecked-star"></span>
                          <span name="star-rating-4" class="fa fa-star unchecked-star"></span>
                          <span name="star-rating-5" class="fa fa-star unchecked-star"></span>
                          <input type="hidden" name="review_location_rate" value=""/>
                        </span>
                      </div>
                    </div>
                    </div>
                    <input type="hidden" id="write-review_res_id" name="write-review_res_id" value=""/>
                    <div class="col-md-12">
                      <textarea id="write-review-text" class="form-control" 
                      rows="10" name="review_content" required="required"
                      placeholder="여기에 리뷰를 작성하세요.."></textarea>
                    </div>
                  </form>
                </div> 
              <div class="modal-footer">
                <button type="button" id="write-reviewBtn" class="btn btn-primary" data-dismiss="modal" >리뷰쓰기</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
              </div>
            </div>
          </div>
        </div>
        </div>
        <!-- 리뷰쓰기 모달 -->