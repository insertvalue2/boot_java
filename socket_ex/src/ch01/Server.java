package ch01;

import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class Server extends JFrame implements ActionListener {

	// GUI 자원
	private JPanel contentPane;
	private JTextField tfPort;
	private JTextArea textArea;
	private JLabel lblPortNum;
	private JButton btnServerStart;
	private JButton btnServerStop;

	// Socket 자원
	private ServerSocket serverSocket;
	private Socket socket;
	private int serverPort;
	private Vector<UserInfo> vc_connecter = new Vector<UserInfo>();
	
	
	// 생성자
	public Server() {
		init(); // 화면생성메서드
		addListener(); // 이벤트리스너 메서드
	}

	// 서버GUI 초기화
	private void init() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 410);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setBounds(12, 10, 310, 230);
		textArea = new JTextArea();
		textArea.setBounds(12, 10, 310, 230);
		scrollPane.add(textArea);
		contentPane.add(scrollPane);

		lblPortNum = new JLabel("포트번호 :");
		lblPortNum.setBounds(12, 273, 82, 15);
		contentPane.add(lblPortNum);

		tfPort = new JTextField();
		tfPort.setBounds(98, 270, 224, 21);
		contentPane.add(tfPort);
		tfPort.setColumns(10);

		btnServerStart = new JButton("서버실행");
		btnServerStart.setBounds(12, 315, 154, 23);
		contentPane.add(btnServerStart);

		btnServerStop = new JButton("서버중지");
		btnServerStop.setBounds(168, 315, 154, 23);
		contentPane.add(btnServerStop);

		setVisible(true);
	}

	private void addListener() {
		btnServerStart.addActionListener(this);
		btnServerStop.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnServerStart) {

			serverPort = Integer.parseInt(tfPort.getText().trim());
			System.out.println("서버실행");
			serverStart();
		}
		if (e.getSource() == btnServerStop) {
			System.out.println("서버중지");
		}
	}// 액션이벤트 끝
	
	private void serverStart() {
		try {
			serverSocket = new ServerSocket(serverPort);
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (serverSocket != null) { // 서버소캣이 정상동작했을경우 실행
			connect();
		}
	}

	private void connect() {
		// 익명 스레드 생성
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() { // 스레드에서 처리할 일을 기재한다.
				// 1가지의 스레드에서는 하나의 일만 처리할 수 있다 -->소캣이 무한 대기중.
				while (true) {
					try {
						textArea.append("서버가사용자접속대기중\n");
						socket = serverSocket.accept(); // 서버가 사용자 접속 무한대기.

						// 사용자가 접속하면 유저인포 객체를 하나 만들면서 생성된 socket정보를 넘겨준다.
						UserInfo userInfo = new UserInfo(socket);
						
						// 각각에 userInfo는 thread를 상속 받았기 때문에 각각 스레드를 실행 시켜줘야 한다.
						userInfo.start();

					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		});
		thread.start();
	}

	// 내부 클래스
	class UserInfo extends Thread {

		private InputStream is;
		private OutputStream os;
		private DataInputStream dis;
		private DataOutputStream dos;

		private Socket user_Socket;
		private String nickName = "";

		// 현재클래스에서 넘어 온 socket을 유저 socket에게 전달해 준다.
		public UserInfo(Socket soc) {
			// 여기서의 this --> UserInfo 
			this.user_Socket = soc;

			userNetwork();
		}

		@Override
		public void run() {		// Thread에서 처리할 내용
			while (true) {
				try {
					String msg = dis.readUTF();
					textArea.append(nickName + ">>" + msg + "\n");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}// run end
		
		private void send_Message(String str) {
			
			try {
				dos.writeUTF(str);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

		private void userNetwork() { // 유저의 network 자원
			try {
				is = user_Socket.getInputStream();
				dis = new DataInputStream(is); 

				os = user_Socket.getOutputStream();
				dos = new DataOutputStream(os);

				// 사용자의 닉네임을 받는다
				nickName = dis.readUTF();
				textArea.append(nickName + ": 사용자 접속\n");
				System.out.println("TEst1");
				
				// 기존 사용자들에게 새로운 접속자 알림 --> 다음에 자신을 Vector에 저장시킨다.
				for (int i = 0; i < vc_connecter.size(); i++) {
					UserInfo u = vc_connecter.elementAt(i);
					u.send_Message("NewUser/"+nickName);
					System.out.println(u);
				}
				vc_connecter.add(this);	// 사용자에게 알린 후 Vector에 자신은 추가				
				System.out.println("TEst1");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	
	public static void main(String[] args) {
		new Server();
	}
}


