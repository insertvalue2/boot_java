package ch04;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * 
 * @author ITPS
 * Reader
 * 문자 단위 입력 스트림 
 * 파일에서 라인 단위로 문자 읽기 - 2
 */
public class MainTest2 {
	public static void main(String[] args) {

		try {
			File file = new File("reader_1.txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;

			while((line = reader.readLine()) != null) {
			 	 System.out.println(line);
			}
		} catch(IOException e) {
		  	e.printStackTrace();
		}
	}

}
