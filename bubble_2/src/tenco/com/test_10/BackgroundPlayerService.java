package tenco.com.test_10;

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

			// NO !
			// Color bottomColor = new Color(image.getRGB(player.getX() + 50 + 15,
			// player.getY() + 25));

			// 1단계
//			int bottomColor = image.getRGB(player.getX(), player.getY() + 50 + 5);
			// - 1 이 아니라는 것은 빨간색이거나 파란색이다.

			// 2단계
			// -2 가 출력 된다면 바닥이 하얀색이다. 
//			int bottomColor = image.getRGB(player.getX(), player.getY() + 50 + 5)
//					+ image.getRGB(player.getX() + 50, player.getY() + 50 + 5);
			
			// 3단계
			// 범위를 조금 줄이자 !! 
			int bottomColor = image.getRGB(player.getX() + 10, player.getY() + 50 + 5)
					+ image.getRGB(player.getX() + 50 - 10, player.getY() + 50 + 5);

			// 1단계 
			// 바닥 충돌 확인
//			if (bottomColor != -1) {
//				System.out.println(" 바닥컬러 " + bottomColor);
//				// for 문이기 때문에 멈추지 않는다.
//				player.setDown(false);
//				// 버그 발생 (왼쪽 하단 좌만 확인 한다면 오른쪽 면에서 버그 발생)
//			}
			
			// 2단계 
			// 바닥 충돌 확인 
			if (bottomColor != -2) {
				System.out.println("바닥컬러" + bottomColor);
				// for 문이기 때문에 멈추지 않는다.
				player.setDown(false);
				// 버그 발생 (왼쪽 하단 좌만 확인 한다면 오른쪽 면에서 버그 발생)
			}

			// 외벽 충돌 확인
			if (leftColor.getRed() == 255 && leftColor.getGreen() == 0 && leftColor.getBlue() == 0) {
				System.out.println("왼쪽 벽에 충돌함");
				player.setLeftWallCrash(true);
				player.setLeft(false);
			} else if (rightColor.getRed() == 255 && rightColor.getGreen() == 0 && rightColor.getBlue() == 0) {
				System.out.println("오른쪽 벽에 충돌함");
				player.setRightWallCrash(true);
				player.setRight(false);
			} else {
				// 충돌하지 않았을 경우 다시 false 로 돌려 줘야 한다.
				player.setLeftWallCrash(false);
				player.setRightWallCrash(false);
			}

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
