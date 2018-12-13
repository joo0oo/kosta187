package pattern2;

import java.awt.Toolkit;

public class SingletoneExample {

	public static void main(String[] args) {
//		Logger logger= new Loger();
		Logger logger = Logger.getInstance();
		logger.log("테스트..,");
		
		Toolkit toolkit= Toolkit.getDefaultToolkit();
		Runtime runtime = Runtime.getRuntime();
	//	runtime.exec("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe ");
	}

}
