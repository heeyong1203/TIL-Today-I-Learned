package com.sinse.mall.model.notice;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sinse.mall.domain.Notice;
import com.sinse.mall.exception.NoticeException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class HibernateNoticeDAO implements NoticeDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List SelectAll() {
		Session session=sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Notice", Notice.class);
		return query.getResultList();
	}

	@Override
	public Notice select(int notice_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Notice notice) throws NoticeException{
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(notice);
		} catch (Exception e) {
			e.printStackTrace(); //개발자를 위한 로그 출력
			log.error("등록 실패", e.getMessage(), e); //개발자를 위한 로그 출력
			throw new NoticeException("등록 실패", e); //유저를 위한 예외 설정
		}
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
