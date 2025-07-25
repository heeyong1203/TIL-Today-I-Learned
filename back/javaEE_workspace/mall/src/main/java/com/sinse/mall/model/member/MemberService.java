package com.sinse.mall.model.member;

import com.sinse.mall.domain.Member;

public interface MemberService {
	public Member checkDuplicate(String id);
	public void regist(Member member);
}
