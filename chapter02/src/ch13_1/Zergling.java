package ch13_1;

public class Zergling extends Unit {
	
	public Zergling(String name) {
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
