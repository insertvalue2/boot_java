package ch05_1;

import java.util.Scanner;

public class UserInfoScanner {
	Scanner scanner; 
	
	public UserInfoScanner() {
		this.scanner = new Scanner(System.in);
	}
	
	public UserInfo inputUserData() {
		System.out.println("사용자 이름을 이력해주세요");
		String name =  scanner.nextLine();
		System.out.println("사용자 아이디를 이력해주세요");
		String id = scanner.nextLine();
		
		return new UserInfo(name, id); 
	}
}
