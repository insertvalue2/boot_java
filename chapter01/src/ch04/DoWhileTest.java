package ch04;

public class DoWhileTest {

	public static void main(String[] args) {
		/* <--- 여러줄 주석 
		while(조건식) {
			
			// 증감식 
		}
		*/
		
		/*
		do {
			// 수행 식 
		} while(조건식)
		 */
		
		int num = 100; 
		int sum = 0; 
		
		// do ~ while 
//		do {
//			System.out.println("현재 값 : " + num);
//			// sum = num + sum;
//			sum += num; 
//			num++;
//		} while(num <= 10);
//		
//		System.out.println("연산에 대한 결과 값 : " + sum);
			
		// 문제 1. 
		// input = 10 , inputSum ;
		// 변수 2개를 선언해서 10 , 9, 8 , 7 
		int input = 10; 
		int inputSume = 0; 
		
		do {
			System.out.println("현재 값 : " + input);
			inputSume += input;
			input--;
			// 9 , 8 , 7 --
		} while(input != 0);
		
		System.out.println("결과값 : " +  inputSume);
		
	}

}
