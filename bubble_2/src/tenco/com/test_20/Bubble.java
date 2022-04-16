package tenco.com.test_20;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import lombok.Getter;
import lombok.Setter;
import tenco.com.test_13.PlayerWay;

@Getter
@Setter
public class Bubble extends JLabel implements Moveable {

	// 버블이 적군을 계산하는 것이 상대적으로 좋다.
	// 의존해야 하는 객체가 적으면 적을 수록 좋다.
	private BubbleFrame mContext;
	private Bubble bubbleContext = this;
	// array 리스이면 통으로 받으면 된다.
	private Enemy enemy;

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

	public Bubble(BubbleFrame mContext) {
		this.mContext = mContext;
		this.player = mContext.getPlayer();
		this.enemy = mContext.getEnemy();
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
		for (int i = 0; i < 250; i++) {
			x--;
			setLocation(x, y);
			if (bubbleObserver.checkLeftWall()) {
				left = false;
				break;
			}

//			if ((Math.abs(x - enemy.getX()) > 40 && Math.abs(x - enemy.getX()) < 60)
//					&& (Math.abs(y - enemy.getY()) > 0 && Math.abs(y - enemy.getY()) < 50)) {
//				if(enemy.isLive()) {
//					attack();
//					break;
//				}
//			}

			// 10보다 작다면
			if ((Math.abs(x - enemy.getX()) < 10)
					&& (Math.abs(y - enemy.getY()) > 0 && Math.abs(y - enemy.getY()) < 50)) {
				if (enemy.isLive()) {
					attack();
					break;
				}
			}

			threadSleep(1);
		}
		up();
	}

	@Override
	public void right() {
		right = true;
		for (int i = 0; i < 250; i++) {
			x++;
			setLocation(x, y);
			if (bubbleObserver.checkRightWall()) {
				right = false;
				break;
			}

			// 0 - 50 = -50 ok 50
			// 0 - 55 = -55 ok 55
			// 0 - 60 = -60 ok 60

			// 10보다 작다면
			if ((Math.abs(x - enemy.getX()) < 10)
					&& (Math.abs(y - enemy.getY()) > 0 && Math.abs(y - enemy.getY()) < 50)) {
				if (enemy.isLive()) {
					attack();
					break;
				}
			}
			threadSleep(2);
		}
		up();
	}

	@Override
	public void up() {
		up = true;
		while (up) {
			y--;
			setLocation(x, y);
			if (bubbleObserver.checkTopWall()) {
				up = false;
				break;
			}

			if (state == 0) {
				try {
					Thread.sleep(2);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else {
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		if(state == 0) {
			removeBubble();
		}
	}

	private void attack() {
		state = 1;
		enemy.setLive(false);
		setIcon(bubbled);
		mContext.remove(enemy);
		mContext.repaint();
		// repaint 하더라도 가비지 컬럭터가 즉시 발생 되지 않음
		// 적군한테 상태값을 주자

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
	
	public void removeBubbled() {
		try {
			up = false; 
			setIcon(bomb);
			Thread.sleep(1000);
			// 2 단계
			setIcon(null);
			bubbleContext = null;
		} catch (Exception e) {
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
