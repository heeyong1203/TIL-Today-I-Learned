package com.sinse.myframework.staff.model.repository;

import org.apache.ibatis.session.SqlSession;

import com.sinse.myframework.exception.BioException;
import com.sinse.myframework.staff.model.domain.Bio;

public class BioDAO {

	public void insert(SqlSession sqlSession, Bio bio) throws BioException {
		int result = sqlSession.insert("Bio.insert", bio);
		if(result<1) {
			throw new BioException("개인 신체 정보 등록 실패");
		}
	}
}
