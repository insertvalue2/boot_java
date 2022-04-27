package ch10;

public class CompanyTest {
	public static void main(String[] args) {
		
		// 단 한개에 주소만 가니는 company 녀셕을 만들겠다. 
		
		// Campany campany = new Campany();
		Company campany1 = Company.getInstance();
		Company campany2 = Company.getInstance();
		Company campany3 = Company.getInstance();

		System.out.println(campany1);
		System.out.println(campany2);
		System.out.println(campany3);

	}
}
