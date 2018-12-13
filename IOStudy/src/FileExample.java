import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Calendar;

public class FileExample {

	public static void main(String[] args) throws IOException {
		String path= "c:/some.dat";		
		File file=new File(path);
		
		System.out.println("이 파일의 존재 여부 : "+ file.exists());
		
		
		path="C:\\KOSTA187\\설치프로그램\\jdk-8u181-windows-x64.exe";
		File file2= new File(path);
		
		System.out.println("파일 용량 : "+file2.length());
		
		Calendar cal=Calendar.getInstance();
		cal.setTimeInMillis(file2.lastModified());
		System.out.println("변경 날짜 : ");
		System.out.printf("%1$tF %1$tp %1$tT \n", cal); //tp가 오전 오후 나타냄
		
		
		path="c:/KOSTA187";
		File file3= new File(path);
		System.out.println("path가 디렉토리인지 파일인지 출력");
		System.out.println("디렉토리의 경우 이 디렉토리의 sub디렉토리 목록 출력");
		if(file3.isDirectory()) {
			System.out.println("디렉토리");
			for (String string : file3.list()) {
				System.out.println("[dir] "+string);
			}
			
			File[] list= file3.listFiles(); //File[] 배열 가능
			for (File f : list) {
				System.out.println("<dir>" + f.getName());
			}
		} else {
			System.out.println("파일");
		}
		
		
		path="example.dat"; //상대경로
		File file4= new File(path);
		System.out.println("이 파일의 절대경로 : ");
		System.out.println(file4.getAbsolutePath());
		System.out.println(file4.getPath());
		System.out.println(file4.toURL()); //불안정한 코드
		System.out.println(file4.toURI()); //대신 이것을 사용 
		
		//조작 관련 기능들
		path="xxx.dat";
		file= new File(path);
		System.out.println(file.createNewFile()); //상대 경로로 생성될것
		
		File temp=File.createTempFile("some", ".dat"); //임시로 생성된 파일의 정보를 제공하는 File객체 리턴
		System.out.println(temp.getAbsolutePath()); //임시경로 리턴
		FileOutputStream out = new FileOutputStream(temp); //임시 파일에 데이터 쓰기
		out.write(10); //임시 파일에 1byte크기 (숫자데이터) 쓰기
		temp.deleteOnExit(); //프로그램이 종료될 때 임시 파일이 삭제되도록 한다
		
		File dir = new File("c:/KOSTA187/XXX");
		dir.mkdirs(); //파일 만들기 (여기서는 디렉토리가 생성됨)
		dir.delete(); //디렉토리 삭제
		
		File[] drives = File.listRoots(); //root 드라이브들을 File 배열로 리턴
		for (File file5 : drives) {
			System.out.println(file5.toString());
		}
		
	}

}
