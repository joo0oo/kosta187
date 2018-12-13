
public class PolymorphismExample {

	public static void main(String[] args) {
		//클래스 형변환 (up casting) : 부모 타입에 자식을 생성
		Shape shape= null;
		//shape = new Shape();
		
		shape = new Circle(10,10,20); //업캐스팅
		System.out.println(shape);
		shape = new Rectangle(10,10,50,20);//업캐스팅
		System.out.println(shape);
		
		//System.out.println(shape.getX()); //원래 부모에 있던 메소드
		//System.out.println(shape.getWidth()); //불가능 (자식에서 추가된 메소드)
		System.out.println(shape.getArea()); //오버라이딩된 메소드라서 가능
		
		//자식에서 추가된 속성이나 메소드를 접근하기 위해 Down Casting 필요
		Rectangle rectangle = (Rectangle)shape; //다운캐스팅
		System.out.println(rectangle.getWidth()); //이제 부모에는 없고 자식에서 추가된 메소드 사용가능
		
		System.out.println(shape instanceof Shape);
		System.out.println(shape instanceof Rectangle);
		System.out.println(shape instanceof Circle);
	}

}
