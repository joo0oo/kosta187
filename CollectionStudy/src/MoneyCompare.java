import java.util.Comparator;

public class MoneyCompare implements Comparator<Account> {

	@Override
	public int compare(Account o1, Account o2) { //객체끼리의 비교 기준 제시
		//a1과 a2를 비교해서 int값 리턴
		// o1 > o2 면 양수 리턴
		// o1 < o2 면 음수 리턴
		// o1 == o2 면 0 리턴
		
		return (int)(o1.getRestMoney() - o2.getRestMoney()); //o1이 크면 양수, o2가 크면 음수 리턴되도록 설계
	}

}
