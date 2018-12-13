
public class ThreadExample2 {
	
	static class MyThread extends Thread{
		//바로 테스트하기 위한 내부클래스 
		
		public MyThread (String name) {
			super(name);
		}
		
		@Override
		public void run() {
			System.out.println(getName()+"쓰레드 시작");
			for(int i=0; i<Integer.MAX_VALUE; i++) {
				try {
					if(i % 10000 == 0) {
						Thread.sleep(1);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println(getName()+"쓰레드 종료");
		}
	}
	
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName()); //현재 돌아가는 쓰레드 이름 : 여기서는 메인쓰레드
		
		System.out.println("프로그램 시작");
		
		
		MyThread t1= new MyThread("방그리");
		t1.setPriority(Thread.MIN_PRIORITY); //우선순위 최고
		
		MyThread t2= new MyThread("소연이");
		t2.setPriority(Thread.MAX_PRIORITY ); //우선순위 최저

		MyThread t3=new MyThread("t3");
		MyThread t4=new MyThread("t4");
		MyThread t5=new MyThread("t5");
	
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		
		System.out.println("프로그램 종료");
	}

}
