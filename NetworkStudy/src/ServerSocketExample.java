import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketExample {

	//public static final String domain="1237.0.0.1";
	
	public static final String domain="localhost";
	public static final int port= 7777;
	
	public static void main(String[] args) {
		boolean running= true;
		
		try {
			ServerSocket serverSocket = new ServerSocket(port);//이 서버가 사용하는 포트 지정
			System.out.println(port+" 포트에서 서버 실행..");
			
			while(running) {
				Socket socket= serverSocket.accept(); //클라이언트 연결 확인하고 Socket 리턴
				Client client= new Client(socket);
				client.start();
			
				InetAddress ia= socket.getInetAddress();//클라이언트 ip
				System.out.println(ia+"클라이언트가 연결해옴 -> 서버 소켓 생성됨");
				
			
				/*
				InputStream in= socket.getInputStream(); //클라이언트에서 넘어오는 데이터를 수신하기 위한 스트림
				OutputStream out= socket.getOutputStream(); //클라이언트에 데이터를 쓰기위한 스트림
				*/
				/*
				while(true) {
					int data= in.read();
					System.out.println("클라이언트 수신 데이터 : "+data);
					out.write(data); //에코 서버 : 받은것 그대로 돌려줌
				}
				*/
				
				
				/*
				PrintWriter pw= new PrintWriter(out);
				BufferedReader br= new BufferedReader(new InputStreamReader(in));
				boolean stop=false;
				while(!stop) {
					String clientMessage = br.readLine();
					System.out.println("from client : "+clientMessage);
					if(clientMessage.equals("quit")) {
						System.out.println(" !!! QUIT !!!");
						break;
					}
					pw.println(clientMessage);
					pw.flush();
					
				}
				
				out.close();
				in.close();
				
				socket.close();
			*/
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}

}
