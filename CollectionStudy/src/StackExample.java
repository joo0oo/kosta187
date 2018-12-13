import java.util.Stack;

public class StackExample {

	public static void main(String[] args) {
		Stack<String> stack=new Stack<String>();
		stack.push("aaa");
		stack.push("bbb");
		stack.push("ccc");
		System.out.println(stack.size()); //저장된 갯수
		System.out.println(stack.pop());
		System.out.println(stack.size());
		System.out.println(stack.peek());
		System.out.println(stack.size());
		
	}

}
