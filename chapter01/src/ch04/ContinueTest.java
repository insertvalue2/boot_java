package ch04;

public class ContinueTest {

	public static void main(String[] args) {
		
		// 예약어 continue
		// 무시하고 진행하는 continue 
		
		// 스캐너를 사용해서 사용자에 입력값을 받아서  배수에 갯수를 출력하는 프로그램을 만들어보세요 
		// 배수 --> 
		// 1 ~ 몇까지 (정수) 
		final int MULTIPLE = 7; 
		final int MAX = 1000; 
		int num = 0; 
		int count = 0;
		
		for(num = 1; num <= MAX; num++) {
			//만약 3에 배수이면 화면에 출력하지 마세요 !!! 
			if (num % MULTIPLE == 0) {
				count++; 
				// count = count + 1; 
				continue; // < -- 무시하고 진행 하라 !!!
			}
			//System.out.println("num : " + num);
		}
		System.out.println( MULTIPLE + " 에 배수는 " + count + " 개 입니다." );
	}
}
