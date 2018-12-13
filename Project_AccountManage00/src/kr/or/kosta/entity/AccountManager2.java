package kr.or.kosta.entity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import java.util.Vector;

/*
 * 
 * Hashtable 이용한 은행 계좌 관리
 * 
 * @author 송주현
 *
 */

public class AccountManager {
		
	private Hashtable<String, Account> accounts;
	
	//생성자 만들기	
	AccountManager(){
		this(50); 
	}
	
	public AccountManager(int size){
		this.accounts= new Hashtable<String, Account>(size);
	}
	
	
	public Hashtable getAccounts() {
		return accounts;
	}

	public void setAccounts(Hashtable<String, Account> accounts) {
		this.accounts = accounts;
	}

	
	
	/**
	 * 계좌를 새로 생성해서 추가하기
	 * @param account	manager 배열에 새로 추가될 새 계좌
	 */
	public void add(Account account) throws AccountException{
		if(accounts.containsKey(account.getAccountNum())) {
			throw new AccountException("이미 등록된 계좌번호 ",-100);
		}
		this.accounts.put(account.getAccountNum(),account);
	}
	
	
	/**
	 * 전체 리스트 리턴 : 현재 저장된 계좌 목록 (유효한 데이터만 반환하기)
	 * @return	전체 계좌 리스트의 레퍼런스 리턴
	 */
	public List<Account> list() { 
		List<Account> list=new ArrayList<Account>();
		Enumeration<Account> e = this.accounts.elements(); 
		while (e.hasMoreElements()) {
			Account ac= e.nextElement();
			list.add(ac);			
		}
		
		Collections.sort(list, new NumberCompare()); //정렬해서 출력하기
		return list;
	}
	
	/**
	 * 계좌번호로 계좌 검색 
	 * @param accountNum	검색할 계좌번호
	 * @return	이 계좌번호를 가진 account 객체의 레퍼런스 리턴
	 */
	public Account get(String accountNum) throws AccountException { 
		if(!accounts.containsKey(accountNum)) {
			throw new AccountException("없는 계좌번호 ",-100);
		}
		return this.accounts.get(accountNum);
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
		Enumeration<Account> e=accounts.elements();
		while(e.hasMoreElements()) {
			Account ac=(Account)e.nextElement();
			if(ac.checkAccountNum(accountNum)) {
				return this.accounts.remove(accountNum, ac);
			}
		}
		return false;
	}
}
