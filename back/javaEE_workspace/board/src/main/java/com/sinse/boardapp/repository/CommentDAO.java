package com.sinse.boardapp.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.sinse.boardapp.exception.CommentException;
import com.sinse.boardapp.model.Comment;
import com.sinse.boardapp.mybatis.MybatisConfig;

public class CommentDAO {
	MybatisConfig config = MybatisConfig.getInstance();
	
	// 모두 선택
	public List<Comment> selectAll() {
		SqlSession sqlSession = config.getSqlSession();
		List<Comment> list = sqlSession.selectList("Comment.selectAll");
		sqlSession.close();
		
		return list;
	}
	
	// 해당 뉴스 기사의 댓글 모두 가져오기
	public List<Comment> selectByNewsId(int news_id) {
		SqlSession sqlSession = config.getSqlSession();
		List<Comment> list = sqlSession.selectList("Comment.selectByNewsId", news_id);
		sqlSession.close();
		
		return list;
	}
	
	// 한 건 선택
	public Comment select(int comment_id) {
		SqlSession sqlSession = config.getSqlSession();
		Comment comment = sqlSession.selectOne("Comment.select", comment_id);
		return comment;
	}
	
	// 한 건 입력
	public void insert(Comment comment) throws CommentException {
		SqlSession sqlSession = config.getSqlSession();
		int result = sqlSession.insert("Comment.insert", comment);
		if(result<1) {
			throw new CommentException("등록 실패");
		}
		
		sqlSession.commit();
		sqlSession.close();
	}
	
	// 한 건 수정
	public void update(Comment comment) {
		
	}
	
	// 한 건 삭제
	public void delete(int comment_id) {
		
	}
}
