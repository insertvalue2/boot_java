package tenco.com.test_21;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public class BackgroundEnemyService implements Runnable {

	private BufferedImage image;
	private Enemy enumy;

	// 플레이어, 버블
	public BackgroundEnemyService(Enemy enumy) {
		this.enumy = enumy;
		try {
			image = ImageIO.read(new File("image/backgroundMapService.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while (enumy.isLive()) {

			Color leftColor = new Color(image.getRGB(enumy.getX() - 10, enumy.getY() + 25));
			Color rightColor = new Color(image.getRGB(enumy.getX() + 50 + 15, enumy.getY() + 25));
			int bottomColor = image.getRGB(enumy.getX() + 10, enumy.getY() + 50 + 5)
					+ image.getRGB(enumy.getX() + 50 - 10, enumy.getY() + 50 + 5);

			if (bottomColor != -2) {
				enumy.setDown(false);
			} else {
				if (!enumy.isUp() && !enumy.isDown()) { // 내려가다가 끝 까지 내려감...
					enumy.down();
				}
			}

			if (leftColor.getRed() == 255 && leftColor.getGreen() == 0 && leftColor.getBlue() == 0) {
				enumy.setLeft(false);
				// 한번만 실행 (즉 가고 있지 않을 때)
				if(!enumy.isRight()) {
					enumy.right();
				}
				//enumy.right();
			} else if (rightColor.getRed() == 255 && rightColor.getGreen() == 0 && rightColor.getBlue() == 0) {
				enumy.setRight(false);
				if(!enumy.isLeft()) {
					enumy.left();
				}
			} 

			try {
				Thread.sleep(6);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
