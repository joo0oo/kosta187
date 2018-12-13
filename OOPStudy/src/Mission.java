
public class Mission {

	public static void main(String[] args) {
		Account account1 = new Account("1111-2222-3333", "김기정", 1233, 200000); 
		Account account2 = new Account("1111-2222-3333", "김기정", 1233, 200000); 
		System.out.println(account1==account2); //주소값이 다르기 때문에 false 출력됨
		
		//객체의 내용을 하나하나 비교하는 메소드
		System.out.println(account1.equals(account2));
		System.out.println(account2.equals(account1));
		
		
		System.out.println(account1.equals(account1));
		System.out.println(account2.equals(account2));
		
		System.out.println(account1.toString());
		System.out.println(account2.toString());
		
		
		//account1.e
	}

}
