/**
 * 프로그램 실행을 위한 애플리케이션 클래스 정의
 */


class AccountExample2 {
	public static void main(String[] args)	{
		System.out.println(" 은행 계좌 애플리케이션 시작됨... ");
	
		Account account = new Account("1111-2222-3333", "김기정", 100000,1234);
		
		int passwd=1234;
		boolean result= account.checkPasswd(passwd);

		if(result) {
			long money=0;
			try {
				money = account.deposit(100000);
				System.out.println("입금 후 잔액 : "+money);
				account.deposit(-5000);
				System.out.println("입금 후 잔액 : "+money);
			} catch (AccountException e) {
				System.out.println(e.getMessage());
			}
		}

		else{
			System.out.println("비밀번호를 확인하세요 ");

		}

	
		Account account2 = new Account(); 		

		System.out.println(account2.getAccountNum());
		System.out.println(account2.getAccountOwner());
		System.out.println(account2.getRestMoney());
		System.out.println(account2.getPasswd());

		Account account3 = new Account("2222-2222-3333", "홍길동");		
		
		System.out.println(Account.bankName); 
		System.out.println(Account.sum(30,20)); 
		
		
		AccountManager2 am2= new AccountManager2(5);
		am2.add(account);
		am2.add(account2);
		am2.add(account3);
		
		System.out.println(" 은행 계좌 애플리케이션 종료됨... ");
	}
}
