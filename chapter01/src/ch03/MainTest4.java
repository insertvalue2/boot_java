package ch03;

public class MainTest4 {

	public static void main(String[] args) {
		// ���� ������, ���� ������ 
		// ++, --
		
		int num1 = 1; 
		num1++; 
		//System.out.println(num1);
		
		int num2 = 1; 
		num2--; 
		//System.out.println(num2);

		// 1. ���� �����ڰ� �ڿ� �� ��� 
	    int num3 = 10; 
	    int num4; 
	    
	    num4 = num3++;
	    //System.out.println(num4);
	    // num3(10) num4�� ���� �����ϰ� �� �� num3���� 1 ���� ���״�. 
	    //System.out.println(num3);
		
	    // 2. ���� �����ڰ� �տ� �� ��� 
	    int num5 = 10; 
	    int num6; 
	    num6 = num5++; 
	    System.out.println(num6);
	    
	    // 3. ���� �����ڰ� �ڿ� �� ��� ����� ȭ�鿡 ���
        int num7 = 100;
        int num8;

        num8 = num7++;
        System.out.println(num8);



        // 4. ���� �����ڰ� �տ� �� ��� ����� ȭ�� �� ���
        int num9 = 100;
        int num10;

        num10 = ++num9;
        System.out.println(num10);

        // 5. ���������ڰ� �ڿ� �� ��� ����� ȭ�鿡 ���
        int num11 = 1_000;
        int num12;

        num12 = num11--;
        System.out.println(num12);

        // 6. ���� �����ڰ� �տ� �� ��� ����� ȭ�鿡 ���
        int num13 = 2_000;
        int num14;

        num14 = --num13;
        System.out.println(num14);
	    
	}

}
