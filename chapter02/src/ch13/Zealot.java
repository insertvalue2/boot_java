package ch13;

public class Zealot extends Unit {

	// 부모에 있는 생성자를 먼저 호출 해야 한다.
	public Zealot(String name) {
		super(name);
		// super.name = name;
		// this();
	}

	// 공격 메서드
	public void attackMarine(Marine marine) {
		System.out.println(name + " 이 공격 합니다.");
		marine.beAttacked(power);
	}

	public void attack(Zergling zergling) {
		zergling.beAttacked(power);
	}

	public void attack(Marine marine) {
		marine.beAttacked(power);
	}

	public void attack(Zealot zealot) {
		zealot.beAttacked(power);
	}

	public void beAttacked(int power) {
		super.hp -= power;
	}

}
