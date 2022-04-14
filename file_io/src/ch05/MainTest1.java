package ch05;

import java.io.FileWriter;
import java.io.IOException;

/**
 * 
 * @author ITPS
 * Writer 
 * 문자 단위 출력 스트림
 * 파일에서 문자 쓰기 - 1
 */
public class MainTest1 {
	public static void main(String[] args) {

		try (FileWriter fw = new FileWriter("writer_1.txt")) {
			fw.write('A'); // 문자 하나 출력
			char buf[] = { 'B', 'C', 'D', 'E', 'F', 'G' };

			fw.write(buf); // 문자 배열 출력
			fw.write("안녕하세요. 잘 써지네요"); // String 출력
			fw.write(buf, 1, 2); // 문자 배열의 일부 출력
			fw.write("65"); // 숫자를 그대로 출력
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("출력이 완료되었습니다.");
	}

}
