import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * TCP/IP 기반의 SocketProgramming 원리
 * @author 송주현
 *
 */
public class SocketExample {

//	public static final String domain="www.naver.com"; //네이버의 도메인
//	public static final int port=80; //네이버가 사용하는 포트
	
//	public static final String domain="192.168.0.136"; // 서버 도메인
	public static final String domain="localhost"; // 서버 도메인
	public static final int port=7777; //서버 포트
	
	public static void main(String[] args) {
		
		Socket socket= null;
		InputStream in= null;
		OutputStream out= null;
		
		try {
			//Socket socket= new Socket(InetAddress.getByName(domain),port);
			socket= new Socket(domain,port);
			//domain이 사용하는 ip주소를 얻어온다
			System.out.println("서버와 연결됨..");
			
			
			
			in = socket.getInputStream(); 
			out= socket.getOutputStream(); 
			//out.write(28);
			//out.write(22);
			//int data=in.read();
			//System.out.println("서버로부터 에코된 데이터 : "+data);
			//InetAddress ia = new 
			//InetAddress ia= InetAddress.getLocalHost(); 
			
			PrintWriter pw=new PrintWriter(out); //서버에 String데이터 전송하기 위해
			BufferedReader br= new BufferedReader(new InputStreamReader(in)); //서버에서 에코되는 String데이터 읽기 위해 
	
			Scanner scanner = new Scanner(System.in);
			while(true) {
				String inputMessage=scanner.nextLine();
				pw.println(inputMessage);
				pw.flush();
				if(inputMessage.equalsIgnoreCase("quit")) {
					break; //quit 을 입력하면 while문 탈출
				}
				
				String serverMessage= br.readLine();
				System.out.println("서버로부터 에코된 데이터 : "+serverMessage);
			}
		
			
		} catch (IOException e) {
			//해당 domain으로 ip를 찾을수 없음 (해당 ip없음)
			System.out.println("서버와 연결할 수 없습니다..");
			
		} finally {
			try {
				out.close(); //socket을 닫으면 socket으로부터 만들어진 int과 out은 자동으로 닫히기 때문에 따로 닫지 않아도 됨
				in.close();
				socket.close(); 
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
