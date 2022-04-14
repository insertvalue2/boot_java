package ch02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *  
 * @author ITPS
 * 입력 스트림
 * 파일에서 한 바이트씩 자료 읽기 1
 */
public class MainTest1 {

	public static void main(String[] args) {
		
		FileInputStream fis = null; 
		try {
			fis = new FileInputStream("boot_a.txt");
			System.out.println((char)fis.read());
			System.out.println((char)fis.read());
			System.out.println((char)fis.read());
			System.out.println((char)fis.read());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("파일이 없습니다.");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("입출력 오류");
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				System.out.println(e);
			} catch (NullPointerException e2) {
				System.out.println(e2);
			}
		}
	}

}
