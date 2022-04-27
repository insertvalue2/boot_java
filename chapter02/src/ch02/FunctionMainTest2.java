package ch02;

public class FunctionMainTest2 {

	// 코드에 시작
	public static void main(String[] args) {

		int num1 = 10;
		int num2 = 20;

		int total = addNum(num1, num2);
		System.out.println("total : " + total);
		sayHello("안녕하세요 홍길동 입니다~");
		int sum = calcSum();
		System.out.println(sum);

	} // end of main

	public static int addNum(int n1, int n2) {
		int result;
		result = n1 + n2;
		return result;
	}

	public static void sayHello(String greeting) {
		System.out.println(greeting);
	}

	public static int calcSum() {
		int sum = 0;
		int i;
		for (i = 1; i <= 100; i++) {
			sum += i;
		}
		return sum;
	}

	// 함수를 만들어 봅시다.
	// 1. 리턴값이 int , 매개변수 n1, n2, n3 이름은 intAdd
	// 2. 리턴값이 double , 매개변수 n1, n2, n3 이름은 doubleAdd
	// 3. 리턴값 void , 매개변수는 String article 이름은 printArticle
	// 4. 직접 사용해 봅시다. (머리속에 메모리 구조와 동작 방식을 꼭 생각하면서 만들어 주세요)

}
