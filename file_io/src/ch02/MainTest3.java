package ch02;

import java.io.FileInputStream;

/**
 * 
 * @author ITPS
 * 입력 스트림
 * 바이트 단위 스트림 - 3 
 * 파일 끝까지 한 바이트씩 자료 읽기 
 * 파일에서 바이트 배열로 자료 읽기
 */
public class MainTest3 {

	public static void main(String[] args) {

		try (FileInputStream fis = new FileInputStream("boot_b.txt")) {			
			byte[] bs = new byte[10];
			int i; 
					
//			while( (i = fis.read(bs)) != -1) {
//				System.out.println("=========");
//				for(int j =0; j< i; j++) {
//					System.out.print((char)bs[j]);
//				}
//			}
			
			while( (i = fis.read(bs, 1, 9)) != -1) {
				//System.out.println("=========");
				for(int j =0; j< i; j++) {
					System.out.print((char)bs[j]);
				}
				System.out.println(": i " + i + "바이트 읽음");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("끝");
		System.out.println( ((int)'안'));
	}
}
