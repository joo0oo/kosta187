import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;

public class GridPanel extends Panel { //패널을 상속해야 나중에 갖다붙이기 쉬움 (Frame이면 다른데 불가능)
	
	Button[] buttons;
	
	public GridPanel() {
		setLayout(new GridLayout(10, 10));
		//GridLayout은 순차접근 (인덱스 접근 불가능 = 단점)
		buttons = new Button[100];
		for (int i = 0; i < buttons.length; i++) {
			buttons[i]=new Button(i+"BUtton");
			add(buttons[i]);
		}		
	}
	
	public static void main(String[] args) {
		Frame frame=new Frame("GridLayout Example");
		GridPanel panel= new GridPanel(); //모듈화
		
		frame.add(panel);
		frame.setSize(600,400);
		frame.setVisible(true);
		
	}
	
	

}
