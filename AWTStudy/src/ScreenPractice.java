import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;

public class ScreenPractice extends Panel{

	Button findB, sendB, cancleB;
	Label toL, fileL, titleL;
	TextField toT, fileT, titleT;
	TextArea contentsT;
	GridBagLayout gridBagLayout;
	GridBagConstraints gridBagConstraints;
	
	public ScreenPractice() {
		findB=new Button("find");
		sendB=new Button("send");
		cancleB=new Button("cancle");
		
		toL=new Label("받는 사람");
		fileL=new Label("첨부 파일");
		titleL=new Label("제목");
		
		toL.setBackground(Color.cyan);
		fileL.setBackground(Color.cyan);
		titleL.setBackground(Color.cyan);
		
		toL.setAlignment(Label.RIGHT);
		fileL.setAlignment(Label.RIGHT);
		titleL.setAlignment(Label.RIGHT);
		
		toT=new TextField();
		fileT=new TextField();
		titleT=new TextField();
		contentsT=new TextArea();
		
		
		gridBagLayout = new GridBagLayout();
		gridBagConstraints= new GridBagConstraints();
	}
	
	public void setContents() {
		//빈칸은 " " 공백 라벨 넣기 		
		setLayout(gridBagLayout);
		
		add(toL,0,0,1,1,0,0);
		add(toT,1,0,2,1,1,0);
		Label blank= new Label("  ");
		Label blank2= new Label("  ");
		Label blank3= new Label("  ");
		blank.setBackground(Color.cyan);
		blank2.setBackground(Color.cyan);
		blank3.setBackground(Color.cyan);
		
		add(blank3,3,0,1,1,1,0);
		add(blank,4,0,1,1,1,0);
				
		add(fileL,0,1,1,1,0,0);
		add(fileT,1,1,2,1,1,0);
		add(findB,3,1,1,1,0,0);	
		add(blank2,4,1,1,1,1,0);
		
		add(titleL,0,3,1,1,0,0);
		add(titleT,1,3,4,1,1,0);
		
	//	add(contentsT,0,4,7,1,1,0);
		add(contentsT,0,4,5,1,1,0);
		
		Panel buttonP=new Panel();
		buttonP.setBackground(Color.ORANGE);
		buttonP.add(sendB);
		buttonP.add(cancleB);
		add(buttonP,0,5,5,1,1,0);		
	}
	
	private void add(Component component, int gridX, int gridY, int gridWidth, int gridHeight, double weightX, double weightY) {
		gridBagConstraints.gridx=gridX; //x축 
		gridBagConstraints.gridy=gridY; //y축
		gridBagConstraints.gridwidth= gridWidth;// 몇개의 격자를 합칠 것인가
		gridBagConstraints.gridheight= gridHeight; // 몇개의 격자를 합칠 것인가
		
		gridBagConstraints.weightx=weightX;
		gridBagConstraints.weighty=weightY;	
		gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
		gridBagConstraints.insets=new Insets(10, 10, 10, 10);
		
		gridBagLayout.setConstraints(component, gridBagConstraints);
		add(component); //컴포넌트 고유의 크기를 유지하면서 add
	}
	
	public static void main(String[] args) {
		Frame frame=new Frame("화면 실습");
		frame.setSize(600, 500);
		
		ScreenPractice panel=new ScreenPractice();
		panel.setContents();
		
		frame.add(panel);
		frame.setVisible(true);
	}
	
}
