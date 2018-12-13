/**
 * 일상생활의 객체를 추상화하기위한 모델링 클래스 정의
 * 은행 계좌 객체
 * 
 */

public class Account {

	//static 초기화 블럭 (특수한 목적의 명령어 실행)
	static {
		System.out.println("초기화 블럭 실행..1");
		System.out.println("초기화 블럭 실행..2");
	}

	//클래스 (static) 변수 (공유됨)
//	public static String bankName ="하나은행";
	public static final String bankName ="하나은행";

	//인스턴스 변수 선언
	private String accountNum;
	private String accountOwner;
	private int passwd;
	private long restMoney;

	
	Account(){
		this(null,null); 
	}

	// 생성자 오버로딩
	Account(String accountNum, String accountOwner){
		this(accountNum, accountOwner, 0, 0); //다른 생성자를 호출해서 코드를 심플하게
	}

	Account(String accountNum, String accountOwner, int passwd, long restMoney){
		this.accountNum = accountNum;
		this.accountOwner = accountOwner;
		this.passwd = passwd;
		this.restMoney = restMoney;
	}

	// setter/getter 메소드
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
	

	@Override
	public boolean equals(Object obj) {	
		if(obj instanceof Account) {
			return this.toString().equals(obj.toString());
		}
		return false;
	}

	
	@Override
	public int hashCode() {		
		//return 999;
		return toString().hashCode();
	}
	

	//인스턴스 메소드
	long deposit( long money) throws AccountException{
		if(money <= 0) {
			throw new AccountException("출금하고자 하는 금액은 음수일 수 없습니다",-1);
		}
		restMoney += money;
		return restMoney;
	}
	
	public long withdraw(long money) throws AccountException{
		if(money <= 0) {
			throw new AccountException("출금하고자 하는 금액은 음수일 수 없습니다",-1);
		}else if(money > this.restMoney) {
			throw new AccountException("잔액이 부족합니다",-2);
		}
		restMoney -= money;
		return restMoney;		
	}

	long getRestMoney(){
		return restMoney;
	}
	
	boolean checkPasswd(int pw){
		return passwd == pw;
	}

	public void print() { //콘솔창에 출력하는 메소드 (콘솔에서만 사용가능하므로 유연성 떨어짐)
		System.out.println(this.accountNum+"\t"+this.accountOwner+"\t"+" **** "+"\t"+this.restMoney);
	}
	public String toString() { 
		//문자열 자체를 리턴 (어플리케이션 클래스에서 자유롭게 결과값을 사용 가능해서 유연성 good
		// 리턴받는 쪽에서 알아서 콘솔/모바일/웹에 출력하도록 사용 가능해짐
		return this.accountNum+"\t"+this.accountOwner+"\t"+" **** "+"\t"+this.restMoney;
	}
	
	
	
	public boolean checkAccountNum(String accountNum) {
		return this.accountNum.equals(accountNum);		
	}


	//클래스 (static) 메소드
	public static int sum(int a, int b){
		return a+b;
	}
	

}
