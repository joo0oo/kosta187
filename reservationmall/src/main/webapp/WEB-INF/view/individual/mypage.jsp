<%@page import="kr.or.kosta.reservationmall.login.dto.User"%>
<%@ page contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<%
String loginId = null;
//String loginCheck = null;
Cookie[] cookies = null;

if(request.getCookies()!=null){
  cookies = request.getCookies();
}
if(cookies != null) {
  for(Cookie cookie : cookies) {
    String cookieName = cookie.getName();
    if(cookieName.equals("loginId")) {
      loginId = cookie.getValue();
    }
  }
}

System.out.println("시작");
System.out.println(request.getAttribute("userId"));
User user= (User)request.getAttribute("user");
System.out.println(user);
System.out.println("끝");

//String cancellationRes= (String)request.getAttribute("cancellationRes");
%>


<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="userId" value="<%=loginId%>" />


<!DOCTYPE html>
<html lang="utf-8">
	<head>
		<link rel="shortcut icon" href="data:image/x-icon;," type="image/x-icon">
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
		<meta name="description" content="">
		<meta name="author" content="">
		<link rel="icon" href="favicon.ico">
		<title>Java - 아름다운 추억을 코딩하세요</title>
		<!-- Bootstrap core CSS -->
		<link href="/reservationmall/resources/css/template/bootstrap.min.css" rel="stylesheet">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
		<!-- Custom styles for this template -->
		<link href="/reservationmall/resources/css/template/owl.carousel.css" rel="stylesheet">
		<link href="/reservationmall/resources/css/template/owl.theme.default.min.css"  rel="stylesheet">
		<link href="/reservationmall/resources/css/template/style.css" rel="stylesheet">
	
    <!-- 주현 css 추가  -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href="/reservationmall/resources/css/sjh/star-rating.css" rel="stylesheet">
    <!-- 주현 css 추가  -->
     
	<script type="text/javascript" src="/reservationmall/resources/js/common/jquery-3.3.1.js"></script>
	<script type="text/javascript" src="/reservationmall/resources/js/sjh/star-rating.js"></script>
    
     
    <!-- 주현 js 추가  -->
    <script type="text/javascript" src="/reservationmall/resources/js/sjh/common.js"></script>
    
    <c:choose>
      <c:when test="${requestScope.editUserResult eq 'trying'}">    
      </c:when>
      <c:when test="${requestScope.editUserResult eq 'success'}">
        <script type="text/javascript">
        $(function(){ 
        	$('#edit-result').html('개인정보 수정되었습니다');
        	$('#edit-confirm-Modal').modal();
        	
        /* 	$('#edit-confirm-Modal-close').on('click',function(){
        		location.href='/reservationmall/individual/mypage.mall';
        	}); */
        	$('#edit-confirm-Modal').on('hidden.bs.modal', function (e) {
        		location.href='/reservationmall/individual/mypage.mall';
        	});
        })
        </script>
      </c:when>
      <c:when test="${requestScope.editUserResult eq 'fail'}">
        <script type="text/javascript">
        $(function(){ 
          $('#edit-result').html('개인정보 수정 실패했습니다');
          $('#edit-confirm-Modal').modal();
          
          /* $('#edit-confirm-Modal-close').on('click',function(){
      		location.href='/reservationmall/individual/mypage.mall';
      	
          }); */
          $('#edit-confirm-Modal').on('hidden.bs.modal', function (e) {
      		location.href='/reservationmall/individual/mypage.mall';
          });
        })
        </script>
        <c:set value="${requestScope.editUserResult}" var="trying"/> 
      </c:when>
      <c:when test="${requestScope.cancellationRes eq 'success'}">
        <script type="text/javascript">
        $(function(){ 
          $('#cancellation-result').html('예약 취소되었습니다');
          
         /*  $('#cancellation-confirm-Modal-close').on('click',function(){
        	  location.href='/reservationmall/individual/mypage.mall';
          }); */
          
          $('#cancellation-confirm-Modal').on('hidden.bs.modal', function (e) {
        		location.href='/reservationmall/individual/mypage.mall';
          });
          
          $('#cancellation-confirm-Modal').modal();
        })
        </script>
      </c:when>
      <c:when test="${requestScope.cancellationRes eq 'fail'}">
        <script type="text/javascript">
        $(function(){ 
          $('#cancellation-result').html('예약 취소 실패입니다');
          
         /*  $('#cancellation-confirm-Modal-close').on('click',function(){
        	  location.href='/reservationmall/individual/mypage.mall';
          }); */
          
          $('#cancellation-confirm-Modal').on('hidden.bs.modal', function (e) {
      		location.href='/reservationmall/individual/mypage.mall';
          });
          
          $('#cancellation-confirm-Modal').modal();
        })
        </script>
      </c:when>
      <c:when test="${requestScope.writingReviewRes eq 'success'}">
        <script type="text/javascript">
        $(function(){ 
          $('#writing-result').html('리뷰가 등록되었습니다');
          
         /*  $('#writing-review-confirm-Modal-close').on('click',function(){
            location.href='/reservationmall/individual/mypage.mall';
          }); */
          
          $('#writing-review-confirm-Modal').on('hidden.bs.modal', function (e) {
      		location.href='/reservationmall/individual/mypage.mall';
          });
          
          $('#writing-review-confirm-Modal').modal();
        })
        </script>
      </c:when>
     </c:choose>
    <!-- 주현 js 추가 끝  -->
    
	</head>
	<body id="page-top">
		<!-- Navigation -->
		<!-- top 네비게이션 -->
		<jsp:include page="/WEB-INF/view/individual/mypage_top.jsp"></jsp:include>
        
		<!-- Header -->
		<section id="my-info" class="bg-info">
			<div class="container">
				<div class="row">
					<div class="col-lg-12 text-center">
						<div class="section-title">
							<h2> 개인정보 조회/수정/탈퇴 </h2>
							<p> 개인정보를 조회, 수정 또는 회원 탈퇴 가능 </p>
						</div>
					</div>
				</div>
        
        
        <!-- 개인정보 조회/수정/탈퇴 탭메뉴 -->
    <div class="container">
      <ul class="nav nav-tabs">
        <li class="active"><a href="#first"><h4>개인정보 조회</h4></a></li>
        <li><a href="#second"> <h4>개인정보 수정</h4> </a></li>
        <li><a href="#third"> <h4>탈퇴 </h4></a></li>
      </ul>
      <br>
    </div>
    <!-- 개인정보 조회/수정/탈퇴 탭메뉴 끝  -->

 <div class="tab-content" >
 <!-- 정보조회 탭 시작 -->
  <div class="tab-pane fade active in" id="first">
      <div class=" text-center mz-module-about">
        <h3> 개인정보 조회 </h3>
      </div> 
      
       <div style="height:50px"></div>
      <div id="ww">
      <div class="container">
          <div class="col-md-12">
            <div class="col-md-4">
                <label for="exampleInputEmail1">아이디</label>
            </div>
            <div class="col-md-8">
                <div> ${user.user_id} </div>
            </div>
          </div>
          <div class="col-md-12">
            <div class="col-md-4">
                <label for="exampleInputEmail1">이름</label> 
            </div>
            <div class="col-md-8">
                <div> ${user.user_name}  </div>
            </div>
          </div>
          <div class="col-md-12">
            <div class="col-md-4">
                <label for="exampleInputEmail1">나이</label> 
            </div>
            <div class="col-md-8">
                <div> ${user.user_age} </div>
            </div>
          </div>
          <div class="col-md-12">
            <div class="col-md-4">
                <label for="exampleInputEmail1">주소</label> 
            </div>
            <div class="col-md-8">
                <div> ${user.user_address} </div>
            </div>
          </div>
           <div class="col-md-12">
            <div class="col-md-4">
                <label for="exampleInputEmail1">전화번호</label> 
            </div>
            <div class="col-md-8">
                <div> ${user.user_phonenum} </div>
            </div>
          </div>
           <div class="col-md-12">
            <div class="col-md-4">
                <label for="exampleInputEmail1">이메일</label> 
            </div>
            <div class="col-md-8">
                <div> ${user.user_email} </div>
            </div>
          </div>
           <div class="col-md-12">
            <div class="col-md-4">
                <label for="exampleInputEmail1">등급</label> 
            </div>
            <div class="col-md-8">
               <div> ${user.user_rate} </div>
            </div>
          </div>
           <div class="col-md-12">
            <div class="col-md-4">
               <label for="exampleInputEmail1">가입일</label> 
            </div>
            <div class="col-md-8">
                <div> ${user.user_regdate} </div>
            </div>
          </div>
          
      </div>
      <!-- /container -->
    </div>
    <!-- /ww -->
    <div style="height:50px"></div>
  </div>
   <!-- 정보조회 탭 끝 -->
  
   <!-- 정보수정 탭 시작 -->
  <div class="tab-pane fade" id="second">
   <div class=" text-center mz-module-about">
      <h3> 개인정보 수정 </h3>
   </div>
    <div style="height:50px"></div>
      <div id="ww">
      <div class="container">
        
        <%-- 수정폼 --%>
        <jsp:include page="/WEB-INF/view/individual/edit_form.jsp"></jsp:include>
        <%-- 수정폼 --%>
      
      </div>
      <!-- /container -->
    </div>
    <!-- /ww -->
    <div style="height:50px"></div>
  </div>
   <!-- 정보수정 탭 끝 -->
   
    <!-- 탈퇴 탭 시작 -->
  <div class="tab-pane fade" id="third">
   <div class=" text-center mz-module-about">
      <h3> 탈퇴 </h3>
   </div>
    <div style="height:50px"></div>
      <div id="ww">
      <div class="container">
        <div class="row">
          <button type="button" class="btn btn-danger center-block" id="withdrawalMOpenBtn">탈퇴하기</button>
        </div>
      </div>
      <!-- /container -->
    </div>
    <!-- /ww -->
    <div style="height:50px"></div>
  </div>
   <!-- 탈퇴 탭 끝 -->
