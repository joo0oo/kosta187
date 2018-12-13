/**
 * �ϻ��Ȱ�� ��ü�� �߻�ȭ�ϱ����� �𵨸� Ŭ���� ����
 * ���� ���� ��ü
 * 
 */

public class Account {

	//static �ʱ�ȭ ���� (Ư���� ������ ���ɾ� ����)
	static {
		System.out.println("�ʱ�ȭ ���� ����..1");
		System.out.println("�ʱ�ȭ ���� ����..2");
	}

	//Ŭ���� (static) ���� (������)
//	public static String bankName ="�ϳ�����";
	public static final String bankName ="�ϳ�����";

	//�ν��Ͻ� ���� ����
	private String accountNum;
	private String accountOwner;
	private int passwd;
	private long restMoney;

	// ������ (���� �ʱ�ȭ) : �޼ҵ�ó�� �������� ����Ÿ�� ���� 
	// ���� ������ �������� ������ ����Ʈ �����ڰ� ����
	// �����ڸ� ���� ����� ����Ʈ �����ڰ� ������ ����
	Account(){
		this(null,null); //�ñ������δ� �� ������ �����ڰ� ȣ���
	}

	// ������ �����ε�
	Account(String accountNum, String accountOwner){
		//this.accountNum = accountNum;
		//this.accountOwner = accountOwner;
		this(accountNum, accountOwner, 0, 0); //�ٸ� �����ڸ� ȣ���ؼ� �ڵ带 �����ϰ�
	}

	Account(String accountNum, String accountOwner, int passwd, long restMoney){
		this.accountNum = accountNum;
		this.accountOwner = accountOwner;
		this.passwd = passwd;
		this.restMoney = restMoney;
	}

	// setter/getter �޼ҵ�
	void setAccountNum(String accountNum){
		this.accountNum = accountNum;
	}
	String getAccountNum(){
		return accountNum;
	}
	
	void setAccountOwner(String accountOwner){
		this.accountOwner = accountOwner;
	}
	String getAccountOwner(){
		return accountOwner;
	}

	void setPasswd(int passwd){
		this.passwd=passwd;
	}
	int getPasswd(){
		return passwd;
	}

	void setRestMoney(long restMoney){
		this.restMoney= restMoney;
	}
	/*
	long getRestMoney(){
		return restMoney;
	}
	*/



	/*
	//���� ����� ����Ʈ ������ (�Ű����� ���� : ȣ���� �׳� new (); )
	Account(){
		accountNum=null;
		accountOwner=null;
		passwd=0;
		restMoney=0L;
	}
	*/

	//�ν��Ͻ� �޼ҵ�
	long deposit( long money){
		restMoney += money;
		return restMoney;
	}
	
	long withdraw(long money){
		restMoney -= money;
		return restMoney;		
	}

	long getRestMoney(){
		return restMoney;
	}
	
	boolean checkPasswd(int pw){
		return passwd == pw;
	}

	//Ŭ���� (static) �޼ҵ�
	public static int sum(int a, int b){
		return a+b;
	}

}