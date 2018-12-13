
public class Unit {
	
	private Weapon weapon; //연관 관계에서 이렇게 사용한다. (Unit안에서 Weapon객체가 필요할때 생성해서 사용)
	//생성자로 초기화하라는 소리가 아니라 setter/getter로 해야한다
	//즉 Unit의 생성자로 weapon 변수(객체)를 초기화하는게 아님 (서로 종속적x 독립적o)
	
	private String name; //Unit의 멤버
	
	public Unit() { }
	
	public Unit(String name) {
		this.name=name;
		//Unit과 Weapon은 전체-부분 관계가 아니므로 Unit 생성자에서 Weapon을 초기화하지 않는다
		//weapon은 setter를 이용해서 초기화
	}
	/*
	 	만약 Unit과 Weapon이 Aggregation 관계라면
	 	public Unit(String name,Weapon weapon) {
			this.name=name;
			this.weapon=weapon;
		}
		이렇게 사용하게 된다 -> Unit의 생성자에서 Weapon을 초기화 
	 */

	public Weapon getWeapon() {
		return weapon;
	}

	public void setWeapon(Weapon weapon) { //weapon은 setter를 이용해서 초기화
		this.weapon = weapon;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	public void attack() {
		weapon.attack(); //이때 알아서 Gun/Sword/Club의 attack()이 호출됨
	}
	
	public static void main(String[] args) {
		
		
		Unit unit=new Unit("SCV");		
		Weapon weapon=null;
		
		weapon=new Gun(); //업캐스팅 (타입은 부모 & 실제 생성은 자식)		
		unit.setWeapon(weapon);
		unit.attack(); //Gun타입 객체를 전달했으므로 자동으로 Gun의 attaack()이 호출
		
		weapon= new Sword();//업캐스팅 (타입은 부모 & 실제 생성은 자식)
		unit.setWeapon(weapon); //Sword타입 객체를 전달했으므로 자동으로 Gun의 attaack()이 호출
		unit.attack();
	}

}
