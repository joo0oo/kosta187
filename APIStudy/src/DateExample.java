import java.text.SimpleDateFormat;
import java.util.Date;

public class DateExample {

	//요즘은 Date 클래스보다 Calendar 클래스를 사용한다
	public static void main(String[] args) {
		Date today= new Date();
		System.out.println(today.getYear());
		System.out.println(today.toString());
		System.out.println(today.toLocaleString());
		System.out.println(today.getTime()); //getTime() ms단위로 그리니치 표준시와의 차이를 리턴
		SimpleDateFormat simple= new SimpleDateFormat();
		
	}

}
