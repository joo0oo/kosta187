/**
 * 학생 객체 추상화
 */


var kosta = {}; // object를 java의 패키지처럼 활용
kosta.school= {}; 

kosta.school.Student = function(name, korean, math, english, science) {
	this.name = name; 
	this.korean = korean;
	this.math = math;
	this.english = english;
	this.science = science;
}
