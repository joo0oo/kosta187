import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Vector;

/**
 * 
 * Vector 이용한 은행 계좌 관리
 * 
 * @author 송주현
 *
 */

public class AccountManager3 {
	
	
	private Vector<Account> accounts;
	//count변수 필요없음 
	
	//생성자 만들기	
	AccountManager3(){
		this(50); 
	}
	
	AccountManager3(int size){
		this.accounts= new Vector<Account>(size,5);
	}
	
	
	public Vector<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(Vector<Account> accounts) {
		this.accounts = accounts;
	}

	
	
	/**
	 * 계좌를 새로 생성해서 추가하기
	 * @param account	manager 배열에 새로 추가될 새 계좌
	 */
	public void add(Account account) { //계좌 새로 생성 : call by reference
		this.accounts.addElement(account);
	}
	
	
	/**
	 * 전체 리스트 리턴 : 현재 저장된 계좌 목록 (유효한 데이터만 반환하기)
	 * @return	전체 계좌 리스트의 레퍼런스 리턴
	 */
	public List<Account> list() { 
		ArrayList<Account> list=new ArrayList<Account>();
		Enumeration<Account> e = this.accounts.elements(); 
		while (e.hasMoreElements()) {
			list.add(e.nextElement());			
		}
		return list;
	}
	
	/**
	 * 계좌번호로 계좌 검색 
	 * @param accountNum	검색할 계좌번호
	 * @return	이 계좌번호를 가진 account 객체의 레퍼런스 리턴
	 */
	public Account get(String accountNum) { 	
		Enumeration<Account> e=this.accounts.elements();
		while(e.hasMoreElements()) {
			Account ac= (Account)e.nextElement();
			if(ac.checkAccountNum(accountNum)) {
				return ac;
			}
		}
		return null;
	}
	
	/**
	 * 예금주명으로 계좌 검색 (중복검색 처리하기) 동일인 중복 계좌는 모두 리턴 (여러개일 경우를 대비해서 배열로 리턴)
	 * @param accountOwner	예금주명
	 * @return	
	 */
	public List<Account> search(String accountOwner) { 
		
		List<Account> list=new ArrayList<Account>();		
		Enumeration<Account> e= this.accounts.elements();
		while(e.hasMoreElements()) {
			Account ac=(Account)e.nextElement();
			if(ac.getAccountOwner().equals(accountOwner)) {
				list.add(ac);
			}
		}
		
		return list;
	}
	
	/**
	 * 계좌번호를 받아서 해당 계좌를 삭제
	 * @param accountNum
	 * @return 삭제 가능하면 삭제하고 true, 삭제 불가능하면 false 리턴
	 */
	public boolean remove(String accountNum) {
		//삭제완료 true/ 삭제불가 false 리턴
		//데이터 삭제 : 참조값을 끊는 방법이 제일 간단 (null 로 설정)
		//다른방법 : 데이터 땡기기 (끊고 땡기기)
		Enumeration<Account> e=accounts.elements();
		while(e.hasMoreElements()) {
			Account ac=(Account)e.nextElement();
			if(ac.checkAccountNum(accountNum)) {
				return this.accounts.removeElement(ac);
			}
		}
		return false;
	}
	
	

}
