package ch01;

import java.io.IOException;


/**
 * @author ITPS
 * 표준 입출력 스트림 2 
 */
public class MainTest3 {

	public static void main(String[] args) {
		System.out.println("알파벳 여러개 쓰고 엔터");
		
		int i; 
		try {
//			i = System.in.read();
//			System.out.println(i);
			// 0 ~ 255 
			while( (i = System.in.read()) != '\n' ) {
				System.out.print(i + ":");
				System.out.print((char)i);
				System.out.print("\t");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
