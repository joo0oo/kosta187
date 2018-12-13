import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedOutputStreamExample {
	
	static final String path= "example.dat"; //여기에 데이터를 쓸 예정 : file outputStream 필요
	
	public static void main(String[] args) throws IOException {
		
		FileOutputStream fos= new FileOutputStream(path);
		BufferedOutputStream out= new BufferedOutputStream(fos); //내부적으로 디폴트 512byte의 buffer를 가지고 생성됨

		out.write(10); //하드에 바로 쓰는게 아니라 BufferedOutputStream에 쓰여짐 (배열로)
		out.write(20); //하드에 바로 쓰는게 아니라 BufferedOutputStream에 쓰여짐 (배열로)
		
		byte[] data= {5,6,7,8,9};
		out.write(data);//하드에 바로 쓰는게 아니라 BufferedOutputStream에 쓰여짐 (배열로)
		out.flush();
		System.out.println("파일에 데이터 씀");
		
	}

}
