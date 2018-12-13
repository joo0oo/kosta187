<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> 파일 업로드 </title>
</head>
<body>


<div class="uploadDiv">
  <input type='file' name='uploadFile' multiple>
</div>

<button id="uploadBtn">Upload</button>

<script src="https://code.jquery.com/jquery-3.3.1.min.js"
		integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
		crossorigin="anonymous">
</script>
<script type="text/javascript">
$(document).ready(function(){
	
	$('#uploadBtn').on('click',function(e){
		var formData= new FormData(); //ajax 파일 업로드
		var inputFile= $('input[name="uploadFile"]');
		var files= inputFile[0].files;
		console.log(files);
		
		for(var i=0; i<files.length; i++){
			//formData에 파일 추가
			formData.append('uploadFile',files[i]);
		}
		
		
		$.ajax({ //파일 전송 처리
			url:'/spring/uploadAjaxAction',
			processData: false,
			contentType: false,
			data: formData,
			type: 'POST',
			success:function(result){
				alert('uploaded');
			}
		});
	});
	
});
</script>

</body>
</html>
