import java.util.LinkedList;
import java.util.Stack;

public class QueueExample {

	public static void main(String[] args) {
		LinkedList<String> queue= new LinkedList<>();
		queue.offer("aaa");
		queue.offer("bbb");
		queue.offer("ccc");
		
		queue.poll();
		queue.poll();
		System.out.println(queue.poll()); //FIFO 이므로 ccc
		
	}

}
