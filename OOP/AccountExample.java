/**
 * ���α׷� ������ ���� ���ø����̼� Ŭ���� ����
 */


class AccountExample {
	public static void main(String[] args)	{
		System.out.println(" ���� ���� ���ø����̼� ���۵�... ");
		
		/*
		//Ŭ�����κ��� ��ü(�ν��Ͻ�) ����
		Account account; //����(���۷���)���� 
		account = new Account();  //�ּ� �Ҵ�
		
		//�ν��Ͻ��� �Ӽ��� ��� ���
		account.accountNum= "1111-2222-3333";
		account.accountOwner= "�����";
		account.restMoney= 100000;
		account.passwd= 1234;
		*/

		Account account = new Account("1111-2222-3333", "�����", 100000,1234);
		
		int passwd=1234;
		boolean result= account.checkPasswd(passwd);

		if(result){
			long money = account.deposit(100000);
			System.out.println("�Ա� �� �ܾ� : "+money);
			money= account.withdraw(10000);
			System.out.println("��� �� �ܾ� : "+money);
		}else{
			System.out.println("��й�ȣ�� Ȯ���ϼ��� ");

		}

		//System.out.println(account.accountNum);

		Account account2 = new Account(); 
		//�ν��Ͻ� ������ ���������� �޸� �ڵ����� �ʱ�ȭ�ȴ� 
		//���ڴ� 0, Ŭ�������� Null (string�� null�� �ʱ�ȭ)

		System.out.println(account2.getAccountNum());
		System.out.println(account2.getAccountOwner());
		System.out.println(account2.getRestMoney());
		System.out.println(account2.getPasswd());

		Account account3 = new Account("2222-2222-3333", "ȫ�浿");
		
		// static Ű���� : �� �ν��Ͻ����� �ϳ��� ���°� �ƴ϶� ��ü �޸𸮿� 1���� �ΰ� ��� �ν��Ͻ��鳢�� ����
		System.out.println(Account.bankName); //static ���� ���, �ν��Ͻ� �������� �ʰ� �ٷ� ����
		//Account.bankName="Hana Bank"; //final ������ �б������̶� ����Ұ� ������ ����
		System.out.println(Account.sum(30,20)); //static �޼ҵ� ���, �ν���Ʈ �������� �ʰ� ȣ��

		System.out.println(" ���� ���� ���ø����̼� �����... ");
	}
}
