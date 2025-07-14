package com.sinse.myframework.staff.model.repository;

import org.apache.ibatis.session.SqlSession;

import com.sinse.myframework.exception.StaffException;
import com.sinse.myframework.staff.model.domain.Staff;

public class StaffDAO {
	
	public void insert(SqlSession sqlSession, Staff staff) throws StaffException {
		int result = sqlSession.insert("Staff.insert", staff);
		
		if(result<1) {
			throw new StaffException("스탭 등록 실패");
		}
	}
}
