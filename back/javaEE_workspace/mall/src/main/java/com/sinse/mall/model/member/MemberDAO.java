package com.sinse.mall.model.member;

import com.sinse.mall.domain.Member;

public interface MemberDAO {
	public Member checkDuplicate(String id);
	public void insert(Member member);
}
