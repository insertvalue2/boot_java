package ch03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ClientFile {
	Socket socket; 
	BufferedWriter bufferedWriter; 
	final String IP = "localhost";
	final int PORT = 10000;
	BufferedReader bufferedReader;
	
	public ClientFile() {
		
		try {
			System.out.println("1. 클라이언트 소켓 시작 ");
			socket = new Socket(IP, PORT);
			
			
			System.out.println("2. 버퍼 연결 ");
			bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			// 그림 - 6
			
			// 키보드 연결 
			System.out.println("3. 키보드 버퍼 연결 ");
			bufferedReader = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("4. 키보드 입력 대기 ");
			String keyboardMsg = bufferedReader.readLine();
			
			// 중요. 메세지 끝을 알려줘야 한다. \n 
			bufferedWriter.write(keyboardMsg + "n");
			bufferedWriter.flush();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public static void main(String[] args) {
		new ClientFile();
	}
}
