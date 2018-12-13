<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<c:if test="${sessionScope.refreshPage}">
	<c:set var="refreshPage" value="${false}" scope="session" />
	<script>location.reload();</script>
</c:if>
<html>

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
	<title>관리자 모드</title>
	<!-- Bootstrap core CSS -->

	<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css"> -->
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU"
	 crossorigin="anonymous">
	<!-- Custom styles for this template -->
	<link href="/reservationmall/resources/css/template/owl.carousel.css" rel="stylesheet">
	<link href="/reservationmall/resources/css/template/owl.theme.default.min.css" rel="stylesheet">
	<link href="/reservationmall/resources/css/template/style.css" rel="stylesheet">
	<link href="/reservationmall/resources/bootstrap/css/bootstrap.css" rel="stylesheet">
	<script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?clientId=aba8nx_n3O9CvAauIsql&amp;submodules=panorama,geocoder,drawing,visualization"></script>


	<!-- JJW css file List -->
	<link rel="stylesheet" href="/reservationmall/resources/css/jjw/common.css">
	<!-- JJW css file List -->
	<script type="text/javascript" src="/reservationmall/resources/js/hjh/payment.js"></script>
	
</head>

<body>
	<jsp:include page="/WEB-INF/view/main/main_top.jsp"></jsp:include>
	<header>
		<div class="container invisible">
			hidden value for layout
		</div>
		<div class="container invisible">
			hidden value for layout
		</div>
		<div class="container invisible">
			hidden value for layout
		</div>
	</header>
