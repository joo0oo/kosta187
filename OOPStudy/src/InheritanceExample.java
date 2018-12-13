/**
 * 상속 개념 이해하기
 * @author 송주현
 *
 */
public class InheritanceExample {

	public static void main(String[] args) {
		Bicycle bicycle;
		bicycle = new Bicycle(10, "삼천리");		
		System.out.println(bicycle.brand);
		
		MountainBicycle mountainBicycle = new MountainBicycle(); 
		//자식 클래스가 생성되면 부모 클래스도 같이 자동으로 생성됨
		System.out.println(mountainBicycle.brand); 
		//현재 자식 클래스의 생성자가 비어있음 ->지금 찍힌 인스턴스 변수 brand는 부모인 Bicycle 객체 안에 있는 변수임
		//brand는 부모로부터 재사용
		
		System.out.println(mountainBicycle.frame);
		System.out.println(mountainBicycle.suspension); 
		//frame과 suspension은 자식 클래스에서 추가된 변수 ->확장 (extension)
		
		
		MountainBicycle mountainBicycle2= new MountainBicycle("카본", true);
		System.out.println(mountainBicycle2.frame);
		System.out.println(mountainBicycle2.suspension); 
		
		MountainBicycle mountainBicycle3 = new MountainBicycle(10,"삼천포","카본",true); //부모 클래스의 생성자를 자동으로 호출하게 됨
		System.out.println(mountainBicycle3.frame);
		System.out.println(mountainBicycle3.suspension);
		
		/*
		 * 객체 생성 과정
		 * MountainBicycle 생성자 호출
		 * Object -> Bicycle -> MountainBicycle 순서로 생성
		 * 
		 */
		
		bicycle.running();
		mountainBicycle.running(); //부모의 메소드를 재사용
		
	}
}
