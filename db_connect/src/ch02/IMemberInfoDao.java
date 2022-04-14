package ch02;

import java.util.ArrayList;

public interface IMemberInfoDao {
	ArrayList<MemberDto> select(String memberId);
	void insert(MemberDto dto); 
	int update(MemberDto dto);
	void delete(String memberId);
}
