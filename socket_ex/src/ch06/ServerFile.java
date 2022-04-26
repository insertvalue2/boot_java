package ch06;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class ServerFile {
	// 클라이언트 연결을 받든 소켓
	ServerFile mContext = this;
	ServerSocket serverSocket;
	Vector<UserSocket> sockets = new Vector<>();
	
	public ServerFile() {
		
		System.out.println("1. >>>>> 서버 소켓 시작 <<<<<");
		try {
			serverSocket = new ServerSocket(11000);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		System.out.println("1. >>>>> 클라이언트 대기 <<<<<");
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true) {
					try {
						Socket socket = serverSocket.accept();
						System.out.println("계속 돌아 가나요?11");
						UserSocket userSocket = new UserSocket(mContext, socket);
						userSocket.start();
						sockets.add(userSocket);
						
					} catch (IOException e) {
						e.printStackTrace();
					};
				}
			}
		}).start();
	}
	
	public void brodcast(String msg) {
		System.out.println("호출 확인 !!! ");
		for(int i = 0; i < sockets.size(); i++) {
			sockets.get(i).sendMessage(msg);
		}
	}


	public static void main(String[] args) {
		new ServerFile();
	}
}
