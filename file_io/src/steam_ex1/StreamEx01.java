package steam_ex1;

import java.io.IOException;
import java.io.InputStream;

public class StreamEx01 {
	
	public static void main(String[] args) {
		InputStream in = System.in; // 키보드에 연결된 
		//1. 키보드 A를 인코딩해서 01000001 으로 컴퓨터에게 전송
		//2. ByteStream으로 플러 들어간다. (Input)
		//3. read() 메서드로 01000001 --> 65로 디코딩 한다.
		//4. 부호화
		//5. 단점 : ABC 를 입력하더라도 A만 받음
		// (ByteStream 이기 때문에 1byte 만 받음)
		try {
			int data = in.read(); // 1byte(8bit)
			System.out.println(data);
			System.out.println((char)data); // 부호화
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