</div>

		</section>
    
    <!--  예약 내역 조회 시작 -->
    <section id="reservation" class="light-bg">
		<section class="light-bg">
			<div class="container">
      
      <div class="row">
          <div class="col-lg-12 text-center">
            <div class="section-title">
              <h2> 예약내역 조회 및 취소 </h2>
              <p> 회원님의 예약 내역을 보여드립니다 </p>
            </div>
          </div>
        </div>
        
        <c:choose>
        <c:when test="${not empty resList}">
        <c:forEach var="reservationInfo" items="${resList}" varStatus="status">
        
          <c:choose>
            <c:when test="${reservationInfo.reservation_status==200}">
              <div class="row bg-info" name="my-reservation" id="my-res-${status.count}" >
            </c:when>
        
            <c:when test="${reservationInfo.reservation_status==400}">
              <div class="row bg-danger" name="my-reservation" id="my-res-${status.count}" >
            </c:when>
                                      
            <c:otherwise>
              <div class="row bg-info" name="my-reservation" id="my-res-${status.count}" >
            </c:otherwise>
          </c:choose>
				
                <div style="height:20px"></div>
			    <div class="col-md-7">
						<div class="section-text">
							<h3> 
                              호텔이름 : 
                              <span name="res_hotel_name">${reservationInfo.hotel_name}</span>
                            </h3>
              
                            <div class="row">
                              <div class="col-md-9 h4">
                              <h4> 
                                예약번호 : 
                                <span name="res_id">${reservationInfo.reservation_id} </span>
                              </h4>
                              </div>
                              <div class="col-md-3 h4">
                              
                                <c:choose>
                                  <c:when test="${reservationInfo.reservation_status==200}">
                                  <%--정상 예약인 경우--%>
                                    <c:choose>
                                      <c:when test="${reservationInfo.end_day_check >= 1}">
                                       <%-- 정상적으로 끝난 예약 --%>
                                       <button type="button" class="btn btn-primary" name="write-reviewOpenBtn"
                                        data-toggle="modal"  data-target="#write-review-Modal"
                                        value="${reservationInfo.reservation_id}">리뷰쓰기</button>
                                      </c:when>
                                      <c:otherwise>
                                        <c:choose>
                                          <c:when test="${reservationInfo.start_day_check > -1 && reservationInfo.end_day_check <1}">
                                           <%-- 진행중 예약 --%>
                                           <span class="text-danger">이용중</span>
                                          </c:when>
                                          <c:when test="${reservationInfo.start_day_check > -2}">
                                           <%--하루 전이므로 취소 불가 예약 --%>
                                           <span class="text-danger">체크인 하루전!</span>
                                          </c:when>
                                          <c:when test="${reservationInfo.start_day_check <= -2}">
                                           <%--아직 시작하지 않은 예약 --%>
                                           <button type="button" class="btn btn-danger" name="cancellationOpenBtn"
                                            data-toggle="modal"  data-target="#cancellation-Modal" 
                                            value="${reservationInfo.reservation_id}">예약취소</button>
                                          </c:when>
                                          <c:otherwise>
                                            <span>에러:${reservationInfo.start_day_check},${reservationInfo.end_day_check}</span>
                                          </c:otherwise>
                                        </c:choose>
                                      </c:otherwise>
                                    </c:choose>
                                   
                                  </c:when>
    
                                  <c:when test="${reservationInfo.reservation_status==400}">
                                  <%--취소된 예약인 경우--%>
                                    <span class="text-danger">취소된 예약</span>
                                  </c:when>
                                  
                                  <c:when test="${reservationInfo.reservation_status==300}">
                                  <%--리뷰 쓴 예약인 경우--%>
                                    <button type="button" class="btn btn-primary" name="reading-reviewOpenBtn"
                                    data-toggle="modal"  data-target="#reading-review-Modal"
                                    value="${reservationInfo.reservation_id}">리뷰읽기</button>
                                  </c:when>
                                  
                                  <c:otherwise>
                                  </c:otherwise>
          
                                </c:choose>
                              
                              </div>
                            </div>
                             
                            <div class="row">
                            <div class="col-md-6 h5"> 
                              <label>체크인</label> 
                              <div name="res_start_day">${reservationInfo.reservation_start_day}</div>
                            </div>
                            <div class="col-md-6 h5"> 
                              <label>체크아웃</label>
                              <div name="res_end_day">${reservationInfo.reservation_end_day}</div> 
                            </div>
                            
                            <div class="col-md-6 h5"> 
                              <label>호텔주소</label> 
                              <div name="res_hotel_address">${reservationInfo.hotel_address}</div> 
                            </div>
                            <div class="col-md-6 h5"> 
                              <label>방이름</label> 
                              <div name="res_room_name">${reservationInfo.room_name}</div>
                            </div>
                            <div class="col-md-6 h5"> 
                              <label>방 기준인원</label> 
                              <div>
                              <span>일반 ${reservationInfo.room_standard_person_number} 명, </span>
                              <span>어린이 ${reservationInfo.room_child_max_number} 명</span>
                              </div>
                            </div>
                            <div class="col-md-6 h5"> 
                             <label>결제금액</label> 
                             <div name="res_total_price">${reservationInfo.total_price}</div>
                            </div>
                            <div class="col-md-6 h5"> 
                              <label>결제일시</label>
                              <div name="res_payment_day">${reservationInfo.payment_day}</div>
                            </div>
                            <div class="col-md-6 h5"> 
                              <label>결제유형</label>
                              <div name="res_payment_type">${reservationInfo.payment_type}</div> 
                            </div>
                            <c:choose>
                            <c:when test="${reservationInfo.reservation_status==400}">
                              <%--취소된 예약인 경우--%>
                            <div class="col-md-12 h5"> 
                                <label class="text-danger">결제취소일</label>
                              <div name="res_payment_cancellation_day">
                                <span class="text-danger">${reservationInfo.payment_cancellation_day}</span>
                              </div> 
                            </div>
                            </c:when>
                            </c:choose>
                            </div>
						</div>
                        <div style="height:20px"></div>
				</div>
                    
                <!-- 호텔 이미지 시작-->
			    <div class="col-md-5">
				  <div class="owl-search-sjh2 owl-carousel">
                    <c:forEach items="${requestScope.resHotelImages}" var="reshotelImage">
                      <c:if test="${reshotelImage.key == reservationInfo.hotel_id}">
                      <c:forEach items="${reshotelImage.value}" var="hotelImage">
                        <div class="item">
                          <div class="owl-search-item">
                            <img src="/reservationmall/resources/images/${hotelImage}" 
                            alt="/reservationmall/resources/images/template/demo/image_main.jpg"
                            class="img-responsive" />
                          </div>
                        </div>
                      </c:forEach>
                      </c:if>
                    </c:forEach>
				  </div>
				</div>
                <!-- 호텔 이미지 끝-->
                     
				</div> <!-- 예약내역 조회 1칸 끝 -->
                <div name="res-blank" style="height:30px"></div>
                
        </c:forEach>
                <button class="form-control btn-primary" 
                id="view-more-res" value="0"> 더보기 </button>
               
        </c:when>
        <c:otherwise>
          <div class="row bg-info">
            <h2>예약 내역이 없습니다 </h2>
          </div>
        </c:otherwise>
        </c:choose>
        
			</div>
        <div style="height:50px"></div>
		</section>
    </section>
    <!--  예약 내역 조회 끝 -->


 
  <!-- 위시리스트 시작 -->
  <section id="wishlist" class="dark-bg">
    <div class="container">

      <div class="row">
        <div class="col-lg-12 text-center">
          <div class="section-title">
            <h2>위시리스트</h2>
            <p> 위시리스트에 담은 호텔 </p>
          </div>
        </div>
      </div>

      <div class="row">
        <div class="owl-search-sjh owl-carousel">
          
          <c:choose>
            <c:when test="${not empty requestScope.wishlistIds}">
              <c:forEach items="${applicationScope.hotelList}" var="hotel">
              <c:forEach items="${requestScope.wishlistIds}" var="wishlistId" varStatus="hotelnum">
                <c:if test="${wishlistId == hotel.hotel_id}">
                  <c:forEach items="${wishHotelImages}" var="hotelImage">
                    <c:if test="${hotelImage.key == wishlistId}">
                      
                      <div class="item">
                        <div class="owl-search-item">
                        <a data-toggle="modal" data-target="#Modal-${wishlistId}" class="hotelInfoLink">
                          <figure class="effect-bubba">
                            <img src="/reservationmall/resources/images/${hotelImage.value[0]}" 
                            alt="/reservationmall/resources/images/template/demo/image_main.jpg"
                            class="img-responsive"/>
                            <figcaption>
                              <h2>${hotel.hotel_name}</h2>
                              <p>${hotel.hotel_rate}</p>
                            </figcaption>
                          </figure>
                          </a>
                        </div>
                      </div>
                      
                    </c:if>
                  </c:forEach>
                </c:if>
              </c:forEach>
              </c:forEach>
            </c:when>
            <c:otherwise>
            <div class="item">
            <div class="owl-search-item">
             <!--  
                <figure class="effect-bubba">
                  <figcaption> -->
                  <h2 class="dark-bg"> 위시리스트가 없습니다 </h2>
                 <!--  </figcaption>
                </figure>
                -->
            </div> 
            </div>
            </c:otherwise>
          </c:choose>

        </div>
      </div>
      <!--  row  -->

    </div>
    <!--  end container  -->
  </section>
  <!-- 위시리스트 끝 -->



  <!-- 최근본호텔  시작 -->
  <section id="lastviews" class="dark-bg">
    <div class="container">

      <div class="row">
        <div class="col-lg-12 text-center">
          <div class="section-title">
            <h2>최근 본 호텔</h2>
            <p> 최근 조회한 호텔 3가지 </p>
          </div>
        </div>
      </div>

      <div class="row">
        <div class="owl-search-sjh owl-carousel">

          <c:choose>
            <c:when test="${not empty requestScope.lastList}">
              <c:forEach items="${applicationScope.hotelList}" var="hotel">
              <c:forEach items="${requestScope.lastList}" var="lastview" varStatus="hotelnum">
                <c:if test="${lastview.hotel_id == hotel.hotel_id}">
                  <c:forEach items="${requestScope.lastHotelImages}" var="hotelImage">
                    <c:if test="${hotelImage.key == lastview.hotel_id}">
                      <div class="item">
                     
                        <div class="owl-search-item">
                        <a data-toggle="modal" data-target="#Modal-${lastview.hotel_id}" class="hotelInfoLink">
                          <figure class="effect-bubba">
                          
                            <img src="/reservationmall/resources/images/${hotelImage.value[0]}" 
                            alt="/reservationmall/resources/images/template/demo/image_main.jpg"
                            class="img-responsive"/>
                            <figcaption>
                              <h2>${hotel.hotel_name}</h2>
                              <p>${hotel.hotel_rate}</p>
                                
                            </figcaption>
                          </figure>
                          </a>
                        </div>
                      </div>
  
                    </c:if>
                  </c:forEach>
                </c:if>
              </c:forEach>
              </c:forEach>
            </c:when>
            <c:otherwise>
            <div class="item">
            <div class="owl-search-item">
             <!--  
                <figure class="effect-bubba">
                  <figcaption> -->
                  <h2 class="dark-bg"> 최근 본 항목이 없습니다 </h2>
                 <!--  </figcaption>
                </figure>
                -->
            </div> 
            </div>
            </c:otherwise>
          </c:choose>

        </div>
      </div>
      <!--  row  -->

    </div>
    <!--  end container  -->
  </section>
  <!-- 최근본호텔 끝 -->

  <p id="back-top">
    <a href="#top"><i class="fa fa-angle-up"></i></a>
  </p>
  <jsp:include page="/WEB-INF/view/main/main_bottom.jsp"></jsp:include>
 
 <!-- 위시리스트 상세조회 모달 -->
