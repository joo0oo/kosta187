package kr.or.kosta.boundary;

import java.awt.Component;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JOptionPane;

import kr.or.kosta.entity.Account;
import kr.or.kosta.entity.AccountException;
import kr.or.kosta.entity.AccountManager;
import kr.or.kosta.entity.MinusAccount;

public class AMSViewFrame extends Frame{
	AMSInputPanel inputPanel;
	Label accountListL, currencyL;
	TextArea outputTA;	
	
	GridBagLayout gridBagLayout;
	GridBagConstraints gridBagConstraints;
	
	AccountManager accountManager;
	
	public AMSViewFrame(){
		this("KOSTA AMS - 메인화면");
	}
	
	public AMSViewFrame(String title){
		super(title);
		inputPanel=new AMSInputPanel();
		outputTA=new TextArea();
		
		gridBagLayout= new GridBagLayout();
		gridBagConstraints = new GridBagConstraints();
		
		accountManager=null;
	}
	
		
	public AccountManager getAccountManager() {
		return accountManager;
	}

	public void setAccountManager(AccountManager accountManager) {
		this.accountManager = accountManager;
	}

	public void setContents() {
		setLayout(gridBagLayout);
		
		inputPanel.setContents();
		
		add(inputPanel,0,0,1,1,0,0);			
		add(outputTA,0,2,1,1,1,0);		
	}
	
	public void finish() {
		setVisible(false);
		dispose();
		System.exit(0);
	}
	
