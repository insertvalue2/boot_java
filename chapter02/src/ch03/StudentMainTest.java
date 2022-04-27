package ch03;

public class StudentMainTest {
	
	public static void main(String[] args) {
		
		Studnet studentKim = new Studnet(); 
		studentKim.studentId = 1; 
		studentKim.studentName = "김길동";
		studentKim.address = "부산시 진구";
		
		
		studentKim.study();
		studentKim.breakTime();
		studentKim.showStudentInfo();
		studentKim.cleanUp();
		////////////////////////////////////////////////
		
		Studnet studnetLee = new Studnet();
		studnetLee.studentId = 2; 
		studnetLee.studentName = "홍길동";
		studnetLee.address = "부산시 해운대구";
		
		studnetLee.study();
		studnetLee.breakTime();
		studnetLee.showStudentInfo();
		studnetLee.takeTest();
		System.out.println("-------------------------------------");
		// 메모리에 2개의 객체가 올라가 있다
		String name1 = studentKim.getStudentName();
		int sId1 = studentKim.getStudentId();
		System.out.println(name1);
		System.out.println(sId1);
		
		String name2 = studnetLee.getStudentName();
		int sId2 = studnetLee.getStudentId();
		System.out.println(name2);
		System.out.println(sId2);
		
		
	}
}











