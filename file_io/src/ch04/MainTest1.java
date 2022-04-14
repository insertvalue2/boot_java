package ch04;

import java.io.FileReader;
import java.io.IOException;

/**
 * 
 * @author ITPS
 * Reader
 * 문자 단위 입력 스트림 
 * 파일에서 문자 읽기 - 1
 */
public class MainTest1 {
	public static void main(String[] args) {

		try(FileReader fr = new FileReader("reader_1.txt")){
			int i;
			while( (i = fr.read()) != -1){
				System.out.print((char)i);
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
	}

}
