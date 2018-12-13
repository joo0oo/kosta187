    
$(function(){ 
        $('ul.nav-tabs a').click(function (e) { //부트스트랩 탭메뉴
          e.preventDefault()
          $(this).tab('show')
        })
        
        if($('#logoutBtn') != null){ // 로그아웃
        	$('#logoutBtn').on('click',function(){
        		var d = new Date();
        	    var expires = "expires=" + d.toGMTString();
        	    document.cookie = 'loginId' + "=" + '' + ";" + expires + ";path=/";
        	    location.href='/reservationmall/index.jsp';
        	});
        } 
        
        if($('#withdrawalMOpenBtn') != null){ // 회원 탈퇴
          $('#withdrawalMOpenBtn').click(function(){
        	  
        	  $('#withdrawalBtn').on('click',function(){
        		  console.log('탈퇴 버튼 클릭');
        		  var userId= '<%=loginId%>';
        		  console.log(userId);
        		  
        		  $.ajax({
        			  data: {
        				'userId' :   userId
        			  },
        			  url:"/reservationmall/individual/withdrawal.mall",
        			  success: function(data){
        				 // alert('탈퇴성공');
        				 data= data.trim();
        				 if(data=='withdrawalSuccess'){
        					 var d = new Date();
        	        	     var expires = "expires=" + d.toGMTString();
        					 document.cookie = 'loginId' + "=" + '' + ";" + expires + ";path=/";
        					 $('#withdrawal-confirm-Modal').modal();
        				 } else if(data == 'withdrawalFail'){
        					 alert('from server : withdrawalFail');
        				 }
        			  }, 
        			  error: function(){
        				 alert('서버로부터 전송 에러');
        			  }
        		  });
        	  });
        	  $('#withdrawal-Modal').modal();
          })
        }
        
        if($('button[name=write-reviewOpenBtn]') != null){ //리뷰 쓰기 버튼
        	$('button[name=write-reviewOpenBtn]').on('click',function(){
        		//alert('리뷰 쓰기 버튼');
        		
        		var writeReviewId= $(this).context.value;
        		var hotelName= $(this).parents('.section-text').find('[name="res_hotel_name"]').text();
        		var roomName= $(this).parents('.section-text').find('[name="res_room_name"]').text();
        		var checkin= $(this).parents('.section-text').find('[name="res_start_day"]').text();
        		var checkout= $(this).parents('.section-text').find('[name="res_end_day"]').text();
        		
        		$('#modal-write-review-id').html(writeReviewId);
        		$('#write-review-hotel-name').html(hotelName);
        		$('#write-review-room-name').html(roomName);
        		$('#write-review-checkin').html(checkin);
        		$('#write-review-checkout').html(checkout);
        		
        		$('#write-review_res_id').removeAttr('value');
        		$('#write-review_res_id').attr('value',writeReviewId);
        		
        		
        		$('#write-reviewBtn').on('click',function(){
        			$('#writeReviewForm').submit();
        		});
        	});
        }
        
        	if($('button[name="reading-reviewOpenBtn"]')!= null){ //리뷰읽기
        		$('button[name="reading-reviewOpenBtn"]').on('click',function(){
        			var reservation_id=$(this).context.value;

        			$.ajax({
            			data: {
            				'reservation_id' :   reservation_id
            			},
            			dataType : 'json',
            			url:"/reservationmall/individual/readReview.mall",
            			success: function(data){
            				$('#modal-read-review-id').html(reservation_id);
            				
            				var content=data.review_content.replace(/\r\n/g, '<br />');
            				$('#read-review-text').html(content);
            				
            				$('#readReviewForm input[name="review_price_rate"]').removeAttr('value');
            				$('#readReviewForm input[name="review_price_rate"]').attr('value',data.review_price_rate);
            				  
            				$('#readReviewForm input[name="review_service_rate"]').removeAttr('value');
            				$('#readReviewForm input[name="review_service_rate"]').attr('value',data.review_service_rate);
            				$('#readReviewForm input[name="review_food_rate"]').removeAttr('value');
            				$('#readReviewForm input[name="review_food_rate"]').attr('value',data.review_food_rate);
            				$('#readReviewForm input[name="review_clean_rate"]').removeAttr('value');
            				$('#readReviewForm input[name="review_clean_rate"]').attr('value',data.review_clean_rate);
            				$('#readReviewForm input[name="review_location_rate"]').removeAttr('value');
            				$('#readReviewForm input[name="review_location_rate"]').attr('value',data.review_location_rate);
            				
            				$('#readReviewForm span[name="review_helpful_count"]').html(data.review_helpful_count);
            				
            				var readRatingList= $('#readReviewForm span[name="star-rating"]');
            				readStarRating(readRatingList);
            				
            			  }, 
            			  error: function(){
            				 alert('서버로부터 전송 에러');
            			  }
            		  });
        		})
        }
        
        if($('button[name=cancellationOpenBtn]') != null){ //예약 취소 버튼
        	$('button[name=cancellationOpenBtn]').on('click',function(){
        		
        		var cancellationId= $(this).context.value;
        		var hotelName= $(this).parents('.section-text').find('[name="res_hotel_name"]').text();
        		var roomName= $(this).parents('.section-text').find('[name="res_room_name"]').text();
        		var checkin= $(this).parents('.section-text').find('[name="res_start_day"]').text();
        		var checkout= $(this).parents('.section-text').find('[name="res_end_day"]').text();
        		console.log(cancellationId);
        
        		
        		$('#modal-cancellation-id').html(cancellationId);
        		$('#cancellation-hotel-name').html(hotelName);
        		$('#cancellation-room-name').html(roomName);
        		$('#cancellation-checkin').html(checkin);
        		$('#cancellation-checkout').html(checkout);
        		
        		$('#cancellation_res_id').removeAttr('value');
        		$('#cancellation_res_id').attr('value',cancellationId);
        		
        		
        		$('#cancellationBtn').on('click',function(){
        			$('#cancellationForm').submit();
        		});
        	});
        }
        
        if($('div[name="my-reservation"]') != null){ 
        	//예약 내역 리스트 더보기 버튼 구현
        	var myResList=  $('div[name="my-reservation"]');
        	var myResBlank=  $('div[name="res-blank"]');
        	var myResListLen=  $('div[name="my-reservation"]').length;
        	var viewStart=$('#view-more-res').attr('value');
        	$('#view-more-res').css('display','none'); //더보기 버튼 숨기기
        	
        	if(viewStart==0){ //최초 실행
        		//console.log(myResList);
        		
        		myResList.each(function(i,val){
        			
            		if( myResListLen < 3){
            			if(myResListLen== i){
            				return false;
            			}
            		}else{ //예약내역 4개 이상
            			if(i >= 3){
            				$(myResList[i]).css('display','none');
            				$(myResBlank[i]).css('display','none');
            			}
            		}
            	}); //each 종료
        		
        		
        		if(myResListLen >4){ //예약내역 4개 이상
        			$('#view-more-res').css('display','block'); //더보기 버튼 보이기
        			$('#view-more-res').removeAttr('value');
    				$('#view-more-res').attr('value',Number(viewStart)+3);
    				$('#view-more-res').on('click',viewMoreRes);
        		}
        	}
        }
        
        
        if($('input[name="delete-wishlist-btn"]')!=null){ //위시리스트에서 제거
        	$('input[name="delete-wishlist-btn"]').each(function(i,val){
        		
        		$(val).on('click',function(){
        			var hotel_id= $(val).closest('div').find('input[name="wishlist-hotel_id"]').attr('value');
        			var user_id= $(val).closest('div').find('input[name="wishlist-user_id"]').attr('value');

        			$.ajax({
            			data: {
            				'hotel_id' :   hotel_id,
            				'user_id' : user_id
            			},
            			//dataType : 'json',
            			url:"/reservationmall/individual/deleteWishlist.mall",
            			success: function(data){
            				if(data.trim() == 'success'){
            					$('#deleteWishlist-result').html('위시리스트에서 제거되었습니다');
            				} else if (data.trim() == 'fail'){
            					$('#deleteWishlist-result').html('위시리스트에서 제거 실패');
            				}
            				$('#deleteWishlist-confirm-Modal').on('hidden.bs.modal', function (e) {
            		      		location.href='/reservationmall/individual/mypage.mall';
            		     	});
            				$('#deleteWishlist-confirm-Modal').modal('show');
            			 }, 
            			 error: function(){
            				 alert('서버로부터 전송 에러');
            			 }
            		  });
        		})
        	});
        }
})
    
    function viewMoreRes(){
    	
    	var myResList=  $('div[name="my-reservation"]');
    	var myResBlank=  $('div[name="res-blank"]');
    	var myResListLen=  $('div[name="my-reservation"]').length;
    	var viewStart=$('#view-more-res').attr('value');
    	
    	//console.log("! len :"+myResListLen);
    	//console.log("! viewStart: "+viewStart);
    	
    	if(myResListLen > viewStart){
    		myResList.each(function(i,val){
    			
    			//console.log("i : "+i);
    			//console.log("! "+Number(Number(i)+Number(viewStart)));
    			
    			if(Number(i)+Number(viewStart) > myResListLen){
    				$('#view-more-res').css('display','none'); //더보기 버튼 숨기기
    				return false;
    			} 
    			
    			$(myResList[Number(i)+Number(viewStart)]).css('display','block');
    			$(myResBlank[Number(i)+Number(viewStart)]).css('display','block');
    			
    			
    			if(i ==2){
    				$('#view-more-res').removeAttr('value');
    				$('#view-more-res').attr('value',Number(viewStart)+3);
    				return false;
    			}
        	});
    	}
		
		//console.log($('#view-more-res').attr('value'));
    }
