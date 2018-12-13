import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.JOptionPane;

public class InputStreamExample2 {
	static final String path="C:\\KOSTA187\\설치프로그램\\jdk-8u181-docs-all.zip";
	public static void main(String[] args) {
		
		InputStream in=null;
		File file= new File(path); //유효성 검증을 위해 File 객체 추가
		
		if(!(file.exists())) {  //설정된 path가 실제 존재하는지 여부를 먼저 판단하고 프로그램이 수행되는 것이 좋다
			JOptionPane.showMessageDialog(null, "파일 없음");
			return ; //유효성 검증 완료
		}
		
		try {
			in = new FileInputStream(path); //추상클래스라서 new 안됨 :하위클래스로 생성
			System.out.println(in.available()); //읽고자 하는 파일 사이즈
			
			// byte[] (버퍼)단위로 입력
			byte[] buffer=new byte[4*1024]; //buffer에는 입력받은 데이터들이 저장됨
			//int count=in.read(buffer); //이때 리턴타입은 읽어온 byte 갯수 (실제 데이터는 buffer에 있음)
		
			/*	
			System.out.println(count); 
			System.out.println(buffer); //이렇게 찍어도 데이터 안나옴 : 해시코드 
			
			for (byte b : buffer) { //이렇게 찍어야 데이터 나옴
				System.out.println(b);
			}
			*/
			
			int count=0;
			int totalCount=0;
			while((count=in.read(buffer)) != -1) { //더 이상 읽어올 데이터가 없으면 -1 리턴됨
				//buffer에 들어있는 내용 읽어오기
				System.out.println(count);
				totalCount += count;
			}
			System.out.println("while문 종료 후 :"+in.available()); //파일을 다 읽어들였기 때문에 0이 찍힘
			System.out.println(totalCount+"바이트 파일 다 읽었음");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			//finally에서 입출력 스트림을 닫아준다
			//스트림은 리소스라서 반드시 닫아야함 : 반드시 실행되는 finally 블록
			try {
				if(in != null) {
					in.close();
				}				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}

}
