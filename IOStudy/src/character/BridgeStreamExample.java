package character;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/*
 * BufferedReader 사용해서 텍스트파일 읽기
 * 
 */
public class BridgeStreamExample {

	public static void main(String[] args) throws IOException {
//		System.out.println(System.in);
//		System.out.println(System.out);
		
		System.out.print("당신의 이름 : ");
		
	//	BufferedReader br= new BufferedReader(System.in); //인자로 reader가 들어가야 해서 에러
		
		InputStreamReader isr = new InputStreamReader(System.in); //여기서 byteStream을 인자로 받고 BufferedReader에 넘겨줌
		BufferedReader br= new BufferedReader(isr); //Reader와 byteStreamd을 연결
		String name= br.readLine();
		System.out.println(name);
		
	}

}
