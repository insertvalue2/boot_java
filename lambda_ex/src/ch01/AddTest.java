package ch01;

public class AddTest {

	public static void main(String[] args) {
		
		IAdd iAdd = (x, y) -> {return x + y;};
		
		System.out.println(iAdd.add(10, 10));
		
		IPrint iPrint = (a, b) -> { System.out.println(a + b);};
		
		iPrint.print1("name : ", "홍길동");
		iPrint.print1("학번 : ", "1230");
		
		IPrint2 iPrint2 = () -> {return "반가워";};
		
		System.out.println(iPrint2.print1() + " : ");
	
		
	}
	
	
}


interface IPrint {
	void print1(String a, String token);
}

interface IPrint2 {
	String print1();
}

