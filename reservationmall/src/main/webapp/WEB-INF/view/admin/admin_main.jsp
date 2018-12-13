<%@ page contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
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
	
	
	<!-- Custom styles for this template -->
	<link href="/reservationmall/resources/css/template/owl.carousel.css" rel="stylesheet">
	<link href="/reservationmall/resources/css/template/owl.theme.default.min.css"  rel="stylesheet">
	<link href="/reservationmall/resources/css/template/style.css" rel="stylesheet">
	<link href="/reservationmall/resources/bootstrap/css/bootstrap.css" rel="stylesheet">
	<script type="text/javascript" src="/reservationmall/resources/js/common/jquery-3.3.1.js"></script>
	<script type="text/javascript" src="/reservationmall/resources/bootstrap/js/bootstrap.js"></script>
	<script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?clientId=aba8nx_n3O9CvAauIsql&amp;submodules=panorama,geocoder,drawing,visualization"></script>
	
	<!-- 허재혁추가 -->
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
	<!-- 허재혁 추가 -->
	<script>
	$(function () {
	  $("#home-tab").on("click", function(e){
		  
		  $("#home-tab").tab('show');
	  });
	  
	  $("#profile-tab").on("click", function(e){
	
		  $("#profile-tab").tab('show');
		});
	  $("a[name='paymentList']").on("click", function(e){
		 $(this).collapse('show');
	  });
		
	  $("#roomInfo").on("click", function(e){
		  
		  $("#roomInfo").tab('show');
	  });
	  
	  console.log("${hotelInfos}");

	});
	function addWisiList(hotel_id, user_id) {
			$.ajax({
				type : "get",
				url : "likeUphjh",
				data : {
					hotel_id : hotel_id,
					user_id : user_id
				},
				dataType : "json",
				success : function(resultType) {
					if(resultType=="true"){
						setTimeInte
					}

				},
				error : function() {
					location.href = "listindexhjh";
				}
			});

		} else {
			checkLike.className = 'icon fa-heart-o';
			$.ajax({
				type : "get",
				url : "likeDownhjh?board_no=" + board_no + "&mem_id=" + mem_id,
				dataType : "json",
				success : function(cnt) {
					$("#icon" + board_no).text(cnt);
				},
				error : function() {
					location.href = "listindexhjh";
				}
			});
		}
	}
	
	</script>
