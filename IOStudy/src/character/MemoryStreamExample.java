package character;

import java.io.IOException;
import java.io.StringReader;

public class MemoryStreamExample {

	public static void main(String[] args) throws IOException {
		
		String message= "A187기 하나금융TI";
		StringReader sr = new StringReader(message);
		System.out.println(sr.read()); //디코딩 없이 그대로 읽음 : 형변환 해주어야 한다
		System.out.println((char)sr.read()); //char로 바꾸기
		
		
	}

}
