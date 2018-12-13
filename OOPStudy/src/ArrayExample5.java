/**
 * 
 * 레퍼런스타입 배열 선언, 생성, 초기화
 * @author 송주현
 *
 */
public class ArrayExample5 {

	public static void main(String[] args) {
		String[][] array= new String[3][100];
		array[0][0]="AAA";
		array[2][0]="ZZZ";
		
		String[][] array2 = new String[][]{{"aa", "bb", "cc"} , {"dd","ee","ff"}, {"gg","hh","ii"}};

	}

}
