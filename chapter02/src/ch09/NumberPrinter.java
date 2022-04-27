package ch09;

public class NumberPrinter {

	// 인스턴스들이 공유 할수 있는 메모리 영역이다.
	private int id;
	public static int waitNumber = 100;

	public NumberPrinter(int id) {
		this.id = id;
		waitNumber = 1;
	}

	// 번호표를 출력합니다.
	public void printWaitNmber() {
		waitNumber++;
		System.out.println(id + " 기기에 대기 순번은 : " + waitNumber);
	}
}
