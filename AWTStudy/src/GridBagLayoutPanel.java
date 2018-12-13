import java.awt.Button;
import java.awt.Component;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Panel;

public class GridBagLayoutPanel extends Panel {
	
	Button button1, button2, button3;
	GridBagLayout gridBagLayout; 
	GridBagConstraints gridBagConstraints; //GridBagLayout 클래스는 정보가 너무 많아서 데이터만 있는 클래스를 따로 분리해둠
	
	public GridBagLayoutPanel() {
		button1= new Button("button1");
		button2= new Button("button2");
		button3= new Button("button3");
		
		gridBagLayout = new GridBagLayout();
		gridBagConstraints = new GridBagConstraints();		
	}
	
	public void setContents() {
		setLayout(gridBagLayout);		
		
		add(button1,0,0,1,1,0,0);
		add(button2,1,0,1,1,1,0);
		add(button3,0,1,2,1,1,0);
		/*
		gridBagConstraints.gridx=0; //x축 
		gridBagConstraints.gridy=0; //y축
		gridBagConstraints.gridwidth= 1;
		gridBagConstraints.gridheight= 1; // 격자 1개짜리 생성
		+
		gridBagConstraints.weightx=0;
		gridBagConstraints.weighty=0;
		
		gridBagLayout.setConstraints(button1, gridBagConstraints);
		add(button1); //컴포넌트 고유의 크기를 유지하면서 add
		
		
		gridBagConstraints.gridx=1; //x축 
		gridBagConstraints.gridy=0; //y축
		gridBagConstraints.gridwidth= 1;
		gridBagConstraints.gridheight= 1; // 격자 1개짜리 생성
		
		gridBagConstraints.weightx=1;
		gridBagConstraints.weighty=1;	
		gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
		gridBagConstraints.insets=new Insets(10, 10, 20, 20);
		
		gridBagLayout.setConstraints(button2, gridBagConstraints);
		add(button2); //컴포넌트 고유의 크기를 유지하면서 add
		*/
	}
	
	private void add(Component component, int gridX, int gridY, int gridWidth, int gridHeight, double weightX, double weightY) {
		gridBagConstraints.gridx=gridX; //x축 
		gridBagConstraints.gridy=gridY; //y축
		gridBagConstraints.gridwidth= gridWidth;// 몇개의 격자를 합칠 것인가
		gridBagConstraints.gridheight= gridHeight; // 몇개의 격자를 합칠 것인가
		
		gridBagConstraints.weightx=weightX;
		gridBagConstraints.weighty=weightY;	
		gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
		//gridBagConstraints.insets=new Insets(10, 10, 20, 20);
		
		gridBagLayout.setConstraints(component, gridBagConstraints);
		add(component); //컴포넌트 고유의 크기를 유지하면서 add
	}
	
	public static void main(String[] args) {
		Frame frame=new Frame();
		GridBagLayoutPanel panel= new GridBagLayoutPanel(); //모듈화
		panel.setContents();
		
		frame.add(panel);
		frame.pack();
		//frame.setSize(400,400);
		frame.setVisible(true);
		
	}

}
