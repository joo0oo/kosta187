/**
 * 
 * Account를 확장한 마이너스 계좌
 * @author 송주현
 *
 */
public class MinusAccount extends Account {

	private long borrowMoney; //대출 금액 변수 새로 추가
	
	public MinusAccount() { //디폴트 생성자 반드시 있어야함
		this(null,null,0,0,0);		
	}
	
	//자식의 생성자를 만들때는 부모의 생성자도 고려해야 한다
	public MinusAccount(String accountNum, String accountOwner, int passwd, long restMoney, long borrowMoney) {
		super(accountNum,accountOwner,passwd,restMoney); //부모의 생성자 호출
		this.borrowMoney = borrowMoney;//자식에서 새로 추가된 변수
	}
	
	//setter getter 만들기
	public long getBorrowMoney() {
		return borrowMoney;
	}

	public void setBorrowMoney(long borrowMoney) {
		this.borrowMoney = borrowMoney;
	}
	
	//getRestMoney() 함수를 오버라이딩 해야한다
	@Override
	public long getRestMoney() {		
		return super.getRestMoney() - getBorrowMoney();
	}
	
	@Override
	public String toString() {
		return super.toString()+"\t"+this.getBorrowMoney();
	}
	
	
	
	public static void main(String[] args) {
		MinusAccount minusAccount = new MinusAccount(); //디폴트 생성자 호출
		System.out.println(minusAccount.getBorrowMoney());
		
		MinusAccount minusAccount2 = new MinusAccount("9999-1111-2222","김대출",1111,0,1000000);
		//minusAccount2.deposit(10000);
		System.out.println("현재 잔액 : "+minusAccount2.getRestMoney());
		
		
		System.out.println(minusAccount2);
	}	
}
