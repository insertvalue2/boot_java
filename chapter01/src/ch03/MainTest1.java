package ch03;

public class MainTest1 {

	// �����۾��� (������)
	// �ڵ忡 ������
	public static void main(String[] args) {

		// ���� ������ ( = ) , ���꿡 ������ �����ʿ��� �������� ������ �˴ϴ�.
		int number = 10;
		// ������ ������ ������ ���� �ִ�.
		int number2 = number;
		System.out.println(number);
		System.out.println(number2);
		System.out.println("================");
		
		// ��ȣ ������ ( + , - ) 
		System.out.println(-number);
		System.out.println(number); // 10 
		// ��ȣ �����ڴ� ��ȣ�� �����ϴ� �����Դϴ�. 
		// ��, ������ �ִ� ���� ���� ������ ���´� �ƴմϴ�. 
		// ���� number��� ������ ���� ���� -10���� �����Ϸ��� �Ʒ��� �ڵ带 �ۼ��� ������
		number = -number;
		System.out.println(number);
	} // end of main

} // end class
