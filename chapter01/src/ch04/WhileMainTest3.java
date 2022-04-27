package ch04;

import java.util.Scanner;

public class WhileMainTest3 {
	
	public static void main(String[] args) {
		
		// 사용자가 0을 입력하면 프로그램을 종료 시켜라 ( 스캐너) 
		// 사용자가 입력한 값을 계속 덧셈 하는 프로그램으로 만들라 
		Scanner scanner = new Scanner(System.in);
		int num; 
		int sum = 0;
		System.out.println("덧셈값 정수를 입력하세요");
		do {
			num = scanner.nextInt(); 
			sum += num;
		} while(num != 0);
		
		System.out.println("연산에 결과값은 : " + sum);
		scanner.close();
	}
}
