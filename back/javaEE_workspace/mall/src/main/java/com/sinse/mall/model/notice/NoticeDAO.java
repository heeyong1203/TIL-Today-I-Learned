package com.sinse.mall.model.notice;

import java.util.List;

import com.sinse.mall.domain.Notice;

/*
	MybatisNoticeDAO든, HibernateNoticeDAO든, JdbcNoticeDAO든 상관없는 
	Notice를 대상으로 한 DAO들의 최상위 DAO 정의
*/
public interface NoticeDAO {
	public List SelectAll();
	public Notice select(int notice_id);
	public void insert(Notice notice);
	public void update(Notice notice);
	public void delete(int notice_id);
}
