package kr.or.kosta.entity;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

import javax.swing.JOptionPane;

/*
 * 
 * 파일 입출력 이용한 은행 계좌 관리
 * 
 * @author 송주현
 *
 */
public class AccountDao {
	
	/** 저장 파일 경로 */
	private static final String FILE_PATH = "amsV2.dbf";
	
	/** 레코드(계좌)수 저장을 위한 파일 컬럼 사이즈 고정 */
	private static final int RECORD_COUNT_LENGTH = 4;
	
	/** 레코드 저장을 위한 컬럼별 사이즈 고정 */
	public static final int NAME_LENGTH = 10; // 이름 10byte
	public static final int ACCOUNTNUM_LENGTH = 30; //계좌번호 30byte
	private static final int PASSWD_LENGTH = 4;  //비밀번호 4byte
	private static final int DEPOSIT_LENGTH = 8; //예금 8byte
	private static final int BORROW_LENGTH = 8; //대출금 8byte
	
	/** 계좌 정보 저장을 위한 레코드 사이즈 : 60 */
	public static final int RECORD_LENGTH = NAME_LENGTH + ACCOUNTNUM_LENGTH + PASSWD_LENGTH+ DEPOSIT_LENGTH+ BORROW_LENGTH;
	
	private RandomAccessFile file; 
	
	/* 저장된 계좌(레코드) 수 */
	private int recordCount=0;
	
