package com.sinse.mall.notice.model;

import java.util.List;

import com.sinse.mall.domain.Notice;

public interface NoticeService {
	
	public List selectAll();
	public Notice select(int notice_id);
	
	//두 개 이상의 DAO를 대상으로 업무 시 insert보다 상위개념인 등록을 표현하는 메서드명으로 가는게 좋다.
	public void regist(Notice notice);
	
	public void update(Notice notice);
	public void delete(int notice_id);
}
