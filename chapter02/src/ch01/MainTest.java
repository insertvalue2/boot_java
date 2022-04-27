package ch01;

public class MainTest {
 
	// 코드의 시작점 
	public static void main(String[] args) {
		
		System.out.println("프로그램을 시작합니다");
		
		int num1 = 10; // 변수에 선언과 초기화 ( 기본값 ) 
		int num2;  // 변수에 선언 
		
		Student s1; // Student 타입으로 변수를 선언(s1) (Student 클래스 타입 ) --> 주소값 --> 참조 변수 , 레퍼런스 타입이다. 
		Student s2; // Student 타입으로 변수를 선언(s2)
		
		// s1 초기화 하기 
		s1 = new Student(); // s1 을 초기화 했다 (값을 넣다) (주소 값)
		s2 = new Student(); // s2을 초기화 했다. (값을 넣다) (주소 값)
		
//		System.out.println(num1);
//		System.out.println(s1);
//		System.out.println(s2);
		
		
		// s1 이라는  name 이라는 변수에 접근해서 홍길동 이는 값을 넣겠다 
		s1.name = "홍길동";
		s1.height = 170;
		s1.weight = 90.5;
		
		// s2 접근해서 값을 여러분이 원하는대로 넣기 !!! 
		s2.name = "이순신";
		s2.height = 190; 
		s2.weight = 80.0; 
		
		// s1 이라는 녀석에 height 값을 화면에 출력 하려면 
		System.out.println(s1);
		System.out.println(s1.height);
		System.out.println(s1.name);
		System.out.println(s1.weight);
		System.out.println("==================");
		// s2 출력해주세요 
		System.out.println(s2);
		System.out.println(s2.height);
		System.out.println(s2.name);
		System.out.println(s2.weight);
		
		
		// 클래스 , 객체, 인스턴스 이해
		
		// 1. 전사를 메모리 올려 주세요
		// 2. 전사 변수에 값을 지정해 주세요
		// 3. 각각에 값들을 화면에 출력해주세요 
	}

}




