
public class Car extends Thread {
	
	/*
	String name;
	
	public Car(String name) {
		this.name = name; //Thread 클래스에 이미 name이 존재해서 이렇게 안써도 된다
	}
	*/
	
	public Car(String name) {
		//super(name);
		setName(name);
	}
	
	public void run() { //이 쓰레드의 entry point
		System.out.println(getName()+" 자동차가 start");
		for(int i=0; i<100; i++) {
			System.out.println(getName()+"자동차 "+ i+"m 전진"); //paint()로 x축으로 이동
			try {
				Thread.sleep(100);//Interrupt 거는 작업 : Thread 잠깐 쉬기
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
		}
		System.out.println(getName()+" 자동차가 finish");
	}
}
