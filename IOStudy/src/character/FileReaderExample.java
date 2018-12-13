package character;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
 * 문자 스트림은 텍스트파일 전용임
 * byte단위 아님
 * 
 */
public class FileReaderExample {

	public static void main(String[] args) throws IOException {
		String path= "src/BufferedInputStreamExample.java";
		FileReader in =new FileReader(path); //텍스트파일 전용  
		System.out.println(in.read()); //첫 문자 1개를 아스키코드로 읽어옴
		System.out.println((char)(in.read())); //그 다음 문자 1개를 아스키코드로 읽어서 char로 변환 
		
		char[] buffer = new char[1024]; //한번에 1024개 문자 읽어오기 위한 배열 생성
		int count=0; //읽어온 문자 갯수를 저장할 변수
		while((count=in.read(buffer)) != -1) { //더 이상 읽어올 문자가 없으면 -1 리턴됨
			for (char c : buffer) {
				System.out.print(c);
			} //글자 하나씩 읽어서 char로 출력
		}
		
		
		//만약 FileReader가 없이 FileInputStream을 써서 같은 작업을 하는 경우
		FileInputStream fis=new FileInputStream(path);
		byte[] buffer2= new byte[1024];
		count=0;
		while((count=fis.read(buffer2)) != -1) {
			for (byte b : buffer2) { //byte 스트림이기때문에 byte로 받는다
				System.out.print((char)b); //다시 char로 변환
			} //그래도 문제 생김 (한글깨짐) : 그래서 텍스트 파일은 FileReader를 쓰는게 좋다
		}
		
	}

}
