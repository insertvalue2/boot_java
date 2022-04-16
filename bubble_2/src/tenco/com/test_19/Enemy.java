package tenco.com.test_19;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import lombok.Getter;
import lombok.Setter;
import tenco.com.test_13.PlayerWay;

// mContext 사용 밥버 
// class Player -> new 가능한 애들!! 게임에 존재할 수 있음. (추상메서드를 가질 수 없다.)
@Getter
@Setter
public class Enemy extends JLabel implements Moveable {
	
	private BubbleFrame mContext; 
	
	// 위치 상태
	private int x;
	private int y;

	// 움직임 상태
	private boolean left;
	private boolean right;
	private boolean up;
	private boolean down;
	
	private boolean isLive; // 0(생존), 1(물방울 갇힌 상태)
	
	// 적군에 방향 
	private EnemyWay enemyWay;
	
	
	// 벽에 충돌한 상태
	private boolean leftWallCrash;
	private boolean rightWallCrash;

	// 플레이어 속도 상태
	private final int SPEED = 5;
	private final int JUMPSPEED = 1; // up, down

	private ImageIcon enemyR, enemyL;

	public Enemy(BubbleFrame mContext) {
		this.mContext = mContext;
		initObject();
		initSetting();
		initBackgroundEnemyService();
	}

	private void initBackgroundEnemyService() {
//		new Thread(new BackgroundEnemyService(this)).start();
	}

	private void initObject() {
		enemyR = new ImageIcon("image/eneumyR.png");
		enemyL = new ImageIcon("image/enemyL.png");
	}

	private void initSetting() {
		x = 500;
		y = 180;
		isLive = true; 
		
		left = false;
		right = false;
		up = false;
		down = false;
		
		enemyWay = EnemyWay.LEFT;
		
		leftWallCrash = false; 
		rightWallCrash = false; 

		setIcon(enemyL);
		setSize(50, 50);
		
		setLocation(x, y);
	}

	// 이벤트 핸들러
	@Override
	public void left() {
		enemyWay = EnemyWay.LEFT;
		left = true;
		new Thread(() -> {
			while (left) {
				setIcon(enemyL);
				x = x - SPEED;
				setLocation(x, y);
				try {
					Thread.sleep(10); // 0.01초
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();

	}

	@Override
	public void right() {
		enemyWay = EnemyWay.RIGHT;
		right = true;
		new Thread(() -> {
			while (right) {
				setIcon(enemyR);
				x = x + SPEED;
				setLocation(x, y);
				try {
					Thread.sleep(10); // 0.01초
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();

	}

	@Override
	public void up() {
		up = true;
		new Thread(() -> {
			for (int i = 0; i < 130 / JUMPSPEED; i++) {
				y = y - JUMPSPEED;
				setLocation(x, y);
				try {
					Thread.sleep(5);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			up = false;
			down();

		}).start();
	}

	@Override
	public void down() {
		down = true;
		new Thread(() -> {
			while(down) {
				y = y + JUMPSPEED;
				setLocation(x, y);
				try {
					Thread.sleep(3);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			down = false;
		}).start();
	}
}
