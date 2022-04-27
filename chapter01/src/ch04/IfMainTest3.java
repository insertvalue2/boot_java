package ch04;

public class IfMainTest3 {

	public static void main(String[] args) {
		
		// 이중 for문을 사용해서 구구단을 출력해주세요 
		
		// num 값이 2부터 9까지 반복 
		for(int num = 2; num < 10; num++) {
			// i 값이 1 부터 9까지 반복 
			for(int i = 1; i < 10; i++) {
				System.out.println(num + " * "+ i + "  = " + (num * i));
			} // end of inner for 
			System.out.println("-----------------------");
		} // end of outer for 
		
		// 화면에 2단부터 9단까지 출력 합니다. 
		// num10 이란 변수가 2 부터 9까지 반복하는 for문 작성해 봅시다.
//		for(int num10 = 2; num10 < 10; num10++) {
//			
//		}
//		
//		
//		int num = 2;
//		for(int i = 1; i < 10; i++) {
//			System.out.println(num + " * "+ i + "  = " + (num * i));
//		}
//		
//		num = 3; 
//		for(int i = 1; i < 10; i++) {
//			System.out.println(num + " * "+ i + "  = " + (num * i));
//		}
//		
//		num = 4;
//		for(int i = 1; i < 10; i++) {
//			System.out.println(num + " * "+ i + "  = " + (num * i));
//		}
		

	}

}
