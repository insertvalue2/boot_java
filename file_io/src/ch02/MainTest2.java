package ch02;

import java.io.FileInputStream;

/**
 * 
 * @author ITPS
 * 입력 스트림
 * 바이트 단위 스트림 - 2 
 * 파일 끝까지 한 바이트씩 자료 읽기 
 * try-with-resources : try(...) 1.7
 */
public class MainTest2 {
	public static void main(String[] args) {
		try(FileInputStream fis = new FileInputStream("boot_a.txt")) {
			int i; 
			while( (i = fis.read()) != -1) {
				System.out.println((char)i);
			}
			
			System.out.println("끝");
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
}
