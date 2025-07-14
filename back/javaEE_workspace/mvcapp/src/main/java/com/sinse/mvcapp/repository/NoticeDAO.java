package com.sinse.mvcapp.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.sinse.boardapp.exception.NoticeException;
import com.sinse.mvcapp.model.Notice;
import com.sinse.mvcapp.mybatis.MybatisConfig;


// CRUD
public class NoticeDAO {
	
	 MybatisConfig config = MybatisConfig.getInstance();
	 
	// 모든 레코드 가져오기
	public List<Notice> selectAll() {
		SqlSession sqlSession = config.getSqlSession();
		List<Notice> list = sqlSession.selectList("Notice.selectAll");
		sqlSession.close();
		return list;
	}
	
	// 레코드 한 건 가져오기
	public Notice select(int notice_id) {
		SqlSession sqlSession = config.getSqlSession();
		Notice notice = sqlSession.selectOne("Notice.select", notice_id);
		sqlSession.close();
		return notice;
	}
	
	// 레코드 한 건 넣기
	public void insert(Notice notice) throws NoticeException {
		SqlSession sqlSession = config.getSqlSession();
		// sqlSession.insert("일 시킬 xml 아이디", "파라미터를 받을 모델");
		int result = sqlSession.insert("Notice.insert", notice);
		sqlSession.commit(); // DML의 트랜잭션 확정
		sqlSession.close();
		
		if(result<1) {
			throw new NoticeException("등록 실패");
		}
	}
	
	// 수정하기
	public void update(Notice notice) throws NoticeException {
		SqlSession sqlSession = config.getSqlSession();
		int result = sqlSession.update("Notice.update", notice);
		sqlSession.commit();
		sqlSession.close();
		
		if(result<1) {
			throw new NoticeException("수정 실패");
		}
	}
	
	// 삭제하기
	public void delete(int notice_id) throws NoticeException {
		SqlSession sqlSession = config.getSqlSession();
		int result = sqlSession.delete("Notice.delete", notice_id);
		sqlSession.commit(); // DML의 트랜잭션 확정
		sqlSession.close();
		
		if(result<1) {
			throw new NoticeException("삭제 실패");
		}
	}
}
