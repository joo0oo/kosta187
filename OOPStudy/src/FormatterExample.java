import java.util.Formatter;

public class FormatterExample {

	public static void main(String[] args) {
		int number = 1234567;
		Formatter formatter = new Formatter();
		// Formatter format(String format,Object... args) //두번째 인자는 여러가지 받을수 있어서 ... 가변인자임
		// format : "%[출력인자순서$][출력옵션(-, +, (,,..)][출력자리수][.소수점이하자리수]출력데이터유형"
		// 출력옵션 외울필요x 네다섯개만 알면됨 (엄청많음)
		// args : 포맷팅 하고자 하는 가변인자
		String formatedString = null;
		formatedString = formatter.format("%d", number).toString(); //%는 뒤에 있는 number변수를 의미함
		System.out.println(formatedString);

		formatter = new Formatter();
		// 우측정렬 후 정수로 출력
		System.out.println(formatter.format("%1$d", number));

		formatter = new Formatter();
		// 20자리확보하고, 3자리단위 콤마 찍고, 부호달고, 좌측정렬 후 정수로 포맷
		System.out.println(formatter.format("%,+-20d", number));

		double height = 23454.34343434356;
		formatter = new Formatter();
		// 20자리확보하고, 3자리단위 콤마 찍고, 부호달고, 좌측정렬 후 소수점 이하 2자리 실수로 포맷
		System.out.println(formatter.format("%,+-20.2f", height));
		
		// 도스콘솔 전용
		System.out.printf("%,+-10d\n", 198745);
		System.out.printf("%1$,-10d와 %2$,10d\n", 1000, 2000);

		// String 클래스의 클래스메소드 활용
		String fs = String.format("%,20.2f\n", 198745.678);
		System.out.println(fs);

	}

}
