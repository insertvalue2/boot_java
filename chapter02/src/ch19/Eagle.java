package ch19;

// 강제성 부모 클래스 추상 메서드가 있다면 자식 클래스는 반드시 
// 추상 메서드를 일반 메서드로 재 정의 해야 한다. !!! 자바 문법
public class Eagle extends Animal {

	@Override
	public void hunt() {
		System.out.println("독수리가 날다가 토끼를 사냥 합니다.");
	}
	
	@Override
	public void move() {
		System.out.println("독수리가 날개를 쭉 펴고 날아 갑니다.");
	}

	
}
