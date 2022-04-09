package tenco.com.test_15;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import lombok.Getter;
import lombok.Setter;
import tenco.com.test_13.PlayerWay;

@Getter
@Setter
public class Bubble extends JLabel implements Moveable {
	// 1단계 
	private BubbleFrame mContext;
	// 2단계 
	private Bubble bubbleContext;
	// 의존성 관리
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
		
	public Bubble(BubbleFrame mContext) {
		this.mContext = mContext;
		// player null point (다시 수정 해정)
		
		this.player = mContext.player;
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
				// for 문을 멈춤 
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
				// 상태값은 나중에 어떻게 사용될지 모르기 때문에 처리
				up = false;  
				break; // break 사용하는게 좀 더 좋다! 
			}
			threadSleep(1);
		}
		removeBubble(); // 천창 도착 2초후에 제거 
	}
	
	// 다른 곳에서 호출할 일이 없기 때문에 private 
	private void removeBubble() {
		try {
			Thread.sleep(2000);
			setIcon(bomb);
			Thread.sleep(1000);
			// 버블은 프레임에서 사라져야 한다..
			// 버블 프레임에 다시한번더 그려져야 한다 !!!
			// 버블 프레임에 정보를 가지고 있어야 한다.
		
			mContext.remove(this);
			mContext.repaint(); // 도화지에 그림을 다시 그림 (메모리에 있는)
			// 패키지 복사 후 다시 설명 
			
			// 2 단계 
			// this = null; <<-- 불가 
//			setIcon(null);
//			bubbleContext = null; 
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
