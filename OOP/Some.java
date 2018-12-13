package kr.or.kosta;

import kr.or.kosta.school.Student; //사용할 패키지명.클래스 (선언형)

public class Some {


	public static void main(String[] args)	{
		System.out.println();
		
		Student student; //서로 다른 패키지에 있어서 컴파일 불가능 (사용할 패키지명을 명시해야 함 : import 사용해서 해결)

		kr.or.kosta.school.Student student2; //인라인 import : 선언을 따로 하지 않고 inline으로 사용
		System.out.println("점심먹고 합시다");
	}
}

