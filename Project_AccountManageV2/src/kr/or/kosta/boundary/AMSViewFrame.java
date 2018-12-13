package kr.or.kosta.boundary;

import java.awt.Component;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.List;

import javax.swing.JOptionPane;

import kr.or.kosta.entity.Account;
import kr.or.kosta.entity.AccountDao;
import kr.or.kosta.entity.AccountException;
import kr.or.kosta.entity.MinusAccount;
/**
 * AMS에서 실행될 Frame 객체
 * AMSInputPanel을 멤버로 가진다
 * 이벤트 처리하는 코드가 여기에 포함됨
 * @author 송주현
 *
 */

public class AMSViewFrame extends Frame {
	AMSInputPanel inputPanel; //미리 만들어둔 AMSInputPanel (데이터 입력받는 용도)
	Label accountListL, currencyL; 
	TextArea outputTA; //이벤트 결과가 출력되는 TextArea 

	GridBagLayout gridBagLayout; //레이아웃 설정
	GridBagConstraints gridBagConstraints; //레이아웃 설정

	//AccountManager accountManager; //실제 Account 데이터를 처리하는 AccountManager

	AccountDao accountDao;
	/**
	 * 디폴트 생성자
	 */
	public AMSViewFrame() {
		this("KOSTA AMS - 메인화면");
	}

	/**
	 * 생성자
	 * @param title Frame 제목
	 */
	public AMSViewFrame(String title) {
		super(title);
		inputPanel = new AMSInputPanel();
		outputTA = new TextArea();
		
		gridBagLayout = new GridBagLayout();
		gridBagConstraints = new GridBagConstraints();

		//accountManager = null;
		accountDao = null;
	}

	public AccountDao getAccountDao() {
		return accountDao;
	}

	public void setAccountDao(AccountDao accountDao) throws IOException {
		this.accountDao = accountDao;
	}

