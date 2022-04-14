package ch03;

import java.io.FileOutputStream;

/**
 * 
 * @author ITPS
 * 
 * 바이트 단위 출력
 * 파일에 한 바이트씩 쓰기 - 1
 * 
 */
public class MainTest1 {

	public static void main(String[] args) {
		// FileOutputStream 파일이 없다면 자동으로 생성
		try (FileOutputStream fos = new FileOutputStream("output_a.txt")) {
			fos.write(65);  // A 
			fos.write(66);  // B  
			fos.write('C');
			fos.write('D');
			fos.write('Z');
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("출력 처리가 끝났습니다");
	}

}
