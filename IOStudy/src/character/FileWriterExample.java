package character;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
 * 문자 스트림은 텍스트파일 전용임
 * byte단위 아님
 * 
 */
public class FileWriterExample {

	public static void main(String[] args) throws IOException {
		String path= "example5.txt";
		
		String message = "배고파";
		FileWriter out= new FileWriter(path); //path에 텍스트파일 내용 쓰기

		char[] chars= new char[1024]; //char[]형으로만 쓸수 있어서 형변환 해야함
		message.getChars(0,message.length(),chars,0);
		out.write(chars);
		out.close();
		
		//형변환이 번거로우므로 이 방법을 사용한다 (인코딩 기능 포함된 buffered)
		BufferedWriter bw= new BufferedWriter(out); //노드 스트림을 인자로 받음
		bw.write(message); //바로 String을 쓸수 있다
		bw.close();
	}

}
