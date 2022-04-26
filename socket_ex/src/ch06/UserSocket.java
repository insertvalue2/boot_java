package ch06;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class UserSocket extends Thread {
	
	ServerFile mContext; 
	Socket socket;
	// 버퍼 달기
	BufferedReader bufferedReader;

	// 새로운 스레드가 필요 하다.
	BufferedWriter bufferedWriter; // 클라언트 쪽으로 데이터를 보내 writer (output stream)

	public UserSocket(ServerFile mContext, Socket socket) {
		this.mContext = mContext;
		this.socket = socket; 
		try {
			// 클라이언트 쪽과 개별 스트림 연결 
			// UserInfo 1 : client 1  ( 스트림은 1 : 1 ) (in, out)  
			bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void sendMessage(String msg) {
		try {
			bufferedWriter.write(msg + "\n");
			bufferedWriter.flush();
			System.out.println("각각 연결된 소켓 + 스트림을 통해 보냄 ");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// 스레드에 또 스레드를 생성해야 한다는 개념 !!! 
	@Override
	public void run() {
		//UserInfo class 도 다른 작업을 해야 하기 때문에 메세지 받는 
		// 부분은 따로 스레드를 생성 해야 한다 !!!! 
		new Thread(new Runnable() {
			@Override
			public void run() {
				while(true) {
					try {
						String msg = bufferedReader.readLine();
						System.out.println("msg : " + msg);
						// 다른 사용자 한테도 알려야 한다. 
						mContext.brodcast(msg);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
				}
			}
		}).start();
	}
	
		
}
