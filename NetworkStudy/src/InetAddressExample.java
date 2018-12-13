import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * DNS와의 통신을 통해 IP <-> Domain 정보 제공 
 * @author 송주현
 *
 */
public class InetAddressExample {

	public static void main(String[] args) throws UnknownHostException {
		
		//InetAddress.getLocalHost(); //팩토리 메소드
		InetAddress ia= InetAddress.getLocalHost(); 
		System.out.println(ia.getHostAddress()); //IP주소 리턴
		
		InetAddress ia2= InetAddress.getByName("www.naver.com"); //도메인으로 실제 IP주소 리턴
		System.out.println(ia2.getHostAddress());
		
		InetAddress[] ias= InetAddress.getAllByName("www.naver.com");
		
		for (InetAddress inetAddress : ias) {
			System.out.println(inetAddress);
		}
	}

}
