package ch03;

public class MainTest3 {

	public static void main(String[] args) {
		// ���� ���Կ����� 
		// �ٸ� �����ڿ� ���� �����ڸ� �Բ� ����ϴ� �� 
		
		int num1 = 1; 
		num1 = num1 + 10; 
		System.out.println(num1);
		// ���� ���Կ��꿡 ���� : �����ϰ� ����ϱ� ����.. 
			
		int num2 = 1;
		num2 += 10; 
		System.out.println(num2);
		
		int num3 = 1;
		//num3 = num3 - 10; 
		num3 -= 10;
		System.out.println(num3);
		
		// ���� ���� �����ڷ� ������ �ּ���
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
