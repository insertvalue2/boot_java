package ch03;

import java.util.Scanner;

public class MainTest7 {

	public static void main(String[] args) {
		
		// ���� ������ 
		// ���ǽ� ? ���1 : ���2 
		
		int num1 =  (5 > 3) ? 10 : 20; 
		System.out.println(num1);
		
		int num2 =  (5 < 3) ? 10 : 20; 
		System.out.println(num2);
		
		// JDK ����� ���� JRE 
		int max = 0; 
		System.out.println("�Է� ���� �� ���� ū ���� ��� �ϼ���");
		
		Scanner sc = new Scanner(System.in);  
		System.out.println("�Է� 1 : ");
		int x = sc.nextInt();
		System.out.println("�Է� 2 : ");
		int y = sc.nextInt(); 
		
//		System.out.println("x : " + x);
//		System.out.println("y : " + y);
		
		// �� ���� �Է� �޾Ƽ�(���� �Դϴ�) 
		// ȭ�鿡 ū ���� ����� �ּ��� . 
		// �� ���� �����ڸ� ����ϼ��� !!! 
		// ���⿡�� �� ����� �ֱ� !!!!
		max = (x > y) ? x : y; 
		
		System.out.println("ū ���ڴ� : " + max + " �Դϴ�. ");
		
	}

}
