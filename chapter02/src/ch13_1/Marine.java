package ch13_1;

public class Marine extends Unit {

	public Marine(String name) {
		super(name);
	}
	
	@Override
	public void attack(Unit unit) {
		// 넘어오는 데이터 타입을 확인해서 처리를 해주세요 
		super.attack(unit);
	}

	public void beAttacked(int power) {
		super.hp -= power;
	}
}
