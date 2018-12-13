/**
 * 인터페이스 다중구현을 이용한 클래스 정의
 * (다중 구현은 갯수 제한 없음)
 * 콤마를 이용해서 다중 구현할 수 있다
 * @author 송주현
 *
 */

public class SamsungTV implements RemoteControl, Browsable {  
	//인터페이스에 있는 메서드 외에도 이 클래스만의 고유 기능이 추가될 수 있음

	private int currentChannel;
	private int currentVolume;
	
	//디폴트 생성자는 무조건 만들도록 한다
	public SamsungTV() { //컴파일시 extends Object 자동으로 추가됨
	//	super();		
	}

	
	public SamsungTV(int currentChannel, int currentVolume) {
	//	super(); //명시적으로 추가하지 않으면 컴파일 시 부모클래스의 디폴트 생성자를 호출하는 super();가 자동추가된다
		this.currentChannel = currentChannel;
		this.currentVolume = currentVolume;
	}



	public int getCurrentChannel() {
		return currentChannel;
	}


	public void setCurrentChannel(int currentChannel) {
		this.currentChannel = currentChannel;
	}


	public int getCurrentVolume() {
		return currentVolume;
	}


	public void setCurrentVolume(int currentVolume) {
		this.currentVolume = currentVolume;
	}


	@Override
	public void surfing(String url) {
		System.out.println(url+"을 화면에 렌더링 합니다..");
	}

	@Override
	public void turnOn() {
		System.out.println("전원을 켭니다..");
	}

	@Override
	public void turnOff() {
		System.out.println("전원을 끕니다..");
	}

	@Override
	public void volumeUp() {
		if(!(this.currentVolume>=MAX_VOLUME)) {
			this.currentVolume++;
		}
	}

	@Override
	public void volumeDown() {
		this.currentVolume--;
	}

	@Override
	public void setVolume(int volume) {
		this.currentVolume=volume;
	}

	@Override
	public void setChannel(int channel) {
		this.currentChannel=channel;
	}
	
	public static void main(String[] args) {
		//바로 SamsungTV 객체를 생성하는게 아님
		RemoteControl tv= new SamsungTV(); //부모에 자식 객체 생성 (업캐스팅) ->바로 SamsungTV객체를 생성하면 호환이 안되기 때문
		tv.turnOn();
		tv.setChannel(22);
		
		//자식에서 추가된 메서드는 부모클래스에서 호출 불가능함
		//따라서 현재 tv.getCurrentChannel(); 은 호출 불가능
		//다운캐스팅이 필요
		System.out.println(((SamsungTV)tv).getCurrentChannel()); //다운캐스팅 후 자식에서 추가된 메서드 호출
		
		tv.volumeUp();
		tv.volumeUp();
		tv.volumeUp();
		tv.volumeUp();
		System.out.println(((SamsungTV)tv).getCurrentVolume()); //다운캐스팅 후 자식에서 추가된 메서드 호출
		
		tv.turnOff();
		//위 코드는 RemoteControl 인터페이스를 사용하는 다른 객체에서도 잘 동작한다
		
		System.out.println(RemoteControl.MAX_CHANNEL); 
		System.out.println(SamsungTV.MAX_CHANNEL); //RemoteComtrol 인터페이스를 부모로 생각해서 이렇게 부모의 상수도 호출 가능
		
	}

}
