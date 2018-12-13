import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyExample {

	public static long copy(String srcPath, String destPath) throws IOException {
		//strPath에서 파일 읽어서 destPath에 붙여넣기 하는 메소드
		InputStream in=null;
		OutputStream out=null;
		
		try {
			in=new FileInputStream(srcPath);
			out=new FileOutputStream(destPath);
			
			int count=0;
			int totalCount=0;
			byte[] buffer = new byte[4*1024];
			
			while((count=in.read(buffer)) != -1) {
				out.write(buffer,0,count);
				totalCount+= count; //전체 복사된 양
			}
			
			return totalCount; //정상 처리 됐을 때 리턴
	
		} finally {
			if(out != null)
				out.close();
			if (in!= null)
				in.close();
		}
	}
	
	public static void main(String[] args) throws IOException {
		String src="C:\\KOSTA187\\설치프로그램\\jdk-8u181-docs-all.zip";
		String dest="eclipse.zip";
		
		long copySize= copy(src,dest);
		System.out.println("파일 복사 완료");

	}

}
