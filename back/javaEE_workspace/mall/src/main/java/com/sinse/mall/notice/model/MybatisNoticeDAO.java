package com.sinse.mall.notice.model;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sinse.mall.domain.Notice;
import com.sinse.mall.exception.NoticeException;

import lombok.extern.slf4j.Slf4j;

//애플리케이션 설계분야에서 CRUD를 담당하는 DAO를 가리켜 repository라고 한다.
//EnableWebMVC annotation에 의해 @Controller, @Repsitory, @Service, @Component 등
//인스턴스가 생성되며 싱글톤으로 관리된다.
@Slf4j
@Repository
public class MybatisNoticeDAO implements NoticeDAO{
	
	//스프링 컨테이너로부터 자동으로 주입 받겠다
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public List SelectAll() {
		log.debug("DAO의 selectAll() 도달");
		return sqlSessionTemplate.selectList("Notice.selectAll");
	}

	@Override
	public Notice select(int notice_id) {
		return sqlSessionTemplate.selectOne("Notice.select", notice_id);
	}

	@Override
	public void insert(Notice notice) throws NoticeException {
		log.debug("DAO의 insert 도달");
		int result = sqlSessionTemplate.insert("Notice.insert", notice);
		if(result<1) {
			log.error("글 등록 실패");
			throw new NoticeException("글 등록 실패");
		}
	}

	@Override
	public void update(Notice notice) {
		// TODO 
		
	}

	@Override
	public void delete(int notice_id) {
		// TODO 
		
	}

}
