
public class WrapperClassExample {

	public static void main(String[] args) {
		
		char c = 'A';
		Character obj = new Character(c); //형변환 (문자->객체)
		//Character 클래스에 있는 메소드 사용 가능해짐
		char c2= obj.charValue(); //형변환 (객체->문자)
		
		char[] data = {'A', 'a', '4',' ', '#'};
		
		for (int i = 0; i < data.length; i++) {
			if(Character.isUpperCase(data[i])){ //isUpperCase() -> 대문자인지 확인
				System.out.println(data[i] + "은 대문자이다.");
			}else if(Character.isLowerCase(data[i])){ //isLowerCase()-> 소문자인지 확인
				System.out.println(data[i] + "은 소문자이다.");
			}else if(Character.isDigit(data[i])){ //isDigit() ->숫자인지 확인
				System.out.println(data[i] + "은 숫자이다.");
			}else if(Character.isSpaceChar(data[i])){ //isSpaceChar() ->공백인지 확인 
				System.out.println(data[i] + "은 공백문자이다.");
			}
		}

		Integer integer1 = new Integer(10);
		Integer integer2 = new Integer("10");
		int i1 = integer1.intValue();
		int i2 = integer2.intValue();
		System.out.println("두수의 합: " + (i1+i2));

		String str = "3578";
		int i3 = Integer.parseInt(str);

		System.out.println("10진수를 2진수로:"+Integer.toBinaryString(i3));
		System.out.println("10진수를 8진수로:"+Integer.toOctalString(i3));
		System.out.println("10진수를 16진수로:"+Integer.toHexString(i3));

		System.out.println(Integer.SIZE);
		System.out.println(Integer.MIN_VALUE);
	}

}
