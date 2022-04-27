package test2;

import java.util.Random;
import java.util.Scanner;

public class ToyMachine {
	// 장난감은 3개 만들어 줍니다.
	// 사용자가 랜덤함수를 사용해서 답을 맞추면
	// 장난감을 반환해주세요.
	// 아니면 꽝 !
	public Toy getToy() {
		System.out.println("번호를 맞추면 장난감이 반환됩니다.");
		Scanner scanner = new Scanner(System.in);
		// 
		Toy toy = null;
		
		int userInput = scanner.nextInt();
		int ranNum = randomValue();
		if (userInput == ranNum) {
			if (userInput == 1) {
				System.out.println("장난감1을 얻었습니다.");
				toy = new Toy1("토끼");
			} else if (userInput == 2) {
				System.out.println("장난감2를 얻었습니다.");
				toy = new Toy2("아이폰");
			} else {
				System.out.println("장난감3을 얻었습니다.");
				toy = new Toy3("라디오");
			}
		}else {
			System.out.println("아쉽지만 꽝 !");
		}
		scanner.close();
		return toy;
	}

	public int randomValue() {
		Random random = new Random();
		int ranNum = random.nextInt(3) + 1;
		return ranNum;
	}
}