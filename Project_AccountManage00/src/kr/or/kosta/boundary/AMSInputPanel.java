package kr.or.kosta.boundary;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;

public class AMSInputPanel extends Panel {
	Label accountKindL, accountNumL, accountNameL, passwdL, depositL, borrowL;
	Choice accountC;
	Button numGetB, numRemoveB, nameSearchB, addNewB, showAllB;
	TextField accountNumTF, accountNameTF, passwdTF, depositTF, borrowTF; 
	
	Label accountListL, currencyL;
	TextArea outputTA;	
	
	GridBagLayout gridBagLayout;
	GridBagConstraints gridBagConstraints;
	
	public AMSInputPanel() {
		accountKindL = new Label("계좌종류");
		accountNumL = new Label("계좌번호");
		accountNameL= new Label("예금주명");
		passwdL= new Label("비밀번호");
		depositL= new Label("입금금액");
		borrowL= new Label("대출금액");
		
		accountC=new Choice();
		accountC.add("전체");
		accountC.add("입출금계좌");
		accountC.add("마이너스계좌");
		
		numGetB=new Button("조회");
		numRemoveB=new Button("삭제");
		nameSearchB=new Button("검색");
		addNewB=new Button("신규등록");
		showAllB=new Button("전체조회");
		
		accountNumTF= new TextField();
		accountNameTF= new TextField();
		passwdTF= new TextField();
		depositTF= new TextField();
		borrowTF= new TextField();
		
		accountListL=new Label("계좌목록");
		currencyL=new Label("(단위 : 원)");
		currencyL.setAlignment(Label.RIGHT);
		outputTA=new TextArea();
		
		gridBagLayout= new GridBagLayout();
		gridBagConstraints = new GridBagConstraints();		
	}
	
	public void setContents() {
		setLayout(gridBagLayout);
		
		add(accountKindL,0,0,1,1,0,0);
		add(accountC,1,0,1,1,0,0);
		Label blank1=new Label(" ");
		add(blank1,2,0,1,1,0,0);
		
		add(accountNumL,0,1,1,1,0,0);
		add(accountNumTF,1,1,2,1,1,0);
		add(numGetB,3,1,1,1,0,0);
		add(numRemoveB,4,1,1,1,0,0);
		Label blank2=new Label(" ");
		add(blank2,5,0,1,1,0,0);
	
		add(accountNameL,0,2,1,1,0,0);
		add(accountNameTF,1,2,2,1,1,0);
		add(nameSearchB,3,2,1,1,0,0);
		
		add(passwdL,0,3,1,1,0,0);
		add(passwdTF,1,3,2,1,1,0);
		add(depositL,3,3,1,1,0,0);
		add(depositTF,4,3,2,1,1,0);
		
		add(borrowL,0,4,1,1,0,0);
		add(borrowTF,1,4,2,1,1,0);
		
		Panel buttonP=new Panel();
		buttonP.add(addNewB);
		buttonP.add(showAllB);
		add(buttonP,3,4,2,1,0,0);
		
		Label blank3=new Label(" ");
		add(blank3,5,4,1,1,0,0);
		
		add(accountListL,0,5,1,1,0,0);
		add(currencyL,5,5,1,1,0,0);
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

}
