
public class Sword implements Weapon {

	//Weapon 인터페이스를 포함했으므로 Weapon에 있는 추상메서드 attack();을 여기서 반드시 구현해줘야 함
	@Override
	public void attack() {
		System.out.println("장칼로 공격..");
	}
}