<c:forEach items="${requestScope.wishlistIds}" var="wishlistId" varStatus="hotelnum">
  <c:forEach items="${applicationScope.hotelList}" var="hotel">
      <c:choose>
        <c:when test="${wishlistId == hotel.hotel_id}">
          <div class="modal fade bs-example-modal-lg" id="Modal-${wishlistId}" tabindex="-1" role="dialog"
            aria-labelledby="Modal-label-${wishlistId}">
            <div class="modal-dialog" role="document">
              <div class="modal-content">
                <!-- hotel infomation  -->

                <div class="modal-header">
                  <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                  </button>
                  <h4 class="modal-title" id="Modal-label-${wishlistId}">${hotel.hotel_name}</h4>
                </div> <!-- modal-header -->
                <div class="modal-body">
                  <div role="tabpanel">
                    <!-- 호텔정보 탭 시작 -->
                      
                        <div class="owl-search-${wishlistId} owl-carousel">
                          <c:forEach items="${requestScope.wishHotelImages}" var="hotelImage">
                            <c:if test="${hotelImage.key == wishlistId}">
                              <c:forEach items="${hotelImage.value}" var="imageDirectory">
                                <div class="item text-center">
                                  <div class="owl-search-item">
                                    <img class="owl-lazy" data-src="/reservationmall/resources/images/${imageDirectory}"
                                      alt="/reservationmall/resources/images/template/demo/image_main.jpg">
                                  </div>
                                </div>
                              </c:forEach>
                            </c:if>
                          </c:forEach>
                        </div>
                        <div class="col-md-12">
                          <div class="col-md-1"></div>
                          <div class="col-md-10 text-center">
                            <c:forTokens items="${hotel.hotel_detail}" delims="<![CDATA[<]]>?!<![CDATA[>]]>" var="detail">
                              <span><span class="label label-info">${detail}</span></span>
                            </c:forTokens>
                          </div>
                          <div class="col-md-1"></div>
                          <div class="col-md-12">
                            <p>호텔 등급 : ${hotel.hotel_rate}</p>
                            <p>호텔 전화번호 : ${hotel.hotel_phonenum}</p>
                            <p>호텔 웹사이트 : ${hotel.hotel_website}</p>
                            <p>호텔 주소 : ${hotel.hotel_address}</p>
                            <p>소개글 : ${hotel.hotel_info}</p>
                          </div>
                          <div class="col-md-12">
                          <form action="/reservationmall/hotel/searchhotel.mall" method="POST" id="searchForm-wishlist-${hotelnum.count}">
                          <div>
                            <input type="hidden" name="searchValueType" value="searchHotel"> 
                            <input type="hidden" name="searchValue" value="${hotel.hotel_name}">
                          </div>
                          <div class="col-md-4">
                            <div class="form-group">
                              <label>입실 날짜</label>
                              <div class='input-group date datetimepicker1'>
                                <input type='text' class="form-control " name="searchStartDay" /> 
                                  <span class="input-group-addon">
                                  <span class="fa fa-calendar"></span>
                                </span>
                              </div>
                            </div>
                          </div>
                          <div class="col-md-4">
                            <div class="form-group">
                              <label>퇴실 날짜</label>
                              <div class='input-group date datetimepicker2'>
                                <input type='text' class="form-control " name="searchEndDay" /> 
                                  <span class="input-group-addon">
                                  <span class="fa fa-calendar"></span>
                                </span>
                              </div>
                            </div>
                          </div>
                          <div class="col-md-4">
                            <div class="form-group">
                              <label>일정</label>
                              <div class='input-group date'>
                                <div class="betweenDay" style="margin-bottom: 12px;">
                                  <strong>1박 2일</strong>
                                </div>
                              </div>
                            </div>
                          </div>
                          <div class="col-md-12">
                            <div class="form-group">
                              <label>객실 수</label> 
                              <select class="form-control " id="roomNumber-wishlist-${hotelnum.count}" name="searchRoomNumber">
                                <option selected>1</option>
                                <option>2</option>
                                <option>3</option>
                                <option>4</option>
                                <option>5</option>
                                <option>6</option>
                              </select> 
                              <input type="hidden" id="roomNumberHidden-wishlist-${hotelnum.count}">
                            </div>
                          </div>
                          <div class="col-md-12" id="roomNumberAnchor-wishlist-${hotelnum.count}">
                            <div class="col-md-6">
                              <div class="form-group">
                                <label>어른 수</label> <select class="form-control" name="searchAdultNumber">
                                  <option>1</option>
                                  <option selected>2</option>
                                  <option>3</option>
                                  <option>4</option>
                                  <option>5</option>
                                  <option>6</option>
                                  <option>7</option>
                                  <option>8</option>
                                  <option>9</option>
                                </select>
                              </div>
                            </div>
                            <div class="col-md-6">
                              <div class="form-group">
                                <label>아이 수</label> <select class="form-control" name="searchChildNumber">
                                  <option selected>0</option>
                                  <option>1</option>
                                  <option>2</option>
                                  <option>3</option>
                                  <option>4</option>
                                  <option>5</option>
                                  <option>6</option>
                                  <option>7</option>
                                  <option>8</option>
                                  <option>9</option>
                                </select>
                              </div>
                            </div>
                          </div>
                          <div class="col-md-4">
                            <input type="submit" value="검색" class="form-control btn-success" id="searchHotelButton-wishlist-${hotelnum.count}">
                          </div>
                          <div class="col-md-4">
                            <input type="hidden" name="wishlist-hotel_id" value="${hotel.hotel_id}">
                            <input type="hidden" name="wishlist-user_id" value="${requestScope.user.user_id}">
                            <input type="button" name="delete-wishlist-btn" value="위시리스트에서 제거" 
                            class="form-control btn btn-danger" >
                          </div>
                          <div class="col-md-4">
                            <input type="button" value="close" class="form-control btn btn-warning" data-dismiss="modal">
                          </div>
                        </form>
                      </div>
                      </div>
                  </div>
                </div>
                <div class="modal-footer">
                </div> <!-- modal-footer -->
              </div>
            </div>
          </div>
        </c:when>
      </c:choose>
    </c:forEach>
    
  </c:forEach>
  <!-- 위시리스트 상세조회 모달 끝 -->
  
  
  
 <!-- 최근본호텔 상세조회 모달 -->
  <c:forEach items="${requestScope.lastList}" var="lastview" varStatus="hotelnum">
    <c:forEach items="${applicationScope.hotelList}" var="hotel">
      <c:choose>
        <c:when test="${lastview.hotel_id == hotel.hotel_id}">
          <div class="modal fade bs-example-modal-lg" id="Modal-${lastview.hotel_id}" tabindex="-1" role="dialog"
            aria-labelledby="Modal-label-${lastview.hotel_id}">
            <div class="modal-dialog" role="document">
              <div class="modal-content">
                <!-- hotel infomation  -->

                <div class="modal-header">
                  <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                  </button>
                  <h4 class="modal-title" id="Modal-label-${lastview.hotel_id}">${hotel.hotel_name}</h4>
                </div> <!-- modal-header -->
                <div class="modal-body">
                  <div role="tabpanel">
                    <!-- 호텔정보 탭 시작 -->
                      
                        <div class="owl-search-${lastview.hotel_id} owl-carousel">
                          <c:forEach items="${requestScope.lastHotelImages}" var="hotelImage">
                            <c:if test="${hotelImage.key == lastview.hotel_id}">
                              <c:forEach items="${hotelImage.value}" var="imageDirectory">
                                <div class="item text-center">
                                  <div class="owl-search-item">
                                    <img class="owl-lazy" data-src="/reservationmall/resources/images/${imageDirectory}"
                                      alt="/reservationmall/resources/images/template/demo/image_main.jpg">
                                  </div>
                                </div>
                              </c:forEach>
                            </c:if>
                          </c:forEach>
                        </div>
                        <div class="col-md-12" id="hotelHtml">
                          <div class="col-md-1"></div>
                          <div class="col-md-10 text-center">
                            <c:forTokens items="${hotel.hotel_detail}" delims="<![CDATA[<]]>?!<![CDATA[>]]>" var="detail">
                              <span><span class="label label-info">${detail}</span></span>
                            </c:forTokens>
                          </div>
                          <div class="col-md-1"></div>
                          <div class="col-md-12">
                            <p>호텔 등급 : ${hotel.hotel_rate}</p>
                            <p>호텔 전화번호 : ${hotel.hotel_phonenum}</p>
                            <p>호텔 웹사이트 : ${hotel.hotel_website}</p>
                            <p>호텔 주소 : ${hotel.hotel_address}</p>
                            <p>소개글 : ${hotel.hotel_info}</p>
                          </div>
                          <div class="col-md-12">
                          <form action="/reservationmall/hotel/searchhotel.mall" method="POST" id="searchForm-lastview-${hotelnum.count}">
                          <div>
                            <input type="hidden" name="searchValueType" value="searchHotel"> 
                            <input type="hidden" name="searchValue" value="${hotel.hotel_name}">
                          </div>
                          <div class="col-md-4">
                            <div class="form-group">
                              <label>입실 날짜</label>
                              <div class='input-group date datetimepicker1'>
                                <input type='text' class="form-control " name="searchStartDay" /> 
                                  <span class="input-group-addon">
                                  <span class="fa fa-calendar"></span>
                                </span>
                              </div>
                            </div>
                          </div>
                          <div class="col-md-4">
                            <div class="form-group">
                              <label>퇴실 날짜</label>
                              <div class='input-group date datetimepicker2'>
                                <input type='text' class="form-control " name="searchEndDay" /> 
                                  <span class="input-group-addon">
                                  <span class="fa fa-calendar"></span>
                                </span>
                              </div>
                            </div>
                          </div>
                          <div class="col-md-4">
                            <div class="form-group">
                              <label>일정</label>
                              <div class='input-group date'>
                                <div class="betweenDay" style="margin-bottom: 12px;">
                                  <strong>1박 2일</strong>
                                </div>
                              </div>
                            </div>
                          </div>
                          <div class="col-md-12">
                            <div class="form-group">
                              <label>객실 수</label> 
                              <select class="form-control " id="roomNumber2-lastview-${hotelnum.count}" name="searchRoomNumber">
                                <option selected>1</option>
                                <option>2</option>
                                <option>3</option>
                                <option>4</option>
                                <option>5</option>
                                <option>6</option>
                              </select> 
                              <input type="hidden" id="roomNumberHidden-lastview-${hotelnum.count}">
                            </div>
                          </div>
                          <div class="col-md-12" id="roomNumberAnchor-lastview-${hotelnum.count}">
                            <div class="col-md-6">
                              <div class="form-group">
                                <label>어른 수</label> <select class="form-control" name="searchAdultNumber">
                                  <option>1</option>
                                  <option selected>2</option>
                                  <option>3</option>
                                  <option>4</option>
                                  <option>5</option>
                                  <option>6</option>
                                  <option>7</option>
                                  <option>8</option>
                                  <option>9</option>
                                </select>
                              </div>
                            </div>
                            <div class="col-md-6">
                              <div class="form-group">
                                <label>아이 수</label> <select class="form-control" name="searchChildNumber">
                                  <option selected>0</option>
                                  <option>1</option>
                                  <option>2</option>
                                  <option>3</option>
                                  <option>4</option>
                                  <option>5</option>
                                  <option>6</option>
                                  <option>7</option>
                                  <option>8</option>
                                  <option>9</option>
                                </select>
                              </div>
                            </div>
                          </div>
                          <div class="col-md-6">
                            <input type="submit" value="검색" class="form-control btn-success" id="searchHotelButton-lastview-${hotelnum.count}">
                          </div>
                          <div class="col-md-6">
                            <input type="button" value="close" class="form-control btn btn-warning" data-dismiss="modal">
                           </div>
                        </form>
                          </div>
                      </div>
                  </div>
                </div>
                <div class="modal-footer">
                </div> <!-- modal-footer -->
              </div>
            </div>
          </div>
        </c:when>
      </c:choose>
    </c:forEach>
    
  </c:forEach>
  <!-- 최근본호텔 상세조회 모달 끝 -->
    
        <!--  개인정보 수정 결과 모달  -->
        <jsp:include page="/WEB-INF/view/individual/edit-confirm-Modal.jsp"></jsp:include>
        
        <!--  회원 탈퇴 모달  -->
        <jsp:include page="/WEB-INF/view/individual/withdrawal-Modal.jsp"></jsp:include>
        
        <!--  회원 탈퇴 성공 모달  -->
        <jsp:include page="/WEB-INF/view/individual/withdrawal-confirm-Modal.jsp"></jsp:include>
    
        <!-- 리뷰쓰기 모달 -->
        <jsp:include page="/WEB-INF/view/individual/write-review-Modal.jsp"></jsp:include>
        
        <!--  리뷰쓰기 결과 모달  -->
        <jsp:include page="/WEB-INF/view/individual/writing-review-confirm-Modal.jsp"></jsp:include>
        
        <!-- 리뷰읽기 모달 -->
        <jsp:include page="/WEB-INF/view/individual/reading-review-Modal.jsp"></jsp:include>
        
        <!-- 예약취소 모달 -->
        <jsp:include page="/WEB-INF/view/individual/cancellation-Modal.jsp"></jsp:include>
     
        <!--  예약취소 확인 모달  -->
        <jsp:include page="/WEB-INF/view/individual/cancellation-confirm-Modal.jsp"></jsp:include>
        
        <!--  위시리스트 제거 확인 모달  -->
        <jsp:include page="/WEB-INF/view/individual/deleteWishlist-confirm-Modal.jsp"></jsp:include>
        

		<!-- Bootstrap core JavaScript
			================================================== -->
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
		<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>
		<script src="/reservationmall/resources/js/template/bootstrap.min.js"></script>
		<script src="/reservationmall/resources/js/template/owl.carousel.min.js"></script>
		<script src="/reservationmall/resources/js/template/cbpAnimatedHeader.js"></script>
		<script src="/reservationmall/resources/js/template/jquery.appear.js"></script>
		<script src="/reservationmall/resources/js/template/SmoothScroll.min.js"></script>
		<script src="/reservationmall/resources/js/template/mooz.themes.scripts.js"></script>
	  
        <!--  송주현 스크립트 추가  -->
        <script type="text/javascript" src="/reservationmall/resources/js/sjh/editUserInfo.js"></script>
        <script type="text/javascript" src="/reservationmall/resources/js/sjh/myCarousel.js"></script>
        
        <!--  송주현 스크립트 추가  -->
  
       <!--======== 위시리스트를 위한 JJW javascript file List =========-->
      <link rel="stylesheet" href="/reservationmall/resources/css/jjw/bootstrap-datetimepicker.css">
      <script type='text/javascript' src="/reservationmall/resources/js/jjw/moment-with-locales.min.js"></script>
      <script type='text/javascript' src="/reservationmall/resources/js/jjw/bootstrap-datetimepicker.js"></script>
      <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=380ae52ddded1dcd6fc9df096287f781&libraries=services"></script>
      <script src="/reservationmall/resources/js/jjw/common.js"></script>
      <!--======== 위시리스트를 위한 JJW javascript file List =========-->
      
      <!--  송주현 스크립트 추가  -->
      <script type="text/javascript" src="/reservationmall/resources/js/sjh/jjwCommon.js"></script>
  </body>
</html>