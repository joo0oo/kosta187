$(function(){ 

	var writeRatingList= $('#writeReviewForm span[name="star-rating"]');
	
	if( $(writeRatingList) != null ){
		writeRatingList.each(function(i,list){
			setStarRating(list);
		})
	}
	
	
 
})
 
 function setStarRating(ratingList){
	var ratingSpans=$(ratingList).find('span');
	var ratingVal= $(ratingList).find('input[type="hidden"]');
	
	var star1= ratingSpans[0];
	var star2= ratingSpans[1];
	var star3= ratingSpans[2];
	var star4= ratingSpans[3];
	var star5= ratingSpans[4];
	
	$(star1).on('click',function(){
		$(ratingVal).removeAttr('value');
		$(ratingVal).attr('value','1');
		star1checked(star1,star2,star3,star4,star5);
	});
	
	$(star2).on('click',function(){
		$(ratingVal).removeAttr('value');
		$(ratingVal).attr('value','2');
		star2checked(star1,star2,star3,star4,star5);
	});
	
	$(star3).on('click',function(){
		$(ratingVal).removeAttr('value');
		$(ratingVal).attr('value','3');
		star3checked(star1,star2,star3,star4,star5);
	});
	
	$(star4).on('click',function(){
		$(ratingVal).removeAttr('value');
		$(ratingVal).attr('value','4');
		star4checked(star1,star2,star3,star4,star5);
	});
	
	$(star5).on('click',function(){
		$(ratingVal).removeAttr('value');
		$(ratingVal).attr('value','5');
		star5checked(star1,star2,star3,star4,star5);
	});
	
	
	
}

function readStarRating(readRatingList){
	readRatingList.each(function(i,list){
		
		var ratingSpans=$(list).find('span');
		var ratingVal= $(list).find('input').attr('value');
	//	console.log(list);
	//	console.log(ratingVal);
			
		var star1= ratingSpans[0];
		var star2= ratingSpans[1];
		var star3= ratingSpans[2];
		var star4= ratingSpans[3];
		var star5= ratingSpans[4];
			
		switch(ratingVal){
			case '1':
				star1checked(star1,star2,star3,star4,star5);
				break;
			case '2':
				star2checked(star1,star2,star3,star4,star5);
				break;
			case '3':
				star3checked(star1,star2,star3,star4,star5);
				break;
			case '4':
				star4checked(star1,star2,star3,star4,star5);
				break;
			case '5':
				star5checked(star1,star2,star3,star4,star5);
				break;
			default:
				break;
			}
	})
}

function star1checked(star1,star2,star3,star4,star5,ratingVal){
	
	$(star1).removeClass('unchecked-star');
	$(star1).addClass('checked-star');

	$(star2).removeClass('checked-star');
	$(star2).addClass('unchecked-star');
	$(star3).removeClass('checked-star');
	$(star3).addClass('unchecked-star');
	$(star4).removeClass('checked-star');
	$(star4).addClass('unchecked-star');
	$(star5).removeClass('checked-star');
	$(star5).addClass('unchecked-star');
}

function star2checked(star1,star2,star3,star4,star5,ratingVal){
	
	$(star1).removeClass('unchecked-star');
	$(star1).addClass('checked-star');
	$(star2).removeClass('unchecked-star');
	$(star2).addClass('checked-star');


	$(star3).removeClass('checked-star');
	$(star3).addClass('unchecked-star');
	$(star4).removeClass('checked-star');
	$(star4).addClass('unchecked-star');
	$(star5).removeClass('checked-star');
	$(star5).addClass('unchecked-star');
}

function star3checked(star1,star2,star3,star4,star5,ratingVal){
	
	$(star1).removeClass('unchecked-star');
	$(star1).addClass('checked-star');
	$(star2).removeClass('unchecked-star');
	$(star2).addClass('checked-star');
	$(star3).removeClass('unchecked-star');
	$(star3).addClass('checked-star');


	$(star4).removeClass('checked-star');
	$(star4).addClass('unchecked-star');
	$(star5).removeClass('checked-star');
	$(star5).addClass('unchecked-star');
}

function star4checked(star1,star2,star3,star4,star5,ratingVal){

	$(star1).removeClass('unchecked-star');
	$(star1).addClass('checked-star');
	$(star2).removeClass('unchecked-star');
	$(star2).addClass('checked-star');
	$(star3).removeClass('unchecked-star');
	$(star3).addClass('checked-star');
	$(star4).removeClass('unchecked-star');
	$(star4).addClass('checked-star');


	$(star5).removeClass('checked-star');
	$(star5).addClass('unchecked-star');
}

function star5checked(star1,star2,star3,star4,star5,ratingVal){
	
	$(star1).removeClass('unchecked-star');
	$(star1).addClass('checked-star');
	$(star2).removeClass('unchecked-star');
	$(star2).addClass('checked-star');
	$(star3).removeClass('unchecked-star');
	$(star3).addClass('checked-star');
	$(star4).removeClass('unchecked-star');
	$(star4).addClass('checked-star');
	$(star5).removeClass('unchecked-star');
	$(star5).addClass('checked-star');
}

