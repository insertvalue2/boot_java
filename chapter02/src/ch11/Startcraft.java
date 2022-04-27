package ch11;

import java.util.Scanner;

public class Startcraft {

	public static void main(String[] args) {

		Zealot zealot1 = new Zealot("질럿1");
		Marine marine1 = new Marine("마린1");
		Zergling zergling1 = new Zergling("저글링1");

		Scanner scanner = new Scanner(System.in);

		// 1. 유닛 선택 (유닛을 선택하세요)
		System.out.println("유닛을 선택하세요.");
		System.out.println("1. 질럿\t2. 마린\t3. 저글링");
		int unitChoice = scanner.nextInt();
		if (unitChoice == 1) {
			zealot1.showInfo();
			// 2. 공격할 유닛 선택
			System.out.println("어떤 유닛을 공격하시겠습니까?");
			System.out.println("1. 마린\t2. 저글링");
			int attackChoice = scanner.nextInt();
			if (attackChoice == 1) {
				// 3. 공격횟수 선택
				System.out.println("몇 번 공격하시겠습니까?");
				int attackCount = scanner.nextInt();
				for (int i = 0; i < attackCount; i++) {
					String temp = ">";
					for (int count = 0; count < 3; count++) {
						// zealot1.attackMarrine(marine1);
						System.out.print(temp);
						try {
							Thread.sleep(300);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					zealot1.attackMarine(marine1);
				}
				marine1.showInfo();
				zealot1.showInfo();
			} else if (attackChoice == 2) {
				// 3. 공격횟수 선택
				System.out.println("몇 번 공격하시겠습니까?");
				int attackCount = scanner.nextInt();
				for (int i = 0; i < attackCount; i++) {
					String temp = ">";
					for (int count = 0; count < 3; count++) {
						// zealot1.attackMarrine(marine1);
						System.out.print(temp);
						try {
							Thread.sleep(300);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					zealot1.attackZergling(zergling1);
				}
				zergling1.showInfo();
				zealot1.showInfo();
			} else {
				System.out.println("잘못된 입력입니다");
			}

		} else if (unitChoice == 2) {
			marine1.showInfo();
			// 2. 공격할 유닛 선택
			System.out.println("어떤 유닛을 공격하시겠습니까?");
			System.out.println("1. 질럿\t2. 저글링");
			int choiceNum2 = scanner.nextInt();
			if (choiceNum2 == 1) {
				// 3. 공격횟수 선택
				System.out.println("몇 번 공격하시겠습니까?");
				int attackCount = scanner.nextInt();
				for (int i = 0; i < attackCount; i++) {
					String temp = ">";
					for (int count = 0; count < 3; count++) {
						// zealot1.attackMarrine(marine1);
						System.out.print(temp);
						try {
							Thread.sleep(20);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					marine1.attackZealot(zealot1);
				}
				zealot1.showInfo();
				marine1.showInfo();
			} else if (choiceNum2 == 2) {
				// 3. 공격횟수 선택
				System.out.println("몇 번 공격하시겠습니까?");
				int attackCount = scanner.nextInt();
				for (int i = 0; i < attackCount; i++) {
					String temp = ">";
					for (int count = 0; count < 3; count++) {
						// zealot1.attackMarrine(marine1);
						System.out.print(temp);
						try {
							Thread.sleep(20);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					marine1.attackZergling(zergling1);
				}
				zergling1.showInfo();
				marine1.showInfo();
			} else {
				System.out.println("잘못된 입력입니다");
			}
		} else if (unitChoice == 3) {
			zergling1.showInfo();
			// 2. 공격할 유닛 선택
			System.out.println("어떤 유닛을 공격하시겠습니까?");
			System.out.println("1. 질럿\t2. 마린");
			int choiceNum2 = scanner.nextInt();
			if (choiceNum2 == 1) {
				// 3. 공격횟수 선택
				System.out.println("몇 번 공격하시겠습니까?");
				int attackCount = scanner.nextInt();
				for (int i = 0; i < attackCount; i++) {
					String temp = ">";
					for (int count = 0; count < 3; count++) {
						// zealot1.attackMarrine(marine1);
						System.out.print(temp);
						try {
							Thread.sleep(20);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					zergling1.attackZealot(zealot1);
				}
				zealot1.showInfo();
				zergling1.showInfo();
			} else if (choiceNum2 == 2) {
				// 3. 공격횟수 선택
				System.out.println("몇 번 공격하시겠습니까?");
				int attackCount = scanner.nextInt();
				for (int i = 0; i < attackCount; i++) {
					String temp = ">";
					for (int count = 0; count < 3; count++) {
						// zealot1.attackMarrine(marine1);
						System.out.print(temp);
						try {
							Thread.sleep(20);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					zergling1.attackMarine(marine1);
				}
				marine1.showInfo();
				zergling1.showInfo();
			} else {
				System.out.println("잘못된 입력입니다");
			}
		} else {
			System.out.println("잘못된 입력입니다.");
		}

	}

}
