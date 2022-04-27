package stcraft_game;

import stcraft_game.protoss.GateWay;
import stcraft_game.protoss.Porge;

public class MainTest {

	public static void main(String[] args) {
		// 게이트 생성 
		// 생산된 유닛 12마리 배열에 담아 주세요!!!
		GateWay gateWay = new GateWay(); 
		// for -- 배열에 담을 수 있다. 
		gateWay.createProtossUnit();
	
		Porge porge = new Porge(); 
		porge.upgradeAttack();
		
		// 테란 (Barrack) 
		// fireBat , Marine 
		
		
		// 저그 ( Hatchery ) 
		// Hydra, Ultra, 저글링 
		
	}

}
