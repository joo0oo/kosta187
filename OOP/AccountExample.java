/**
 * 프로그램 실행을 위한 애플리케이션 클래스 정의
 */


class AccountExample {
	public static void main(String[] args)	{
		System.out.println(" 은행 계좌 애플리케이션 시작됨... ");
		
		/*
		//클래스로부터 객체(인스턴스) 생성
		Account account; //참조(레퍼런스)변수 
		account = new Account();  //주소 할당
		
		//인스턴스의 속성과 기능 사용
		account.accountNum= "1111-2222-3333";
		account.accountOwner= "김기정";
		account.restMoney= 100000;
		account.passwd= 1234;
		*/

		Account account = new Account("1111-2222-3333", "김기정", 100000,1234);
		
		int passwd=1234;
		boolean result= account.checkPasswd(passwd);

		if(result){
			long money = account.deposit(100000);
			System.out.println("입금 후 잔액 : "+money);
			money= account.withdraw(10000);
			System.out.println("출금 후 잔액 : "+money);
		}else{
			System.out.println("비밀번호를 확인하세요 ");

		}

		//System.out.println(account.accountNum);

		Account account2 = new Account(); 
		//인스턴스 변수는 지역변수와 달리 자동으로 초기화된다 
		//숫자는 0, 클래스들은 Null (string은 null로 초기화)

		System.out.println(account2.getAccountNum());
		System.out.println(account2.getAccountOwner());
		System.out.println(account2.getRestMoney());
		System.out.println(account2.getPasswd());

		Account account3 = new Account("2222-2222-3333", "홍길동");
		
		// static 키워드 : 각 인스턴스들이 하나씩 갖는게 아니라 전체 메모리에 1개만 두고 모든 인스턴스들끼리 공유
		System.out.println(Account.bankName); //static 변수 출력, 인스턴스 생성하지 않고 바로 접근
		//Account.bankName="Hana Bank"; //final 변수는 읽기전용이라 변경불가 컴파일 에러
		System.out.println(Account.sum(30,20)); //static 메소드 사용, 인스턴트 생성하지 않고 호출

		System.out.println(" 은행 계좌 애플리케이션 종료됨... ");
	}
}
