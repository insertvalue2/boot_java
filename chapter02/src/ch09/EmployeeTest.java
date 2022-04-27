package ch09;

public class EmployeeTest {

	public static void main(String[] args) {
		
		// 1. Employee 만들어 내는 입장에서 사원에 번호를 
		// 직접 입력 못하게 코드 설계한다. 
		
		// 2. 객체를 생성할 때마 자동으로 사원에 번호가 
		// 증가 시켜서 정보를 저장 해야 한다면 
//		for(int i = 1; i <= 100; i++) {
//			Employee employee = new Employee();
//			employee.showInfo();
//		}
		
		Employee employee1 = new Employee();
		employee1.setEmployeeName("홍길동");
		employee1.setDepartment("영업팀");
		employee1.showInfo();
	}
}







