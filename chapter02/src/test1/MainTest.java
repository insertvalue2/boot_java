package test1;

import java.util.Scanner;

public class MainTest {
	public static void main(String[] args) {
		boolean flag = true;

		ToyMachine toyMachine = new ToyMachine();
		Scanner scanner = new Scanner(System.in);

		System.out.println("[인형 뽑기]");
		System.out.println("정답을 맞춰주세요 ( 1 ~ 3 ) ");

		while (flag) {
			System.out.println("========================================");
			System.out.println("정답을 맞춘면 장난감을 뽑을 수 있습니다.");
			System.out.println("종료 : 0");
			System.out.print("정답 입력: ");
			int select = scanner.nextInt();
			if (select == 0) {
				System.out.println("뽑기 종료");
				flag = false;
			} else {
				flag = toyMachine.randomValue(select);
			}
		}
		scanner.close();
	}
}