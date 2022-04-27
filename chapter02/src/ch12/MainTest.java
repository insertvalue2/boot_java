package ch12;

public class MainTest {
	
	
	
	// 함수 
	// 메인함수 (코드에 시작점) 
	public static void main(String[] args) {
		
		C c = new C(); 
		
		c.num1 = 1;
		c.num2 = 2;
		c.num3= 3;
		c.num4 = 4;
		c.num5 = 5;
		
		System.out.println(c.num1);
		System.out.println(c.num2);
		System.out.println(c.num3);
		System.out.println(c.num4);
		System.out.println(c.num5);
	} // end of main 

} // end of class 


class A {
	public int num1; 
	public int num2; 
	public int num3; 
	// 100 개 
}

class B {
	int num1; 
	int num2; 
	int num3; 
	// 100 개
	int num4; 
	int num5; 
}

// 상속이라는 개념을 배웠을 때 ... ( extends ) 

class C extends A {
	
	int num4; 
	int num5;
	
}









