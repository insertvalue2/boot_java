package tenco.com.test_15;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

// 쓰레드로 만들지 않음 !!!
// 느려진다.
// 버블이에서 메서드 호출 
// 버블이 만들어질 때 마다 new 되어야 한다. 
// 하나의 버블 객체를 감시하는 녀석 !!! 
// 버블이 하나 만들어 질 때마다 new 
// 백그라운드는 플에이어 서비스는 독립적으로 하나만 생성해서 일을 하고 있음
public class BackgroundBubleObserver {

	private BufferedImage image;
	private Bubble bubble;
	// 멤버 변수이여하 할까? (여기서는 지역 변수가 더 좋음) 
	// 메서드가 호출 되고 메모리에서 없애 버리자 (stack) 
	// 코드에 리백토링 과정 !!  
	public BackgroundBubleObserver(Bubble bubble) {
		this.bubble = bubble;
		try {
			image = ImageIO.read(new File("image/backgroundMapService.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public boolean checkLeftWall() {
		// 1단계 
		Color leftColor = new Color(image.getRGB(bubble.getX() - 25, bubble.getY()));
		if(leftColor.getRed() == 255 && leftColor.getGreen() == 0 && leftColor.getBlue() == 0) {
			return true; 
		}
		return false;
	}

	public boolean checkRightWall() {
		// 2단계 		
		if (isCrashColor()) {
			return true;
		}
		return false;
	}

	public boolean checkTopWall() {
		// 3단계 
		return isCrashColor(); 
	}

	private boolean isCrashColor() {
		Color color = new Color(image.getRGB(bubble.getX() + 50 + 15, bubble.getY()));
		if (color.getRed() == 255 && color.getGreen() == 0 && color.getBlue() == 0) {
			return true;
		}
		return false;
	}
}
