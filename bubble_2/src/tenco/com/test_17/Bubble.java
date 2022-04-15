package tenco.com.test_17;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import lombok.Getter;
import lombok.Setter;
import tenco.com.test_13.PlayerWay;

@Getter
@Setter
public class Bubble extends JLabel implements Moveable {
	
	private Bubble bubbleContext;

	// player 객체에 의존적
	private Player player;
	private BackgroundBubleObserver bubbleObserver;
	
	// 위치 상태
	private int x;
	private int y;

	// 움직임 상태
	private boolean left;
	private boolean right;
	private boolean up;

	// 적군을 맞춘 상태
	private int state; // 0(물방울), 1(적을 가둔 물방울)

	private ImageIcon bubble; // 기본 물방울
	private ImageIcon bubbled; // 적을 가둔 물방울
	private ImageIcon bomb; // 물방울이 터진 상태
	
	public Bubble(Player player) {
		this.player = player;
		initObject();
		initSetting();
		initThread();
	}
		

	private void initObject() {
		bubble = new ImageIcon("image/bubble.png");
		bubbled = new ImageIcon("image/bubbled.png");
		bomb = new ImageIcon("image/bomb.png");
		bubbleObserver = new BackgroundBubleObserver(this); 
	}

	private void initSetting() {
		left = false;
		right = false;
		up = false;

		x = player.getX();
		y = player.getY();

		setIcon(bubble);
		setSize(50, 50);
		
		state = 0;
	}

	private void initThread() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				if (player.getPlayerWay() == PlayerWay.LEFT) {
					left();
				} else {
					right();
				}
			}
		}).start();
	}


	@Override
	public void left() {
		left = true;
		for (int i = 0; i < 400; i++) {
			x--;
			setLocation(x, y);
			if(bubbleObserver.checkLeftWall()) {
				left = false;
				break;
			}
			threadSleep(1);
		}
		up();
	}

	@Override
	public void right() {
		right = true;
		for (int i = 0; i < 400; i++) {
			x++;
			setLocation(x, y);
			if(bubbleObserver.checkRightWall()) {
				right = false;
				break;
			}
			threadSleep(1);
		}
		up();
	}

	@Override
	public void up() {
		up = true;
		while (up) {
			y--;
			setLocation(x, y);
			if(bubbleObserver.checkTopWall()) {
				up = false;  
				break;  
			}
			threadSleep(1);
		}
		removeBubble(); 
	}
	
	private void removeBubble() {
		try {
			Thread.sleep(2000);
			setIcon(bomb);
			Thread.sleep(1000);
			// 2 단계 
			setIcon(null);
			bubbleContext = null; 
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void threadSleep(int time) {
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
