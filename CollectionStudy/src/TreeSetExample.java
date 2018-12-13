import java.util.Set;
import java.util.TreeSet;

public class TreeSetExample {

	public static void main(String[] args) {
		Set<String> set=new TreeSet<String>();
		set.add("김기정");
		set.add("홍기정");
		set.add("이기정");
		set.add("박기정");
		set.add("최기정");
		set.add("bbbb기정");
		set.add("aaaa");
		// add와 동시에 정렬 : add 연산 속도가 오래 걸림
		// 이렇게 섞어서 저장해도 정렬되어 나옴
		
		for (String string : set) {
			System.out.println(string);
		}
	}

}
