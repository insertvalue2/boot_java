package ch01;

import java.io.IOException;

/**
 * 
 * @author ITPS
 * 표준 입출력 스트림 1 
 */
public class MainTest2 {
	
	public static void main(String[] args) {
		System.out.println("알파벳 하나 쓰고 엔터");
		
		int i; 
		try {
			i = System.in.read();
			System.out.println(i);
			System.out.println((char)i);
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
}
