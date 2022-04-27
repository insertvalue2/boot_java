package ch02;

public class TypeConversion {
	
	public static void main(String[] args) {

		// 데이터 형 변환 ( 정수값을 실수값으로 변경한다. ) 
		// 자동 형변환, 강제 형변환 
		int iNum1 = 100; 
		System.out.println(iNum1);
		
		// 자동 형변환 
		double dNum1 = iNum1; 
		System.out.println(dNum1);
		
		System.out.println("==========================");
		// 강제 형변환 
		double dNum2 = 1.12345; 
		int iNum2 = (int)dNum2; // 개발자가 컴파일러한테 괜찮으니깐 강제로 값을 넣어 !! 
		System.out.println(dNum2);
		System.out.println(iNum2);
		// 강제 형 변환시 데이터에 손실이 발생할 수 있다. 
		// 소수점을 그냥 버리고 정수값만 저장해 !!! 

		// 연습 (강제형변환에 의미를 알고 사용할 수 있는가?) 
		double a; 
		int b; 
		
		//1.  a 에 값을 0.5 담아 보세요
		a = 0.5; 
		//2. b 에 값을 10.5 를 담아 보세요 
		b = (int)10.5;
		// 출력 결과값 10 (데이터 손실이 발생) 
		System.out.println(b);
		
	} // end of main 

} // end of class 