</head>
<body>
	<!-- top 네비게이션 -->
	<jsp:include page="/WEB-INF/view/main/basic_top.jsp"></jsp:include>

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
			
			<div class="row row-0-gutter">
				<!-- start portfolio item -->
				<div class="col-md-4 col-0-gutter">
					<div class="ot-portfolio-item">
						<figure class="effect-bubba">
							<img src="/reservationmall/resources/images/hotels/hotel_1.jpg" alt="img02" class="img-responsive" />
							<figcaption>
								<h2>신라호텔</h2>
								<p>호텔업소, 4성급</p>
								<a data-toggle="modal" data-target="#Modal-1">View more</a>
							</figcaption>
						</figure>
					</div>
				</div>
				<!-- end portfolio item -->
				<!-- start portfolio item -->
				<div class="col-md-4 col-0-gutter">
					<div class="ot-portfolio-item">
						<figure class="effect-bubba">
							<img src="/reservationmall/resources/images/hotels/hotel_2.jpg" alt="img02" class="img-responsive" />
							<figcaption>
								<h2>힐튼 호텔</h2>
								<p>고급 호텔, 5성급</p>
								<a href="#" data-toggle="modal" data-target="#Modal-2">View more</a>
							</figcaption>
						</figure>
					</div>
				</div>
				<!-- end portfolio item -->
				<!-- start portfolio item -->
				<div class="col-md-4 col-0-gutter">
					<div class="ot-portfolio-item">
						<figure class="effect-bubba">
							<img src="/reservationmall/resources/images/hotels/hotel_3.jpg" alt="img02" class="img-responsive" />
							<figcaption>
								<h2>대충 호텔</h2>
								<p>이런 느낌, 오케이?</p>
								<a href="#" data-toggle="modal" data-target="#Modal-3">View more</a>
							</figcaption>
						</figure>
					</div>
				</div>
				<!-- end portfolio item -->
			</div>
			<div class="row row-0-gutter">
				<!-- start portfolio item -->
				<div class="col-md-4 col-0-gutter">
					<div class="ot-portfolio-item">
						<figure class="effect-bubba">
							<img src="/reservationmall/resources/images/hotels/hotel_4.jpg" alt="img02" class="img-responsive" />
							<figcaption>
								<h2>Smart Name</h2>
								<p>Branding, Design</p>
								<a href="#" data-toggle="modal" data-target="#Modal-4">View more</a>
							</figcaption>
						</figure>
					</div>
				</div>
				<!-- end portfolio item -->
				<!-- start portfolio item -->
				<div class="col-md-4 col-0-gutter">
					<div class="ot-portfolio-item">
						<figure class="effect-bubba">
							<img src="/reservationmall/resources/images/hotels/hotel_5.jpg" alt="img02" class="img-responsive" />
							<figcaption>
								<h2>Fast People</h2>
								<p>Branding, Web Design</p>
								<a href="#" data-toggle="modal" data-target="#Modal-5">View more</a>
							</figcaption>
						</figure>
					</div>
				</div>
				<!-- end portfolio item -->
				<!-- start portfolio item -->
				<div class="col-md-4 col-0-gutter">
					<div class="ot-portfolio-item">
						<figure class="effect-bubba">
							<img src="/reservationmall/resources/images/hotels/hotel_6.jpg" alt="img02" class="img-responsive" />
							<figcaption>
								<h2>Kites & Stars</h2>
								<p>Branding, Web Design</p>
								<a href="#" data-toggle="modal" data-target="#Modal-2">View more</a>
							</figcaption>
						</figure>
					</div>
				</div>
				<!-- end portfolio item -->
			</div>
			
			<div class="row row-0-gutter">
				<!-- start portfolio item -->
				<div class="col-md-4 col-0-gutter">
					<div class="ot-portfolio-item">
						<figure class="effect-bubba">
							<img src="/reservationmall/resources/images/hotels/hotel_1.jpg" alt="img02" class="img-responsive" />
							<figcaption>
								<h2>신라호텔</h2>
								<p>호텔업소, 4성급</p>
								<a href="#" data-toggle="modal" data-target="#Modal-1">View more</a>
							</figcaption>
						</figure>
					</div>
				</div>
				<!-- end portfolio item -->
				<!-- start portfolio item -->
				
				<!-- end portfolio item -->
				<!-- start portfolio item -->
			
				<!-- end portfolio item -->
			</div>
			
			
			</div><!-- end container -->
		
			<div class="row">
				<div class="col-lg-12 text-center">
					<div class="section-footer">
						<h2><button class="btn btn-warning">더 보기</button></h2>
					</div>
				</div>
			</div>
		
		</section>
		
		
		<section>
		<div class="container">
		    <div class="panel-body">
				<div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
				  <div class="panel panel-default">
				    <div class="panel-heading" role="tab" id="headingOne">
				      <h4 class="panel-title">
				        <button class="btn btn-info" data-toggle="collapse" data-parent="#accordion" href="#collapseOne" data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
				         	 결제정보
				        </button>
				      </h4>
				    </div>
				    <div id="collapseOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">
				      <div class="panel-body">
				        고객정보 방예약 정보 등등
				      </div>
				    </div>
				  </div>
				  <div class="panel panel-default">
				    <div class="panel-heading" role="tab" id="headingTwo">
				      <h4 class="panel-title">
				        <button class="btn btn-info collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" data-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
				          방정보
				        </button>
				      </h4>
				    </div>
				    <div id="collapseTwo" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo">
				      <div class="panel-body">
				        <ul class="list-group">
				          <li class="list-group-item">스위트룸</li>
				          <li class="list-group-item">고급룸</li>
				          <li class="list-group-item">그루비룸</li>
				        </ul>
				      </div>
				    </div>
				  </div>
				</div>
		   	</div>
		    <div class="panel-footer">
		    	<span style="flat:left;">총 결제 금액 : 35000</span> <button type="button" class="btn btn-danger" style="float:right;">결제하기</button>
		    </div>
		</div>
				
		</section>	

	
	<!-- 모달 -->
	<div class="modal fade bs-example-modal-lg" id="Modal-1" tabindex="-1" role="dialog" aria-labelledby="Modal-label-1">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<!-- hotel infomation  -->
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						<h4 class="modal-title" id="Modal-label-1">신라호텔</h4><i class="far fa-heart">위시리스트 수 1</i>
					</div>
					<div class="modal-body">
						<div role="tabpanel">
						    <ul class="nav nav-tabs" role="tablist">
						      <li role="presentation" class="active"><a href="#home" id="home-tab" role="tab" data-toggle="tab" aria-controls="home" aria-expanded="true" data-target="#home">호텔정보</a></li>
						      <li role="presentation"><a href="#profile" role="tab" id="profile-tab" data-toggle="tab" aria-controls="profile" data-target="#profile">비교분석</a></li>
						    </ul>
						    <!-- 호텔정보 탭 시작 -->
							<div id="myTabContent" class="tab-content">
								<div role="tabpanel" class="tab-pane fade in active" id="home" aria-labelledBy="home-tab">
									<div class="owl-portfolio owl-carousel">
										<div class="item">
											<div class="owl-portfolio-item"><img src="/reservationmall/resources/images/hotels/hotel_1.jpg" class="img-responsive" alt="portfolio"></div>
										</div>
										<div class="item">
											<div class="owl-portfolio-item"><img src="/reservationmall/resources/images/hotels/hotel_2.jpg" class="img-responsive" alt="portfolio"></div>
										</div>
										<div class="item">
											<div class="owl-portfolio-item"><img src="/reservationmall/resources/images/hotels/hotel_3.jpg" class="img-responsive" alt="portfolio"></div>
										</div>
									</div>
									<img src="/reservationmall/resources/images/hotels/hotel_1.jpg" alt="img01" class="img-responsive" />
									<div class="modal-works">
										<span>특급호텔</span><span>스파</span><span>찜질방</span>
									</div>
									<p>안녕하세요 신라호텔입니다. 성심성의껏 고객님을 황제로 모시겠습니다.</p>
									<div role="tabpanel">
									    <ul class="nav nav-tabs" role="tablist">
									      <li role="presentation" class="active"><a href="#room1" id="room1-tab" role="tab" data-toggle="tab" aria-controls="room1" aria-expanded="true" data-target="#room1">방 선택1</a></li>
									      <li role="presentation"><a href="#room2" role="tab" id="room2-tab" data-toggle="tab" aria-controls="room2" data-target="#room2">방 선택2</a></li>
									    </ul>
									    
									    <div id="roomTab" class="tab-content">
									    	<div role="tabpanel" class="tab-pane fade in active" id="room1" aria-labelledBy="room1-tab">
									    	<span class="label label-success">기준인원 : 4 </span>
									    	<table class="table table-hover">
										      <thead>
										        <tr>
										          <th>#</th>
										          <th>방이름</th>
										          <th>인원수</th>
										          <th>가격</th>
										          <th>선택</th>
										        </tr>
										      </thead>
										      <tbody>
										        <tr>
										          <th scope="row">1</th>
										          <td>스위트룸</td>
										          <td>최소 : 3  최대 : 6</td>
										          <td>3000000원</td>
										          <td><button type="button" id="roomInfo" class="btn btn-primary" data-toggle="collapse" data-target="#romminfo" aria-expanded="false" aria-controls="romminfo">방정보</button>
										          <button type="button" class="btn btn-primary">선택</button></td>
										        </tr>
										        <tr>
										          <th scope="row">2</th>
										          <td>Jacob</td>
										          <td>Thornton</td>
										          <td>@fat</td>
										        </tr>
										        <tr>
										          <th scope="row">3</th>
										          <td>Larry</td>
										          <td>the Bird</td>
										          <td>@twitter</td>
										        </tr>
										      </tbody>
										    </table>
										    <div class="collapse" id="romminfo">
											  <div class="well" >
											    방정보
											  </div>
											</div>
									    	
									    	</div>
									    	
									    	<div role="tabpanel" class="tab-pane fade in active" id="room2" aria-labelledBy="room2-tab">
									    	</div>
									    </div>
									    
									</div>
										
								</div>
									
								<!-- 비교분석 탭 시작 -->
								<div role="tabpanel" class="tab-pane" id="profile" aria-labelledBy="profile-tab">
							 		<div class="row">
									  	<div class="col-md-6">
									  		<div class="jumbotron">
											 	<div id="map" style="width:100%;height:300px;"></div>
												<script>
												var mapOptions = {
												    center: new naver.maps.LatLng(37.3595704, 127.105399),
												    zoom: 10
												};
												
												var map = new naver.maps.Map('map', mapOptions);
												</script>
									  		</div>
									  	</div>
									  	<div class="col-md-6">
									  		<div class="jumbotron">
											 <script type="text/javascript" src="/reservationmall/resources/js/common/Chart.js"></script>
											 <div style="border: solid 1px black; width: 100%; height: 30%; margin-bottom: 10px;">
											        <canvas id="canvasRadar" style="margin-left: 5px;"></canvas>
											</div>
											<div style="border: solid 1px black; width: 100%; 
												height: 30%; margin-bottom: 10px;">
												        <canvas id="canvasRadar2" style="margin-left: 5px;"></canvas>
											</div>
											<script>
											var target = document.getElementById('canvasRadar').getContext('2d');
											var targets = document.getElementById('canvasRadar2').getContext('2d');
									
											var ChartHelper = {
										            chartColors: {
										                red: 'rgb(255, 99, 132)'
										                , orange: 'rgb(255, 159, 64)'
										                , yellow: 'rgb(255, 205, 86)'
										                , green: 'rgb(75, 192, 192)'
										                , blue: 'rgb(54, 162, 235)'
										                , purple: 'rgb(153, 102, 255)'
										                , grey: 'rgb(201, 203, 207)'
										            }
										        };
											 var color = Chart.helpers.color;
												
										        var data1 = null;
										        var data2 = null;
										        var barChartData = null;
											
									
											window.RadarChart = new Chart(target, {
											    type: 'radar',
											    data: {
											        labels: ['서비스', '청결도', '가격', '시설', '교통'],
											        datasets: [
										                {
										                    label: '신라호텔'
										                    , backgroundColor: 
															color(ChartHelper.chartColors.blue).alpha(0.5).rgbString()
										                    , borderColor: ChartHelper.chartColors.blue
										                    , borderWidth: 1
										                    , data: [3.5, 2.2, 5.0, 4.2, 3.8]
										                }, {
										                    label: '평균값'
											                    , backgroundColor: 
																color(ChartHelper.chartColors.red).alpha(0.5).rgbString()
											                    , borderColor: ChartHelper.chartColors.red
											                    , borderWidth: 1
											                    , data: [3.2, 3.2, 3.0, 3.2, 3.8]
											                }]
											    },
											    option : Chart.defaults.radar
											});
													var data1 = null;
											        var data2 = null;
											        var barChartData = null;
											
											       
											        // todo: data setting
											        data1 = [150000];
											        data2 = [200000];
											
											        barChartData = {
											            labels: ['총가격']
											            , datasets: [
											                {
											                    label: '신라호텔'
											                    , backgroundColor: 
											color(ChartHelper.chartColors.blue).alpha(0.5).rgbString()
											                    , borderColor: ChartHelper.chartColors.blue
											                    , borderWidth: 1
											                    , data: data1
											                }
											                , {
											                    label: '평균가격'
											                    , backgroundColor: 
											color(ChartHelper.chartColors.red).alpha(0.5).rgbString()
											                    , borderColor: ChartHelper.chartColors.red
											                    , borderWidth: 1
											                    , data: data2
											                }
											            ]
											        };
									
									        window.BarChart = new Chart(targets, {
									            type: 'bar'
												// 옆으로 누운 bar 차트를 쓰실 경우 바꾸시면 됩니다.
									            //type: 'horizontalBar'
									            , data: barChartData
									            , options: Chart.defaults.bar
									        });
											</script>
										</div>
									</div>
							 	</div>
							</div>
						</div>
					</div>
					

					<div class="modal-footer">
						<button type="button" class="btn btn-info">예약하기</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					</div>
					
				</div>
			</div>
		</div>
		</div>
		
		
			

	<!-- bottom네비게이션 -->
	<jsp:include page="/WEB-INF/view/main/main_bottom.jsp"></jsp:include>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>
	<script src="/reservationmall/resources/js/template/bootstrap.min.js"></script>
	<script src="/reservationmall/resources/js/template/owl.carousel.min.js"></script>
	<script src="/reservationmall/resources/js/template/cbpAnimatedHeader.js"></script>
	<script src="/reservationmall/resources/js/template/jquery.appear.js"></script>
	<script src="/reservationmall/resources/js/template/SmoothScroll.min.js"></script>
	<script src="/reservationmall/resources/js/template/mooz.themes.scripts.js"></script>
</body>
</html>