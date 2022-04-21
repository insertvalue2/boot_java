package ch02;

public class MainTest {
	public static void main(String[] args) {

		// 우리가 알고 있던 모습
		IMaxNumber maxInt = new IMaxNumber() {
			@Override
			public int getMax(int a, int b) {
				if (a < b) {
					return b;
				}
				return a;
			}
		};
		// 사용 방법
		System.out.println(maxInt.getMax(100, 20));

		// 람다 표현식으로 변경 Lambda 1
		IMaxNumber lambdaMaxInt = (x, y) -> {
			if (x > y) {
				return x;
			}
			return y;
		};

		System.out.println(lambdaMaxInt.getMax(80, 1));

		// 람다 표현식으로 변경 Lambda 2
		IMaxNumber lambdaMaxInt2 = (x, y) -> x > y ? x : y;
		System.out.println(lambdaMaxInt2.getMax(1000, 100000));

	}
}
