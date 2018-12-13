/**
 * 
 * 은행 계좌 관리 애플리케이션
 * @author 송주현
 *
 */
public class AMS2 {

	public static void main(String[] args) {
		//총 생성자 2개 만들기
		//AccountManager manager = new AccountManager(); //디폴트 생성자
		AccountManager manager = new AccountManager(100); // 사이즈 지정한 생성자 만들기
		
		
		//새로 생성된 account 객체를 manager 객체에 추가하기 
		Account account = new Account("1111-2222-3333", "김기정", 1233, 200000); 		
		manager.add(account);
		
		
		manager.add(new Account("2222-3333-4444", "박지성", 0000, 200000));
		manager.add(new Account("3333-9999-6666", "손흥민", 3333, 100000));
		manager.add(new Account("7777-7777-7777", "손흥민", 9999, 55000));
		manager.add(new Account("8080-2020-8080", "손흥민", 6424, 800000));
		manager.add(new Account("8888-7777-4444", "류세은", 6554, 555000));
		
		//업캐스팅 : Account에 MinusAccount 생성
		manager.add(new MinusAccount("1234-4567-4567", "김대출", 8888, 1000, 100000000));
		manager.add(new MinusAccount("1114-4567-6666", "홍길동", 2222, 5000, 50000000));
	
		manager.add(new Account("6777-1877-6036", "박찬동", 0030, 15200));
		
		
		Account[] list = manager.list(); //전체 리스트를 리턴
		for (Account account2 : list) {
			System.out.println(account2.toString()); //전체 리스트 출력
		}
		
		System.out.println();
		manager.remove("2222-3333-4444");
		list = manager.list(); //전체 리스트를 리턴
		for (Account account2 : list) {//전체 리스트 출력
			if(account2 instanceof MinusAccount) {
				System.out.println(" minus account : "+account2.toString()); 
			}
			else {
				System.out.println(account2.toString()); 
			}
		}
		
		
	}

}
