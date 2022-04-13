package ch01;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GraphicsClipEx extends JFrame {
	private MyPanel panel = new MyPanel();

	public GraphicsClipEx() {
		setTitle("클리핑 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		setSize(300, 640);
		setVisible(true);
	}

	class MyPanel extends JPanel {
		private ImageIcon icon = new ImageIcon("image/backgroundMap.png");
		private Image img = icon.getImage(); // 이미지 객체

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setClip(100, 100, 150, 150);
			g.drawImage(img, 0, 0, 150, 150, this);
			
		}
	}

	public static void main(String[] args) {
		new GraphicsClipEx();
	}
}
