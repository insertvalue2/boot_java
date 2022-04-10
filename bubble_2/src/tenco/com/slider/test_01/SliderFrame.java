package tenco.com.slider.test_01;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class SliderFrame extends JFrame {

	private JLabel backgroundMap;
	
	public SliderFrame() {

		initObject();
		initSettings();
		initListener();
	}

	private void initObject() {
		backgroundMap = new JLabel(new ImageIcon("image/backgroundMap.png"));
		
		setSize(400, 400);
		setVisible(true);
		setResizable(true);
		//setLocationRelativeTo();
	}

	private void initSettings() {
		backgroundMap.setLocation(0, 0);
		setContentPane(backgroundMap);
		
	}
	
	int pointX = 0; 
	int piintY = 0; 
	private void initListener() {
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode(); 
				switch (keyCode) {
				case KeyEvent.VK_LEFT:
					new Thread(new Runnable() {
						
						@Override
						public void run() {
							for(int i = 400; i > -100; i--) {
								backgroundMap.setLocation(0, i);
								try {
									Thread.sleep(5);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
						}
					}).start();
					
					break;

				default:
					break;
				}
			}
		});
	}

	public static void main(String[] args) {
		new SliderFrame();
	}

}
