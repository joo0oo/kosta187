/**
 * 상속 개념 이해하기
 * @author 송주현
 *
 */

public class Bicycle /* extends Object */ { //extends Object가 항상 자동으로 추가됨 : 모든 Java 클래스의 부모는 Object 
	int id;
	String brand;
	
	public Bicycle() {
		this(0,null);
	}
	
	public Bicycle (int id, String brand) {
		this.id= id;
		this.brand=brand;
	}
	
	public void running() {
		System.out.println("자전거가 달립니다");
	}
}
