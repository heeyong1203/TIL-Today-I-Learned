package com.sinse.practiceapp.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.sinse.practiceapp.exception.PracticeNoticeException;
import com.sinse.practiceapp.model.PracticeNotice;
import com.sinse.practiceapp.mybatis.MybatisConfig;

// CRUD
public class PracticeNoticeDAO {
	MybatisConfig config = MybatisConfig.getInstance();
	
	// 모든 레코드 가져오기
	public List<PracticeNotice> selectAll() {
		SqlSession sqlSession = config.getSqlSession();
		List<PracticeNotice> list = sqlSession.selectList("Notice.selectAll");
		sqlSession.close();
		return list;
	}
	
	// 하나만 조회하기
	public PracticeNotice select(int notice_id) {
		SqlSession sqlSession = config.getSqlSession();
		PracticeNotice notice = sqlSession.selectOne("Notice.select", notice_id);
		sqlSession.close();
		return notice;
	}
	
	// 데이터 추가하기
	public void insert(PracticeNotice notice) throws PracticeNoticeException {
		SqlSession sqlSession = config.getSqlSession();
		int result = sqlSession.insert("Notice.insert", notice);
		sqlSession.commit();
		sqlSession.close();
		
		if(result<1) {
			throw new PracticeNoticeException("등록 실패");
		}
	}
	
	// 데이터 수정하기
	public void update(PracticeNotice notice) throws PracticeNoticeException {
		SqlSession sqlSession = config.getSqlSession();
		int result = sqlSession.update("Notice.update", notice);
		sqlSession.commit();
		sqlSession.close();
		
		if(result<1) {
			throw new PracticeNoticeException("수정 실패");
		}
	}
	
	// 데이터 삭제하기
	public void delete(int notice_id) throws PracticeNoticeException {
		SqlSession sqlSession = config.getSqlSession();
		int result = sqlSession.delete("Notice.delete", notice_id);
		sqlSession.commit();
		sqlSession.close();
		
		if(result<1) {
			throw new PracticeNoticeException("삭제 실패");
		}
	}
	
	// 레코드 수 반환하기
	public int selectCount() throws PracticeNoticeException{
		SqlSession sqlSession = config.getSqlSession();
		int count = sqlSession.selectOne("Notice.selectCount");
		sqlSession.close();
		return count;
	}
	
}
