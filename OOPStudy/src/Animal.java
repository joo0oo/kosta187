
public abstract class Animal { //추상클래스
	protected String name;
	protected int age;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public void printInf() {
		System.out.println("이름 : "+name+", 나이 : "+age);
	}
	
	public abstract void sleep(); //반드시 하위클래스에서 오버라이딩해야 하는 추상메서드
	public abstract void eat(); //반드시 하위클래스에서 오버라이딩해야 하는 추상메서드
	
	
}
