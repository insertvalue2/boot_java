package ch11;

public class Zealot {

	private static int zealotSId;

	private int id;
	private String name;
	private int power;
	private int hp;

	public Zealot(String name) {
		this.name = name;
		zealotSId++;
		this.id = zealotSId;
		power = 10; 
		hp = 100; 
	}

	// getter
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getPower() {
		return power;
	}

	public int getHp() {
		return hp;
	}

	// 객체와 객체를 상호 작용하게 코딩한다. 
	// 마린을 공격합니다.
	public void attackMarine(Marine marine) {
		// 질럿 공격력 10 <---
		marine.beAttacked(power);
		System.out.println("질럿이 마린을 공격 합니다.");
	}
	
	// 저글링을 공격 합니다.
	public void attackZergling(Zergling zergling) {
		zergling.beAttacked(power);
		System.out.println("질럿이 저글링을 공격합니다.");
		
	}
	
	// 내가 공격을  당하다 
	public void beAttacked(int power) {
		this.hp -= power; 
		if(this.hp <= 0) {
			System.out.println(this.name + "은 사망하였습니다");
			this.hp = 0;
		}
	}

	public void showInfo() {
		System.out.println("====정보창====");
		System.out.println(" 이름 : " + name);
		System.out.println(" 아이디 : " + id);
		System.out.println(" 공격력 : " + power);
		System.out.println(" 생명력 : " + hp);
		System.out.println("============");
	}

}
