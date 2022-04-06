package tenco.com;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MiniGame extends JFrame implements ActionListener {

	BufferedImage backgroundImage;
	BufferedImage playerIcon;
	BufferedImage playerIconLeft;
	BufferedImage playerIconRight;
	BufferedImage amongImage2;
	CustomJPanel customPanel;

	BorderLayout borderLayout;
	JPanel bottomPanel;
	JButton btnStart;
	JButton btnStop;

	boolean isThread = true;

	int among1XPoint = 0;
	int among1YPoint = 370;
	int among2XPoint = 200;
	int among2YPoint = 200;

	public MiniGame() {
		initData();
		setInitLayout();
		addEventListener();

		Thread thread = new Thread(customPanel);
		thread.start();
	}

	private void initData() {
		setTitle("이미지 백그라운드 연습");
		setSize(600, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		borderLayout = new BorderLayout();
		btnStart = new JButton("start");
		btnStop = new JButton("stop");
		bottomPanel = new JPanel();

		try {
			backgroundImage = ImageIO.read(new File("images/backgroundMap.png"));
			playerIconLeft = ImageIO.read(new File("images/playerL.png"));
			playerIconRight = ImageIO.read(new File("images/playerR.png"));
			amongImage2 = ImageIO.read(new File("images/enemyL.png"));
		} catch (IOException e) {
			System.out.println("파일이 없습니다.");
			System.exit(0);

		}
		// 내부 클래스 생성
		customPanel = new CustomJPanel();

		playerIcon = playerIconLeft;
	}

	private void setInitLayout() {
		this.setVisible(true);
		this.setResizable(false);
		this.setLayout(borderLayout);

		this.add(customPanel, borderLayout.CENTER);
		this.add(bottomPanel, borderLayout.SOUTH);
		bottomPanel.setLayout(new FlowLayout());
		bottomPanel.add(btnStart);
		bottomPanel.add(btnStop);

		// this 포커스 처리
		this.requestFocusInWindow();
	}

	private void addEventListener() {

		btnStart.addActionListener(this);
		btnStop.addActionListener(this);

		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int code = e.getKeyCode();
				switch (code) {
				case KeyEvent.VK_UP:
					among2YPoint -= 10;
					break;
				case KeyEvent.VK_DOWN:
					among2YPoint += 10;
					break;
				case KeyEvent.VK_LEFT:
					among2XPoint -= 10;
					break;
				case KeyEvent.VK_RIGHT:
					among2XPoint += 10;
					break;
				}

			}
		});
	}

	private class CustomJPanel extends JPanel implements Runnable {

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(backgroundImage, 0, 0, 600, 600, null);
			g.drawImage(playerIcon, among1XPoint, among1YPoint, 100, 100, null);
			g.drawImage(amongImage2, among2XPoint, among2YPoint, 100, 100, null);

		}

		@Override
		public void run() {
			boolean direcation = true;
			while (true) {
				if (isThread) {
					if (direcation) {
						among1XPoint = among1XPoint + 10;
					} else {
						among1XPoint = among1XPoint - 10;
					}

					if (among1XPoint == 400) {
						direcation = false;
					}

					if (among1XPoint == 0) {
						direcation = true;
					}

					if ((among1XPoint == among2XPoint) && (among1YPoint == among2YPoint)) {
						amongImage2 = null;
						System.out.println("충돌");
					}

					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				repaint();
			}
		}
	} // end of MyImagePanel (내부 클래스)

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton targetBtn = (JButton) e.getSource();
		if (btnStart == targetBtn) {
			System.out.println("btnStart targetBtn : " + targetBtn);
			isThread = true;

		} else {
			System.out.println("btnStop targetBtn : " + targetBtn);
			isThread = false;

		}

		// this 포커스 처리
		this.requestFocusInWindow();
	}

	public static void main(String[] args) {
		new MiniGame();
	}

}
