import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class ExitHandler extends WindowAdapter{
	//frame을 전달받아서 창을 닫기는 기능만 구현된 클래스 (이벤트를 따로 클래스로 구현해둠)
	
	//서로 참조할 수 있도록 제어할 프레임을 변수로 선언
	ChatFrame frame; //생성자로 받거나 setter로 받는다
	
	public ExitHandler(ChatFrame frame) {
		this.frame= frame;
	}

	//WindowAdapter는 클래스이므로 상속받음 : 추상메서드를 모두 오버라이딩할 필요 없어짐 
	//원래는 WindowListner인터페이스를 implements해서 추상메서드를 필수적으로 모두 구현했어야 함
	@Override
	public void windowClosing(WindowEvent e) {
		frame.finish(); //frame객체의 finish 메소드를 호출시킨다
	}
}