	public void eventRegist() {
		
		//창닫기
		addWindowListener(new WindowAdapter() {	
			@Override
			public void windowClosing(WindowEvent e) {
				finish();
			}
		});
		
		//계좌번호로 계좌 조회하기
		inputPanel.numGetB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				outputTA.setText("");
				String accountNum= inputPanel.accountNumTF.getText();
				
				try {
					if(inputPanel.accountNumTF.getText().length() != 0) {
						outputTA.setText(accountManager.get(accountNum).toString());
					}else {
						JOptionPane.showMessageDialog(null, " 빈칸있음 ", "알림", JOptionPane.INFORMATION_MESSAGE);
					}
				}catch (AccountException getException) {
					JOptionPane.showMessageDialog(null, " 없는 계좌번호 ", "알림", JOptionPane.INFORMATION_MESSAGE);
				}
				inputPanel.accountNumTF.setText("");				
			}
		});
		
		
		//계좌번호로 계좌 삭제하기
		inputPanel.numRemoveB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				outputTA.setText("");
				String accountNum= inputPanel.accountNumTF.getText();
				/*
				try {
					if(inputPanel.accountNumTF.getText().length() != 0) {
						accountManager.remove(accountNum);
						outputTA.setText(accountNum+" 계좌 삭제되었읍니다");
					}else {
						JOptionPane.showMessageDialog(null, " 빈칸있음 ", "알림", JOptionPane.INFORMATION_MESSAGE);
					}
				}catch (AccountException getException) {
					JOptionPane.showMessageDialog(null, " 없는 계쫘번호 ", "알림", JOptionPane.INFORMATION_MESSAGE);
				}
				*/
				
				if(accountManager.remove(accountNum)){
					/*
					boolean isRemove = accountManager.remove(accountNum);
					if(isRemove) {
						outputTA.setText(accountNum+" 계좌 삭제되었읍니다");
					}
					else {
						JOptionPane.showMessageDialog(null, " 삭제할수 없음 ", "알림", JOptionPane.INFORMATION_MESSAGE);
					}			
					*/		
				}	
				else {
					JOptionPane.showMessageDialog(null, " 삭제할수 없음 ", "알림", JOptionPane.INFORMATION_MESSAGE);
				}	
				inputPanel.accountNumTF.setText("");
			}
		});
		
		//예금주명으로 계좌 찾기
		inputPanel.nameSearchB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				outputTA.setText("");
				
				String accountName= inputPanel.accountNameTF.getText();
				
				if(accountName.length() != 0) {
					List<Account> list = accountManager.list(); //전체 리스트를 리턴
					for (Account account2 : list) {//전체 리스트 출력
						if(account2 instanceof MinusAccount) {
							outputTA.setText(" minus account : "+account2.toString()); 
						}
						else {
							outputTA.setText(account2.toString()); 
						}
					}
				}else {
					JOptionPane.showMessageDialog(null, " 조회할수 없음 ", "알림", JOptionPane.INFORMATION_MESSAGE);
				}
				
				
				inputPanel.accountNameTF.setText("");
			}
		});
		
		//새 계좌 추가하기
		inputPanel.addNewB.addActionListener(new ActionListener() {
			
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				outputTA.setText("");
				String accountKind = inputPanel.accountC.getSelectedItem();

				try {
					if (accountKind.equals("입출금계좌") && inputPanel.accountNumTF.getText().length() != 0
							&& inputPanel.accountNameTF.getText().length() != 0
							&& inputPanel.passwdTF.getText().length() != 0
							&& inputPanel.depositTF.getText().length() != 0
					) {
						String accountNum = inputPanel.accountNumTF.getText();
						String accountName = inputPanel.accountNameTF.getText();
						int passwd = Integer.parseInt(inputPanel.passwdTF.getText());
						int depositMoney = Integer.parseInt(inputPanel.depositTF.getText());
						accountManager.add(new Account(accountNum, accountName, passwd, depositMoney));
						JOptionPane.showMessageDialog(null, " 추가됨 ", "알림", JOptionPane.INFORMATION_MESSAGE); //스프링
						
					} else if (accountKind.equals("마이너스계좌") && inputPanel.accountNumTF.getText().length() != 0
							&& inputPanel.accountNameTF.getText().length() != 0
							&& inputPanel.passwdTF.getText().length() != 0
							&& inputPanel.depositTF.getText().length() != 0
							&& inputPanel.borrowTF.getText().length() != 0) {
						String accountNum = inputPanel.accountNumTF.getText();
						String accountName = inputPanel.accountNameTF.getText();
						int passwd = Integer.parseInt(inputPanel.passwdTF.getText());
						int depositMoney = Integer.parseInt(inputPanel.depositTF.getText());
						int borrowMoney = Integer.parseInt(inputPanel.borrowTF.getText());
						accountManager
								.add(new MinusAccount(accountNum, accountName, passwd, depositMoney, borrowMoney));
						JOptionPane.showMessageDialog(null, " 추가됨 ", "알림", JOptionPane.INFORMATION_MESSAGE); //스프링

					} else {
						JOptionPane.showMessageDialog(null, " 빈칸있음 ", "알림", JOptionPane.INFORMATION_MESSAGE);
					}

				} catch (AccountException e) {
					JOptionPane.showMessageDialog(null, " 중복된 계좌번호 ", "알림", JOptionPane.INFORMATION_MESSAGE);
				}
				/*
				if(accountKind=="입출금계좌") {
					if(!isEmptyInput(1)) { //입력칸이 비어있지 않으면 실행
						try {
							
						} catch (AccountException e) {
							
						}
						
					}
					
				}else if (accountKind=="마이너스계좌") {
					if(!isEmptyInput(2)) { //입력칸이 비어있지 않으면 실행
						try {
							
						} catch(AccountException e) {
							
						}						
					}
				}
				*/
				
				
				/*
				if(accountKind =="입출금계좌") {
					try {
						
						String accountNum= inputPanel.accountNumTF.getText();
						String accountName= inputPanel.accountNameTF.getText();					
						int passwd= Integer.parseInt(inputPanel.passwdTF.getText());
						int depositMoney=Integer.parseInt(inputPanel.depositTF.getText());
						int borrowMoney=Integer.parseInt(inputPanel.borrowTF.getText());
						
						
						accountManager.add(new Account(accountNum,accountName,passwd,depositMoney));
						JOptionPane.showMessageDialog(null, " 추가됨 ", "알림", JOptionPane.INFORMATION_MESSAGE); //스프링
						
						
					} catch (AccountException e) {
						JOptionPane.showMessageDialog(null, " 중복된 계쫘번호 ", "알림", JOptionPane.INFORMATION_MESSAGE);
					}
					
				} else if(accountKind=="마이너스계좌") {
					
					
				}
				if(isEmptyInput(1)) {
					try {
						
						String accountNum= inputPanel.accountNumTF.getText();
						String accountName= inputPanel.accountNameTF.getText();					
						int passwd= Integer.parseInt(inputPanel.passwdTF.getText());
						int depositMoney=Integer.parseInt(inputPanel.depositTF.getText());
						int borrowMoney=Integer.parseInt(inputPanel.borrowTF.getText());
						
						if(accountKind =="입출금계좌") {
							accountManager.add(new Account(accountNum,accountName,passwd,depositMoney));
							JOptionPane.showMessageDialog(null, " 추가됨 ", "알림", JOptionPane.INFORMATION_MESSAGE); //스프링
							
						}else if(accountKind=="마이너스계좌") {
							accountManager.add(new MinusAccount(accountNum,accountName,passwd,depositMoney,borrowMoney));
							JOptionPane.showMessageDialog(null, " 추가됨 ", "알림", JOptionPane.INFORMATION_MESSAGE); //스프링
							
						}
						
					} catch (AccountException e) {
						JOptionPane.showMessageDialog(null, " 중복된 계쫘번호 ", "알림", JOptionPane.INFORMATION_MESSAGE);
					}
					
				}
				*/
				
				inputPanel.accountNumTF.setText("");
				inputPanel.accountNameTF.setText("");
				inputPanel.passwdTF.setText("");
				inputPanel.depositTF.setText("");
				inputPanel.borrowTF.setText("");				
			}
		});
		
		//계좌 전체 조회하기
		inputPanel.showAllB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				outputTA.setText("");
				
				List<Account> list = accountManager.list(); //전체 리스트를 리턴
				outputTA.append("---------------------------------------------------\n");
				outputTA.append("계좌종류\t 계좌번호\t 예금주명\t 현재잔액\t 대출금액\n");
				outputTA.append("===================================================\n");
				for (Account account : list) {//전체 리스트 출력
					if(account instanceof MinusAccount) {
						outputTA.append("마이너스\t"+account.toString()); 
					}
					else {
						outputTA.append("입출금\t"+account.toString()); 
					}
				}
				
				/*
				for (Object object : list) {
					outputTA.append(((Account)object).toString()+"\n");
				}
				*/
			}
		});
		
	}
	
	/*
	public boolean isEmptyInput(int caseCheck) {
	
		switch(caseCheck) {
		case 1: //입출금 계좌
			
			
			break;
		case 2 : //마이너스 계좌
			
			break;
			
		
		}
		return false;
	}
	*/
	
	private void add(Component component, int gridX, int gridY, int gridWidth, int gridHeight, double weightX, double weightY) {
		gridBagConstraints.gridx=gridX; //x축 
		gridBagConstraints.gridy=gridY; //y축
		gridBagConstraints.gridwidth= gridWidth;// 몇개의 격자를 합칠 것인가
		gridBagConstraints.gridheight= gridHeight; // 몇개의 격자를 합칠 것인가
		
		gridBagConstraints.weightx=weightX;
		gridBagConstraints.weighty=weightY;	
		gridBagConstraints.fill=gridBagConstraints.HORIZONTAL;
		gridBagConstraints.insets=new Insets(10, 10, 20, 20);
		
		gridBagLayout.setConstraints(component, gridBagConstraints);
		add(component); //컴포넌트 고유의 크기를 유지하면서 add
	}

}
