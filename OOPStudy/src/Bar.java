
public class Bar {

	@Deprecated	
	public void some() { //더 이상 이 메서드를 사용하지 않을것임
		System.out.println("썸..");
	}
	
	/*
	@Override
	public void myMethod() { //오버라이딩한 메서드가 아니라서 컴파일러가 에러 띄움 
		System.out.println("어노테이션 테스트");
	}
	*/
	
	@Override
	public String toString() {
		return "어노테이션 테스트";
	}
	
	public static void main(String[] args) {
		Bar bar=new Bar();
		bar.some(); //@Deprecated 결과 
	}
}
