public class Calculator {
	
	public static int sum(int x, int y) {		
		return x+y;
	}
	
	public static double sum(double x, double y) {		//메소드 오버로딩 (중복 정의)
		return x+y;
	}
	
	public static void main(String[] args) {
		sum(10,20); //그냥 이렇게 호출도 가능 : 같은 클래스 안에 있는 메소드라서
		Calculator.sum(10,20); //이렇게 호출도 가능 : static 메소드라서
		//인스턴스 메소드는 인스턴스 생성 후 호출해야함
		
		System.out.println(sum(7,8));
		System.out.println(sum(3.0154,5.8989));
		
	}

}
