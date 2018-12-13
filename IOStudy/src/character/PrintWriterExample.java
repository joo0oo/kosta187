package character;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

/*
 * PrintWriter 사용해서 텍스트파일 쓰기
 * 
 */
public class PrintWriterExample {

	public static void main(String[] args) throws IOException {
		String path= "example6.html";
		
		PrintWriter out = new PrintWriter(path); //인자로 노드스트림 필요없음
		out.println("<html>");
		out.println("<body>");
		out.println("<b>HTML 텍스트 파일 </b>");
		out.println("</body>");
		out.println("</html>");
		
		out.close();
	}

}