<section id="search" class="dark-bg">
		<div class="container">
			<div class="row">
				<form action="/reservationmall/hotel/searchhotel.mall" method="POST" id="searchForm">
					<div class="col-md-2">
						<div class="form-group">
							<label>검색 타입</label> <select class="form-control " name="searchValueType" id="searchValueType">
								<option value="searchLocation" ${searchValueType=='searchLocation' ? 'selected' : '' }>지역</option>
								<option value="searchHotel" ${searchValueType=='searchHotel' ? 'selected' : '' }>호텔 이름</option>
							</select>
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							<label>검색 내용</label> <input type="search" class="form-control" placeholder="검색하고 싶은 내용을 입력하세요" id="searchValueInput"
							 value="${searchValue}"> <input type="hidden" name="searchValue" id="searchValueInputHidden" value="${searchValue}">
						</div>
					</div>
					<div class="col-md-2">
						<div class="form-group">
							<label>입실 날짜</label>
							<div class='input-group date' id='datetimepicker1'>
								<input type='text' class="form-control " name="searchStartDay" value="${searchStartDay}" /> <span class="input-group-addon">
									<span class="fa fa-calendar"></span>
								</span>
							</div>
						</div>
					</div>
					<div class="col-md-2">
						<div class="form-group">
							<label>퇴실 날짜</label>
							<div class='input-group date' id='datetimepicker2'>
								<input type='text' class="form-control " name="searchEndDay" value="${searchEndDay}" /> <span class="input-group-addon">
									<span class="fa fa-calendar"></span>
								</span>
							</div>
						</div>
					</div>
					<div class="col-md-2">
						<div class="form-group">
							<label>일정</label>
							<div class='input-group date'>
								<p id="betweenDay" style="margin-bottom: 12px;">
									<strong>1박 2일</strong>
								</p>
							</div>
						</div>
					</div>
					<div class="col-md-2">
						<div class="form-group">
							<label>객실 수</label> <select class="form-control " id="roomNumber2" name="searchRoomNumber">
								<option ${searchRoomNumber==1 ? 'selected' : '' }>1</option>
								<option ${searchRoomNumber==2 ? 'selected' : '' }>2</option>
								<option ${searchRoomNumber==3 ? 'selected' : '' }>3</option>
								<option ${searchRoomNumber==4 ? 'selected' : '' }>4</option>
								<option ${searchRoomNumber==5 ? 'selected' : '' }>5</option>
								<option ${searchRoomNumber==6 ? 'selected' : '' }>6</option>
							</select> <input type="hidden" id="roomNumberHidden" value="${searchRoomNumber}">
						</div>
					</div>
					<div class="col-md-3" id="roomNumberAnchor">
						<c:forEach begin="1" end="${searchRoomNumber}" var="i">
							<c:forEach items="${searchAdultNumber}" var="adultNumber" varStatus="adultNumberStatus">
								<c:if test="${adultNumberStatus.count == i}">
									<div class="col-md-6">
										<div class="form-group">
											<label>어른 수</label> <select class="form-control" name="searchAdultNumber">
												<option ${adultNumber==1 ? 'selected' : '' }>1</option>
												<option ${adultNumber==2 ? 'selected' : '' }>2</option>
												<option ${adultNumber==3 ? 'selected' : '' }>3</option>
												<option ${adultNumber==4 ? 'selected' : '' }>4</option>
												<option ${adultNumber==5 ? 'selected' : '' }>5</option>
												<option ${adultNumber==6 ? 'selected' : '' }>6</option>
												<option ${adultNumber==7 ? 'selected' : '' }>7</option>
												<option ${adultNumber==8 ? 'selected' : '' }>8</option>
												<option ${adultNumber==9 ? 'selected' : '' }>9</option>
											</select>
										</div>
									</div>
								</c:if>
							</c:forEach>
							<c:forEach items="${searchChildNumber}" var="childNumber" varStatus="childNumberStatus">
								<c:if test="${childNumberStatus.count == i}">
									<div class="col-md-6">
										<div class="form-group">
											<label>아이 수</label> <select class="form-control" name="searchChildNumber">
												<option ${childNumber==0 ? 'selected' : '' }>0</option>
												<option ${childNumber==1 ? 'selected' : '' }>1</option>
												<option ${childNumber==2 ? 'selected' : '' }>2</option>
												<option ${childNumber==3 ? 'selected' : '' }>3</option>
												<option ${childNumber==4 ? 'selected' : '' }>4</option>
												<option ${childNumber==5 ? 'selected' : '' }>5</option>
												<option ${childNumber==6 ? 'selected' : '' }>6</option>
												<option ${childNumber==7 ? 'selected' : '' }>7</option>
												<option ${childNumber==8 ? 'selected' : '' }>8</option>
												<option ${childNumber==9 ? 'selected' : '' }>9</option>
											</select>
										</div>
									</div>
								</c:if>
							</c:forEach>
						</c:forEach>
					</div>
					<div class="col-md-1">
						<div class="form-group">
							<label style="visibility: hidden;">hidden</label> <input class="btn btn-primary" type="button" data-toggle="collapse"
							 data-target="#collapseSearch" aria-expanded="false" aria-controls="collapseSearch" id="searchExtra" value="추가 검색">
						</div>
					</div>
					<div class="col-md-6 collapse extraSearch" id="collapseSearch">
						<div class="col-md-5">
							<div class="form-group">
								<label>평점 검색</label> <select class="form-control " name="searchRateType">
									<option value="searchAllRate" ${searchRateType=='searchAllRate' ? 'selected' : '' }>전체
										별점 평균</option>
									<option value="searchPriceRate" ${searchRateType==searchPriceRate ? 'selected' : '' }>가격
										별점 평균</option>
									<option value="searchCleanRate" ${searchRateType==searchCleanRate ? 'selected' : '' }>청결도
										별점 평균</option>
									<option value="searchServiceRate" ${searchRateType==searchServiceRate ? 'selected' : '' }>서비스
										별점 평균</option>
									<option value="searchFoodRate" ${searchRateType==searchFoodRate ? 'selected' : '' }>음식
										별점 평균</option>
									<option value="searchLocationRate" ${searchRateType==searchLocationRate ? 'selected' : '' }>위치
										별점 평균</option>
								</select>
							</div>
						</div>
						<div class="col-md-7 extraSearch">
							<div class="form-group">
								<label style="visibility: hidden;">hidden</label> <input type="text" class="form-control " name="searchHotelRate"
								 placeholder="호텔 평점을 입력해주세요. (1 ~ 5)" value="${searchHotelRate}">
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label>최소 비용</label> <input type="text" class="form-control " name="searchMinMoney" placeholder="최소 비용을 입력해주세요"
								 value="${searchMinMoney}">
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label>최대 비용</label> <input type="text" class="form-control " name="searchMaxMoney" placeholder="최대 비용을 입력해주세요"
								 value="${searchMaxMoney}">
							</div>
						</div>
					</div>
					<div class="col-md-12">
						<input type="button" value="검색" class="form-control btn-success" id="searchHotelButton">
					</div>
					<div class="hidden">
						<input type="hidden" id="loginIdHidden" name="user_id">
						<input type="hidden" id="loginPwHidden" name="user_pw">
						<input type="hidden" name="daoType" value="hotelSearch">
					</div>
				</form>
			</div>
		</div>
	</section>


	<section>
		<div class="container">
			<div class="row">
				<div class="col-lg-12 text-center">
					<div class="section-title">
						<h2>검색 결과</h2>
						<p>요기조아 만의 차별화된 검색으로 고객님의 행복을 찾아 드립니다.</p>
					</div>
				</div>
			</div>
			<div class="row row-0-gutter" id="owl-search-num">
				<c:choose>
					<c:when test="${noResult}">
						<h2>죄송합니다! 고객님이 원하시는 조건에 부합하는 호텔이 없습니다.</h2>
						<p class="lead">조건을 낮추거나 기간을 조정하여 다시 검색해 주세요.</p>
					</c:when>
					<c:otherwise>
						<c:forEach items="${hotelInfos}" var="hotelInfo" varStatus="hotelnum">
							<c:forEach items="${hotelList}" var="hotel">
								<c:if test="${hotelInfo.hotelId == hotel.hotel_id}">
									<c:forEach items="${hotelImages}" var="hotelImage">
										<c:if test="${hotelImage.key == hotelInfo.hotelId}">
											<!-- start portfolio item -->
											<div class="col-md-4 col-0-gutter">
												<div class="ot-portfolio-item">
													<figure class="effect-bubba">
														<img src="/reservationmall/resources/images/${hotelImage.value[0]}" alt="/reservationmall/resources/images/template/demo/image_main.jpg"
														 class="img-responsive" />
														<figcaption>
															<h2>${hotel.hotel_name}</h2>
															<p>${hotel.hotel_rate}</p>
															<a data-toggle="modal" data-target="#Modal-${hotelInfo.hotelId}" class="hotelInfoLink">View more</a>
														</figcaption>
													</figure>
												</div>
											</div>
											<!-- end portfolio item -->
										</c:if>
									</c:forEach>
								</c:if>
							</c:forEach>
							<c:if test="${(hotelnum.count)%3 == 0 && !hotelnum.last}">
								<hr class="col-md-12">
							</c:if>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
		<!-- end container -->
	</section>


	<section>
		<div class="container">
			<div class="panel-body">
				<div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
					<div class="panel panel-info">
						<div class="panel-heading" role="tab" id="headinghotel">
							<h4 class="panel-title">
								<a data-toggle="collapse" data-parent="#accordion" href="#collapseHotel" data-target="#collapseHotel"
								 aria-expanded="false" aria-controls="collapseHotel" id="collapseHotelAnchor">선택 호텔 정보</a>
							</h4>
						</div>
					</div>
					<div class="panel panel-info">
						<div class="panel-heading" role="tab" id="headingRoom">
							<h4 class="panel-title">
								<a data-toggle="collapse" data-parent="#accordion" href="#collapseRoom" data-target="#collapseRoom"
								 aria-expanded="false" aria-controls="collapseRoom" id="collapseRoomAnchor">선택 방 정보</a>
							</h4>
						</div>
					</div>
					<div class="panel panel-info">
						<div class="panel-heading" role="tab" id="headingTwo">
							<h4 class="panel-title">
								<a data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" data-target="#collapseTwo" aria-expanded="false"
								 aria-controls="collapseTwo">선택 세부 사항</a>
							</h4>
						</div>
						<div id="collapseTwo" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo">
							<div class="panel-body">
								<h3>예약할 방의 수</h3>
								<p class="lead">${searchRoomNumber}</p>
								<h3>예약 기간</h3>
								<p class="lead">${searchStartDay} ~ ${searchEndDay} <span class="label label-default" id="betweenDay2"><strong>1박
											2일</strong></span></p>
								<h3>예약 지역</h3>
								<p class="lead">${searchValue}</p>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="panel-footer col-md-12">
				<form class="row" name="paymentProc">
					<div class="col-xs-10 col-md-10"><span class="lead" id="totalPrice"></span></div>
					<div class="col-xs-2 col-md-2">
						<button type="button" class="btn btn-danger" style="float: right;" onclick="javascript:paymentProgress()">결제하기</button>
						<div class="hidden">
							<input type="hidden" id="userId" name="userId" value="${(userId == null) || userId.length() == 0 ? '' : userId}">
							<input type="hidden" id="hotelId" name="hotelId">
							<input type="hidden" id="roomName" name="roomName">
							<input type="hidden" id="totalPrice2" name="totalPrice">
							<input type="hidden" id="reservationStartDay" name="reservationStartDay" value="${searchStartDay}">
							<input type="hidden" id="reservationEndDay" name="reservationEndDay" value="${searchEndDay}">
						</div>
					</div>
				</form>
			</div>
		</div>
	</section>


	<!-- 모달 -->
	<c:if test="${!noResult}">
		<c:forEach items="${hotelInfos}" var="hotelInfo" varStatus="hotelnum">
			<c:forEach items="${hotelList}" var="hotel">
				<c:choose>
					<c:when test="${hotelInfo.hotelId == hotel.hotel_id}">
						<div class="modal fade bs-example-modal-lg" id="Modal-${hotelInfo.hotelId}" tabindex="-1" role="dialog"
						 aria-labelledby="Modal-label-${hotelInfo.hotelId}">
							<div class="modal-dialog" role="document">
								<div class="modal-content">
									<!-- hotel infomation  -->


									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal" aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
										<h4 class="modal-title" id="Modal-label-${hotelInfo.hotelId}">${hotel.hotel_name}</h4>
																				<!-- 위시리스트 추가 -->
										<i class="far fa-heart" onclick="javascript:addWishList(${hotelInfo.hotelId})"></i>위시리스트 등록
										<div id="hotelMapInfo${hotelInfo.hotelId}" style="color:blue;"></div>
										<!-- 끝 -->
									</div>
									<div class="modal-body">
										<div role="tabpanel">
											<ul class="nav nav-tabs" role="tablist">
												<li role="presentation" class="active"><a href="#home-${hotelInfo.hotelId}" id="home-tab-${hotelInfo.hotelId}"
													 role="tab" data-toggle="tab" aria-controls="home-${hotelInfo.hotelId}" aria-expanded="true" data-target="#home-${hotelInfo.hotelId}">호텔정보</a></li>
												<li role="presentation"><a href="#profile-${hotelInfo.hotelId}" role="tab" id="profile-tab-${hotelInfo.hotelId}"
													 data-toggle="tab" aria-controls="profile-${hotelInfo.hotelId}" data-target="#profile-${hotelInfo.hotelId}">비교분석</a></li>
												<li role="presentation"><a href="#review-${hotelInfo.hotelId}" role="tab" id="review-tab-${hotelInfo.hotelId}"
													 data-toggle="tab" aria-controls="review-${hotelInfo.hotelId}" data-target="#review-${hotelInfo.hotelId}">호텔
														리뷰</a></li>
												<li role="presentation"><a href="#locationMap-${hotelInfo.hotelId}" role="tab" id="locationMap-${hotelInfo.hotelId}-tab"
													 data-toggle="tab" aria-controls="locationMap-${hotelInfo.hotelId}" data-target="#locationMap-${hotelInfo.hotelId}">위치정보</a></li>
											</ul>

											<!-- 호텔 전체 정보 모달 바디 시작 -->
											<div id="myTabContent" class="tab-content">

												<!-- 호텔정보 탭 시작 -->
												<div role="tabpanel" class="tab-pane fade in active" id="home-${hotelInfo.hotelId}" aria-labelledBy="home-tab-${hotelInfo.hotelId}">
													<div class="owl-search-${hotelInfo.hotelId} owl-carousel">
														<c:forEach items="${hotelImages}" var="hotelImage">
															<c:if test="${hotelImage.key == hotelInfo.hotelId}">
																<c:forEach items="${hotelImage.value}" var="imageDirectory">
																	<div class="item text-center">
																		<div class="owl-search-item">
																			<img class="owl-lazy" data-src="/reservationmall/resources/images/${imageDirectory}" alt="/reservationmall/resources/images/template/demo/image_main.jpg">
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
															<p>호텔 웹사이트 : <a href="${hotel.hotel_website}" target="_blank">${hotel.hotel_website}</a></p>
															<p>호텔 주소 : ${hotel.hotel_address}</p>
															<p>소개글 : ${hotel.hotel_info}</p>
														</div>
													</div>
													<div role="tabpanel">
														<ul class="nav nav-tabs" role="tablist">
															<c:forEach items="${hotelInfo.rooms}" varStatus="roomnum">
																<li role="presentation" class="${roomnum.count == 1 ? 'active' : ''}"><a href="#room${hotelInfo.hotelId}-${roomnum.count}"
																	 id="room${hotelInfo.hotelId}-${roomnum.count}-tab" role="tab" data-toggle="tab" aria-controls="room${hotelInfo.hotelId}-${roomnum.count}"
																	 aria-expanded="${roomnum.count == 1 ? 'true' : 'false'}" data-target="#room${hotelInfo.hotelId}-${roomnum.count}">방
																		선택${roomnum.count}</a></li>
															</c:forEach>
														</ul>

														<div id="roomTab" class="tab-content">
															<c:forEach items="${hotelInfo.rooms}" varStatus="roomnum" var="rooms">
																<div role="tabpanel" class="tab-pane fade in ${roomnum.count == 1 ? 'active' : ''}" id="room${hotelInfo.hotelId}-${roomnum.count}"
																 aria-labelledBy="room${hotelInfo.hotelId}-${roomnum.count}-tab">
																	<span class="lead"><span class="label label-default">예약 인원</span></span class="lead">
																	<c:forEach items="${searchAdultNumber}" var="adultNumber" varStatus="adultNumberStatus">
																		<c:if test="${adultNumberStatus.count == roomnum.count}">
																			<span class="lead"><span class="label label-success">어른 : ${adultNumber}명</span></span>
																			<input type="hidden" id="adultNumber${roomnum.count}" value="${adultNumber}">
																		</c:if>
																	</c:forEach>
																	<c:forEach items="${searchChildNumber}" var="childNumber" varStatus="childNumberStatus">
																		<c:if test="${childNumberStatus.count == roomnum.count}">
																			<span class="lead"><span class="label label-success">아이 : ${childNumber}명</span></span>
																			<input type="hidden" id="childNumber${roomnum.count}" value="${childNumber}">
																		</c:if>
																	</c:forEach>
																	<table class="table table-hover">
																		<thead>
																			<tr>
																				<th>#</th>
																				<th>방이름</th>
																				<th>인원수</th>
																				<th>가격</th>
																				<th></th>
																			</tr>
																		</thead>
																		<tbody>
																			<script>
																				var roomSize = parseInt("${rooms.value.size()}")
																			</script>
																			<c:forEach items="${rooms.value}" var="room" varStatus="roomId">
																				<!-- hjh -->
																				<script>
																					var roomAvg = 0;

																					roomAvg = roomAvg + parseInt("${room.price}");
																				</script>
																				<tr>
																					<th scope="row">${roomId.count}</th>
																					<td>${room.name}</td>
																					<td>최소 : 1 최대 : ${room.standardNumber}</td>
																					<td>${room.price}원</td>
																					<td>
																						<button type="button" class="btn btn-primary room-info-btn" data-toggle="collapse" data-target="#romminfo${hotelInfo.hotelId}-${roomnum.count}-${roomId.count}"
																						 aria-expanded="false" aria-controls="romminfo${hotelInfo.hotelId}-${roomnum.count}-${roomId.count}">방정보</button>
																						<button type="button" class="btn btn-primary roomSelect">선택</button>
																						<input type="hidden" value="${hotelInfo.hotelId}">
																						<input type="hidden" value="${roomnum.count}">
																						<input type="hidden" value="${roomId.count}">
																						<input type="hidden" value="${room.price}">
																						<input type="hidden" value="${room.name}">
																					</td>
																				</tr>
																				<tr class="collapse" id="romminfo${hotelInfo.hotelId}-${roomnum.count}-${roomId.count}">
																					<td colspan="5" style="width: 100%;">
																						<span>
																							<div class="col-md-12" id="select${hotelInfo.hotelId}-${roomnum.count}-${roomId.count}">
																								<img class="img-responsive" src="/reservationmall/resources/images/${room.images[0]}" alt="/reservationmall/resources/images/template/demo/image_main.jpg">
																								<div>${room.info}</div>
																								<div>
																									<c:forEach items="${room.detail}" var="detail">
																										<span class="label label-warning">${detail}</span>
																									</c:forEach>
																								</div>
																							</div>
																						</span>
																					</td>
																				</tr>
																			</c:forEach>
																		</tbody>
																	</table>
																</div>
															</c:forEach>
														</div>

													</div>
												</div>
												<!-- 비교분석 탭 시작 -->
												<div role="tabpanel" class="tab-pane" id="profile-${hotelInfo.hotelId}" aria-labelledBy="profile-tab-${hotelInfo.hotelId}">
													<div class="row">
														<div class="col-md-12">
															<script type="text/javascript" src="/reservationmall/resources/js/common/Chart.js"></script>
															<div style="border: solid 1px black; width: 100%; height: 30%; margin-bottom: 10px;">
																<canvas id="canvasRadar${hotel.hotel_id}" style="margin-left: 5px;"></canvas>
															</div>
															<div style="border: solid 1px black; width: 100%; height: 30%; margin-bottom: 10px;">
																<canvas id="canvasBar${hotel.hotel_id}" style="margin-left: 5px;"></canvas>
															</div>
															<script>
																var graph_hotel_rate = [];
																graph_hotel_rate.push("${hotelInfo.priceRate}");
																graph_hotel_rate.push("${hotelInfo.foodRate}");
																graph_hotel_rate.push("${hotelInfo.serviceRate}");
																graph_hotel_rate.push("${hotelInfo.cleanRate}");
																graph_hotel_rate.push("${hotelInfo.locationRate}");


																if (graph_hotel_rate[0].length == 0) {
																	graph_hotel_rate = [0, 0, 0, 0, 0];
																}

																var target = document
																	.getElementById(
																		'canvasRadar${hotel.hotel_id}')
																	.getContext(
																		'2d');
																var targets = document
																	.getElementById(
																		'canvasBar${hotel.hotel_id}')
																	.getContext(
																		'2d');

																var ChartHelper = {
																	chartColors: {
																		red: 'rgb(255, 99, 132)',
																		orange: 'rgb(255, 159, 64)',
																		yellow: 'rgb(255, 205, 86)',
																		green: 'rgb(75, 192, 192)',
																		blue: 'rgb(54, 162, 235)',
																		purple: 'rgb(153, 102, 255)',
																		grey: 'rgb(201, 203, 207)'
																	}
																};
																var color = Chart.helpers.color;

																var data1 = null;
																var data2 = null;
																var barChartData = null;
																var hotelRateAvg = [
																	("${hotelRateAvg.price_avg}"),
																	("${hotelRateAvg.food_avg}"),
																	("${hotelRateAvg.service_avg}"),
																	("${hotelRateAvg.clean_avg}"),
																	("${hotelRateAvg.location_avg}")
																];
																window.RadarChart = new Chart(
																	target,
																	{
																		type: 'radar',
																		data: {
																			labels: [
																				'가격',
																				'음식',
																				'서비스',
																				'청결',
																				'위치'],
																			datasets: [
																				{
																					label: "${hotel.hotel_name}",
																					backgroundColor: color(
																						ChartHelper.chartColors.blue)
																						.alpha(
																							0.5)
																						.rgbString(),
																					borderColor: ChartHelper.chartColors.blue,
																					borderWidth: 1,
																					data: graph_hotel_rate
																				},
																				{
																					label: '평균값',
																					backgroundColor: color(
																						ChartHelper.chartColors.red)
																						.alpha(
																							0.5)
																						.rgbString(),
																					borderColor: ChartHelper.chartColors.red,
																					borderWidth: 1,
																					data: hotelRateAvg
																				}]
																		},
																		option: Chart.defaults.radar
																	});
																var data1 = null;
																var data2 = null;
																var barChartData = null;

																// todo: data setting
																data1 = [(roomAvg / roomSize)];
																data2 = [("${hotelRoomAvg.room_avg}")];

																barChartData = {
																	labels: ['평균가격'],
																	datasets: [
																		{
																			label: "${hotel.hotel_name}",
																			backgroundColor: color(
																				ChartHelper.chartColors.blue)
																				.alpha(
																					0.5)
																				.rgbString(),
																			borderColor: ChartHelper.chartColors.blue,
																			borderWidth: 1,
																			data: data1
																		},
																		{
																			label: '평균가격',
																			backgroundColor: color(
																				ChartHelper.chartColors.red)
																				.alpha(
																					0.5)
																				.rgbString(),
																			borderColor: ChartHelper.chartColors.red,
																			borderWidth: 1,
																			data: data2
																		}]
																};

																window.BarChart = new Chart(
																	targets,
																	{
																		type: 'bar'
																		// 옆으로 누운 bar 차트를 쓰실 경우 바꾸시면 됩니다.
																		//type: 'horizontalBar'
																		,
																		data: barChartData,
																		options: Chart.defaults.bar
																	});
															</script>

														</div>
													</div>
												</div>

												<!-- 지도 탭 시작 -->
												<div role="tabpanel" class="tab-pane" id="locationMap-${hotelInfo.hotelId}" aria-labelledBy="locationMap-tab-${hotelInfo.hotelId}">
													<div class="row">
														<div class="panel panel-default">
															<div class="panel-body">
																<div id="hotelmap${hotel.hotel_id}" style="width: 100%; height: 400px;"></div>
																<script>
																	var HOME_PATH = window.HOME_PATH || '.';

																	var hotel = new naver.maps.LatLng("${hotel.hotel_y}", "${hotel.hotel_x}"),
																		map = new naver.maps.Map('hotelmap${hotel.hotel_id}', {
																			center: hotel.destinationPoint(0, 300),
																		}),
																		marker = new naver.maps.Marker({
																			map: map,
																			position: hotel
																		});

																</script>
															</div>
														</div>
													</div>
												</div>

												<!-- 리뷰 탭 시작 -->
												<div role="tabpanel" class="tab-pane" id="review-${hotelInfo.hotelId}" aria-labelledBy="review-tab-${hotelInfo.hotelId}">
													<div class="row">
														<div class="col-md-12">
															<c:forEach items="${hotelInfo.reviews}" var="review" varStatus="reviewStatus">
																<div class="media">
																	<hr>
																	<c:choose>
																		<c:when test="${userId == review.userId}">
																			<div class="media-body text-right">
																				<div class="media-heading text-center">
																					<span class="label label-info">서비스 : ${review.serviceRate}</span>
																					<span class="label label-info">가격 : ${review.priceRate}</span>
																					<span class="label label-info">음식 : ${review.foodRate}</span>
																					<span class="label label-info">청결도 : ${review.cleanRate}</span>
																					<span class="label label-info">위치 : ${review.locationRate}</span>
																				</div>
																				<p>
																					${review.content}
																				</p>
																				<div class="text-right">${review.date}</div>
																			</div>
																			<div class="media-right text-center">
																				<i class="fa fa-user"></i>
																				${review.userId}
																				<hr>
																				<span>좋아요!</span>
																				<div class="label-large"><span class="label label-default">${review.helpfulCount}</span></div>
																			</div>
																		</c:when>
																		<c:otherwise>
																			<div class="media-left text-center">
																				<i class="fa fa-user"></i>
																				${review.userId}
																				<hr>
																				<span>좋아요!</span>
																				<div class="label-large"><span class="label label-default">${review.helpfulCount}</span></div>
																			</div>
																			<div class="media-body">
																				<div class="media-heading text-center">
																					<span class="label label-info">서비스 : ${review.serviceRate}</span>
																					<span class="label label-info">가격 : ${review.priceRate}</span>
																					<span class="label label-info">음식 : ${review.foodRate}</span>
																					<span class="label label-info">청결도 : ${review.cleanRate}</span>
																					<span class="label label-info">위치 : ${review.locationRate}</span>
																				</div>
																				<p>
																					${review.content}
																				</p>
																				<div class="text-right">${review.date}</div>
																			</div>
																			<div class="media-right text-center">
																				<input type="hidden" name="reviewId" value="${review.reviewId}">
																				<c:choose>
																					<c:when test="${review.isLiked == true}">
																						<button class="btn btn-link review-like"><i class="fas fa-heart"></i></button>
																					</c:when>
																					<c:otherwise>
																						<button class="btn btn-link review-like"><i class="far fa-heart"></i></button>
																					</c:otherwise>
																				</c:choose>
																				<hr>
																				<c:choose>
																					<c:when test="${review.isHated}">
																						<button class="btn btn-link review-hate"><i class="fas fa-trash-alt"></i></button>
																					</c:when>
																					<c:otherwise>
																						<button class="btn btn-link review-hate"><i class="far fa-trash-alt"></i></button>
																					</c:otherwise>
																				</c:choose>
																			</div>
																		</c:otherwise>
																	</c:choose>
																	<c:if test="${reviewStatus.last}">
																		<hr class="col-md-12">
																	</c:if>
																</div>
															</c:forEach>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>

									<div class="modal-footer">
										<button type="button" class="btn btn-info reservationButton">예약하기</button>
										<div class="hidden">
											<c:forEach items="${hotelInfo.rooms}" varStatus="roomnum" var="rooms">
												<input type="hidden" id="roomSelected${hotelInfo.hotelId}-${roomnum.count}">
											</c:forEach>
										</div>
										<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
									</div>
								</div>
							</div>
						</div>
					</c:when>
				</c:choose>
			</c:forEach>
		</c:forEach>
	</c:if>

	<div class="modal fade bs-example-modal-lg" id="paymentModal" tabindex="-1" role="dialog" aria-labelledby="paymentModal-label-2">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
					<h4 class="modal-title">결제 진행 중</h4>
				</div>
				<div class="modal-footer">
					<span class="label label-primary">결제 진행률</span>
					<div class="progress">
						<div class="progress-bar" id="proBar" role="progressbar" aria-valuenow="0" aria-valuemin="0" aria-valuemax="100"
						 style="width: 0%;">
							0%
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>






	<script type="text/javascript" src="/reservationmall/resources/js/common/jquery-3.3.1.js"></script>
	<script src="/reservationmall/resources/js/template/bootstrap.min.js"></script>
	<script src="/reservationmall/resources/js/template/owl.carousel.min.js"></script>
	<script src="/reservationmall/resources/js/template/cbpAnimatedHeader.js"></script>
	<script src="/reservationmall/resources/js/template/jquery.appear.js"></script>
	<script src="/reservationmall/resources/js/template/SmoothScroll.min.js"></script>
	<script src="/reservationmall/resources/js/template/mooz.themes.scripts.js"></script>

	<!--======== JJW javascript file List =========-->
	<link rel="stylesheet" href="/reservationmall/resources/css/jjw/bootstrap-datetimepicker.css">
	<script type='text/javascript' src="/reservationmall/resources/js/jjw/moment-with-locales.min.js"></script>
	<script type='text/javascript' src="/reservationmall/resources/js/jjw/bootstrap-datetimepicker.js"></script>
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=380ae52ddded1dcd6fc9df096287f781&libraries=services"></script>
	<script src="/reservationmall/resources/js/jjw/common.js"></script>
	<script src="/reservationmall/resources/js/jjw/review.js"></script>
	<!--======== JJW javascript file List =========-->
</body>

</html>