package ch04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerFile {
	// 클라이언트 연결을 받든 소켓
	ServerSocket serverSocket;
	// 실제 통신을 하는 소켓
	Socket socket;
	// 버퍼 달기
	BufferedReader bufferedReader;

	public ServerFile() {
		System.out.println("1. >>>>> 서버 소켓 시작 <<<<<");
		try {
			serverSocket = new ServerSocket(11000);

			System.out.println("2. ==== 서버 소켓 생성 완료 ==== ");
			// 실행하면 방화벽을 허용할까요? os 방화벽 역활(모든 포트를 막는 기능) (그림)
			socket = serverSocket.accept(); // 클라이언트 접속 대기중....
			System.out.println("3. 클라이언트 연결 완료");

			bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			// 그림설명

			while (true) {
				String msg = bufferedReader.readLine();
				System.out.println("4. 클라이언트로 받은 메세지 : " + msg);
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("예외 발생 : " + e.getMessage());
		}
	}

	public static void main(String[] args) {
		new ServerFile();
		// 1. 왜 여기에 소켓이 두개가 존재 해야 하는가? (그림)
		// 2. 서버 소켓은 연결만 받는다 (통신은 못한다)
		// 3. 소켓으로 스트림 전달 (1024 ~ 65535 까지 사용하지 않는 포트
		// 번호를 랜덤으로 선정한다) : 랜덤으로 정해주는 것이 편하다.

	}
}
