import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

public class PropertiesExample {

	static { //static 초기화 블록
		String path="config.properties";
		Properties prop= new Properties(); //메모리에 빈 Map 생성 

		try {
			prop.load(new FileInputStream(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		prop.put("name4", "eangry");
		
		System.out.println("name2 : "+prop.getProperty("name2"));
		
		
		Enumeration<Object> res= prop.elements();
		while(res.hasMoreElements()) {
			System.out.println(res.nextElement());
		}
		
	}
	public static void main(String[] args) throws FileNotFoundException, IOException {
		System.out.println("프로그램 시작됨");
	}
}
