import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Collection과 관련된 다양한 유틸리티 클래스들을 제공

public class CollectionsExample {

	public static void main(String[] args) {
		
		// <? super T> : T의 부모들은 모두 받을 수 있다는 의미 (?=* 같은뜻)
		
		List<Account> list=new ArrayList<>();
		list.add(new Account("2222-2222-3333", "홍기정", 1234,2000));
		list.add(new Account("8888-2222-3333", "박기정", 3333,1000));
		list.add(new Account("1111-2222-3333", "김기정", 1234,5000));
		
		
		//데이터 정렬하기 : 계좌번호 기준 & 오름차순
		Collections.sort(list, new NumberCompare()); //두번째 인자는 list를 정렬할 기준이 됨
		for (Account account : list) {
			System.out.println(account);
		}
		
		System.out.println();
		//데이터 정렬하기 : 잔액 기준 & 오름차순
		Collections.sort(list, new MoneyCompare()); //두번째 인자는 list를 정렬할 기준이 됨
		for (Account account : list) {
			System.out.println(account);
		}
		
	}

}
