import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class BufferedInputStreamExample {
	static final String path="C:\\KOSTA187\\설치프로그램\\jdk-8u181-docs-all.zip";
	
	public static void main(String[] args) throws IOException {
		
		//Node Stream
		InputStream fin=null;
		fin = new FileInputStream(path); 
		
		//Filter Stream
		BufferedInputStream in= null; //단독으로 생성 불가
		in = new BufferedInputStream(fin); //512바이트 배열로 자동생성 (디폴트)
		in.mark(5); //0번째 위치에 마킹
		
		System.out.println(in.read()); //0번째 read
		in.read(); //1번째 read
		in.read(); //2번째 read
		in.read(); //3번째 read
		in.read(); //4번째 read
		in.read(); //5번째 read
		
		in.reset(); //마킹한 위치로 다시 돌아감 (0번째)
		System.out.println(in.read());
		in.skip(20); //20바이트 건너뛰기 (20번째 위치)
	}

}
