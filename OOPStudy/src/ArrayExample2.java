/**
 * 
 * 다차원배열 테스트
 * @author 송주현
 *
 */
public class ArrayExample2 {

	public static void main(String[] args) {
		char[][] array; //다차원배열 선언 (선언할때 숫자 넣으면 안됨, new 연산자와 함께 사이즈 할당해야 함)
		array= new char[10][10];
		array[0][0]= 'A';
		array[9][9]= 'Z';
		
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j]+"\t");
				
			}
			System.out.println();
		}
		
	}

}
