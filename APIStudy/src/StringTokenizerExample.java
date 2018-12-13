import java.util.StringTokenizer;

public class StringTokenizerExample {

	public static void main(String[] args) {
		
		String date="2018-08-23";
		StringTokenizer str= new StringTokenizer(date, "-"); //date를 - 로 분리
		
		String num="5555 222 3333";
		StringTokenizer str2= new StringTokenizer(num, " ");
		StringTokenizer str3= new StringTokenizer(num); //디폴트 생성자가 공백문자라서 이것도 가능
		
		
		System.out.println("토큰 갯수 : "+str.countTokens());
		while(str.hasMoreTokens()) {
			String token= str.nextToken(); 
			System.out.println(token);
			/*
			 * 1회차 : token에 2018 저장
			 * 2회차 : token에 08
			 * 3회차 : token에 23저장
			 * 4회차 : hasMoreTokens()가 false 반환해서 반복문 탈출
			 */
		}
	}

}
