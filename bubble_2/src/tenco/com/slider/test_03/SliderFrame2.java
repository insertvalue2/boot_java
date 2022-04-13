package tenco.com.slider.test_03;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import tenco.com.slider.test_01.Player;

public class SliderFrame2 extends JFrame {

	private BgPanel bgPanel;
	private ImageIcon icon;
	private Player player;

	int bgPointX = 0;

	public SliderFrame2() {
		initData();
		setInitLayout();
		addEventListener();
	}

	private void initData() {

		setSize(400, 640);
		icon = new ImageIcon("image/backgroundMap.png");
		bgPanel = new BgPanel();
	}

	private void setInitLayout() {
		setLayout(null);
		setContentPane(bgPanel);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void addEventListener() {
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

				int keyCode = e.getKeyCode();

				switch (keyCode) {
				case KeyEvent.VK_LEFT:
					new Thread(new Runnable() {
						@Override
						public void run() {
							System.out.println(bgPointX);
							if (bgPointX > -600) {
								for (int i = 0; i < 10; i++) {
									bgPointX--;
									repaint();
									try {
										Thread.sleep(10);
									} catch (InterruptedException e) {
										e.printStackTrace();
									}
								}
							}
						}
					}).start();
					break;
				case KeyEvent.VK_RIGHT:
					new Thread(new Runnable() {
						@Override
						public void run() {
							System.out.println(bgPointX);
							if (bgPointX < -10) {
								for (int i = 0; i < 10; i++) {
									bgPointX++;
									repaint();
									try {
										Thread.sleep(10);
									} catch (InterruptedException e) {
										e.printStackTrace();
									}
								}
							}

						}
					}).start();
					break;
				}
			}
		});
	}

	private class BgPanel extends JPanel {
		private static final long serialVersionUID = 1L;
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(icon.getImage(), bgPointX, 0, null);
		}
	}
	
	public static void main(String[] args) {
		new SliderFrame2();
	}
	
}
