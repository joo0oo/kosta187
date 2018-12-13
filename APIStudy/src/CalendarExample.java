import java.util.Calendar;
//import java.util.GregorianCalendar;

public class CalendarExample {
	
	public static int getWorks(String year, String month, String date) {
		//근무 일수를 계산하는 메서드
		// Calendar 클래스가 여기서 필요함
		
		Calendar calNow= Calendar.getInstance();
		Calendar calStart= Calendar.getInstance();
		int y=Integer.parseInt(year);
		int m=Integer.parseInt(month);
		int d=Integer.parseInt(date);
		
		calStart.set(Calendar.YEAR,y);
		calStart.set(Calendar.MONTH,m-1); //month는 0부터 시작이므로 -1해줘야 한다
		calStart.set(Calendar.DATE,d); 
		
		long startTime=calStart.getTimeInMillis();
		long endTime=calNow.getTimeInMillis();
		
		long during=(endTime-startTime)/(24 * 60 * 60 * 1000);
		System.out.println("during : "+during);
		
		return (int)during;		
	}

	public static void main(String[] args) {
		//Calendar today= new Calendar(); //추상클래스는 이렇게 생성할 수 없다
		//Calendar today = new GregorianCalendar(); //추상클래스 Calendar를 상속받는(확장한) GregorianCalendar를 생성
		//그러나 이렇게 생성하지 않음 (new 써서 객체 생성 안함 : 어자피 객체 생성할때의 시간만 들어가는데 객체 새로 만드는것은 메모리 낭비임)
		
		Calendar today= Calendar.getInstance(); //이렇게 생성한다
		//new로 객체를 생성하는게 아니라 static메서드 getInstance()의 리턴형을 사용 (팩토리 메서드)
		//getInstance()의 리턴형은 GregorianCalendar(); 
		//String pool처럼 이미 생성된지 확인하고 생성되어 있으면 참조만, 없으면 생성함
		
		today=Calendar.getInstance();
		System.out.println(today);
		today=Calendar.getInstance();
		System.out.println(today);
		today=Calendar.getInstance();
		System.out.println(today);
		today=Calendar.getInstance();
		System.out.println(today);
		
		
		int year=today.get(Calendar.YEAR);
		int month=today.get(Calendar.MONTH);
		int date=today.get(Calendar.DATE);
		System.out.println(year);
		System.out.println(month);
		System.out.println(date);
		System.out.println(year+" - "+month+" - "+date);
		
		
		int day= today.get(Calendar.DAY_OF_WEEK);
		System.out.println(day);
		switch (day) {
			case Calendar.SUNDAY: System.out.println("일요일");
				break;
			case Calendar.MONDAY: System.out.println("월요일");
				break;

			default:
				break;
		}
		
		today.set(Calendar.YEAR, 1997);
		
		
		System.out.println(String.format("%tY", Calendar.getInstance())); //4자리년도
		System.out.println(String.format("%ty", Calendar.getInstance())); //2자리년도
		System.out.println(String.format("%tm", Calendar.getInstance())); //숫자월 
		System.out.println(String.format("%tB", Calendar.getInstance())); //문자열월
		System.out.println(String.format("%td", Calendar.getInstance())); //일
		System.out.println(String.format("%tA", Calendar.getInstance())); //요일

		System.out.println(String.format("%tH", Calendar.getInstance())); //24시간
		System.out.println(String.format("%1$tp %tI", Calendar.getInstance())); //오전/오후 12시간System.out.println(String.format("%tM", Calendar.getInstance())); //분
		System.out.println(String.format("%tS", Calendar.getInstance())); //초

		System.out.println(String.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS %1$tA", Calendar.getInstance()));

		// 날짜/시간 합성문자 사용
		System.out.println(String.format("%1$tF %1$tT", Calendar.getInstance()));

		
		
		//근무일수 구하기
		int value=getWorks("1987","3","1"); //입사 날짜
		System.out.println(value);
		
	}

}
