package tenco.com.test_21;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BackgroundBubleObserver {
	
	private static int LEFT_XPOINT = 0;
	private static int RIGHT_XPOINT = 60;
	private static int CENTER_TOP = 25;
	
	private BufferedImage image;
	private Bubble bubble;

	public BackgroundBubleObserver(Bubble bubble) {
		this.bubble = bubble;
		try {
			image = ImageIO.read(new File("image/backgroundMapService.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public boolean checkLeftWall() {
		return isCrashColor(LEFT_XPOINT);
	}

	public boolean checkRightWall() {
		return isCrashColor(RIGHT_XPOINT);
	}

	public boolean checkTopWall() {
		return isCrashColor(CENTER_TOP);
	}

	private boolean isCrashColor(int correctionPont) {
		Color color = new Color(image.getRGB(bubble.getX() + correctionPont, bubble.getY()));
		if (color.getRed() == 255 && color.getGreen() == 0 && color.getBlue() == 0) {
			return true;
		}
		return false;
	}
}
