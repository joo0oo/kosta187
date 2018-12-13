
public class StringExample {

	public static void main(String[] args) {
		
		//명시적 생성
		String str1 = new String("Java Programming");
		String str2 = new String("Java Programming");
		// 레퍼런스 비교
		if(str1 == str2){
		     System.out.println("레퍼런스 같다.");
		}else{
		     System.out.println("레퍼런스 다르다.");
		}

		//묵시적 생성 (String Pool에서 관리)
		String str3 = "Java Programming";
		String str4 = "Java Programming";
		// 레퍼런스 비교
		// 문자열 상수를 이용한 생성시 StringPool에서
		// 검색 후 존재하지 않을 경우 새로 생성
		if(str3 == str4){
		     System.out.println("레퍼런스 같다.");
		}else{
		     System.out.println("레퍼런스 다르다.");
		}
		
		System.out.println(str1 == str3); //주소 비교
		System.out.println(str1.equals(str3)); //내용 비교
		
		
		//String의 주요 메소드 테스트
		String message = "Java Programming";
		System.out.println(message.substring(5));
		System.out.println("Java Programming".substring(5));
		System.out.println(message.substring(5,8)); //Pro
		
		System.out.println("김기정".concat("바보"));
		System.out.println("JavaJava".replace('J','K'));
		System.out.println("JavaJava".replaceAll("Java","김기정"));
		
		String ssn="680313-1234567";
		/*
		 *체이닝된 코드 -> 바람직하진 않음
		int index= ssn.indexOf('-')+1; //'-'의 인덱스 리턴
		char c= ssn.charAt(7);
		*/ 
		char c= ssn.charAt(ssn.indexOf('-')); // 체이닝 해결 (c도 없애고 바로 switch에 넣는게 좋음)
		switch(c) {
			case '1' : System.out.println("2000년 이전 출생 남자"); break;
			case '2' : System.out.println("2000년 이전 출생 여자"); break;
			case '3' : System.out.println("2000년 이후 출생 남자"); break;
			case '4' : System.out.println("2000년 이후 출생 여자"); break;
			
			default: System.out.println("외국인");
		}
		System.out.println("               J  av     a          ");
		System.out.println("               J  av     a          ".trim()); //trim() : 공백제거
		
		int num = 1015320532;
		System.out.println(String.valueOf(num)); //valueOf()는 그 데이터를 String으로 바꿔주는 오버로딩 된 함수 (각 데이터 타입별로 가능)
		
		//shift+F2 : API Document 조회
		
		
		

	}

}
