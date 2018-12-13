
public class OuterClass {
	
	enum Direction{ //
		A,B,C
	}
	
	class InnerClass{ //멤버 내부 클래스
		public void foo() {
			System.out.println("foo 호출됨");
		}
	}
	
	static class SInnerClass{ //스태틱 내부 클래스
		public void bar() {
			System.out.println("bar 호출됨");
		}
	}

}
