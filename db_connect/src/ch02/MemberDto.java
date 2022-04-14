package ch02;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;


@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class MemberDto {
	
	@NonNull
	private String memberId;
	@NonNull
	private String memberName;
	@NonNull
	private String memberAddress;
}
