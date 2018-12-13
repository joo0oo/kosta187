/**
 * 무기에 대한 수평적 규격 역할의 인터페이스
 * @author 송주현
 *
 */
public interface Weapon {//여기서 public 안써도 컴파일러가 알아서 public 붙여줌

	public int weight=10; //인터페이스 변수 앞에 static final 자동으로 붙음(그래서 이탤릭체임)
	public void attack(); //여기서 public abstract 안써도 컴파일러가 알아서 public , abstract 붙여줌, 그러나 대체로 public은 쓰도록 한다
	//attack()은 추상메서드
}

/*
 * !!시험!!
 자바 컴파일시 컴파일러에서 자동으로 추가되는 것 세가지
 default 생성자
 extends Object 
 생성자 첫번째줄 super()
 접근제한자 public
 메소드 public abstract (추상메서드에서 abstract)
 인터페이스의 변수앞에 public static final 
 
*/
