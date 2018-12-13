import java.io.IOException;

/**
 * 표준 입출력 예제
 * @author 송주현
 *
 */
public class StandardInOutExample {

	public static void main(String[] args) throws IOException {
//		System.out.println(System.in);
//		System.out.println(System.out);
		
		System.out.print("당신의 이름 : ");
		byte[] buffer=new byte[100];		
		int count = System.in.read(buffer);
		
		//문자 디코딩 처리
		String name=new String(buffer,0,count-2);  //맨 마지막 2바이트를 뺀다 (\n)
		System.out.println("이름은 "+name+" 입니다");
		
		System.out.print("당신의 나이 : ");
		count=System.in.read(buffer);
		String age= new String(buffer,0,count-2);
		System.out.println(Integer.parseInt(age)+10);
	}

}
