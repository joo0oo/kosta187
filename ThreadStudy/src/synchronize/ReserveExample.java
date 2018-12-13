package synchronize;

public class ReserveExample {
	public static void main(String[] args) {
		// 멀티스레드에 의해 공유되는 객체 생성
		MovieReserveSystem reserveSystem = new MovieReserveSystem(10);
		
		// 테스트를 위한 고객 스레드 생성 및 실행
		Member m1 = new Member("찬호", reserveSystem);
		Member m2 = new Member("지성", reserveSystem);
		Member m3 = new Member("승엽", reserveSystem);
		Member m4 = new Member("재석", reserveSystem);
		Member m5 = new Member("소미", reserveSystem);
		Member m6 = new Member("현아", reserveSystem);
		
		m1.start();
		m2.start();
		m3.start();
		m4.start();
		m5.start();
		m6.start();
	}
}