	/* 디폴트 생성자*/
	public AccountDao() throws IOException {
		file= new RandomAccessFile(FILE_PATH, "rw"); //읽고 쓰기 가능한 랜덤 접근 가능한 파일 설정
		
		//이미 이 파일이 사용중인 경우
		if(file.length() != 0) {
			recordCount= file.readInt(); //파일 포인터 재설정
		}else {
			JOptionPane.showMessageDialog(null, " 처음 실행되어 파일 비어있음 ", "알림", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	/* getter */
	public int getRecordCount(){
		return recordCount; //저장된 레코드 수 리턴
	}
	
	public void add(Account account) throws IOException, AccountException {
		
		//중복된 계좌번호인 경우
		for(int i=0; i<recordCount; i++) {
			if(read(i).getAccountNum().equals(account.getAccountNum())) {
				throw new AccountException("이미 존재하는 계좌번호",-11);
			}
		}
		
		//파일의 마지막 레코드 끝으로 파일 포인터 이동 (새로 저장할 시작점)
		file.seek((recordCount*RECORD_LENGTH)+RECORD_COUNT_LENGTH);
		
		//새 레코드 (계좌) 추가
		String accountNum= account.getAccountNum();
		String name= account.getAccountOwner();
		int passwd= account.getPasswd();
		long depositMoney= account.getRestMoney();
		long borrowMoney=0L;
		if(account instanceof MinusAccount) {
			//마이너스 계좌
			borrowMoney= ((MinusAccount) account).getBorrowMoney();
		}else {
			//입출금 계좌
		}
		
		int charCount= accountNum.length();
		for(int i=0; i<(ACCOUNTNUM_LENGTH)/2; i++) {
			file.writeChar(i<charCount ? accountNum.charAt(i) : ' ');
		}
		
		charCount= name.length();
		for(int i=0; i< (NAME_LENGTH)/2; i++) {
			file.writeChar((i<charCount ? name.charAt(i) : ' '));
			//i가 name 글자수 내에 있으면 i번째 글자를 파일에 쓴다
			//i가 name 글자수 초과하면 공백을 파일에 쓴다
		}
		
		file.writeInt(passwd);
		file.writeLong(depositMoney);
		file.writeLong(borrowMoney);
		
		//레코드 저장 후 파일포인터를 파일의 처음으로 이동시키기 (이후 다른 작업 대비)
		file.seek(0);
		//저장된 레코드 수 1 증가
		file.writeInt(++recordCount);
	}
	

	/**
	 * 현재 저장된 계좌 목록 정렬해서 리턴하기 (유효한 데이터만)
	 * 
	 * @return 전체 계좌 리스트의 레퍼런스 리턴
	 * @throws IOException 
	 */
	public List<Account> list() throws IOException {
		List<Account> list = new ArrayList<Account>();
		
		for(int i=0; i<recordCount; i++) {
			//파일에 저장된 account 객체 불러와서 list에 저장
			list.add(read(i));
		}

		Collections.sort(list, new NumberCompare()); // 정렬해서 출력하기
		return list;
	}
	
	/* 한 레코드의 정보를 Account 객체로 리턴 */
	private Account read(int index) throws IOException {
		Account account = null;
		
		//파일 포인터 재설정 (index 번째 레코드로)
		file.seek((index*RECORD_LENGTH)+RECORD_COUNT_LENGTH);
		String accountNum="";
		for(int i=0; i<(ACCOUNTNUM_LENGTH)/2 ; i++) {
			accountNum += file.readChar();
		}
		accountNum= accountNum.trim();
		
		String name= "";
		for(int i=0; i<(NAME_LENGTH)/2; i++) {
			name += file.readChar();
		}
		name= name.trim();
		
		int passwd= file.readInt(); 
		long depositMoney= file.readLong();
		long borrowMoney= file.readLong();
		
		//MinusAccount 처리
		if(borrowMoney != 0) {
			account= new MinusAccount(accountNum, name, passwd, depositMoney, borrowMoney);
		}else {
			account= new Account(accountNum, name, passwd, depositMoney);
		}
		
		return account;
	}

	/**
	 * 계좌번호로 계좌 검색하기
	 * 
	 * @param accountNum 검색할 계좌번호
	 * @return 이 계좌번호를 가진 account 객체의 레퍼런스 리턴
	 * @throws IOException 
	 * @throws AccountException 
	 */
	public Account get(String accountNum) throws IOException, AccountException {
		Account account= null;
		
		for(int i=0; i<recordCount; i++) {
			account= read(i);
			if(account.getAccountNum().equals(accountNum)) {
				return account;
			}
		}
		throw new AccountException("없는 계좌번호 ", -100);
	}
	
	//이름으로 계좌 검색
	public List<Account> search(String accountOwner) throws AccountException, IOException {

		List<Account> list = new ArrayList<Account>();
		
		for(int i=0; i<recordCount; i++) {
			Account ac= read(i);
			if(ac.getAccountOwner().equals(accountOwner)) {
				list.add(ac); //이름이 일치하면 list에 추가
			}
		}
		if (list.isEmpty()) {
			throw new AccountException("해당 이름이 없음", -101);
		}
		return list;
	}

	//계좌번호로 삭제
	public boolean remove(String accountNum) throws IOException {
		Account account= null;
		int deleteIndex=0; //삭제할 계좌 객체의 인덱스
		
		if(recordCount ==0) { //파일에 아무것도 저장되어있지 않은 경우
			return false;	//삭제 불가		
			
		} else if(recordCount ==1 ) { //파일에 1개 저장된 경우
			//포인터 설정
			file.seek(((recordCount-1)*RECORD_LENGTH)+RECORD_COUNT_LENGTH);
			
			//계좌번호 일치하는지 확인
			if(read(0).getAccountNum().equals(accountNum)) {
				for(int j=0; j<(ACCOUNTNUM_LENGTH)/2; j++) {
					file.writeChar(' ');
				}
				for(int j=0; j< (NAME_LENGTH)/2; j++) {
					file.writeChar(' ');
				}
				file.writeInt(0);
				file.writeLong(0);
				file.writeLong(0L);
				
				//총 저장된 레코드 수 1 감소
				file.seek(0);
				file.writeInt(--recordCount);
				
				return true; //삭제 완료
			}
			
			return false; //삭제 불가능
			
		} else { //파일에 계좌 여러개 저장된 경우
					
			for(int i=0; i<recordCount; i++) {
				account= read(i);
				if(account.getAccountNum().equals(accountNum)) {//계좌번호 일치하는지 확인
					
					deleteIndex=i;//삭제할 계좌 인덱스 가져오기
					
					//맨 마지막 account 가져오기
					Account lastAcc= read(recordCount-1);
					
					// 맨 마지막 account를 index 번째에 덮어쓰기 
					// 삭제할 레코드 맨 앞으로 포인터 이동
					file.seek(((deleteIndex)*RECORD_LENGTH)+RECORD_COUNT_LENGTH);
					
					//덮어쓰기
					int charCount= lastAcc.getAccountNum().length();
					for(int j=0; j<(ACCOUNTNUM_LENGTH)/2; j++) {
						file.writeChar(j<charCount ? lastAcc.getAccountNum().charAt(j) : ' ');
					}
					charCount= lastAcc.getAccountOwner().length();
					for(int j=0; j< (NAME_LENGTH)/2; j++) {
						file.writeChar((j<charCount ? lastAcc.getAccountOwner().charAt(j) : ' '));
					}
					file.writeInt(lastAcc.getPasswd());
					file.writeLong(lastAcc.getRestMoney());
					if(lastAcc instanceof MinusAccount) {
						file.writeLong(((MinusAccount) lastAcc).getBorrowMoney());
					}else {
						file.writeLong(0L);
					}
					
					//총 저장된 레코드 수 1 감소
					file.seek(0);
					file.writeInt(--recordCount);
					
					return true; //삭제 완료
				}
			}
		}
		
		return false;
	}
	
	//스트림 닫기 ; 여기서 try catch로 잡아야 main에서 사용가능
	public void close() {
		if(file!= null) {
			try {
				file.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	
}
