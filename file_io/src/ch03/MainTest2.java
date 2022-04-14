package ch03;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 
 * @author ITPS
 * 바이트 단위 출력
 * byte[] 배열에 A-Z 까지 넣고 배열을
 * 한꺼번에 파일에 쓰기 - 2
 */
public class MainTest2 {
	
	public static void main(String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream("output_b.txt", true); // java 9
		try(fos) {
			byte[] bs = new byte[26];
			byte data = 65; 
			for(int i = 0; i < bs.length; i++) {
				bs[i] = data; 
				data++;
			}
			fos.write(bs); // 배열을 한꺼먼에 출력 하기 
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("출력 끝");
	}
}
