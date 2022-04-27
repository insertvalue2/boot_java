package ch09;

public class Company {
	
	// 멤버 변수 
	private String name; 
	private Employee employee; 
	
	
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	// 입사한다 메서들 만들어 보세요
	public void join(Employee employee) {
		this.employee = employee; 
	}
	
	// 회사 사원에 정보를 출력한다. 
	public void showEmployeeInfo() {
		System.out.println(employee.getEmployeeId());
		System.out.println(employee.getEmployeeName());
		System.out.println(employee.getDepartment());
	}
	
	
}
