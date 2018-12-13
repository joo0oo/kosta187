
window.onload = function(){
	init();
	eventRegist();
}

function init(){
	//초기화 작업
   registForm= document.getElementById('regist-form'); 
   registBtn= document.getElementById('regist-btn');
}

function eventRegist(){
	//이벤트 등록
	document.getElementById('regist-btn').onclick= regist;
	
	
	document.getElementById('inputPassword').onkeyup=function(e){
		//isValidAccNum();
		if( e.keyCode == 13) {//키보드의 엔터(13)가 눌렸을 때

		} 
	}
	
}


function confirmPW(){
	var inputPW = document.getElementById("inputPassword").value;
	var confirmPW = document.getElementById("confirmPassword").value;
	
	if(inputPW.trim().length ==0 ){
		return false;
	}
	if(inputPW != confirmPW){ //비밀번호 다름
		return false;
	} else{
		return true;
	}
}

function regist(){
	//가입
	
	if( confirmPW()== true ){
		alert('같은 비밀번호');
		registForm.submit();
	} else{
		alert('비밀번호가 다릅니다');
	}
}
