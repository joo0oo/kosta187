/**
 * 버튼 클릭 시 아작스 실행을 위한 자바스크립트 파일 :-0
 */

$('#sendnote_ck').on('click',function(){
	getNote();
})

	function getNote() {
	var user_id = $('#name').val();
	var note_email = $('#email').val();
	var note_question = $('#message').val();
	
	$.ajax({
		data : {
			'user_id' : user_id,
			'note_email' : note_email,
			'note_question' : note_question
		},
		url : "/reservationmall/note/controller.mall",
		success : function(data) {
			data = data.trim();
			console.log(data);
			
			
			if(data === 'success'){ //데이터 전송 성공 시
				$('#boxes').modal('show');
				
				
			}else{ //데이터 전송 실패 시 
				$('#boxesfail').modal('show');
			}
			
		},
		error : function() {
			$('#boxesfail').modal('show');
		}
	});
}