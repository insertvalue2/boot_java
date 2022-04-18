package ch04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @author ITPS
 * Reader
 * 문자 단위 입력 스트림 
 * 버퍼드리더로 문자 읽기 - 3
 */
public class MainTest3 {
	public static void main(String[] args) {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter your name: ");
		String name;
		try {
			name = reader.readLine();
			System.out.println("Your name is: " + name);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
