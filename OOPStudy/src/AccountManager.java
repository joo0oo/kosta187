/**
 * 과제
 * 배열을 이용한 은행 계좌 관리
 * 
 * @author 송주현
 *
 */

public class AccountManager {
	
	
	private Account[] accounts;
	private int count;
	
	//생성자 만들기
	
	AccountManager(){
		this(50); 
	}
	
	AccountManager(int size){
		this.accounts= new Account[size];
		count=0;
	}
	
	
	
	// getter setter
	public Account[] getAccounts() {
		return accounts;
	}

	public void setAccounts(Account[] accounts) {
		this.accounts = accounts;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	
	
	/**
	 * 계좌를 새로 생성해서 추가하기
	 * @param account	manager 배열에 새로 추가될 새 계좌
	 */
	public void add(Account account) { //계좌 새로 생성 : call by reference
		accounts[this.count]=account;
		this.count++;
	}
	
	
	/**
	 * 전체 리스트 리턴 : 현재 저장된 계좌 목록 (유효한 데이터만 반환하기)
	 * @return	전체 계좌 리스트의 레퍼런스 리턴
	 */
	public Account[] list() { 
		Account[] acc=new Account[this.count];
		for(int i=0; i<this.count; i++) {
			acc[i]= accounts[i];
		}
		return acc;
	}
	
	/**
	 * 계좌번호로 계좌 검색 
	 * @param accountNum	검색할 계좌번호
	 * @return	이 계좌번호를 가진 account 객체의 레퍼런스 리턴
	 */
	public Account get(String accountNum) { 
	
		for(int i=0; i<this.count; i++) {			
			if( accounts[i].checkAccountNum(accountNum) ) {
				return accounts[i];
			}				
		}		
		return null;		
	}
	
	/**
	 * 예금주명으로 계좌 검색 (중복검색 처리하기) 동일인 중복 계좌는 모두 리턴 (여러개일 경우를 대비해서 배열로 리턴)
	 * @param accountOwner	예금주명
	 * @return	
	 */
	public Account[] search(String accountOwner) { 
		
		int cnt=0;
		Account[] find= new Account[this.count];
		
		for(int i=0; i<this.count; i++) {
			if(accountOwner.equals(this.accounts[i].getAccountOwner())) {				
				find[cnt]=this.accounts[i];		
				cnt++;
			}
		}
		
		Account[] res=new Account[cnt];
		for(int i=0; i<cnt; i++) {
			res[i]= find[i];
		}
		
		return res;
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
		
		int index=0;
		boolean isRemove=false;
		for(int i=0; i<this.count; i++) {
			if(accounts[i].checkAccountNum(accountNum)) {
				index=i;
				isRemove=true;
			}
		}
		
		for(int i=index; i<this.count; i++) {
			accounts[i] = accounts[i+1];
		}
		
		if(isRemove) {
			this.count--;
			accounts[count]=null;
			return true;
		}
		
		return false;
	}
	
	

}
