import java.util.HashMap;
import java.util.Map;

/**
 * 동적 객체 정의 (Map 이용)
 * @author 송주현
 *
 */
public class Student {
	Map<String,Object> prop;

	
	public Student() {
		prop=new HashMap<String,Object>();
	}


	public Map<String, Object> getProp() {
		return prop;
	}


	public void setProp(Map<String, Object> prop) {
		this.prop = prop;
	}

	public void setProperty(String key, Object value) {
		prop.put(key, value);
	}
	
	public Object getProperty(String key) {
		return prop.get(key); 
	}
	
	public static void main(String[] args) {
		//저장될 객체들의 속성이 가지각색일때 : 동적 객체 사용
		//student1은 학번과 이름만 있는 객체
		Student student1=new Student();
		student1.setProperty("ssn", "87878");
		student1.setProperty("name", "김기정");
		
		//student2는 학번 이름 주소만 있는 객체
		Student student2=new Student();
		student2.setProperty("ssn", "55511");
		student2.setProperty("name", "박소연");
		student2.setProperty("address", "LA");
		
		
	}
	
}
