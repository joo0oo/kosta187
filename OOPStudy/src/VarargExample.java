
public class VarargExample {

	public static int sum(int[] args) { //JAVA 5버전 이전 방식 (가변인자 x)
		int result=0;
		for (int i : args) {
			result += i;
		}
		return result;		
	}
	
	public static int sum2(int... args) { //args를 내부적으로 배열로 처리하기때문에 위의 함수와 같은 이름을 사용할 수 없다 (오버로딩 불가능)
		int result=0;
		for (int i : args) {
			result += i;
		}
		return result;		
	}
	
	public static void main(String[] args) {
		//sum({10,20,30,40,50}); //배열 변수처리 없이 바로 인자 전달 불가능
		int[] arr= {10,20,30,40,50};
		System.out.println(sum(arr));

		//더 쉽게 하는 방법
		System.out.println(sum2(10,20,30,40,50));
		System.out.println(sum2(10,30,50)); //가변인자
		
	}

}
