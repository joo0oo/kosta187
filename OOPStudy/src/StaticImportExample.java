import static java.lang.System.out;
import static java.lang.Math.*;

public class StaticImportExample {

	public static void main(String[] args) {
		System.out.println("피곤한 월요일");
		System.out.println(Math.max(11, 22));
		
		//static import를 하면 이렇게 써도 가능
		//현업에서는 잘 쓰는 방법은 아님
		out.println("");
		max(11,22);
		
	}
}