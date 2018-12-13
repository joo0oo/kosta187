import java.util.ArrayList;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Vector;

/**
 * Vector는 'element'가 들어간 메서드를 사용해야 한다 (동기처리된 메서드)
 * Vector는 확장for문을 사용하면 안된다 (확장 for문은 동기처리가 되어있지 않기 때문)
 * @author 송주현
 *
 */
public class ListExample2 {

	//Set은 배열과 비슷하지만, 중복 저장을 하지 않는다
	public static void main(String[] args) {
		//List list = null;
		Vector list=null;
		list = new Vector(); //Vector로 바꿔도 이 코드는 문제없이 실행됨 (단 실행결과가 좀 다를것)
		//list =new Vector(10,5); //(초기값, 증가치); :증가치 설정하지 않으면 자동으로 배로 늘어남
		/*
		list.add("황의조");
		list.add("손흥민");
		list.add("바나나");
		list.add(100); //내부적으로 오토박싱 발생 : Object obj=100;
		list.add(new Integer(100)); 
		list.add(Calendar.getInstance());
		list.add("황의조");
		
		 * Vector는 .add()를 사용하지 않고 .addElement()를 사용한다 : 동기처리 된 메서드
		 * add()는 동기처리 되어있지 않음
		 * Vector를 이처럼 List로 선언하면 addElement()를 사용할 수 없으므로
		 * Vector타입으로 선언해야 한다
		 * 
		 */
		list.addElement("황의조");
		list.addElement("손흥민");
		list.addElement("바나나");
		list.addElement(100); //내부적으로 오토박싱 발생 : Object obj=100;
		list.addElement(new Integer(100)); 
		list.addElement(Calendar.getInstance());
		list.addElement("황의조");
		
		System.out.println("담겨진 갯수 : "+list.size()); //원소 개수 출력
		// 중복된 원소 고려하지 않고 개수 출력됨 : set과 다름
		System.out.println("비어있는지 여부 : "+list.isEmpty());
		
		System.out.println(list.elementAt(0)); //Vector가 원소를 읽어올때 사용
		System.out.println(list.removeElement("바나나"));
		
		//확장for문 대신 사용가능한 코드
		Enumeration e = list.elements(); //동기처리 되어있음
		while (e.hasMoreElements()) {
			Object object = (Object) e.nextElement();			
		}
	}

}
