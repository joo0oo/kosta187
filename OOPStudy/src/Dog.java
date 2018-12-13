
public class Dog extends Animal {

	private boolean loyalty;
	
	public Dog() {
		this(null,0,false);
	}
	
	public Dog (String name, int age, boolean loyalty) {
		this.name=name;
		this.age=age;
		this.loyalty=loyalty;
	}
	
	@Override
	public void sleep() {
		System.out.println("강아지가 먹는다..");

	}

	@Override
	public void eat() {
		System.out.println("강아지가 잔다..");
	}
	
	public static void main(String[] args) {
		Animal animal = null; //추상클래스는 타입선언만 가능
		animal = new Dog("루니",2,false);
		animal.printInf();
		animal.eat();
		animal.sleep();
	}

}
