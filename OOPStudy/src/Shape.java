/**
 * 모든 도혀의 공통적인 속성과 기능 정의
 * @author 송주현
 *
 */
public abstract class Shape { //추상클래스 선언
	//private double x,y;
	protected double x,y; //추상클래스에서는 변수를 protected로 설정
	
	/*08.24 : 이제 추상클래스가 되었으므로 getter/setter 사용할 필요가 없어짐
	public Shape() {
		//super(); //꼭 명시적으로 호출하지 않아도 자동 호출됨 (안써도 상관없음)
		//여기에 아무것도 쓰지 않는다면 double형 자동 초기화 (0.0으로)
		this(0.0, 0.0);
	}


	public Shape(double x, double y) {
		//super(); //꼭 명시적으로 호출하지 않아도 자동 호출됨 (안써도 상관없음)
		this.x = x;
		this.y = y;
	}


	public double getX() {
		return x;
	}


	public void setX(double x) {
		this.x = x;
	}


	public double getY() {
		return y;
	}


	public void setY(double y) {
		this.y = y;
	}	
	*/
	
	//추상 메소드
	//서브클래스가 반드시 구현(재정의)해야 할 수직적 규약 
	public abstract void draw();  //추상 메서드 (구현x 틀만 잡기)
	
	public abstract double getLength();
	
	public abstract double getArea();
	
	
	@Override
	public String toString() {
		return x+" , "+ y+" 의 도형입니다..";
	}
	
}
