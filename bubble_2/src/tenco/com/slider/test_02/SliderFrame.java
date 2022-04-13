package tenco.com.slider.test_02;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import tenco.com.test_16.Player;

public class SliderFrame extends JFrame {

	private JLabel backgroundMap;
	private Player player;
	private Image bgImage;
	private int backgroundX;
	private BgPanel bgPanel;
	
	public SliderFrame() {

		initObject();
		initSettings();
		initListener();
	}

	private void initObject() {
		setSize(200, 640);
		
		bgImage = new ImageIcon("image/backgroundMap.png").getImage();
		
		bgPanel = new BgPanel();
		player = new Player();
		
		backgroundX = 0; 
	}

	private void initSettings() {
		setContentPane(bgPanel);
		
		add(player);
		setResizable(true);
		setVisible(true);
	}
	
	private void initListener() {
		addKeyListener(new KeyAdapter() {

			// 키보드 클릭 이벤트 핸들러
			@Override
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					if (!player.isLeft() && !player.isLeftWallCrash()) {
						player.left();
					}
					break;
				case KeyEvent.VK_RIGHT:
					if (!player.isRight() && !player.isRightWallCrash()) {
						player.right();
					}

					break;
				case KeyEvent.VK_UP:
					if (!player.isUp() && !player.isDown()) {
						player.up();
					}
					break;
				case KeyEvent.VK_SPACE:
//					Bubble bubble = new Bubble(player); 
//					add(bubble);
//					add(player.attackBubble());
					break;
				}
			}

			// 키보드 해제 이벤트 핸들러
			@Override
			public void keyReleased(KeyEvent e) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					player.setLeft(false);
					break;
				case KeyEvent.VK_RIGHT:
					player.setRight(false);
					break;
				}
			}

		});
	}

	
	private class BgPanel extends JPanel {
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(bgImage,backgroundX, 0, 200, 640, null);
		}
	}
	
	public static void main(String[] args) {
		new SliderFrame();
	}

}
