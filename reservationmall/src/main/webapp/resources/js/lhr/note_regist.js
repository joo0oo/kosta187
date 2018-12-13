window.onload = function(){
	init();
	
	if(document.getElementById('registForm') != null){ //가입화면인 경우
		
		document.getElementById('regist_name').onkeyup=function(){
			//이름 유효성 확인
			isValidName();
		}
		
		document.getElementById('regist_email').onkeyup=function(){
			//이메일 중복검사
		}
		document.getElementById("registSubmitBtn").onclick = function(){
			//폼 제출
			if(registReady == true) {
				console.log('submit regist');
				var form= document.getElementById('registForm');
				form.submit();
			}
		}
	}
}

function init(){
	registReady=false;
	
	document.getElementById('regist_idAlert').style.display='none';
	document.getElementById('regist_idValidAlert').style.display='none';
	document.getElementById('regist_idSuccess').style.display='none';
	
	document.getElementById('regist_pwAlert').style.display='none';
	document.getElementById('regist_pwAlertSec').style.display='none';
	document.getElementById('regist_pwChckAlert').style.display='none';
	
	document.getElementById('regist_nameAlert').style.display='none';
	document.getElementById('regist_emailAlert').style.display='none';
}

//아이디 검사
function isValidId(){
	const reg = /^\w{3,15}$/;
	var user_id= document.getElementById('regist_id').value;
	
	
	if(user_id.trim().length == 0 || user_id==null){
		$('#regist_idAlert').css('display','none');
		$('#regist_idSuccess').css('display','none');
		$('#regist_idValidAlert').css('display','none');
		registReady=false;
		return;
	}
	
	if( !reg.test(user_id) ){ //유효하지 않은 아이디 
		$('#regist_idValidAlert').css('display','block');
		$('#regist_idAlert').css('display','none');
		$('#regist_idSuccess').css('display','none');
		registReady=false;
		return;
	}
	
	user_id= $('#regist_id').serialize();
	$.ajax({
		data : user_id,
		async : true,
		type: "get",
		url: "/reservationmall/individual/validation.mall",
		
		success : function(data){
			data= data.trim();
			
			if(data==='newId'){ //없는 아이디
				registReady=true;
				$('#regist_idAlert').css('display','none');
				$('#regist_idSuccess').css('display','block');
				$('#regist_idValidAlert').css('display','none');
				registReady=true;
			
			}else if(data==='usedId'){ //존재하는 아이디
				registReady=false;
				$('#regist_idAlert').css('display','block');
				$('#regist_idSuccess').css('display','none');
				$('#regist_idValidAlert').css('display','none');
				registReady=false;
			}
			
		},
		error: function(){
			alert('데이터 수신 에러');
		}
	
	});
}

//이메일 중복
function isValidEmail(){
	var user_email= $('#regist_email').val();
	if(user_email.trim().length == 0 || user_email==null){
		$('#regist_emailAlert').css('display','none');
		registReady=false;
		return;
	}
	
	user_email= $('#regist_email').serialize();
	$.ajax({
		data: user_email,
		type: 'get',
		url: '/reservationmall/individual/validation.mall',
		
		success:function(data){
			data= data.trim();
			
			if(data === 'newEmail'){ //사용가능한 이메일
				$('#regist_emailAlert').css('display','none');
				registReady=true;
				
			}else if (data === 'usedEmail'){ //중복된 이메일
				$('#regist_emailAlert').css('display','block');
				registReady=false;
			}
		},
		error: function(){
			alert('데이터 수신 에러');
		}
		
	});
}

//이름 유효성
function isValidName(){
	var regK= /^[가-힣]{2,5}$/;
	var regE= /^[a-zA-Z]{2,20}$/;
	
	var name = document.getElementById('regist_name').value;
	if( (regK.test(name)==false) && (regE.test(name)==false) ){ 
		//유효하지 않은 이름
		document.getElementById('regist_nameAlert').style.display='block';
		registReady=false;
	} else{
		document.getElementById('regist_nameAlert').style.display='none';
		registReady=true;
	}
}




