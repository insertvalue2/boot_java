package ch01;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;


public class Client extends JFrame implements ActionListener {
	
	
	//Login GUI 변수
	private JFrame Login_init = new JFrame(); //JFrame을 직접 생성함.
	private JPanel pnlLogin;
	private JTextField tfServerIp;
	private JTextField tfServerPort;
	private JTextField tfUserId;
	private JLabel lblServerIp;
	private JLabel lblServerPort;
	private JLabel lblUserId;
	private JButton btnConnect;
	
	//Main GUI 변수
	private JPanel contentPane;
	private JTextArea taContentsView;
	private JTextField tfMessage;
	private JLabel lblTotalPersonNum;
	private JButton btnSendMessage;
	private JLabel lblRoomList;
	private JButton btnJoinRoom;
	private JButton btnMakeRoom;
	private JButton btnConfirm;
	private JList lsRoomList;					//방 목록 리스트
	private JList lsTotalNum;					//전체 접속자 리스트

	//soket 자원 변수
	private Socket socket;
	private String ip = "";			//ip는 String 타입 이다.
	private int port;			//port 는 int 타입 이다.
	private String id;
	private InputStream is;
	private OutputStream os;
	private DataInputStream dis;
	private DataOutputStream dos;
	
	//그외 변수들
	Vector<String> userList = new Vector<String>();
	Vector<String> roomList = new Vector<String>();
	StringTokenizer st;
	
	
	public Client() { 
		Login_init();			//Login 창 화면구성
		Main_init();			//Main 창 화면구성
		addListener();			//리스너 연결
	}
	
	private void Login_init() {
		//조심해야할 부분 this. 이 아닌 Login_init. 임
		Login_init.setTitle("로그인");
		Login_init.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Login_init.setBounds(100, 100, 340, 430);
		pnlLogin = new JPanel();
		pnlLogin.setBorder(new EmptyBorder(5, 5, 5, 5));
		Login_init.setContentPane(pnlLogin);
		pnlLogin.setLayout(null);
		
		lblServerIp = new JLabel("Server IP :");
		lblServerIp.setBounds(12, 183, 64, 15);
		pnlLogin.add(lblServerIp);
		
		lblServerPort = new JLabel("Server Port :");
		lblServerPort.setBounds(12, 245, 89, 15);
		pnlLogin.add(lblServerPort);
		
		lblUserId = new JLabel("User ID :");
		lblUserId.setBounds(12, 301, 64, 15);
		pnlLogin.add(lblUserId);
		
		tfServerIp = new JTextField();
		tfServerIp.setBounds(134, 180, 171, 21);
		pnlLogin.add(tfServerIp);
		tfServerIp.setColumns(10);
		
		tfServerPort = new JTextField();
		tfServerPort.setBounds(134, 242, 171, 21);
		pnlLogin.add(tfServerPort);
		tfServerPort.setColumns(10);
		
		tfUserId = new JTextField();
		tfUserId.setBounds(134, 298, 171, 21);
		pnlLogin.add(tfUserId);
		tfUserId.setColumns(10);
		
		btnConnect = new JButton("접속");
		btnConnect.setBounds(62, 350, 209, 23);
		pnlLogin.add(btnConnect);
		
		tfServerIp.setText("127.0.0.1");
		
		Login_init.setVisible(true);
	}
	
	private void Main_init(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 100, 765, 485);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblTotalPersonNum = new JLabel("전 제 접 속 자");
		lblTotalPersonNum.setBounds(12, 10, 97, 15);
		contentPane.add(lblTotalPersonNum);
		
		lsTotalNum = new JList();
		lsTotalNum.setBounds(12, 28, 112, 127);
		contentPane.add(lsTotalNum);
		
		btnSendMessage = new JButton("쪽지보내기");
		btnSendMessage.setBounds(12, 165, 112, 23);
		contentPane.add(btnSendMessage);
		
		lblRoomList = new JLabel("채 팅 방 목 록");
		lblRoomList.setBounds(12, 198, 97, 15);
		contentPane.add(lblRoomList);
		
		lsRoomList = new JList();
		lsRoomList.setBounds(12, 219, 112, 127);
		contentPane.add(lsRoomList);
		
		btnJoinRoom = new JButton("방 참여");
		btnJoinRoom.setBounds(12, 356, 112, 23);
		contentPane.add(btnJoinRoom);
		
		btnMakeRoom = new JButton("방 만들기");
		btnMakeRoom.setBounds(12, 400, 112, 23); 
		contentPane.add(btnMakeRoom);
		
		taContentsView = new JTextArea();
		taContentsView.setBounds(136, 28, 588, 350);
		contentPane.add(taContentsView);
		
		tfMessage = new JTextField();
		tfMessage.setBounds(133, 401, 482, 22);
		contentPane.add(tfMessage);
		tfMessage.setColumns(10);
		
		btnConfirm = new JButton("전송");
		btnConfirm.setBounds(627, 400, 97, 23);
		contentPane.add(btnConfirm);
		
		setVisible(true);
	}
	
	private void addListener() {
		btnConnect.addActionListener(this);
		btnSendMessage.addActionListener(this);
		btnJoinRoom.addActionListener(this);
		btnMakeRoom.addActionListener(this);
		btnConfirm.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnConnect) {
			
			ip = tfServerIp.getText().trim();
			port = Integer.parseInt(tfServerPort.getText().trim()); //int 형으로 변환
			id = tfUserId.getText().trim();
			//this.setVisible(true);
			Login_init.setVisible(false);
			startNetwork();
			System.out.println("접속버튼 클릭됨...");
		}else if(e.getSource() == btnSendMessage) {
			System.out.println("쪽지보내기버튼클릭");
		}else if(e.getSource() == btnJoinRoom) {
			System.out.println("방참여 버튼 클릭");
		}else if(e.getSource() == btnMakeRoom) {
			System.out.println("방 만들기 버튼 클릭");
		}else if(e.getSource() == btnConfirm) {
			System.out.println("전송 버튼 클릭 ");
			sendMessage("임시로 보내보는 test 메세지");
		}
	}
	
	private void startNetwork() {
		
		try {
			socket = new Socket(ip,port);
			
			if(socket != null) {
				connect();
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void connect() { //실제적인 메서드 연결부분
		
		try {
			is = socket.getInputStream();
			dis = new DataInputStream(is);
			
			os = socket.getOutputStream();
			dos = new DataOutputStream(os);
			
		} catch (IOException e) {	//에러처리부분
			
			e.printStackTrace();
		}// Stream 설정 끝
		
		//처음 접속시 ID를 서버에게 전송
		sendMessage(id);
		
		// IsTotalNum 에 id를 저장한다. 
		userList.add(id); 
		lsTotalNum.setListData(userList);
		System.out.println("스레드 만나기 전");
		
		Thread th = new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true) {
					try {
						String msg = dis.readUTF();
						System.out.println("서버측으로 부터 수신된 메세지 >> " +msg );
						System.out.println("메세지 들어 오나");
						inmessage(msg);
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}); 
		th.start();
	} //런 메서드의 끝
	private void inmessage(String str) {		// 서버로부터 들어오는 모든 메세지
		//어떤문자열을 자를것인지, 어떤 문자로 구분할 것인지
		st = new StringTokenizer(str,"/");
		
		String protocol = st.nextToken();
		String message = st.nextToken();
		
		System.out.println("프로토콜 :" + protocol);
		System.out.println("내용" + message);
		
		
	}
	private void sendMessage(String str) {
		
		try {
			dos.writeUTF(str);
			System.out.println("메세지전송");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		new Client();
	}

}


