
public class Foo {
	public void someMethod(){
	//	String message= null;
	//	System.out.println(message.length()); //여기서 new NullPointerException이라는 객체가 만들어짐 
		
	//	System.out.println(10/0); //java.lang.ArithmeticException: / by zero
		
		int[] arr= {1,2,3};
		System.out.println(arr[3]); //java.lang.ArrayIndexOutOfBoundsException: 3
	}
	
	public void someMethod2(){
		try {
			String message= null;
			System.out.println(message.length()); //여기서 new NullPointerException이라는 객체가 만들어짐 
			
			System.out.println(10/0); //java.lang.ArithmeticException: / by zero
			
			int[] arr= {1,2,3};
			System.out.println(arr[3]); //java.lang.ArrayIndexOutOfBoundsException: 3
		}catch (NullPointerException e) {
			System.out.println("인스턴스 생성 안 됨"); //프로그램 셧다운 안되고 출력문만 출력
			System.out.println(e.getMessage());
			e.printStackTrace();
		}catch (ArithmeticException e) {
			System.out.println("인스턴스 생성 안 됨"); //프로그램 셧다운 안되고 출력문만 출력
			System.out.println(e.getMessage());
			e.printStackTrace();
		}catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("인스턴스 생성 안 됨"); //프로그램 셧다운 안되고 출력문만 출력
			System.out.println(e.getMessage());
			e.printStackTrace();
		}catch (Exception e) { //switch-case의 default처럼 다형성을 적용해서 혹시 위의 경우에 벗어나는 예외를 처리
			System.out.println("인스턴스 생성 안 됨"); //프로그램 셧다운 안되고 출력문만 출력
			System.out.println(e.getMessage());
			e.printStackTrace();
		}finally {
			System.out.println("예외 발생 여부와 상관 없이 항상 실행되는 코드");
		}
		
	}
	
	public void someMethod3() throws NullPointerException,ArithmeticException,ArrayIndexOutOfBoundsException {
		String message= null;
		System.out.println(message.length()); //여기서 new NullPointerException이라는 객체가 만들어짐 
		
		System.out.println(10/0); //java.lang.ArithmeticException: / by zero
		
		int[] arr= {1,2,3};
		System.out.println(arr[3]); //java.lang.ArrayIndexOutOfBoundsException: 3
	}
	
	public static void main(String[] args) {
		System.out.println("JVM에 의해 프로그램 시작..");
		
		Foo foo= new Foo();
		//foo.someMethod();
		//foo.someMethod2();
		
		try { //throws 로 예외처리
			foo.someMethod3();
		}catch (Exception e) { //main에서 예외 처리해줌
			System.out.println("main에서 모든 예외 처리 완료");
		}
		
		System.out.println("JVM에 의해 프로그램 종료..");
	}
}
