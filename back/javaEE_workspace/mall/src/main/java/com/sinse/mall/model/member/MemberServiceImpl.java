package com.sinse.mall.model.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinse.mall.domain.Member;
import com.sinse.mall.exception.MemberException;
import com.sinse.mall.exception.MemberNotFoundException;
import com.sinse.mall.exception.PasswordEncryptException;
import com.sinse.mall.util.PasswordUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	PasswordUtil passwordUtil;
	
	@Autowired
	private MemberDAO memberDAO;
	
	@Override
	public Member selectById(String id) throws MemberException {
		return memberDAO.selectById(id);
	}
	
	@Override
	public void regist(Member member) throws PasswordEncryptException {
		log.debug("sns provider is "+member.getSnsProvider());

		if(member.getSnsProvider()==null) {
			//홈페이지 회원인 경우
			String salt = passwordUtil.generateSalt();
			
			//전송된 파라미터와 salt를 섞어 hash를 만들자
			String hashedPassword = passwordUtil.hashPassword(member.getPassword(), salt);
			
			//Member 모델에 덮어쓰기
			member.setSalt(salt);
			member.setPassword(hashedPassword);
		}
			memberDAO.insert(member);
			//이메일 발송
	}
	
	@Override
	public Member login(Member member) throws MemberException, MemberNotFoundException {
		//이메일을 이용하여 현재 로그인 시도 회원이 과거 가입 시 사용했던 salt를 조사한다.
		Member savedMember = memberDAO.selectByEmail(member.getEmail());
		
		log.debug("db에 저장된 salt는 " + savedMember.getSalt());
		log.debug("db에 저장된 salt와 파라미터로 전송된 비밀번호와의 조합 해시는 " + passwordUtil.hashPassword(member.getPassword(), savedMember.getSalt()));
		log.debug("db에 저장되어 있었던 비밀번호는 " + savedMember.getPassword());
		
		String newHash = passwordUtil.hashPassword(member.getPassword(), savedMember.getSalt());
		
		if(newHash.equals(savedMember.getPassword())==false) {
			throw new MemberNotFoundException("로그인 정보가 올바르지 않습니다");
		}
		return savedMember;
	}
}
	