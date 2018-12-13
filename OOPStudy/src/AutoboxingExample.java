
public class AutoboxingExample {

	public static void main(String[] args) {
		//Double obj = new Double(3.33); //원래 이렇게 생성해야 함
		
		Double obj= 3.33; //오토박싱 
		//자동으로 객체로 변환되어 저장됨

		System.out.println(obj);
		
		//double value=3.33; //원래 이렇게 생성해야 함
		double value= new Double(3.33); //언박싱
		//Double 객체의 doubleValue()메서드 자동 호출됨 
	}

}
