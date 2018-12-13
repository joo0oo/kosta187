package kr.or.kosta.entity;

import java.util.Formatter;

/**
 * 일상생활의 객체를 추상화하기위한 모델링 클래스 정의 은행 계좌 객체
 * @author 송주현
 * 
 */

public class Account {

	public static final String bankName = "KOSTA 은행";

	// 인스턴스 변수 선언
	private String accountNum;
	private String accountOwner;
	private int passwd;
	private long restMoney;

	Account() {
		this(null, null); // 궁극적으로는 맨 마지막 생성자가 호출됨
	}

	Account(String accountNum, String accountOwner) {
		this(accountNum, accountOwner, 0, 0); // 다른 생성자를 호출해서 코드를 심플하게
	}

	public Account(String accountNum, String accountOwner, int passwd, long restMoney) {
		this.accountNum = accountNum;
		this.accountOwner = accountOwner;
		this.passwd = passwd;
		this.restMoney = restMoney;
	}

	// setter/getter 메소드
	void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}

	String getAccountNum() {
		return accountNum;
	}

	void setAccountOwner(String accountOwner) {
		this.accountOwner = accountOwner;
	}

	String getAccountOwner() {
		return accountOwner;
	}

	void setPasswd(int passwd) {
		this.passwd = passwd;
	}

	int getPasswd() {
		return passwd;
	}

	void setRestMoney(long restMoney) {
		this.restMoney = restMoney;
	}
	/*
	 * long getRestMoney(){ return restMoney; }
	 */

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Account) {
			return this.toString().equals(obj.toString());
		}
		return false;
	}

	// 인스턴스 메소드
	long deposit(long money) throws AccountException {
		if (money <= 0) {
			throw new AccountException("출금하고자 하는 금액은 음수일 수 없습니다", -1);
		}
		restMoney += money;
		return restMoney;
	}

	public long withdraw(long money) throws AccountException {
		if (money <= 0) {
			throw new AccountException("출금하고자 하는 금액은 음수일 수 없습니다", -1);
		} else if (money > this.restMoney) {
			throw new AccountException("잔액이 부족합니다", -2);
		}
		restMoney -= money;
		return restMoney;
	}

	long getRestMoney() {
		return restMoney;
	}

	boolean checkPasswd(int pw) {
		return passwd == pw;
	}

	public void print() { // 콘솔창에 출력하는 메소드 (콘솔에서만 사용가능하므로 유연성 떨어짐)
		System.out.println(this.accountNum + "\t" + this.accountOwner + "\t" + " **** " + "\t" + this.restMoney);
	}

	public String toString() {
		Formatter formatter = new Formatter();
		return formatter.format("%10s %5s %,20d", this.accountNum, this.accountOwner, this.restMoney).toString();
	}

	public boolean checkAccountNum(String accountNum) {
		return this.accountNum.equals(accountNum);
	}

}
