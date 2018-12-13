/**
 * 게시판 클릭 시 게시판 내용 데이터 불러오는 AJAX통신 
 * 게시판 데이터를 불러온 후, 상세보기 클릭 시 토글 효과
 * 
 * @returns
 */






//게시판 클릭 
$('#board').on('click', function() {
	//아작스 통신 시작
	$.ajax({
		async : true, // 이거 생략하면 비동기다.
		type : "get", // 이거 빼면 디폴트가 get
		dataType : "text",
		url : "article/controller.mall",
		success : function(data) {
			// 수신한 데이터 body에 추가
			$("#abcd").append(data);
			
			
			var nameArray = $('button[name= "myhide"]');
			if ($(nameArray) != null) {
				nameArray.each(function(i, btn) {
					abc();// 모든 항목 hide를 위한 메서드
					
					
					$(nameArray[i]).on('click', function() {
						var contents = $('[name="conts"]');
						contents.each(function(j, con) {
							// 일치하는 게시물을 클릭했을 경우 
							if (i == j) {
								//console.log("입력 데이터 i "+ i);
								//console.log("입력 데이터 j "+ j);
								$(contents[j]).toggle('slow');
								
							}
						});// 이벤트 내용 끝
							
					});
				})// each
				
				
				/**
				 * 상세보기 클릭 -> 데이터 전송 
				 */
				$('button[name= "myhide"]').on('click', function() {
					var button = this;
					var articleId = $(button).closest('tr').children().eq(0).text();
					$.ajax({
						data: {articleId: articleId},
						url : "article/controller.mall",
						dataType: "text",
						success : function(data) {
							$(button).closest('tr').children().eq(4).text(data);
						}
					});
				});// hide button
				
				
			}// if
		}// success
	});// ajax
});


/**
 * 게시물 toggle효과를 닫아주는 function
 * @returns
 */
function abc() {
	var contents = $('[name="conts"]');
	contents.each(function(j, con) {
		$(con).hide();
	});
}

/**
 * 게시판 종료 후에 모든 게시물 toggle효과 닫아주기 
 * @returns
 */

$('#notice').on('hidden.bs.modal', function() {
	$.ajax({
		async : true, // 이거 생략하면 비동기다.
		type : "get", // 이거 빼면 디폴트가 get
		dataType : "text",
		url : "article/controller.mall",
		success : function(data) {
			// 수신한 데이터 body에 추가
			$("#abcd").append(data);
			var nameArray = $('button[name= "myhide"]');
			if ($(nameArray) != null) {
				nameArray.each(function(i, btn) {
					abc();//모든 항목 hide를 위한 메서드 
					
					$(nameArray[i]).on('click', function() {
						var contents = $('[name="conts"]');
						contents.each(function(j, con) {
							if (i == j) {
								$(contents[j]).toggle();
							}
						})// 이벤트 내용 끝
					});
				})// each
			}// if
		
		}// success
	});// ajax
})
