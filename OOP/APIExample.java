/**
 * 자바 표준 API의 기본 클래스 사용하기
 *
 */
public class APIExample {
	public static void main(String[] args)	{
		// 명시적 생성
		String str;
		//str= new String(); //디폴트 생성자 호출
		str= new String("자바가 시러욧"); //생성자 호출
		
		//묵시적 생성 (String만 가능)
		str="김기정 바보"; 
		
		int length= str.length();
		System.out.println(length);

		char c=str.charAt(0); //
		System.out.println(c);
		
		int x=-20;
		System.out.println(Math.abs(x));

	}
}
