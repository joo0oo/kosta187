import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class InputStreamExample {
	static final String path="C:\\KOSTA187\\설치프로그램\\jdk-8u181-docs-all.zip";
	public static void main(String[] args) {
		
		InputStream in=null;
		try {
			in = new FileInputStream(path); //추상클래스라서 new 안됨 :하위클래스로 생성
			System.out.println(in.available()); //읽고자 하는 파일 사이즈
			
//			int b=in.read(); //파일의 첫번째 데이터 리턴
//			System.out.println(b);
			
			int b=0;
			while((b=in.read()) != -1) { //더이상 읽어올 게 없으면 -1 리턴
				System.out.println(b);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//finally에서 입출력 스트림을 닫아준다
			//스트림은 리소스라서 반드시 닫아야함 : 반드시 실행되는 finally 블록
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}

}
