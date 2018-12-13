
public class SystemExample {

	public static void main(String[] args) {
		System.out.println("프로그램 실행..");
		
		
		System.gc(); //가비지 콜렉터 실행
		
	
		
		
		long start = System.currentTimeMillis(); //프로그램 실행 시간 체크할때 많이 사용
		
		int num=0;
		 for(int i=0; i<1000000; i++) {
			 /* 프로그램  */
			 num++;
		 }
		long end= System.currentTimeMillis(); 
		System.out.println(end-start); //프로그램 수행시간 체크
		
		System.out.println(System.getenv("path"));
		System.out.println(System.getenv("java_home"));
		
		System.exit(0); //프로세스 종료 (0: 정상종료) ->이 이후의 문장은 실행되지 않음
		
		System.out.println("프로그램 종료.."); 
	}

}
