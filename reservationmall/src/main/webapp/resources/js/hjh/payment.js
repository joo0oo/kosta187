
function paymentProgress(){
	$('#paymentModal').modal('show');
	$('#paymentModal').modal('backdrop');
	var i = 0;
	var userId =document.getElementById("userId").value;
	var hotelId = document.getElementById("hotelId").value;
	var roomName = document.getElementById("roomName").value;
	var totalPrice2 = document.getElementById("totalPrice2").value;
	var reservationStartDay = document.getElementById("reservationStartDay").value;
	var reservationEndDay = document.getElementById("reservationEndDay").value;
	
	var paymentResult;
	
	var proInterval = setInterval(function() {
		i = i+1
		document.getElementById("proBar").setAttribute("style", "width:"+ i + "%;");
		$('#proBar').text(i + "%");
		//결제 진행
		if(i==50){
			clearInterval(proInterval);
			 $.ajax({
				type : "post",
				url : '/reservationmall/hotelPaymentCheck.mall',
				data : {
					hotel_id : hotelId,
					user_id : userId,
					totalPrice2 : totalPrice2,
					reservationStartDay : reservationStartDay,
					reservationEndDay : reservationEndDay,
					room_id_list : roomName
				},
				dataType : "text",
				success : function(resultType) {
					
					if(resultType.trim()=='success'){
						paymentResult = resultType.trim();
						location.href="/reservationmall/paymentResult/success.mall"
					}else if(resultType.trim()=="existReserve"){
						document.getElementById("probarColor").setAttribute("class","label label-danger");
						location.href="/reservationmall/paymentResult/fail.mall"
					}
				},
				error : function() {
					console.log('실패');
				}
			});
		}
		
		if(i == 100){
			clearInterval(proInterval);
		}
	}, 50);
}
