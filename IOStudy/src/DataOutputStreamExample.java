import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataOutputStreamExample {

	static final String path= "example3.dat"; //여기에 데이터를 쓸 예정 : file outputStream 필요
	
	public static void main(String[] args) throws IOException {
		//이 데이터들을 파일에 출력하기 위해 DataOutputStream 따로 필요
		boolean flag= false;
		char c = '김';
		int age= 30;
		double weight= 66.7;
		String message= "입출력 프로그램입니다";
		
		DataOutputStream out = new DataOutputStream(new FileOutputStream(path));
		/*FileOutputStream과 DataOutputStream 조합해서 사용
		조합 cf) OutputStream out= new DataOutputStream(new BufferedOutputStream(new FileOutputStream(path)));
		*/
		out.writeBoolean(flag); 
		out.writeChar(c);
		out.writeInt(age);
		out.writeDouble(weight);
		out.writeUTF(message);
		
		out.close();
		System.out.println("파일 씀");
		//이렇게 write해도 열었을 때 writeUTF만 제대로 보임 : String은 UTF라고 인코딩 형식 지정해줬기 때문에
		//읽을 때도 쓸 때도 같은 형식으로 접근해야 읽고 쓰기 가능 : 읽는 프로그램을 따로 만들어야 한다 (FIFO 형식 지켜서)
		

	}

}
