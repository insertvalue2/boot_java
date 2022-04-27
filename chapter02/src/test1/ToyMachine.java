package test1;

import java.util.Random;

public class ToyMachine {
	
	// 동적으로 장난감에 갯수를 생성할 수 있다. 
	
	private static Toy[] toy = new Toy[3];
	private static String[] toyName = {"토끼 인형", "강아지 인형", "로봇"};
	
	public ToyMachine() {
		toy[0] = new Toy("토끼 인형");
		toy[1] = new Toy("강아지 인형");
		toy[2] = new Toy("로봇");
	}
	
	private void efect() {
		System.out.println("******************");
		System.out.println("정답 확인중");
		for(int i = 0; i < 5; i++) {
			System.out.println(".");
			try {
				Thread.sleep(1000);
			} catch (Exception e){	
			}
		}
	}
	
	public boolean randomValue(int num) {
		efect();
		Random r = new Random();
		int value = r.nextInt(2) +1;
		if( value == num ) {
			System.out.println("당첨");
			System.out.println(toy[value-1]);
			return false;
		}else {
			System.out.println("떙!!!!!!!!!");
			System.out.println("정답은 " + value + "입니다.");
			return true;
		}
		
	}

}
