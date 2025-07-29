package com.sinse.mall.domain;

import lombok.Data;

@Data
public class Member {
	private int member_id;
	private SnsProvider snsProvider;
	private String id; 							//sns의 id가 비록 숫자이지만, 홈페이지 회원의 경우는 문자열이다.
	private String password;
	private String salt;							//비밀번호를 왜곡시켜 사용자의 실제 비밀번호를 저장하지 않기 위함
	private String name; 						//홈페이지 회원은 실명일 수 있지만, sns회원은 가명일 가능성이 크다.
	private String email;						//sns 업체 정책에 따라 이메일 제공이 없을 수 있다. 따라서 null이 가능하다.
	private String date;
}
