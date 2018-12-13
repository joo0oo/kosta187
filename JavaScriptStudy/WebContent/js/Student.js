/**
 * 학생 객체 추상화
 */


/* 사용자 정의 객체 (생성자) */

function Student(name, korean, math, english,science){ 
  this.name= name; //this를 쓰지 않으면 그냥 지역변수로 생성됐다가 사라짐 -> this를 써야 맵에 key& value로 저장됨
  this.korean= korean;
  this.math= math;
  this.english= english;
  this.science= science;
  
  //메모리 절약을 위해 인스턴스들이 메소드 공유하도록 Prototpe 설정
  /*
  this.getSum= function(){
	  return this.korean+ this.math+ this.english+ this.science;
  }
  
  this.getAverage= function(){
	  return this.getSum() /4;
  }
  
  this.toString = function(){
	  return this.name+'\t'+this.korean+'\t'+this.math+'\t'+this.science+'\t';
  }
  */
}

//프로토타입에 메소드 저장
Student.prototype.getSum= function(){
	  return this.korean+ this.math+ this.english+ this.science;
} //Student 객체의 prototype 맵에 getSum이라는 key로 function() 이하를 저장

Student.prototype.getAverage= function(){
	  return this.getSum() /4;
}
Student.prototype.toString = function(){
	  return this.name+'\t'+this.korean+'\t'+this.math+'\t'+this.science+'\t';
}
	
Student.schoolName='KOSTA 대학교'; //java의 static처럼 사용 ->Student의 맵 안에 저장됨