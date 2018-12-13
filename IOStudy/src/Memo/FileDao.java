package Memo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class FileDao {
	
	String message;
	String pathR, pathW;
	
	BufferedReader bReader;
	PrintWriter pWriter;
	
	public FileDao() throws FileNotFoundException {
		pathR=null;
		pathW=null;
		
		bReader= null;
		pWriter= null;
	}
	
	// 파일 열기(읽기)
	public String openTXT(String dir, String title) throws IOException {
		pathR=dir+"\\"+title;
		
		File file= new File(pathR); //유효성 검사
		if(!file.exists()) {
			throw new IOException("파일 존재하지 않음");
		}
		
		bReader= new BufferedReader(new FileReader(pathR));
		
		String txt= "";
		String fullTxt="";
		while((txt=bReader.readLine()) != null) {
			fullTxt = fullTxt+txt+"\n";
		}
		bReader.close();
		
		return fullTxt;
	}
	
	// 파일 저장하기(쓰기)
	public void saveTXT(String dir, String title, String context) throws IOException {
		pathW=dir+"\\"+title;
		
		pWriter= new PrintWriter(pathW);
		context= context.replaceAll("\n", "\r\n");
		pWriter.print(context);
		pWriter.close();
	}
	

}
