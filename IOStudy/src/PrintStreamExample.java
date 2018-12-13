import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Calendar;

public class PrintStreamExample {

	static final String path= "example4.dat"; //여기에 데이터를 쓸 예정 : file outputStream 필요
	
	public static void main(String[] args) throws IOException {
		//이 데이터들을 파일에 출력하기 위해 DataOutputStream 따로 필요
		boolean flag= false;
		char c = '김';
		int age= 30;
		double weight= 66.7;
		String message= "입출력 프로그램입니다";
		
		
		Calendar now = Calendar.getInstance(); 
		
		PrintStream out = new PrintStream(new FileOutputStream(path));
		//PrintStream out = new PrintStream(path);
		//PrintStream은 필터 스트림이지만 노드 스트림을 인자로 받지 않아도 된다
	
		out.println(flag);
		out.println(c);
		out.println(age);
		out.println(weight);
		out.println(message);
		out.printf("%1$tF %1$tT", now); //현재시간을 파일에 기록
		
		out.close();
		System.out.println("파일 씀");
	
	}

}
