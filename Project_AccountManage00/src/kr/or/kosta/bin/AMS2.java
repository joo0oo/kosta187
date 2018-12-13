package kr.or.kosta.bin;

import java.util.List;

import kr.or.kosta.boundary.AMSViewFrame;
import kr.or.kosta.entity.Account;
import kr.or.kosta.entity.AccountException;
import kr.or.kosta.entity.AccountManager2;
import kr.or.kosta.entity.MinusAccount;

/**
 * 
 * 은행 계좌 관리 애플리케이션
 * @author 송주현
 *
 */
public class AMS2 {

	public static void main(String[] args) {
		AccountManager2 manager = new AccountManager2(100); 
		AMSViewFrame amsFrame = new AMSViewFrame();
		amsFrame.setAccountManager(manager);
				
		
		amsFrame.setContents();
		amsFrame.eventRegist();
		
		amsFrame.setSize(600,500);
		amsFrame.setVisible(true);
		
		
		/*
		 * Account account = new Account("1111-2222-3333", "김기정", 1233, 200000); 
		try {
			manager.add(account);		
			manager.add(new Account("2222-3333-4444", "박지성", 0000, 200000));
			manager.add(new Account("3333-9999-6666", "손흥민", 3333, 100000));
			manager.add(new Account("7777-7777-7777", "손흥민", 9999, 55000));
			manager.add(new Account("8080-2020-8080", "손흥민", 6424, 800000));
			manager.add(new Account("8888-7777-4444", "류세은", 6554, 555000));
			manager.add(new MinusAccount("1234-4567-4567", "김대출", 8888, 1000, 100000000));
			manager.add(new MinusAccount("1114-4567-6666", "홍길동", 2222, 5000, 50000000));	
			manager.add(new Account("6777-1877-6036", "박찬동", 0030, 15200));
		} catch (AccountException e) {
			System.out.println(e.getMessage());
		}
		
		
		
		List list = manager.list(); //전체 리스트를 리턴
		System.out.println("====전체 계좌 목록====");
		for (Object object : list) {
			System.out.println(((Account)object).toString());
		}
		System.out.println();
		
		try {
			Account ac1=manager.get("3333-9999-6666");
			Account ac2=manager.get("6777-1877-6036");
			System.out.println("====계좌번호 검색 결과====");
			ac1.print();
			ac2.print();
			System.out.println();
		}catch (AccountException e) {
			System.out.println(e.getMessage());
		}
		
		
		
		List searchList= manager.search("손흥민");
		System.out.println("====예금주명 검색 결과====");
		for (Object object : searchList) {
			System.out.println(((Account)object).toString());
		}
		System.out.println();
		manager.remove("2222-3333-4444");
		manager.remove("7777-7777-7777");
		
		list = manager.list(); //전체 리스트를 리턴
		System.out.println("====전체 계좌 목록====");
		for (Object object : list) {
			System.out.println(((Account)object).toString());
		}
		
		*/
		
		
	}

}
