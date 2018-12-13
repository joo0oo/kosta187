package kr.or.kosta.entity;

import java.util.Formatter;

/**
 * 
 * Account를 확장한 마이너스 계좌
 * 
 * @author 송주현
 *
 */
public class MinusAccount extends Account {

	private long borrowMoney; // 대출 금액 변수 새로 추가

	public MinusAccount() { // 디폴트 생성자 반드시 있어야함
		this(null, null, 0, 0, 0);
	}

	public MinusAccount(String accountNum, String accountOwner, int passwd, long restMoney, long borrowMoney) {
		super(accountNum, accountOwner, passwd, restMoney); // 부모의 생성자 호출
		this.borrowMoney = borrowMoney;// 자식에서 새로 추가된 변수
	}

	public long getBorrowMoney() {
		return borrowMoney;
	}

	public void setBorrowMoney(long borrowMoney) {
		this.borrowMoney = borrowMoney;
	}

	@Override
	public long getRestMoney() {
		return super.getRestMoney() - getBorrowMoney();
	}

	@Override
	public String toString() {
		Formatter formatter = new Formatter();
		//formatter.format("%,20d", this.getBorrowMoney()).toString();
		return super.toString() + formatter.format("%,20d", this.getBorrowMoney()).toString();
	}
}
