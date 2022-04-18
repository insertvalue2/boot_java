package ch05;

import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 * 
 * @author ITPS BufferedWriter 이용한 파일에서 문자 쓰기 - 2
 */
public class MainTest2 {
	public static void main(String[] args) {

		String text = "File Writer Test";
		String fileName = "result.txt";

		try {
			// BufferedWriter 와 FileWriter를 조합하여 사용 (속도 향상) , true (append)
			BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true));

			// 파일안에 문자열 쓰기
			bw.write(text);
			bw.flush();

			// 객체 닫기
			bw.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
