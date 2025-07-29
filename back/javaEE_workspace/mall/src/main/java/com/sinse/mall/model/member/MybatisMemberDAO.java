package com.sinse.mall.model.member;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sinse.mall.domain.Member;
import com.sinse.mall.exception.MemberException;
import com.sinse.mall.exception.MemberNotFoundException;

@Repository
public class MybatisMemberDAO implements MemberDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public Member selectById(String id){
		return sqlSessionTemplate.selectOne("Member.selectById", id);
	}
	
	@Override
	public void insert(Member member) throws MemberException {
		int result = sqlSessionTemplate.insert("Member.insert", member);
		if(result<1) {
			throw new MemberException("회원 등록 실패");
		}
	}
	
	@Override
	public Member selectByEmail(String email) throws MemberException {
		Member member = sqlSessionTemplate.selectOne("Member.selectByEmail", email);
		if(member==null) {
			throw new MemberException("입력하신 정보와 일치하는 회원이 없습니다.");
		}
		return member;
	}
	
	@Override
	public Member login(Member member) throws MemberNotFoundException {
		Member logginedMember = sqlSessionTemplate.selectOne("Member.login",member);
		if(logginedMember==null) {
			throw new MemberNotFoundException("로그인 정보가 올바르지 않습니다.");
		}
		return logginedMember;
	}
}
