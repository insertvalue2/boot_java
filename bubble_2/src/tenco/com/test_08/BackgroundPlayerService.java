package tenco.com.test_08;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

// 벽에 부딪치는 테스트 
// 메인 쓰레드는 바쁨 -- 키보드 이벤트 처리 
// 백그라운드에서 계속 관찰
public class BackgroundPlayerService implements Runnable {

	private BufferedImage image;
	private Player player;

	public BackgroundPlayerService(Player player) {
		this.player = player;
		try {
//			image = ImageIO.read(new File("image/test.png"));
			image = ImageIO.read(new File("image/backgroundMapService.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void run() {
		// 색상 확인
		while (true) {

			Color leftColor = new Color(image.getRGB(player.getX() - 10, player.getY() + 25));
			Color rightColor = new Color(image.getRGB(player.getX() + 50 + 15, player.getY() + 25));

//			System.out.println("-----------------------------");
//			System.out.println("왼쪽 : " + leftColor);
//			System.out.println("오른쪽 : " + rightColor);
//			System.out.println("-----------------------------");
			// 255, 0 , 0

			if (leftColor.getRed() == 255 && leftColor.getGreen() == 0 && leftColor.getBlue() == 0) {
				System.out.println("왼쪽 벽에 충돌함");
			} else if (rightColor.getRed() == 255 && rightColor.getGreen() == 0 && rightColor.getBlue() == 0) {
				System.out.println("오른쪽 벽에 충돌함");
			}

//			if(leftColor.getRed() == 255 && leftColor.getGreen() == 0 && leftColor.getBlue() == 0 ) {
//				System.out.println("왼쪽 벽에 충돌");
//			} else if (rightColor.getRed() == 255 && rightColor.getGreen() == 0 && rightColor.getBlue() == 0) {
//				System.out.println(player.getX() + 55 + 10);
//				System.out.println(rightColor);
//				System.out.println("오른쪽 벽에 충돌");
//			}

			//

			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// 아직 실행은 안된 상태
	}

}
