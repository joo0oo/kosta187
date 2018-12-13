import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class DataInputStreamExample {

	static final String path= "example3.dat"; //여기에 데이터를 쓸 예정 : file outputStream 필요
	
	public static void main(String[] args) throws IOException {
		//이 데이터들을 파일에 출력하기 위해 DataOutputStream 따로 필요
		boolean flag= false;
		char c = 0;
		int age= 0;
		double weight= 0;
		String message= null;
		
		DataInputStream in = new DataInputStream(new FileInputStream(path));
		
		//write한 순서대로 read해야한다
		flag=in.readBoolean(); 
		c=in.readChar();
		age=in.readInt();
		weight=in.readDouble();
		message=in.readUTF();
		
		System.out.println(flag);
		System.out.println(c);
		System.out.println(age);
		System.out.println(weight);
		System.out.println(message);
		
		in.close();
		System.out.println("파일 읽음");
		

	}

}
