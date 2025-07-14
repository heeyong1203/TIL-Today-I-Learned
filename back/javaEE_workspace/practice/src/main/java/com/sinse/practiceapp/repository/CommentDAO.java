package com.sinse.practiceapp.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.sinse.practiceapp.exception.CommentException;
import com.sinse.practiceapp.model.Comment;
import com.sinse.practiceapp.model.PracticeNotice;
import com.sinse.practiceapp.mybatis.MybatisConfig;

public class CommentDAO {
	MybatisConfig config = MybatisConfig.getInstance();
	
	public List<Comment> selectByNoticeId(int notice_id){
		SqlSession sqlSession = config.getSqlSession();
		List<Comment> list = sqlSession.selectList("Comment.selectByNoticeId", notice_id);
		sqlSession.close();
		
		return list;
	}
	
	public void insert(PracticeNotice notice) throws CommentException {
		SqlSession sqlSession = config.getSqlSession();
		int result = sqlSession.insert("Comment.insert", notice);
		if(result<1) {
			throw new CommentException("등록 실패");
		}
		sqlSession.commit();
		sqlSession.close();
	}
}
