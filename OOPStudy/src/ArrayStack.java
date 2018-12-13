/**
 * 과제 : 배열로 stack 구현 (클래스로 구현)
 * LIFO 구조의 스택구현
 * @author 송주현
 *
 */

public class ArrayStack {
	
	private int[] array;
	private int top=-1;
	
	ArrayStack(int size){ //생성자
		array=new int[size];
	}
	
	/**
	 * 스택에 새로 값 추가
	 * @param value
	 */
	public void push(int value) {
		this.top++;
		this.array[top]=value;		
	}
	
	/**
	 * 스택에 저장된 값 추출 (맨 마지막에 저장된 것부터)
	 * @return 제일 나중에 저장된 값 (제일 위에 있는 값)
	 */
	public int pop() {
		int val = this.array[top];
		this.array[top]=0;
		top--;
		return val;
	}
	
	/**
	 * 스택의 사이즈 구하기
	 * @return 스택의 사이즈(top+1) 리턴 
	 */
	public int length() { //스택의 사이즈 리턴	
		return this.top+1;
	}
	
	/**
	 * 스택 내용 출력
	 */
	public void print() {
		for (int i = 0; i < this.top+1; i++) {
			System.out.println(array[i]);
		}
	}
	
	public static void main(String[] args) {
		ArrayStack stack= new ArrayStack(20); //생성자 파라미터는 만들 스택의 사이즈
		
		stack.push(5);
		stack.push(15);
		stack.push(55);
		
		//테스트를 위한 stack 출력
		stack.print();
		
		System.out.println();
		//pop출력
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		
		System.out.println();
		//push-pop 연산 이후 스택의 length 출력 -> 0이 나와야 함
		System.out.println(stack.length());
		
	}
}