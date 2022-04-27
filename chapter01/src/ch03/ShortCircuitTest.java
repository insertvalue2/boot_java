package ch03;

public class ShortCircuitTest {

	public static void main(String[] args) {
		int num1 = 5; 
		int i = 0; 
		//								(15 ) < 10 --> false --> true 
		boolean value = ( ( num1 = num1 + 10 ) > 10 ) && ( ( i = i + 2 ) < 10 );
		System.out.println(value);
		System.out.println(num1);
		System.out.println(i);
		
		System.out.println("==================");
		//                   15 < 10 --> false        ||   i(2)  2 + 2 < 10 ---> true 
		value = ( (num1 = num1 + 10) < 10 ) ||  ( ( i =  i + 2) < 10 );		
		System.out.println(value);
		System.out.println(num1);
		System.out.println(i);	
	}

}
