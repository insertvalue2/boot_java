package ch18;

import java.util.Random;
import java.util.Scanner;

public class MainTest {

	
	public static void main(String[] args) {
		//System.out.println(ranValue());
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("번호를 맞춰 보세요");
		int userInput = scanner.nextInt(); 
		int targetValue = ranValue(); 
		
		if(userInput == targetValue) {
			System.out.println(">>> 정답 입니다. ");
		} else {
			System.out.println("아쉽지만 꽝 !!! ");
		}
		
	}

	
	// 함수 랜덤 값을 뽑아 내는 함수 만들어 보기 
	public static int ranValue() {
		// JDK 도구 
		Random random = new Random(); 
		// 0 부터 ~ 44 까지 랜덤 적인 정수값 뽑아 준다. 
		int value = random.nextInt(1) + 1; 
		return value; 
	}

}
