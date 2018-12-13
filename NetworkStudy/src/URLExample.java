import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JOptionPane;

public class URLExample {

	public static void main(String[] args) {
//		String urlString="http://www.daum.net:80/index.html";
		String urlString="https://post.naver.com/viewer/postView.nhn?volumeNo=16555682&memberNo=11880830";
		
		try {
			URL url= new URL(urlString);
			System.out.println(url.getProtocol());
			System.out.println(url.getHost());
			
			//byte 스트림으로 html 읽기 : 인코딩 작업 필요
			InputStream in=url.openStream();
			byte[] buffer= new byte[1024];
			int count=0;
			while((count=in.read(buffer))!= -1) {
				//System.out.println(buffer);
				String text=new String(buffer,0,count);
				System.out.println(text);
			}
			
			//문자 스트림으로 읽기: 간단 
			InputStreamReader isr = new InputStreamReader(in);
			BufferedReader br= new BufferedReader(isr);
			String text;
			while((text=br.readLine()) != null) {
				//String text=new String(buffer,0,count);
				System.out.println(text);
			}
			
			
		//	System.out.println(in);
			System.out.println(in.read()); //html의 첫번째 read
		} catch (MalformedURLException e) {
			JOptionPane.showMessageDialog(null, "서버를 찾을수 없습니다");
		} catch (IOException e) {
			e.printStackTrace();
		}
				
	}
}
