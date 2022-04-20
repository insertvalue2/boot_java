package ch05;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ClientFile {
	Socket socket;
	BufferedWriter bufferedWriter;
	final String IP = "localhost";
	final int PORT = 11000;
	BufferedReader keyboardBufferedReader;
	
	boolean flag = true; 
	
	// 서버에서 보낸 메세지를 읽기 위해 buffer 장착
	BufferedReader bufferedReader;

	public ClientFile() {

		try {
			System.out.println("1. [[[[[ 클라이언트 소켓 시작 ]]]]");
			socket = new Socket(IP, PORT);

			System.out.println("2. 버퍼 연결 ");
			bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			// 그림 - 6

			// 키보드 연결
			System.out.println("3. 키보드 버퍼 연결 ");
			keyboardBufferedReader = new BufferedReader(new InputStreamReader(System.in));

			bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			// 새로운 쓰레드 생성
			ReadThread readThread = new ReadThread();
			Thread thread = new Thread(readThread);
			thread.start();

			// 메인 쓰레드 역할 (글 쓰기)
			System.out.println("4. 키보드 입력 대기 ");

			while (flag) {
				String keyboardMsg = keyboardBufferedReader.readLine();
				// 중요. 메세지 끝을 알려줘야 한다. \n
				bufferedWriter.write(keyboardMsg + "\n");
				bufferedWriter.flush();
			}
			// 계속 메시지를 서버쪽으로 보낼 수 있다
			// 하지만 반대가 안됨 (서버에서 클라이언트 쪽으로 못 보냄)
			// 즉 서버에서 읽을 쓰는 스레드가 없음
			// 클라이언트는 읽는 스레드가 없음
			// 즉 -> 현재 로직은 단방향 통신 밖에 되지 않는다. !!!
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				flag = false; 
				bufferedWriter.close();
				keyboardBufferedReader.close();
				bufferedReader.close();
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

	}

	private class ReadThread implements Runnable {
		@Override
		public void run() {
			while (flag) {
				try {
					String serverMessage = bufferedReader.readLine();
					System.out.println("서버로부터 받은 메세지 : " + serverMessage);
				} catch (IOException e) {
					flag = false; 
					e.printStackTrace();
					
				}
			}
		}
		
	}

	public static void main(String[] args) {
		new ClientFile();
	}
}
