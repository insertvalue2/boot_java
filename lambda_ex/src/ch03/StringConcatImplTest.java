package ch03;

public class StringConcatImplTest {

	public static void main(String[] args) {
		
		String s1 = "Hello";
		String s2 = "java";
		
		// 우리가 알던 방식 OOP 방식 
		StringConcatImpl impl = new StringConcatImpl();
		//impl.makeString("hello", "java");
		impl.makeString(s1, s2);
		
		
		// 우리가 알던 방식 인터페이스를 익명 구현 객체로 활용 하는 방식 
		IStringConcat concat1 = new IStringConcat() {
			@Override
			public void makeString(String s1, String s2) {
				System.out.println(" **** " + s1 + ","+ s2 + " **** ");
			}
		};
		// 클래스설계 없이 바로 사용 가능 (클래스가 없는 것이 아니라 익명 클래스(익명 구현 클래스)로 만들어 
		// 지기 때문에 사용이 되는 것이다. (프로그래머하 하는 부분을 줄이는 것 뿐) 
		
		
		// 람다 표현식으로 사용하는 방식 ( 함수 선언(식)을 하고 concat2 변수에 담다 )  
		IStringConcat concat2 = (ls1, ls2) -> System.out.println(" **** " + ls1 + ","+ ls2 + " **** "); 
		concat2.makeString(s1, s2);
		
		// 람다 표현식으로 사용하는 방식 
		IStringConcat concat3 = (ls1, ls2) -> System.out.println(" >>>> " + s1 + " | "+ s2 + " <<<< ");
		concat3.makeString(s1, s2);
		
				
		
	}

}
