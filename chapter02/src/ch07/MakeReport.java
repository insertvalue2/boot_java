package ch07;

import java.util.Scanner;

public class MakeReport {
	
	private Scanner sc; 
	String c = null; 
	
	private String str = ""; 
	private String line = "=========================\n"; 
	private String title = "이름\t        주소 \t\t   전화번호\n"; 
	
	// hint --> 객체가 메모리 올라 갈때 생성자 !! 
	public MakeReport() {
		// 필요값이 있으면 초기화 한다
		// 이스케이프 문자(제어문자) 
		// 인쇄할 수 없거나 키보드로 표현할 수 없는 특별한 문자를 가리킨다.
		// 역슬래시와(\) 한개의 문자와 결합하여 사용한다. 
	}
	
	private void makeHeader() {
		str +=  line; 
		str += title; 
		str += line; 
	}
	
	private void generateBody() {
		
		str += "홍길동\t";
		str += "서울 \t";
		str += "010-1234-1234\n";
		
		
		
	}
	
	private void makeFooter() {
		str += line; 
	}
	
	public String getReport() {
		makeHeader();
		generateBody();
		makeFooter();
		return this.str;
	}
	
}