	/**
	 * Frame의 컴포넌트들을 배치하기
	 * 레이아웃 설정하고 inputPanel과 outputTA를 배치
	 */
	public void setContents() {
		setLayout(gridBagLayout);
		inputPanel.setContents();

		add(inputPanel, 0, 0, 1, 1, 0, 0);
		add(outputTA, 0, 2, 1, 1, 1, 0);
	}

	
	/**
	 * 윈도 창을 X를 눌러 종료시키기
	 */
	public void finish() {
		setVisible(false);
		dispose();
		System.exit(0);
	}

	
	/**
	 * 이벤트 처리 메서드
	 */
	public void eventRegist() {

		/*
		 * 창 닫기
		 */
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				accountDao.close();
				finish();
			}
		});

		/*
		 * 계좌번호로 계좌 조회하기
		 * acocuntNumTF에 입력받은 값으로 AccountDao의 파일에서 검색
		 * accountNumTF가 공백이 아닐 경우 조회 결과를 outputTA에 출력
		 * 공백일 경우 알림창 띄우기
		 */
		inputPanel.numGetB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				outputTA.setText("");
				String accountNum = inputPanel.accountNumTF.getText();

				if (inputPanel.accountNumTF.getText().length() != 0) {
					outputTA.append("------------------------------------------------------------------------------------\n");
					outputTA.append(String.format("%5s %15s %5s %12s %12s", "계좌종류", "계좌번호", "예금주명", "현재잔액", "대출금액"));
					outputTA.append("\n====================================================================================\n");
					
					try {
						if ((accountDao.get(accountNum)) instanceof MinusAccount) {
							outputTA.append("마이너스\t" + accountDao.get(accountNum).toString() + "\n");
						} else if(accountDao.get(accountNum) instanceof Account) {
							outputTA.append("입출금\t" + accountDao.get(accountNum).toString() + "\n");
						} else {
							JOptionPane.showMessageDialog(null, " 해당 없음 ", "알림", JOptionPane.INFORMATION_MESSAGE);
							outputTA.append("해당 없음");
						}
						outputTA.append("---------------------------------------------------\n");
					}catch (IOException e1) {
						JOptionPane.showMessageDialog(null, " File IO Error ", "알림", JOptionPane.INFORMATION_MESSAGE);
					}catch (AccountException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(), "알림", JOptionPane.INFORMATION_MESSAGE);
					}
					
				} else {
					JOptionPane.showMessageDialog(null, " 빈칸있음 ", "알림", JOptionPane.INFORMATION_MESSAGE);
				}
				setBlankTF(); //textField 빈칸으로 초기화
			}
		});

		/*
		 * 계좌번호로 계좌 삭제하기
		 * acocuntNumTF에 입력받은 값으로 AccountDao의 파일에서 검색
		 * accountNumTF가 공백이 아닐 경우 해당 Account를 AccountDao의 파일에서 삭제
		 * 공백일 경우 알림창 띄우기
		 */
		inputPanel.numRemoveB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				outputTA.setText("");
				String accountNum = inputPanel.accountNumTF.getText();

				try {
					if (accountDao.remove(accountNum)) {
						JOptionPane.showMessageDialog(null, " 삭제됨 ", "알림", JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, " 삭제할수 없음 ", "알림", JOptionPane.INFORMATION_MESSAGE);
					}
				} catch (HeadlessException | IOException e) {
					e.printStackTrace();
				}

				setBlankTF(); //textField 빈칸으로 초기화
			}
		});

		/*
		 * 예금주명으로 계좌 찾기
		 * acocuntNameTF에 입력받은 값으로 AccountDao의 파일에서 검색
		 * acocuntNameTF가 공백이 아닐 경우 모든 조회 결과를 outputTA에 출력
		 * 예금주명은 여러개일 수 있으므로 List로 리턴받아 출력
		 * acocuntNameTF가 공백일 경우 알림창 띄우기
		 */
		inputPanel.nameSearchB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				outputTA.setText("");

				String accountName = inputPanel.accountNameTF.getText();

				if (accountName.length() != 0) { // 이름에 유효한 값이 들어오면
					outputTA.append("------------------------------------------------------------------------------------\n");
					outputTA.append(String.format("%5s %15s %5s %12s %12s", "계좌종류", "계좌번호", "예금주명", "현재잔액", "대출금액"));
					outputTA.append("\n====================================================================================\n");
					List<Account> list = null;

					try {
						list = accountDao.search(accountName);// 전체 리스트를 리턴
						for (Account account2 : list) {// 전체 리스트 출력
							if (account2 instanceof MinusAccount) {
								outputTA.append("마이너스\t" + account2.toString() + "\n");
							} else {
								outputTA.append("입출금\t" + account2.toString() + "\n");
							}
						}

					} catch (AccountException e) {
						JOptionPane.showMessageDialog(null, e.getMessage(), "알림", JOptionPane.INFORMATION_MESSAGE);
					} catch (IOException e) {
						e.printStackTrace();
					}

					outputTA.append("------------------------------------------------------------------------------------\n");

				} else {
					JOptionPane.showMessageDialog(null, " 이름을 입력하세요 ", "알림", JOptionPane.INFORMATION_MESSAGE);
				}

				setBlankTF(); // textField 빈칸으로 초기화
			}
		});

		/*
		 * 계좌 종류가 [마이너스계좌]가 선택되었을 때만 [대출금액]입력창 활성화시키기
		 */
		inputPanel.accountC.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (inputPanel.accountC.getSelectedItem().equals("마이너스계좌")) {
					inputPanel.borrowTF.setEnabled(true);
				} else {
					inputPanel.borrowTF.setEnabled(false);
				}
			}
		});

		/*
		 * 새 계좌 추가하기
		 * 각 textField에 입력받은 값으로 AccountManager의 Hashtable에 추가
		 * textField에 공백이 있는 경우 새 계좌 추가 불가능 : 알림창 띄우기 (isEmptyTF 메서드로 체크)
		 * 이미 존재하는 계좌번호인 경우 추가 불가능 : 알림창 띄우기 (AccountException으로 체크)
		 * 정상적으로 추가된 경우 알림창 띄우기
		 */
		inputPanel.addNewB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				outputTA.setText("");
				String accountKind = inputPanel.accountC.getSelectedItem();

				try {
					if (accountKind.equals("입출금계좌")) { 
						isTypedTF(1); //'입출금계좌'가 선택되고 입력 textField에 빈칸이 없는지 확인
						isValidVal(1); //'입출금계좌'가 선택되고 textField가 유효한 값인지 확인
						String accountNum = inputPanel.accountNumTF.getText();
						String accountName = inputPanel.accountNameTF.getText();
						int passwd = Integer.parseInt(inputPanel.passwdTF.getText());
						int depositMoney = Integer.parseInt(inputPanel.depositTF.getText());
						accountDao.add(new Account(accountNum, accountName, passwd, depositMoney));
						JOptionPane.showMessageDialog(null, " 추가됨 ", "알림", JOptionPane.INFORMATION_MESSAGE);
						
					} else if (accountKind.equals("마이너스계좌") ) { 
						isTypedTF(2); //'마이너스계좌'가 선택되고 입력 textField에 빈칸이 없는지 확인
						isValidVal(2); //'마이너스계좌'가 선택되고 textField가 유효한 값인지 확인
						String accountNum = inputPanel.accountNumTF.getText();
						String accountName = inputPanel.accountNameTF.getText();
						int passwd = Integer.parseInt(inputPanel.passwdTF.getText());
						int depositMoney = Integer.parseInt(inputPanel.depositTF.getText());
						int borrowMoney = Integer.parseInt(inputPanel.borrowTF.getText());
						accountDao.add(new MinusAccount(accountNum, accountName, passwd, depositMoney, borrowMoney));
						JOptionPane.showMessageDialog(null, " 추가됨 ", "알림", JOptionPane.INFORMATION_MESSAGE);  
					} 
					
				} catch(AccountException e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "알림", JOptionPane.INFORMATION_MESSAGE);
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null, " IOException 에러 ", "알림", JOptionPane.INFORMATION_MESSAGE);
				} 

				setBlankTF(); //textField 빈칸으로 초기화

			}
		});

		
		/*
		 * 현재 AccountDao에 저장된 전체 계좌 조회하기
		 */
		inputPanel.showAllB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				outputTA.setText("");

				List<Account> list;
				try {
					list = accountDao.list();// accountDao에 저장된 전체 Account 리스트를 리턴하는 메서드
					outputTA.append("------------------------------------------------------------------------------------\n");
					outputTA.append(String.format("%5s %15s %5s %12s %12s", "계좌종류", "계좌번호", "예금주명", "현재잔액", "대출금액"));
					outputTA.append("\n====================================================================================\n");
					for (Account account : list) { // 전체 리스트 출력하기
						if (account instanceof MinusAccount) {
							outputTA.append("마이너스\t" + account.toString() + "\n");
						} else {
							outputTA.append("입출금\t" + account.toString() + "\n");
						}
					}
					outputTA.append("------------------------------------------------------------------------------------\n");
				} catch (IOException e) {
					e.printStackTrace();
				} 
				
			}
		});

	}

	/**
	 * Frame에 gridBagLayout을 적용해서 컴포넌트를 붙이기 위한 메서드
	 * @param component 패널에 붙일 컴포넌트
	 * @param gridX x축
	 * @param gridY y축
	 * @param gridWidth 가로로 합칠 격자 수
	 * @param gridHeight 세로로 합칠 격자 수
	 * @param weightX 가로 가중치
	 * @param weightY 세로 가중치
	 */
	private void add(Component component, int gridX, int gridY, int gridWidth, int gridHeight, double weightX, double weightY) {
		gridBagConstraints.gridx = gridX; // x축
		gridBagConstraints.gridy = gridY; // y축
		gridBagConstraints.gridwidth = gridWidth;// 몇개의 격자를 합칠 것인가
		gridBagConstraints.gridheight = gridHeight; // 몇개의 격자를 합칠 것인가

		gridBagConstraints.weightx = weightX;
		gridBagConstraints.weighty = weightY;
		gridBagConstraints.fill = gridBagConstraints.HORIZONTAL;
		gridBagConstraints.insets = new Insets(10, 10, 20, 20);

		gridBagLayout.setConstraints(component, gridBagConstraints);
		add(component); // 컴포넌트 고유의 크기를 유지하면서 add
	}

	/**
	 * 계좌 추가할 때 입력 textField에 빈칸이 있는지 확인하기
	 * @param caseNum 입출금계좌/마이너스계좌인 경우 구분하는 인자
	 * @return 빈칸이 하나라도 있으면 throw 예외 처리/ 없으면 정상 종료
	 * @throws AccountException 빈칸 예외 처리
	 */
	private void isTypedTF(int caseNum) throws AccountException {

		//대출금을 제외한 모든 textField가 채워져있는 경우
		if (inputPanel.accountNumTF.getText().length() != 0 && inputPanel.accountNameTF.getText().length() != 0
				&& inputPanel.passwdTF.getText().length() != 0 && inputPanel.depositTF.getText().length() != 0) {
			
			switch (caseNum) {
			case 1: // 입출금 계좌 선택된 경우
				//전부 입력됨 
				return;
			case 2: // 마이너스 계좌 선택된 경우
				if (inputPanel.borrowTF.getText().length() != 0) {
					//전부 입력됨 
					return;
				} else {
					//빈칸 있음
					throw new AccountException("빈칸이 있습니다",-77);
				}
			}
		}
		
		//if문 벗어나면 대출금 제외한 4가지 필드중 하나라도 빈칸 있는 경우임
		throw new AccountException("빈칸이 있습니다",-77);
		
	}
	
	/**
	 * 텍스트 필드에 입력된 값이 유효한지 검증하는 메서드
	 * 유효하지 않은 값이 하나라도 있으면 throw 예외 처리/ 없으면 정상 종료
	 * @param caseNum 입출금계좌/마이너스계좌인 경우 구분하는 인자
	 * @throws AccountException 빈칸 예외 처리
	 */
	private void isValidVal(int caseNum) throws AccountException {
		String accountNum = inputPanel.accountNumTF.getText().trim();
		if(accountNum.length() > (accountDao.ACCOUNTNUM_LENGTH/2) ) {
			//범위 초과
			throw new AccountException("범위 초과한 값입니다",-77);
		}
		
		String accountName = inputPanel.accountNameTF.getText().trim();
		if(accountName.length() > (accountDao.NAME_LENGTH/2) ) {
			//범위 초과
			throw new AccountException("범위 초과한 값입니다",-77);
		}
		
		//숫자 값들은 문자인지 한번 더 확인
		try {
			int passwd = Integer.parseInt(inputPanel.passwdTF.getText().trim());
			if(passwd > 9999 || passwd <0) {
				//범위 초과
				throw new AccountException("범위 초과한 값입니다",-77);
			}
			
			long depositMoney = Long.parseLong(inputPanel.depositTF.getText().trim());
			if( depositMoney > Long.MAX_VALUE || depositMoney < 0) {
				//범위 초과
				throw new AccountException("범위 초과한 값입니다",-77);
			}
		} catch(NumberFormatException e){
			throw new AccountException("유효하지 않은 값입니다",-77);
		}
		
		
		switch (caseNum) {
		case 1: // 입출금 계좌 선택된 경우
			break;
		case 2: // 마이너스 계좌 선택된 경우
			long borrowMoney = Long.parseLong(inputPanel.borrowTF.getText().trim());
			if( borrowMoney > Long.MAX_VALUE || borrowMoney < 0) {
				//범위 초과
				throw new AccountException("범위 초과한 값입니다",-77);
			}
			break;
		}
	}

	/**
	 * textField 빈칸으로 초기화하기
	 */
	private void setBlankTF() {
		inputPanel.accountNumTF.setText("");
		inputPanel.accountNameTF.setText("");
		inputPanel.passwdTF.setText("");
		inputPanel.depositTF.setText("");
		inputPanel.borrowTF.setText("");
	}

}
