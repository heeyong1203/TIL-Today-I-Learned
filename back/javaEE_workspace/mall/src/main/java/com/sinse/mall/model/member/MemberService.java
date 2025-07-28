package com.sinse.mall.model.member;

import com.sinse.mall.domain.Member;

public interface MemberService {
	public Member selectById(String id);
	public void regist(Member member);
}
