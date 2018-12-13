window.onload = function(){
	eventRegist();
	document.getElementById("registerBtn").onclick = function(){
		location.href = "/reservationmall/login/regist_form.mall";
	}
}

function setCookie(cname,cvalue) {
    var d = new Date();
    var expires = "expires=" + d.toGMTString();
    document.cookie = cname + "=" + cvalue + ";" + expires + ";path=/";
}

function searchHotel(hotelName){
	$("#searchValueType option:eq(1)").attr("selected", "selected");
	$("#searchValueInput").val(hotelName);
	location.href="#search";
}

function addWishList(hotel_id){
	if(getCookie('loginId').length ==undefined || getCookie('loginId').length ==0){
		$("#hotelMapInfo"+hotel_id).text("로그인이 필요한 기능입니다.");
		setTimeout(function(){
			$("#hotelMapInfo"+hotel_id).text("");
		},3000);
		return null;
	}
	
	$.ajax({
		type : "post",
		url : '/reservationmall/wishlist.mall',
		data : {
			hotel_id : hotel_id,
			user_id : getCookie('loginId')
		},
		dataType : "text",
		success : function(resultType) {
			if(resultType.trim()=='success'){
				$("#hotelMapInfo"+hotel_id).text("위시리스트에 등록되었습니다.");
				setTimeout(function(){
					$("#hotelMapInfo"+hotel_id).text("");
				},3000);
			}else if(resultType.trim()=="exist"){
				$("#hotelMapInfo"+hotel_id).text("이미 등록된 호텔입니다.");
				setTimeout(function(){
					$("#hotelMapInfo"+hotel_id).text("");
				},3000);
			}else{
				$("#hotelMapInfo"+hotel_id).text("등록 실패");
				setTimeout(function(){
					$("#hotelMapInfo"+hotel_id).text("");
				},3000);
			}

		},
		error : function() {
			console.log('실패');
		}
	});
	
}

function getCookie(cname)
{
    var name = cname + "=";
    var decodedCookie = decodeURIComponent(document.cookie);
    var ca = decodedCookie.split(';');
    for(var i=0; i<ca.length; i++)
    {
        var c = ca[i];
        while(c.charAt(0) == ' ')
        {
            c = c.substring(1);
        }
        if(c.indexOf(name) == 0)
        {
            return c.substring(name.length, c.length);
        }
    }
    return "";
}

function eventRegist(){
	document.getElementById("registerBtn").onclick = function(){
		location.href = "/jsp/login/regist_form.jsp";
	}
	if(document.getElementById("logoutBtn")!=null){
		document.getElementById("logoutBtn").onclick = function(){
			setCookie('loginId', '');
			location.replace('/index.jsp');
		}
	}

	document.getElementById("loginBtn").onclick = function(){
		var id = null;
		var pw = null;
		if(document.getElementsByName("userid")[0].value.length == 0 ){
			document.getElementById("idAlert").setAttribute('style', 'display:block;');
			return false;
		}else if(document.getElementsByName("userpw")[0].value.length==0){
			document.getElementById("pwAlert").setAttribute('style', 'display:block;');
			return false;
		}else{
			id = document.getElementsByName("userid")[0];
			pw = document.getElementsByName("userpw")[0];
		}
	
		if(id.value.match(/[a-zA-Z0-9_]{6,10}$/)!=id.value){
			document.getElementById("idAlert").setAttribute('style', 'display:block;');
			return false;
		}else if(pw.value.match(/[a-zA-Z0-9_]{4,12}$/)!=pw.value){
			document.getElementById("pwAlert").setAttribute('style', 'display:block;');
			return false;
		}else{
			loginform.submit();
		}
	}
	
	document.getElementById("login_id").onclick = function(){
		document.getElementById("loginAlert").setAttribute('style', 'display:none;');
		document.getElementById("idAlert").setAttribute('style', 'display:none;');
		document.getElementById("pwAlert").setAttribute('style', 'display:none;');
	}
	
	document.getElementById("login_pw").onclick = function(){
		document.getElementById("loginAlert").setAttribute('style', 'display:none;');
		document.getElementById("idAlert").setAttribute('style', 'display:none;');
		document.getElementById("pwAlert").setAttribute('style', 'display:none;');
	}
}
