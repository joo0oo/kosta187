package test;
import org.junit.Test;

import kr.or.kosta.shippingmall.log4j.SomeService;

/**
 * Annotation을 이용하여 Test 클래스를 정의하는 방법(JUnit 4)
 * extends 제거
 */
public class Log4JTest {
	SomeService service= new SomeService();
	
	

	@Test
	public void testLog4J() {
		service.someMethod();
	}
	

}
