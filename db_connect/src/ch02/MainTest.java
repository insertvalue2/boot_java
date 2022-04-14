package ch02;

import java.util.ArrayList;

public class MainTest {

	public static void main(String[] args) {
		
	MemberInfoSqlDao infoSqlDao = new MemberInfoSqlDao();
		
		// 데이터 조회 
		ArrayList<MemberDto> data = infoSqlDao.select("");
		for (MemberDto memberDto : data) {
			System.out.println(memberDto);
		}
	
		
		// 데이터 추가 
		MemberDto dto1 = new MemberDto("test1", "티모", "붉은 언덕"); 
		infoSqlDao.insert(dto1);

		// 데이터 수정 (memberName 만 변경, 조건 memberId) 
		MemberDto dto2 = new MemberDto("test1", "티모변경", "붉은 언덕");
		int resultCount = infoSqlDao.update(dto2);
		System.out.println("resultCount : " + resultCount);
		
		
		System.out.println("-----------------------------");
		ArrayList<MemberDto> data2 = infoSqlDao.select("test1");
		for (MemberDto memberDto : data2) {
			System.out.println(memberDto);
		}
		System.out.println("-----------------------------");
		
		// 데이터 삭제 
		infoSqlDao.delete("test1");
		
		
		System.out.println("-----------------------------");
		ArrayList<MemberDto> data3 = infoSqlDao.select("test1");
		for (MemberDto memberDto : data) {
			System.out.println(memberDto);
		}
	}

}
