   <%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
        <!-- 리뷰읽기 모달 -->
        <div class="modal fade" id="reading-review-Modal" role="dialog">
          <div class="modal-dialog">
            <div class="modal-content">
              <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">×</button>
                <h4 class="modal-title"> 리뷰 읽기 </h4>
              </div>
              <div class="modal-body">
                <div class="col-md-12">
                <p>
                  예약 번호 
                  <span id="modal-read-review-id"> </span>
                </p>
                </div>
                <div>
                  <form id="readReviewForm">
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
                        <div class="col-md-12"> 
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
                    <div>
                      <div class="col-md-12">
                        <div class="col-md-12"> 
                          <span>좋아요 </span> 
                          <span name="review_helpful_count"></span>
                          <span> 개</span>
                        </div>
                      </div>
                    </div>
                    
                    <input type="hidden" id="read-review_res_id" name="read-review_res_id" value=""/>
                    
                    <div class="col-md-12 bg-info">
                      <p  id="read-review-text" name="review_content"></p>
                    </div> 
                  </form>
                </div> 
              <div class="modal-footer">
                <button type="button" id="reading-review-Modal-close" class="btn btn-default" data-dismiss="modal">Close</button>
              </div>
            </div>
          </div>
        </div>
        </div>
        <!-- 리뷰읽기 모달 -->
