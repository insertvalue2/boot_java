package ch09;

public class MainTest1 {
	
	// static 메서드 (함수) 
	public static void main(String[] args) {
		
		// StringBuilder, StringBuffer 개념을 이해해 보자 
		
		// heap 메모리에 인스턴스로 생성 
		String a = new String("a");
		
		// 상수풀 메모리에 생성 
		String b = "b";
		
		String str0 = "abc";
		String str1 = "abc";
		String str2 = "abc";
		
		str0 += "_0";
		//str1 += "_1";
		
		// 상수풀에 생성된 녀셕을은 immutable 성질을 가진다 
		// 즉 한번 생성된 문자열은 수정할 수 없다...
		
		// new String("abc");
		// mutable 수정이 가능하다. 
		String strA = new String("A");
		System.out.println(System.identityHashCode(strA));
		
		strA += "_1";
		System.out.println(System.identityHashCode(strA));
		
		System.out.println(strA);
		
		//System.out.println(str0 == str1); // --> ture
		
		
//		String str2 = "abc";
//		String str3 = "abc";
//		
//		// 클래스 타입 (주소값 비교 합니다.) 
//		// str1 == str2 
//		System.out.println(str1 == str2 ); // --> false
//		System.out.println("=================");
//		System.out.println(str2 == str3);
//		// str1 에 주소값을 출력해보자
//		
//		System.out.println(System.identityHashCode(str1));
//		System.out.println(System.identityHashCode(str2));
//		System.out.println(System.identityHashCode(str3));

	}
	
	

}
