import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class OutputStreamExample {
	static final String path="example.dat"; //상대경로

	public static void main(String[] args) throws IOException {
		OutputStream out= new FileOutputStream(path);
		/*
		out.write(65);
		out.close();
		System.out.println("파일에 1바이트 씀");
		*/
		
		byte[] buffer= new byte[128];
		for (int i = 0; i < buffer.length; i++) {
			buffer[i]=(byte)i;
		}
		
		out.write(buffer); //아랫줄과 같은 뜻
		// out.write(buffer,0,buffer.length); 
		out.close();
		System.out.println("파일에 128바이트 씀");
	}

}
