import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * 클라이언트의 데이터 수신 및 처리 
 * @author 송주현
 *
 */ 

public class Client extends Thread {

	private boolean running; 
	private Socket socket;
	private BufferedReader in;
	private PrintWriter out;
	
	public Client(Socket socket) throws IOException {
		this.socket= socket;
		in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
		out=new PrintWriter(socket.getOutputStream(), true); //autoflush : true
		running = true;
	}
	
	public void recieve() {
		while(running) {
			String clientMessage=null;
			try {
				clientMessage = in.readLine();
				System.out.println("from client : "+clientMessage);
				if(clientMessage.equals("quit")) {
					System.out.println(" !!! QUIT !!!");
					break;
				}
				out.println(clientMessage);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		if(socket != null) {
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void run() {
		recieve();
	}
}
