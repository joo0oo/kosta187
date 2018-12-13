import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CollectionQuiz {

	public static void main(String[] args) {
		Set<Account> set= new HashSet<>(); //Account를 저장하는 해시set
		set.add(new Account("1111-2222-3333", "김기정", 1000,1234));
		set.add(new Account("8888-2222-3333", "박기정", 100000,3333));
		set.add(new Account("1111-2222-3333", "김기정", 1000,1234));
		System.out.println(set.size());
		
		//Object 클래스의 8가지 메소드 중에서 오버라이딩..

		for (Object object : set) {
			System.out.print("[hash: "+object.hashCode()+"] ");
			System.out.println(object);
		}
		/*		
		객체를 저장할 때
		1차 : 해시코드 비교
		1. 그 객체의 해시코드를 불러온다
		2. 기존 객체들의 해시코드와 비교한다
		3. 같은 종류의 객체(Account형)인지 확인
		
		2차 : equals() 비교
		
		만약 해시코드 비교에서 같지 않다면 equals()도 호출되지 않음
		객체는 무조건 해시코드가 다 다르게 나오므로 hashCode()는 오버라이딩 해주는게 좋다 (같은 그룹으로 만들기 위해)
		
		String에서는 hashCode가 오버라이딩 되어있어서 내용이 같으면 해시코드가 다르게 나옴 
		[해결]Account에서 toString.hashCode()로 오버라이딩한다		
		*/	
		
		Map<String,String> mapp= System.getenv(); //현재 환경변수들을 map으로 가져오는 함수 
		Set<String> keySet=mapp.keySet();
		for (String name : keySet) {
			String value= System.getenv(name);
			System.out.println(name+" = "+value);
			
		}
	}

}
