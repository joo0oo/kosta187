import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
// Map : Key & Value 로 데이터 관리

public class MapExample {

	public static void main(String[] args) {
		Map<String, String> map=new HashMap<>();
		map.put("680313", "김기정");
		map.put("690313", "박기정");
		map.put("610313", "홍기정");
		map.put("620313", "이기정");
		map.put("680313", "최기정"); //기존의 key와 중복되면 최신 데이터로 덮어씌움
		//따라서 저장하기 전에 key가 이미 존재하는지 확인해야 함
		
		System.out.println(map.get("680313"));
		System.out.println(map.get("680313"));
		
		if(map.containsKey("680313")) {
			//이미 이 key가 존재하면 저장하지 않아야 한다
			System.out.println("이미 존재하는 키..");
		}else {
			map.put("680313", "곽기정"); 
		}
		System.out.println(map.get("680313"));
		
		Set<String> keyList= map.keySet(); //저장된 key 목록반환, 리턴타입은 set
		for (String string : keyList) {
			System.out.println(string); 
		}
		
		Collection<String> values=map.values(); //저장된 value목록 반환, 리턴타입은 Colletion
		for (String string : values) {
			System.out.println(string);
		}
	}
}
