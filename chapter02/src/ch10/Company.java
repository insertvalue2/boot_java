package ch10;

public class Company {
	
	// 싱글톤 패턴 
	private static Company instance = new Company();

	// 생성자를 통해서 객체를 생성 하지 못하게 막는다.
	private Company() {

	}

	// 
	public static Company getInstance() {
		if (instance == null) {
			instance = new Company();
		}
		return instance; 
	}
}
