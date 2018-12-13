
public class CarExample {

	public static void main(String[] args) {
		System.out.println("메인스레드에 의해 프로그램 시작됨");
		
		Car car1=new Car("방그리");
		//car.run(); //쓰레드를 상속받았어도 메서드를 직접 호출하면 쓰레드처럼 동작하지 않음
		car1.start(); //Thread의 start()를 호출해야 독립적으로 동작함
		
		Car car2=new Car("car2");
		car2.start();
		
		Car car3=new Car("car3");
		car3.start();
		
		System.out.println("메인스레드에 의해 프로그램 종료됨");

	}

}
