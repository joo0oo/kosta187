$(function(){ 

	init();

	if (document.getElementById('registForm') != null) { //가입화면인 경우

		$('#regist_id').on('change', isValidId); //아이디 중복검사
		$('#regist_email').on('change', isValidEmail); //이메일 중복검사

		document.getElementById('regist_pass').onkeyup = function () {
			//비밀번호 유효성
			isValidPasswd();
		}

		document.getElementById('regist_passcheck').onkeyup = function () {
			//비밀번호 일치 확인
			isSamePasswd();
		}

		document.getElementById('regist_name').onkeyup = function () {
			//이름 유효성 확인
			isValidName();
		}

		document.getElementById('regist_age').onkeyup = function () {
			//나이 유효성 확인
			isValidAge();
		}

		document.getElementById('regist_phonnum').onkeyup = function () {
			//전화번호 유효성 확인
			isValidPhoneNum();
		}

		document.getElementById('regist_email').onkeyup = function () {
			//이메일 중복검사
			isValidEmail();
		}


		document.getElementById("registSubmitBtn").onclick = function () {
			//폼 제출
			isValidId();
			isValidEmail();
			isSamePasswd();
			isValidPasswd();
			isValidName();
			isValidAge();
			isValidPhoneNum();
			isValidEmail();

			if (registReady == true) {
				console.log('submit regist');
				var form = document.getElementById('registForm');
				form.submit();
			}
		}
	}

})

function init() {
	registReady = true;

	if (document.getElementById('registForm') != null) { //가입화면인 경우
		document.getElementById('regist_idAlert').style.display = 'none';
		document.getElementById('regist_idValidAlert').style.display = 'none';
		document.getElementById('regist_idSuccess').style.display = 'none';
	
		document.getElementById('regist_pwAlert').style.display = 'none';
		document.getElementById('regist_pwAlertSec').style.display = 'none';
		document.getElementById('regist_pwChckAlert').style.display = 'none';
	
		document.getElementById('regist_nameAlert').style.display = 'none';
		document.getElementById('regist_ageAlert').style.display = 'none';
		document.getElementById('regist_phonnumAlert').style.display = 'none';
		document.getElementById('regist_emailAlert').style.display = 'none';
	}
}

//아이디 검사
function isValidId() {
	const reg = /^\w{3,15}$/;
	var user_id = document.getElementById('regist_id').value;

	if (user_id.trim().length == 0 || user_id == null) {
		$('#regist_idAlert').css('display', 'none');
		$('#regist_idSuccess').css('display', 'none');
		$('#regist_idValidAlert').css('display', 'none');
		registReady = false && registReady;
		return;
	}

	if (!reg.test(user_id)) { //유효하지 않은 아이디 
		$('#regist_idValidAlert').css('display', 'block');
		$('#regist_idAlert').css('display', 'none');
		$('#regist_idSuccess').css('display', 'none');
		registReady = false && registReady;
		return;
	}

	user_id = $('#regist_id').serialize();
	$.ajax({
		data: user_id,
		async: true,
		type: "get",
		url: "/reservationmall/regist/validation.mall",

		success: function (data) {
			data = data.trim();

			if (data === 'newId') { //없는 아이디
				$('#regist_idAlert').css('display', 'none');
				$('#regist_idSuccess').css('display', 'block');
				$('#regist_idValidAlert').css('display', 'none');
				registReady = true && registReady;

			} else if (data === 'usedId') { //존재하는 아이디
				$('#regist_idAlert').css('display', 'block');
				$('#regist_idSuccess').css('display', 'none');
				$('#regist_idValidAlert').css('display', 'none');
				registReady = false && registReady;
			}

		},
		error: function () {
			alert('데이터 수신 에러');
		}

	});
}

//이메일 중복
function isValidEmail() {
	var user_email = $('#regist_email').val();
	if (user_email.trim().length == 0 || user_email == null) {
		$('#regist_emailAlert').css('display', 'none');
		registReady = false && registReady;
		return;
	}

	user_email = $('#regist_email').serialize();
	$.ajax({
		data: user_email,
		type: 'get',
		url: '/reservationmall/regist/validation.mall',

		success: function (data) {
			data = data.trim();

			if (data === 'newEmail') { //사용가능한 이메일
				$('#regist_emailAlert').css('display', 'none');
				registReady = true && registReady;

			} else if (data === 'usedEmail') { //중복된 이메일
				$('#regist_emailAlert').css('display', 'block');
				registReady = false && registReady;
			}
		},
		error: function () {
			alert('데이터 수신 에러');
		}

	});
}


//비밀번호 유효성 검사
function isValidPasswd() {
	var passwd = document.getElementById('regist_pass').value;
	//var passwdCheck= document.getElementById('regist_passcheck').value;

	if (document.getElementById('regist_pass').value.length > 30) {
		//너무 긴 비밀번호
		$('#regist_pwAlert').css('display', 'block');
		registReady = false && registReady;
	} else {
		$('#regist_pwAlert').css('display', 'none');
		registReady = true && registReady;
	}
}

//비밀번호 일치 검사
function isSamePasswd() {
	//var reg= /^\d{4}$/;
	var passwdCheck = document.getElementById('regist_passcheck').value;
	var passwd = document.getElementById('regist_pass').value;

	if (passwd.trim().length != 0 || passwd != null) {
		if (passwdCheck.trim().length == 0 || passwdCheck == null) {
			//비밀번호 확인 입력하세요
			$('#regist_pwAlertSec').css('display', 'block');
			registReady = false && registReady;
		} else {
			$('#regist_pwAlertSec').css('display', 'none');
			if (passwd != passwdCheck) {
				//비밀번호 불일치
				$('#regist_pwChckAlert').css('display', 'block');
				registReady = false && registReady;
			} else {
				$('#regist_pwChckAlert').css('display', 'none');
				registReady = true && registReady;
			}
		}
	}
}

//이름 유효성
function isValidName() {
	var regK = /^[가-힣]{2,5}$/;
	var regE = /^[a-zA-Z]{2,20}$/;

	var name = document.getElementById('regist_name').value;
	if ((regK.test(name) == false) && (regE.test(name) == false)) {
		//유효하지 않은 이름
		document.getElementById('regist_nameAlert').style.display = 'block';
		registReady = false && registReady;
	} else {
		document.getElementById('regist_nameAlert').style.display = 'none';
		registReady = true && registReady;
	}
}

//나이 유효성 
function isValidAge() {
	var reg = /^\d{6}$/;
	var age = document.getElementById('regist_age').value;
	if (!reg.test(age)) {
		//유효하지 않은 나이
		document.getElementById('regist_ageAlert').style.display = 'block';
		registReady = false && registReady;
	} else {
		document.getElementById('regist_ageAlert').style.display = 'none';
		registReady = true && registReady;
	}
}

//전화번호 유효성
function isValidPhoneNum() {
	var reg = /^\d{3}-\d{3,4}-\d{4}$/;
	var phoneNum = document.getElementById('regist_phonnum').value;
	if (!reg.test(phoneNum)) {
		//유효하지 않은 전화번호
		document.getElementById('regist_phonnumAlert').style.display = 'block';
		registReady = false && registReady;
	} else {
		document.getElementById('regist_phonnumAlert').style.display = 'none';
		registReady = true && registReady;
	}
}
