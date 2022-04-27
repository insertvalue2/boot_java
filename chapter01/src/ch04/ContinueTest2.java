package ch04;

import java.util.Scanner;

public class ContinueTest2 {
	public static void main(String[] args) {
		// 예약어 continue
		// 무시하고 진행하는 continue
		Scanner sc1 = new Scanner(System.in);
		
		System.out.print("배수 입력 : ");
		final int MULTIPLE = sc1.nextInt();
		
		System.out.print("숫자 몇까지?");
		final int MAX = sc1.nextInt();
		
		final int FIRST_VALUE = 1; 
		int num;
		int count = 0;
		
		for (num = FIRST_VALUE; num <= MAX; num++) {
			// 3의 배수이면 화면에 출력하지 마세요
			if (num % MULTIPLE == 0) {
				count++;
				continue; // 무시하고 진행하라
			}
			System.out.println("num : " + num);
		}
		System.out.println();
		System.out.println(MULTIPLE + "의 배수는 " + count + "개입니다.");
	} // end of main
}
