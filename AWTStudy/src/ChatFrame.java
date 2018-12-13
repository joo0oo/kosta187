import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.List;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

public class ChatFrame extends Frame {
	Label serverL;
	TextField serverTF, inputTF;
	Button connectB, sendB;
	TextArea messageTA;
	List userList;
	
	MenuBar menuBar;
	Menu menu;
	MenuItem newMI, exitMI; 

	public ChatFrame() {
		this("no name.."); //자동으로 title 됨
	}
	public ChatFrame(String title) { //생성자로 초기화
		super("title");
		serverL= new Label("서버");	
		serverTF= new TextField();
		inputTF= new TextField();
		connectB= new Button("연결") {
			//내부클래스 구현
			@Override
			public void paint(Graphics g) {
				g.drawLine(10, 10, 50, 10);
			}
		};
		sendB= new Button("전송");
		messageTA= new TextArea(10,30);
		userList = new List();
		
		userList.add("말미잘");
		userList.add("말미잘2");
		userList.add("말미잘3");
		userList.add("말미잘4");
		userList.add("말미잘5");
		
		
		menuBar=new MenuBar(); //메뉴를 담기위한 컨테이너
		menu=new Menu("file");
		newMI = new MenuItem("new");
		newMI.setShortcut(new MenuShortcut(KeyEvent.VK_N));
		exitMI= new MenuItem("exit");
		exitMI.setShortcut(new MenuShortcut(KeyEvent.VK_X)); //단축키만 정해두고 아직 이벤트 처리를 안한 상태
		
	}
	
	//화면 배치함수는 따로 만들기
	public void setContents() {
	//	connectB.setEnabled(false); // 버튼 비활성화
		connectB.setBackground(new Color(100,100,255)); //RGB로 색상 지정
	//	connectB.setForeground(Color.WHITE); //상수로 색상 지정
				
		connectB.setFont(new Font("궁서",Font.BOLD,20));

		Panel northP= new Panel();
		northP.setLayout(new BorderLayout());
		northP.add(serverL, BorderLayout.WEST);
		northP.add(serverTF, BorderLayout.CENTER);
		northP.add(connectB, BorderLayout.EAST);
		
		Panel southP=new Panel();
		southP.setLayout(new BorderLayout());
		southP.add(inputTF, BorderLayout.CENTER);
		southP.add(sendB, BorderLayout.EAST);
		
		add(northP,BorderLayout.NORTH);
		add(messageTA,BorderLayout.CENTER);
		add(userList,BorderLayout.EAST);
		add(southP,BorderLayout.SOUTH);
		
		setLocation(100,100);
		
	//	setColorAll(Color.BLUE);
		
		//메뉴 추가
		setMenuBar(menuBar);
		menuBar.add(menu);
		menu.add(newMI);
		menu.addSeparator();
		menu.add(exitMI);
	}
	
	public void setCenter() {
		//Runtime.getRuntime(); //팩토리 메소드 
		Toolkit.getDefaultToolkit().beep(); //팩토리 메소드
		Dimension dim=  Toolkit.getDefaultToolkit().getScreenSize();
	//	System.out.println(dim);
		int x= (int) ((dim.getWidth()-getSize().width)/2);
		int y= (int) ((dim.getHeight()-getSize().height)/2);
		setLocation(x,y);
		
		
	}
	
	private void setColorAll(Color bg) {
		Component[] com= getComponents(); //모든 컴포넌트들 리턴
		for (Component component : com) {
			if(component instanceof Panel) { //프레임에 직접 add된게 아니라 패널을 통해 add된 경우 처리
				Component[] cs= ((Panel)component).getComponents();
				for (Component component2 : cs) {
					component2.setBackground(bg);
				}
			}
			component.setBackground(bg); //현재 모든 컴포넌트들의 색을 같게 설정
		}
	}
	
	public void finish() {
		setVisible(false);
		dispose();
		System.exit(0);
	}
	
	
	public void appendMessage() {
		String message= inputTF.getText(); //inputTF에 있는 글자 가져오기
		messageTA.append("\n"+message); //messageTA에 글자 뿌리기 
		inputTF.setText(" "); //inputTF에 있는 글자 지우기
	}
	
	public void eventRegist() {
	//	addWindowListener(new ExitHandler(this));
	//	addWindowListener(new Exiter()); //이벤트 처리가 내부 클래스에서 되어있으므로 그냥 호출하면 된다
		
		/* 이름 있는 지역 내부 클래스*/
		/*
		class Exiter extends WindowAdapter{
			@Override 
			public void windowClosing(WindowEvent e) {
				finish();
			}			
		}
		addWindowListener(new Exiter());
		*/
		
		/** 이름 없는 지역 내부 클래스**/
		//new WindowAdapter() { 	}; 
		
		/** 이름 없는 지역 내부 클래스 사용**/
		addWindowListener(new WindowAdapter() {			
			@Override
			public void windowClosing(WindowEvent e) {
				finish();
			}
		});
		
		inputTF.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				appendMessage();
			}
		});
		
		serverTF.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				//e.getModifiers(); //alt, ctrl, shift 키 구분
				System.out.println(e.getKeyCode());
				System.out.println(e.getKeyChar());
				/*
				if(e.getKeyCode() == KeyEvent.VK_K) {
					System.out.println("kkkkkkkk");
				} */
				System.out.println(KeyEvent.VK_G);
				System.out.println(KeyEvent.VK_ENTER);
			}
			
			@Override
			public void keyReleased(KeyEvent e) { 			} 		
			@Override
			public void keyPressed(KeyEvent e) { 			}
		});
		
		inputTF.addTextListener(new TextListener() {
			
			@Override
			public void textValueChanged(TextEvent e) {
				System.out.println(inputTF.getText());
			}
		});
		
		userList.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()== ItemEvent.SELECTED) {
					String name = userList.getSelectedItem();
					JOptionPane.showMessageDialog(null, name+" 선택", "알림", JOptionPane.INFORMATION_MESSAGE); //스프링
				}
			}
		});
		
		exitMI.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				finish();
			}			
		});
		
	}
	
	
	/** 멤버 내부 클래스를 이용한 이벤트 처리 **/
	/*
	public class Exiter extends WindowAdapter{
		@Override
		public void windowClosing(WindowEvent e) {
			finish();
		}
		addWindowListener(new Exiter());
	}
	*/
	

	
	
	
	
	
	public static void main(String[] args) {
		ChatFrame frame=new ChatFrame("타이틀 입니다..");		
		frame.setContents();
		frame.setSize(400,600);
		frame.setCenter();
		frame.eventRegist();
		frame.setVisible(true);
	}	
}
