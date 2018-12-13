/**
 * 상속 개념 이해하기
 * @author 송주현
 *
 */
public class MountainBicycle extends Bicycle{
	
	
	//자식 클래스의 추가 속성
	String frame;
	boolean suspension;
	
	public MountainBicycle() { //생성자는 디폴트 포함해서 항상 두개정도 만들어 주는게 좋음
		// 지금 눈에 보이지는 않지만 모든 생성자의 맨 첫줄에는 부모의 디폴트생성자 가 호출됨
		// super();
		this(null, false);
	}
	
	public MountainBicycle(String frame, boolean suspension) { //부모의 생성자를 상속받을 수 없으므로 자식에서 새로 생성
		// 지금 눈에 보이지는 않지만 모든 생성자의 맨 첫줄에는 부모의 디폴트생성자 가 호출됨
		// super();
		this.frame = frame;
		this.suspension = suspension;
	}
	
	public MountainBicycle(int id, String brand, String frame, boolean suspension) {
	//	this.id=id;
	//	this.brand=brand; //부모클래스의 멤버 초기화  ->이렇게 사용하지 맙시다
		
		//여기서는 명시적으로 super(int,string);를 호출했기 때문에 super();가 호출되지 않는다
		super(id,brand); //부모클래스의 생성자 호출
		this.frame=frame;
		this.suspension=suspension;
	}
	
	public void running() { //부모의 메서드 오버라이딩
		System.out.println("자전거가 산도 달립니다");
	}
}
