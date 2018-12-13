
public interface RemoteControl {
	//public static final은 쓰지 않아도 컴파일시 자동으로 추가됨 (상수처리)
	public static final int MAX_VOLUME=50; //생성자에서 초기화시키는게 아님
	public static final int MIN_VOLUME=0; //두 단어 조합할때는 관례상 언더바_ 사용
	public static final int MAX_CHANNEL=100; 
	public static final int MIN_CHANNEL=1;
	
	/*
	 * 설계된 UML 디자인을 JAVA코드로 자동으로 생성되는 기능 존재->순공학
	 * StarUML->Option->Java->Code Generation->General->Generate codes even when
		반대 역공학도 존재
	*/
	
	public abstract void turnOn(); //abstract 키워드도 컴파일 시 자동으로 추가됨 (인터페이스이므로)
	public abstract void turnOff();
	public abstract void volumeUp();
	public abstract void volumeDown();
	public void setVolume(int volume); //일반적으로 abstract를 생략해서 쓴다
	public void setChannel(int channel);
	
	//인터페이스는 상수들과 추상메서드들의 집합이다
	//이 인터페이스는 실제 객체가 생성되는건 아님(규격일 뿐) ->실제 이 인터페이스를 사용할 객체를 따로 생성해야 한다

}
