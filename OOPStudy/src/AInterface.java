
public interface AInterface { 
	//여러 인터페이스/클래스를 한 파일에 작성할 때는 파일명이 되는 한가지만 public선언된다
	public void a(); //추상 메서드
}

interface BInterface{
	public void b();
}

interface CInterface extends AInterface, BInterface{ //인터페이스는 다중 상속이 가능
	public void c();
	
}