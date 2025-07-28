package com.sinse.mall.model.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinse.mall.domain.Member;
import com.sinse.mall.exception.MemberException;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private MemberDAO memberDAO;
	
	@Override
	public Member selectById(String id) throws MemberException {
		return memberDAO.selectById(id);
	}
	
	@Override
	public void regist(Member member) {
		memberDAO.insert(member);
		
		//이메일 발송
		
	}
}
