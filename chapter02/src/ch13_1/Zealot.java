package ch13_1;

public class Zealot extends Unit {

	// 부모에 있는 생성자를 먼저 호출 해야 한다.
	public Zealot(String name) {
		super(name);
	}

	@Override
	public void attack(Unit unit) {
		super.attack(unit);
	}

	public void beAttacked(int power) {
		super.hp -= power;
	}

}
