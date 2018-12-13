/**
 * 
 * java FileReader[읽고자 하는 파일명1][읽고자 하는 파일명2][...]
 * @author 송주현
 *
 */
public class FileReader {

	public static void main(String[] args) {
		
		if(args.length != 2) { 
			System.out.println("사용법 : java FileReader[읽고자 하는 파일명1][읽고자 하는 파일명2][...]");
			return;
		}
		String fileName1= args[0];
		String fileName2= args[1];
		
		System.out.println(fileName1);
		System.out.println(fileName2);
	}

}
