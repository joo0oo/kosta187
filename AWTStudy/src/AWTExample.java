import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;

public class AWTExample {
	public static void main(String[] args) {
		Frame frame = new Frame("처음으로 만드는 프레임");
		frame.setSize(1000, 500);
		
		
		Button button1 = new Button("AWT 버튼1");
		Button button2 = new Button("AWT 버튼2");
		
		frame.setLayout(new FlowLayout());
		frame.add(button1); 
		frame.add(button2); 
		//frame.setResizable(false);
		
		Label label= new Label("AWT Label");
		frame.add(label);
		
		TextField textField = new TextField("ID");
		frame.add(textField);
		TextArea textArea= new TextArea(20,10);
		frame.add(textArea);
		
		Checkbox checkbox1 = new Checkbox("남", true);
		Checkbox checkbox2 = new Checkbox("여", true);
		frame.add(checkbox1);
		frame.add(checkbox2);
		
		//라디오버튼 만들기 : CheckboxGroup
		CheckboxGroup cg= new CheckboxGroup();
		Checkbox cb1 = new Checkbox("male",false,cg);
		Checkbox cb2 = new Checkbox("female",false, cg);	
		
		frame.add(cb1);
		frame.add(cb2);
		
		Choice selectBox = new Choice();
		selectBox.add("박찬호");
		selectBox.add("박지성");
		selectBox.add("박혁거세");
		frame.add(selectBox);
		
		frame.setVisible(true);
	
	}
}
