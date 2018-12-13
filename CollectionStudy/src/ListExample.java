import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * List 는 순서를 통해 데이터를 관리하기 위한 규약(인터페이스)이다.
 *  Set과 달리 요소가 순차적으로 관리되며, 중복을 허용하는 특징을 가진다.
 *   ArrayList, Vector, LinkedList가 List 인터페이스를 구현한 대표적 클래스이다
 * @author 송주현
 *
 */
public class ListExample {

	//Set은 배열과 비슷하지만, 중복 저장을 하지 않는다
	public static void main(String[] args) {
		List list = null;
		list = new ArrayList();
		list.add("황의조");
		list.add("손흥민");
		list.add("바나나");
		list.add(100); //내부적으로 오토박싱 발생 : Object obj=100;
		list.add(new Integer(100)); 
		list.add(Calendar.getInstance());
		list.add("황의조");
		
		System.out.println("담겨진 갯수 : "+list.size()); //원소 개수 출력
		// 중복된 원소 고려하지 않고 개수 출력됨 : set과 다름
		System.out.println("비어있는지 여부 : "+list.isEmpty());
		
		
		Set boddari = new HashSet();
		boddari.add("aaaa");
		boddari.add("bbbb");
		boddari.add("cccc");
		
		list.addAll(boddari);
		System.out.println("담겨진 갯수 : "+list.size()); //원소 개수 출력
		
		boolean result = list.remove("바나나");
		System.out.println("삭제 결과 :"+result);
		
		System.out.println(list.contains("황의조")); //set 안에 이 원소가 존재하면 true 리턴
		System.out.println(list.contains(Calendar.getInstance())); //이건 false (아까의 Calendar와 다름)
		
		//Set 안의 원소들을 하나씩 출력하는 방법
		//방법1
		Object[] lists = list.toArray();
		for (Object object : lists) {
			if(object instanceof String) {
				System.out.println(((String) object).length());
			}
			System.out.println(object);
		}
		//방법2
		Iterator iter=list.iterator(); //반복자
		while(iter.hasNext()) { //hasNext() 다음 가져올 것이 있으면 true
			Object obj = iter.next(); //오브젝트타입 리턴
			System.out.println(obj);
		}
		
		//요즘은 방법1 방법2 모두 잘 쓰지 않음 : 확장 for문을 사용
		for (Object object : list) {
			System.out.println(object);
		}
		
		//List에 추가된 규약 메소드들..
		list.add(0,"김기정"); //index에 객체 추가 (끼워넣기)
		System.out.println(list.get(0)); //index의 객체 리턴
		System.out.println(list.remove(0)); //index의 객체 삭제하고 삭제한 객체 리턴
		System.out.println(list.set(0, "황희찬"));
		
		System.out.println(list.size());
		List l= list.subList(0, 3);
		for (Object object : l) {
			System.out.println(object);
		}
		
	}

}
