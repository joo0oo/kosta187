/**
 * 
 * 레퍼런스타입 배열 선언, 생성, 초기화
 *  * @author 송주현
 *
 */
public class ArrayExample3 {

	public static void main(String[] args) {
		String[] teams; //string도 클래스임
		teams= new String[10]; //현재 모두 null로 초기화된 상태
		teams[0] = "두산 베어스";//teams[0]는 String 객체를 저장하기 위한 레퍼런스 변수
		teams[1] = "SK 와이번즈";
		teams[2] = "한화 이글즈";
		teams[9] = "NC 다이노즈";
		
		for (int i = 0; i < teams.length; i++) {
			int count=0;
			if(teams[i] != null) {
				
				count=teams[i].length();
			}
			
			System.out.println((i+1)+" 위 "+teams[i]+"  ("+count+") ");
		}

	}

}
