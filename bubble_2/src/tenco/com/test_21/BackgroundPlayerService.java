package tenco.com.test_21;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public class BackgroundPlayerService implements Runnable {

	private BufferedImage image;
	private Player player;
	private List<Bubble> bubbles = new ArrayList<Bubble>();

	// 플레이어, 버블
	public BackgroundPlayerService(Player player) {
		this.player = player;
		this.bubbles = player.getBubbleList();
		try {
			image = ImageIO.read(new File("image/backgroundMapService.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while (true) {

			// 1. 버블 충돌 체크
			for (int i = 0; i < bubbles.size(); i++) {
				Bubble targetBubble = bubbles.get(i);
				if (targetBubble.getState() == 1) {
					// player.getY() 값 조심
					if ((Math.abs(player.getX() - targetBubble.getX()) < 10)
							&& (Math.abs(player.getY() - targetBubble.getY()) > -10
									&& Math.abs(player.getY() - targetBubble.getY()) < 50)) {
						System.out.println("플레이어와 물방울 충돌");
						// 그림을 다시 그리는 순간 망가져 버림 !!
						// java.lang.ArrayIndexOutOfBoundsException
						// targetBubble.removeBubbled();
						new Thread(new Runnable() {
							@Override
							public void run() {
								targetBubble.removeBubbled();
							}
						}).start();
						break;
					}
				}
			}

			// 2. 벽 충돌 체크
			Color leftColor = new Color(image.getRGB(player.getX() - 10, player.getY() + 25));
			Color rightColor = new Color(image.getRGB(player.getX() + 50 + 15, player.getY() + 25));
			int bottomColor = image.getRGB(player.getX() + 10, player.getY() + 50 + 5)
					+ image.getRGB(player.getX() + 50 - 10, player.getY() + 50 + 5);

			if (bottomColor != -2) {
				player.setDown(false);
			} else {
				if (!player.isUp() && !player.isDown()) { // 내려가다가 끝 까지 내려감...
					player.down();
				}
			}

			if (leftColor.getRed() == 255 && leftColor.getGreen() == 0 && leftColor.getBlue() == 0) {
				player.setLeftWallCrash(true);
				player.setLeft(false);
			} else if (rightColor.getRed() == 255 && rightColor.getGreen() == 0 && rightColor.getBlue() == 0) {
				player.setRightWallCrash(true);
				player.setRight(false);
			} else {
				player.setLeftWallCrash(false);
				player.setRightWallCrash(false);
			}

			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
