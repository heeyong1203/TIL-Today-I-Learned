package com.sinse.mall.model.member;

import com.sinse.mall.domain.Member;

public interface MemberDAO {
	public Member selectById(String id);
	public void insert(Member member);
}
