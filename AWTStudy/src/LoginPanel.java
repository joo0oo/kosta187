import java.awt.Button;
import java.awt.Component;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPanel extends Panel implements ActionListener{
	
	TalkFrame frame; //TalkFrame과 LoginPanel의 쌍방 통신/제어를 위해 서로에게 서로의 객체를 만든다
	
	GridBagLayout gridBagLayout;
	GridBagConstraints gridBagConstraints;
	
	Label emailL, passwdL;
	TextField emailTF, passwdTF;
	Button loginB, registB;
	
	public LoginPanel(TalkFrame frame) {
		this.frame=frame;  //LoginPanel에서 TalkFrame을 이벤트로 제어하기 위해 객체 받아서 변수 생성
		
		gridBagLayout = new GridBagLayout();
		gridBagConstraints = new GridBagConstraints();
		
		emailL = new Label("EMAIL");
		passwdL = new Label("PASSWD");
		emailTF = new TextField();
		passwdTF = new TextField();
		passwdTF.setEchoChar('*');
		loginB = new Button("LOGIN");
		registB = new Button("REGIST");
		setContents();
		
		loginB.addActionListener(this); //이벤트 등록
	}
	
	private void add(Component component, int gridx, int gridy, int gridwidth, int gridheight, double weightx, double weighty) {
		gridBagConstraints.gridx = gridx;
		gridBagConstraints.gridy = gridy;
		gridBagConstraints.gridwidth = gridwidth;
		gridBagConstraints.gridheight = gridheight;
		gridBagConstraints.weightx = weightx;
		gridBagConstraints.weighty = weighty;
		gridBagConstraints.fill = gridBagConstraints.HORIZONTAL;
		gridBagConstraints.insets = new Insets(4, 1, 4, 1);
		
		gridBagLayout.setConstraints(component, gridBagConstraints);		
		add(component);
	}
	
	public void setContents() {
		setLayout(gridBagLayout);
		add(new Label(" "),   0, 0, 1, 1, 0, 0);
		add(emailL,   1, 0, 1, 1, 0, 0);
		add(emailTF,  2, 0, 1, 1, 1, 0);
		add(new Label(" "), 3, 0, 1, 1, 0, 0);
		
		add(new Label(" "),   0, 1, 1, 1, 0, 0);
		add(passwdL,  1, 1, 1, 1, 0, 0);
		add(passwdTF, 2, 1, 1, 1, 1, 0);
		add(new Label(" "),   3, 1, 1, 1, 0, 0);
		
		Panel buttonPanel = new Panel();
		buttonPanel.add(loginB);
		buttonPanel.add(registB);
		add(buttonPanel, 0, 2, 3, 1, 0, 0);
		
	}
	
	public static void main(String[] args) {
		/*
		Frame frame = new Frame("메인화면");
		
		LoginPanel loginPanel = new LoginPanel();
		
		frame.add(loginPanel);
		frame.setSize(300, 500);
//		frame.pack();
		frame.setVisible(true);
		*/
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		/*
		 * LoginPanel의 Button에서 발생한 이벤트로 TalkFrame을 제어하기 위한 코드
		 * 그러나 이러면 클래스 캡슐화가 깨짐 : TalkFrame의 데이터를 외부 클래스에서 막 접근하면 안됨
		 * TalkFrame에서 스스로 제어하도록 합시다
		 */
		//frame.cardLayout.show(frame.cardPanel, "MAIN"); 
		
		frame.changeCard("MAIN");
		//TalkFrame에서 changeCard();메소드를 만들고 LoginPanel에서는 이 메소드만 호출
	}

}