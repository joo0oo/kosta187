
public class ShapeApp {

	public static void main(String[] args) {
	//	Shape shape = new Shape(12.3,33.1);
	//	shape.draw();
		
		Circle circle = new Circle(15.0,15.0,22.2);
		circle.draw();
		System.out.println("circle area : " +circle.getArea());
		System.out.println("circle length : "+circle.getLength());
		
		Rectangle rectangle = new Rectangle(0.0,0.0,33.3,22.2);
		rectangle.draw();
		System.out.println("rectangle length : "+rectangle.getLength());
		System.out.println("rectangle area : "+rectangle.getArea());
		
//		System.out.println(shape); //이렇게 써도 toString임
//		System.out.println(shape.toString());
		//여기서 만약 숫자가 찍힌다면 C처럼 포인터라고 표현할테지만 그게 아님
		//이거 출력하면 [클래스이름]@[주소] 이렇게 나옴 (Shape@7852e922)
		//VM이 포인터를 숨기기 위해서 이렇게 만들어둠
		
		String str= "Java Programming"; //String도 하나의 클래스임. str 자체를 출력하면 shape처럼 해시주소까지 찍혀나와야 할것 (객체 이름은 주소라서)
		System.out.println(str); //하지만 여기서 출력하면 str에 저장된 데이터가 출력됨
		//즉 toString이 오버라이딩 된것 (이미 String객체에서 오버라이딩 되어있다) 따라서 주소값 출력이 아니라 문자열 데이터 내용이 출력됨
		//사용자에게 String 객체의 주소값을 보여줘봤자 아무 소용이 없기 때문에 의미있는 형태로 미리 오버라이딩 해둔 것
		//모든 객체를 만들때 toString()을 오버라이딩해주는 것이 좋다 (주소값 찍어봤자 의미없기때문)
		
		
		System.out.println(circle.toString());
		System.out.println(rectangle.toString());
		
	}

}
