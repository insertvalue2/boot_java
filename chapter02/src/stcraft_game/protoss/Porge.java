package stcraft_game.protoss;

// 프로토스에 공격력 또는 방버력을 업그레이드 하는 클래스 입니다. 
public class Porge {

	// 공격력 업그레이드 
	public void upgradeAttack() {
		Protoss.attack++;
	}
	
	// 방어력을 업그레이드 
	public void upgradeArmor() {
		Zealot.armor++;
		Dragoon.armor++; 
		DarkTempler.armor++; 
	}
}
