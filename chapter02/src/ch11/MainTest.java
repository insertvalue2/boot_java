package ch11;

import java.util.Iterator;
import java.util.Scanner;

public class MainTest {

	public static void main(String[] args) {

		Zealot zealot = new Zealot("질럿");
		Marine marine = new Marine("마린");
		Zergling zergling = new Zergling("저글링");
		boolean flag = true;
		Scanner sc = new Scanner(System.in);

		while (flag) {

			System.out.println("캐릭터를 선택해주세요.\n " + "1. 질럿\t" + "2. 마린\t" + "3. 저글링\t" + "4. 게임 종료");
			int select = sc.nextInt();
			if (select == 1) {
				zealot.showInfo();

				System.out.println("무엇을 공격하겠습니까?\n" + "1. 마린\t" + "2. 저글링\t");
				int attackNum = sc.nextInt();
				if (attackNum == 1) {
					System.out.println("몇 번 공격하시겠습니까?");
					int attackNum2 = sc.nextInt();
					for (int i = 0; i < attackNum2; i++) {
						String temp = ">";
						for (int a = 0; a < 8; a++) {
							System.out.print(temp);
							try {
								Thread.sleep(50);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						zealot.attackMarine(marine);
					}

					marine.showInfo();
				} else if (attackNum == 2) {
					System.out.println("몇 번 공격하시겠습니까?");
					int attackNum2 = sc.nextInt();
					for (int i = 0; i < attackNum2; i++) {
						String temp = ">";
						for (int a = 0; a < 8; a++) {
							System.out.print(temp);
							try {
								Thread.sleep(50);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						zealot.attackZergling(zergling);
					}
					zergling.showInfo();
				} else {
					System.out.println("잘못 입력하셨습니다.");
				}

			} else if (select == 2) {
				marine.showInfo();
				System.out.println("무엇을 공격하겠습니까?\n" + "1. 질럿\t" + "2. 저글링\t");
				int attackNum = sc.nextInt();
				if (attackNum == 1) {
					System.out.println("몇 번 공격하시겠습니까?");
					int attackNum2 = sc.nextInt();
					for (int i = 0; i < attackNum2; i++) {
						String temp = ">";
						for (int a = 0; a < 8; a++) {
							System.out.print(temp);
							try {
								Thread.sleep(50);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						marine.attackZealot(zealot);
					}
					zealot.showInfo();
				} else if (attackNum == 2) {
					System.out.println("몇 번 공격하시겠습니까?");
					int attackNum2 = sc.nextInt();
					for (int i = 0; i < attackNum2; i++) {
						String temp = ">";
						for (int a = 0; a < 8; a++) {
							System.out.print(temp);
							try {
								Thread.sleep(50);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						marine.attackZergling(zergling);
					}
					zergling.showInfo();
				} else {
					System.out.println("잘못 입력하셨습니다.");
				}
			} else if (select == 3) {
				zergling.showInfo();
				System.out.println("무엇을 공격하겠습니까?\n" + "1. 질럿\t" + "2. 마린\t");
				int attackNum = sc.nextInt();
				if (attackNum == 1) {
					System.out.println("몇 번 공격하시겠습니까?");
					int attackNum2 = sc.nextInt();
					for (int i = 0; i < attackNum2; i++) {
						String temp = ">";
						for (int a = 0; a < 8; a++) {
							System.out.print(temp);
							try {
								Thread.sleep(50);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						zergling.attackZealot(zealot);
					}
					zealot.showInfo();
				} else if (attackNum == 2) {
					System.out.println("몇 번 공격하시겠습니까?");
					int attackNum2 = sc.nextInt();
					for (int i = 0; i < attackNum2; i++) {
						String temp = ">";
						for (int a = 0; a < 8; a++) {
							System.out.print(temp);
							try {
								Thread.sleep(50);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						zergling.attackMarine(marine);
					}
					marine.showInfo();
				} else {
					System.out.println("잘못 입력하셨습니다.");
				}
			} else if (select == 4) {
				System.out.println("게임을 종료합니다.");
				flag = false;
				break;
			} else {
				System.out.println("잘못 입력하셨습니다.");

			}
		}
	}
}
