package character;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
 * BufferedReader 사용해서 텍스트파일 읽기
 * 
 */
public class BufferedReaderExample {

	public static void main(String[] args) throws IOException {
		String path= "src/BufferedInputStreamExample.java";
		FileReader in =new FileReader(path); //텍스트파일 전용  
	
		/*
		char[] buffer = new char[1024]; //한번에 1024개 문자 읽어오기 위한 배열 생성
		int count=0; //읽어온 문자 갯수를 저장할 변수
		while((count=in.read(buffer)) != -1) { //더 이상 읽어올 문자가 없으면 -1 리턴됨
			for (char c : buffer) {
				System.out.print(c);
			} //글자 하나씩 읽어서 char로 출력
		}
		*/
		
		/* BufferedReader 사용 */
		BufferedReader br= new BufferedReader(in); //노드스트림FileReader를 인자로 받는다
		String txt= br.readLine(); //텍스트파일 한 줄 읽어오기
		System.out.println(txt);
		
		//전체 텍스트파일 읽기
		txt=null;
		while((txt=br.readLine()) != null) { //readLine()은 더 이상 읽어올 String이 없으면 null 리턴
			System.out.println(txt);			
		}
	}

}
