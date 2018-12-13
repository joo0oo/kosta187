package kr.or.kosta.jsp;


/**
 * JavaBean
 * 
 */

public class Account {

	public static final String bankName ="하나은행";

	private String accountNum;
	private String accountOwner;
	private int passwd;
	private long restMoney;
	
	public Account(){
		this(null,null); //궁극적으로는 맨 마지막 생성자가 호출됨
	}

	// 생성자 오버로딩
	public Account(String accountNum, String accountOwner){
		this(accountNum, accountOwner, 0, 0); //다른 생성자를 호출해서 코드를 심플하게
	}

	public Account(String accountNum, String accountOwner, int passwd, long restMoney){
		this.accountNum = accountNum;
		this.accountOwner = accountOwner;
		this.passwd = passwd;
		this.restMoney = restMoney;
	}

	// setter/getter 메소드
	public void setAccountNum(String accountNum){
		this.accountNum = accountNum;
	}
	public String getAccountNum(){
		return accountNum;
	}
	
	public void setAccountOwner(String accountOwner){
		this.accountOwner = accountOwner;
	}
	public String getAccountOwner(){
		return accountOwner;
	}

	public void setPasswd(int passwd){
		this.passwd=passwd;
	}
	public int getPasswd(){
		return passwd;
	}

	public void setRestMoney(long restMoney){
		this.restMoney= restMoney;
	}

	@Override
	public boolean equals(Object obj) {	
		if(obj instanceof Account) {
			return this.toString().equals(obj.toString());
		}
		return false;
	}

	//인스턴스 메소드
	long deposit( long money)  {
		restMoney += money;
		return restMoney;
	}
	
	public long withdraw(long money) {
		restMoney -= money;
		return restMoney;		
	}

	public long getRestMoney(){
		return restMoney;
	}
	
	boolean checkPasswd(int pw){
		return passwd == pw;
	}

	public void print() { //콘솔창에 출력하는 메소드 (콘솔에서만 사용가능하므로 유연성 떨어짐)
		System.out.println(this.accountNum+"\t"+this.accountOwner+"\t"+" **** "+"\t"+this.restMoney);
	}
	public String toString() { 
		return this.accountNum+"\t"+this.accountOwner+"\t"+" **** "+"\t"+this.restMoney;
	}
	
	public boolean checkAccountNum(String accountNum) {
		return this.accountNum.equals(accountNum);		
	}

	

}
