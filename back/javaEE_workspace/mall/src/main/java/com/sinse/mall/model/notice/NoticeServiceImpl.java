package com.sinse.mall.model.notice;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinse.mall.domain.Notice;
import com.sinse.mall.exception.NoticeException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class NoticeServiceImpl implements NoticeService{
	
	//@Qualifier("mybatisNoticeDAO") //스프링 컨테이너가 보유한 여러 인스턴스 중 원하는 아이디를 넣어야 함
	@Qualifier("hibernateNoticeDAO")
	@Autowired
	private NoticeDAO noticeDAO;
	
	/*@Autowired
	private SqlSessionTemplate sqlSessionTemplate;*/
	
	@Transactional
	public List selectAll() {
		log.debug("service의 selectAll() 도달");
		return noticeDAO.SelectAll(); //DAO의 메서드 호출
		// return sqlSessionTemplate.selectList("Notice.selectAll");
	}

	@Override
	public Notice select(int notice_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	public void regist(Notice notice) throws NoticeException {
		log.debug("service의 regist() 도달");
		noticeDAO.insert(notice);		
	}

	@Override
	public void update(Notice notice) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int notice_id) {
		// TODO Auto-generated method stub
		
	}

}
