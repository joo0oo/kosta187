package pattern;

import java.util.Calendar;

/**
 * 싱글톤 패턴 적용 클래스
 * @author 송주현
 *
 */
public class Logger {

	private static Logger logger= new Logger();
	
	private Logger() {	}
	
	public static Logger getInstance() {
		return logger; //이 클래스 안에 만들어진 logger를 리턴
	}
	
	public void log(String message) {
		Calendar today= Calendar.getInstance();
		String time= String.format("%1$tF %1$tT", today);
		System.out.println(" ["+time+"] "+message);
	}
	
}
