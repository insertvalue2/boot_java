package steam_ex3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class StreamEx03 {

	public static void main(String[] args) {
		InputStream in = System.in; // 키보드에 연결된 
		InputStreamReader ir = new InputStreamReader(in); // 65 --> A로 부호화
		BufferedReader br = new BufferedReader(ir); // 매력적 --> String 으로 받을 수 있다. 
		
		try {
			String data = br.readLine(); 
			System.out.println(data);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
