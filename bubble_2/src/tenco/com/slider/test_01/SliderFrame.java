package tenco.com.slider.test_01;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import tenco.com.test_16.Player;

public class SliderFrame extends JFrame {

	private JLabel backgroundMap;
	private Player player;
	public SliderFrame() {

		initObject();
		initSettings();
		initListener();
	}

	private void initObject() {
		backgroundMap = new JLabel(new ImageIcon("image/backgroundMap.png"));
		player = new Player();
		setSize(400, 400);
		
		
		//setLocationRelativeTo();
	}

	private void initSettings() {
		
		backgroundMap.setLocation(0, 0);
		setContentPane(backgroundMap);
		add(player);
		setResizable(true);
		setVisible(true);
	}
	
	private void initListener() {
		
	}

	public static void main(String[] args) {
		new SliderFrame();
	}

}
