import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;


public class UserFrame extends Frame implements MouseListener, WindowListener {
	//String title; 
	Button eButton, wButton, sButton, nButton, cButton;

	public UserFrame() {
		this("no name.."); //자동으로 title 됨
	}
	public UserFrame(String title) {
		super("title");
		this.eButton = new Button("EAST");
		this.wButton = new Button("WEST");
		this.sButton = new Button("SOUTH");
		this.nButton = new Button("NORTH");
		this.cButton = new Button("CENTER");
	}
	
	//화면 배치함수는 따로 만들기
	public void setContents() {
		setLayout(new FlowLayout());
		
		add(eButton,BorderLayout.EAST);
		add(wButton,BorderLayout.WEST);
		add(sButton,BorderLayout.SOUTH);
		add(nButton,BorderLayout.NORTH);
		add(cButton,BorderLayout.CENTER);
		
	}
	
	public void eventRegist() {
		//이벤트 소스에 이벤트 리스너 연결
		eButton.addMouseListener(this);
		wButton.addMouseListener(this);
		sButton.addMouseListener(this);
		nButton.addMouseListener(this);
		cButton.addMouseListener(this);
		// MouseListenr를 인자로 받아야 하는데 여기서는 UserFrame 자체가 "implements MouseListener"를 가지기 때문에 this로 호출
		
		this.addWindowListener(this);
	}
	
	public static void main(String[] args) {
		UserFrame frame=new UserFrame("타이틀 입니다..");
		frame.setSize(500,300);
		frame.setContents();
		frame.eventRegist();
		frame.setVisible(true);		
	}
	
	//이벤트 처리 부분
	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("마우스 클릭됨..");
		//e.getSource(); //이 마우스이벤트가 발생한 객체 리턴
		Object source= e.getSource();
		Button button= (Button)source;
		int r= (int)(Math.random()*256);
		int g= (int)(Math.random()*256);
		int b= (int)(Math.random()*256);
		button.setBackground(new Color(r,g,b));
		
		//버튼별로 이벤트 구분하기
		if(source == eButton) { //mouseClicked 이벤트 발생한 객체가 eButton이면
			System.out.println("EAST Clicked");
		}
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		System.out.println("mouseEntered() called");
	}
	@Override
	public void mouseExited(MouseEvent e) {
		System.out.println("mouseExited() called");
	}
	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("mousePressed() called");
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println("mouseReleased() called");
	}
	
	
	//WindowListener 추상메서드 구현
	@Override
	public void windowActivated(WindowEvent e) {
		//윈도 창 활성화됨
	}
		@Override
	public void windowClosed(WindowEvent e) {
		//윈도 창 
	}
	@Override
	public void windowClosing(WindowEvent e) {
		System.out.println("창이 닫힘..");
		setVisible(false); //화면에서 사라지게 한다
		dispose(); //os에 그래픽리소스 반납
		System.exit(0); //JVM종료
	}
	@Override
	public void windowDeactivated(WindowEvent e) {
		//윈도 창 비활성화
	}
	@Override
	public void windowDeiconified(WindowEvent e) {
		//윈도 창 최소화 풀림
	}
	
	@Override
	public void windowIconified(WindowEvent e) {
		//윈도 창 최소화
	}
	@Override
	public void windowOpened(WindowEvent e) {
		//윈도 창 처음 열릴때
		System.out.println("창이 열림..");
	}	
}
