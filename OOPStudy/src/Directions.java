
public enum Directions {
	EAST,WEST,NORTH,SOUTH
	//상수처럼 사용가능
	
	//javap <- 역컴파일 하는 키워드
	//enum이라는 클래스가 있음
	/*
	 * public final class Directions extends java.lang.Enum<Directions> {
	 * public satic final Directons EAST;
	 * public satic final Directons WEST;
	 * public satic final Directons NORTH;
	 * public satic final Directons SOUTH;
	 * static {};
	 * public static Directions[] values(); //열거형을 배열로 리턴
	 * public static Directions valueOf(java.lang.String); //문자열을 열거형으로 형변환
	 *  그리고 object의 여덟가지 메소드가 모두 들어있는 것임
	 * }
	 */
}
