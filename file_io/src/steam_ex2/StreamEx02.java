package steam_ex2;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class StreamEx02 {

	public static void main(String[] args) {
		InputStream in = System.in; // 키보드에 연결된 
		InputStreamReader ir = new InputStreamReader(in); // 65 --> A로 부호화
		// ir 의 단점 (가변적으로 못 받음)   
		
		try {
			// 1 
			// int data = ir.read();
			char[] data = new char[3]; // 캐스팅 없이 받을 수 있음
			// A -> 999 개 낭비 
			// char[] data = new char[1000]; 
			// 잘 사용하지 않음 (특히 통신) --> 해결방안 Buffer 이다.
			
			ir.read(data);
			System.out.println(data);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
