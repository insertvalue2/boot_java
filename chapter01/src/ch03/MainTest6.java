package ch03;

public class MainTest6 {

	public static void main(String[] args) {
		// �� ������ ( &&, || ) ���ۼ�Ʈ, ��Ʈ�� ��
		// ���� �����ڿ� ȥ���Ͽ� ���� ����Ѵ�.
		// ���꿡 ����� true, false

		int num1 = 10;
		int num2 = 20;
		// true && true
		boolean flag1 = (num1 > 0) && (num2 > 0);
		System.out.println(flag1);
		// true && false
		flag1 = (num1 > 0) && (num2 < 0);
		System.out.println(flag1);

		// true || true
		boolean flag2 = (num1 > 0) || (num2 > 0);
		System.out.println(flag2);

		//      		true    ||      false  
		flag2 = (num1 > 0) || (num2 < 0);
		System.out.println(flag2);
		
		// ��� : �������� �ϳ��� ������ ������ ���꿡 ����� false �̴�. 
		//          ���տ��� �ϳ��� ���� ������ ���꿡 ����� true �̴�. 
		System.out.println("===============");
		System.out.println(!flag2);
		System.out.println("===============");
		boolean flag3 = !(5 > 3);
		System.out.println(flag3);
		
	}

}
