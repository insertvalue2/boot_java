package ch03;

public class MainTest3 {

	public static void main(String[] args) {
		// 복합 대입연산자 
		// 다른 연산자와 대입 연산자를 함께 사용하는 것 
		
		int num1 = 1; 
		num1 = num1 + 10; 
		System.out.println(num1);
		// 복합 대입연산에 취지 : 간편하게 사용하기 위해.. 
			
		int num2 = 1;
		num2 += 10; 
		System.out.println(num2);
		
		int num3 = 1;
		//num3 = num3 - 10; 
		num3 -= 10;
		System.out.println(num3);
		
		// 문제 복합 연산자로 변경해 주세요
		num1 = num1 * 2; 
		// 
		num1 *= 2; 
		
		num2 = num2 / 2; 
		//
		num2 /= 2; 
		
		num2 = num2 % 2; 
		// 
		num2 %= 2; 
		
	}

}
