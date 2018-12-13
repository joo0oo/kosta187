import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Set은 데이터의 중복 저장 없이 데이터를 관리하기 위한 규약(인터페이스)이다.
 * 순서와 관련 없이 데이터를 관리한다.
 * HashSet이 Set 인터페이스를 구현한 대표적인 클래스이다
 * @author 송주현
 *
 */
public class SetExample {

	//Set은 배열과 비슷하지만, 중복 저장을 하지 않는다
	public static void main(String[] args) {
		Set set = null;
		set = new HashSet(10);
		
		set.add("황의조");
		set.add("손흥민");
		set.add("바나나");
		set.add(100); //내부적으로 오토박싱 발생 : Object obj=100;
		set.add(new Integer(100)); 
		set.add(Calendar.getInstance());
		set.add("황의조");
		
		System.out.println("담겨진 갯수 : "+set.size()); //원소 개수 출력
		// 중복된 원소 제외하고 개수 출력됨
		System.out.println("비어있는지 여부 : "+set.isEmpty());
		
		
		Set boddari = new HashSet();
		boddari.add("aaaa");
		boddari.add("bbbb");
		boddari.add("cccc");
		
		set.addAll(boddari);
		System.out.println("담겨진 갯수 : "+set.size()); //원소 개수 출력
		
		boolean result = set.remove("바나나");
		System.out.println("삭제 결과 :"+result);
		
		System.out.println(set.contains("황의조")); //set 안에 이 원소가 존재하면 true 리턴
		System.out.println(set.contains(Calendar.getInstance())); //이건 false (아까의 Calendar와 다름)
		
		//Set 안의 원소들을 하나씩 출력하는 방법
		//방법1
		Object[] list = set.toArray();
		for (Object object : list) {
			if(object instanceof String) {
				System.out.println(((String) object).length());
			}
			System.out.println(object);
		}
		//방법2
		Iterator iter=set.iterator(); //반복자
		while(iter.hasNext()) { //hasNext() 다음 가져올 것이 있으면 true
			Object obj = iter.next(); //오브젝트타입 리턴
			System.out.println(obj);
		}
		
		//요즘은 방법1 방법2 모두 잘 쓰지 않음 : 확장 for문을 사용
		for (Object object : set) {
			System.out.println(object);
		}
	}

}
