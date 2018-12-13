
public class Foo {
	
	public void move(Directions directions) {
		switch(directions) {
		case EAST:
			System.out.println("동쪽 이동..");
			break;
		case WEST:
			System.out.println("서쪽 이동..");
			break;
		case SOUTH:
			System.out.println("남쪽 이동..");
			break;
		case NORTH:
			System.out.println("북쪽 이동..");
			break;			
		default:
			break;
		}
	}
	
	public static void main(String[] args) {
		Foo foo= new Foo();
		foo.move(Directions.EAST);
		foo.move(Directions.WEST);
		
		Directions[] list= Directions.values();
		for (Directions directions : list) {
			System.out.println(directions);			
		}
		
		String name="NORTH"; //문자열임. 이 문자열을 enum객체로 변환해보자
		Directions dir=Directions.valueOf(name); //String이 아니라 실제 Directions 객체를 리턴
		foo.move(dir);
				
	}
}
