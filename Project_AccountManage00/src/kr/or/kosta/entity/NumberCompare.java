package kr.or.kosta.entity;
import java.util.Comparator;

public class NumberCompare implements Comparator<Account> {

	@Override
	public int compare(Account o1, Account o2) { //객체끼리의 비교 기준 제시
		//a1과 a2를 비교해서 int값 리턴
		// o1 > o2 면 양수 리턴
		// o1 < o2 면 음수 리턴
		// o1 == o2 면 0 리턴
		
		return o1.getAccountNum().compareTo(o2.getAccountNum()); //문자열 비교는 compareTo 메소드 : 앞이 크면 양수, 뒤가 크면 음수, 같으면 0
		//return 0; //compare함수는 0이면 o1과 o2가 같다는 뜻
	}

}
