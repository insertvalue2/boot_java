package ch02;

public class FunctionMainTest1 {

	// 메인 함수 
	public static void main(String[] args) {
	
		System.out.println("프로그램을 시작합니다. ");
		int addResult1 = add(10, 100);
		System.out.println(addResult1);
		
		int addResult2 = add(33, 77);
		System.out.println(addResult2);

	} // end of main 
	
	
	// add 라는 함수를 만들어 봅시다. --> 두 수를 입력 받아 덧셈 하기  
	public static int add(int num1, int num2) {
		int result; // <--- 지역 변수 
		result = num1 + num2; 
		return result;  // return 키워드를 만났을 때 실행에 제어권을 반납한다. 
	} // end of add 

	// 함수란?  
	// 자바에서 함수란 객체와 상관없이 독립적으로 어떠한 기능을 수행하는 일련 코드 묶음 
	
}
