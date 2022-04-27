package test3;

public class B extends A {

	@Override
	public void test1() {
		System.out.println("B 클래에 있는 메서드가 동작 합니다");
	}
	
	public void testPrint() {
		System.out.println("B클래스만에 메서드 동작 입니다.");
	}
}
