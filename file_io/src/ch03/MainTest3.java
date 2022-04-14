package ch03;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 
 * @author ITPS 
 * 
 * 바이트 단위 출력 byte[] 
 * 배열의 특정 위치에서 부터 정해진 길이 만큼 쓰기 - 3
 */
public class MainTest3 {

	public static void main(String[] args) {
		// FileOutputStream("output_c.txt", true)  
		try (FileOutputStream fos = new FileOutputStream("output_c.txt")) {

			byte[] bs = new byte[26];
			byte data = 65; // 'A' 의 아스키 값
			for (int i = 0; i < bs.length; i++) { // A-Z 까지 배열에 넣기
				bs[i] = data;
				data++;
			}
			fos.write(bs, 2, 24); // 배열의 2 번째 위치부터 10 개 바이트 출력하기
			fos.flush(); // 출력 버퍼를 비울때 flush() 메서드를 사용
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("출력이 완료되었습니다.");
		// close() 메서드 내부에서 flush()가 호출되므로 close()메서드가 호출되면 출력 버퍼가 비워짐
	}
}
