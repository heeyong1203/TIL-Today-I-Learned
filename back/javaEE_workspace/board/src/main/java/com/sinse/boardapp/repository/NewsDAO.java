package com.sinse.boardapp.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.sinse.boardapp.exception.NewsException;
import com.sinse.boardapp.model.News;
import com.sinse.boardapp.mybatis.MybatisConfig;

// DAO의 존재는 그대로 유지하되, DAO의 CRUD 메서드 안에 상투적 jdbc 코드를 작성하지 않는다.
// Mybatis 프레임워크(SQL Mapper)와 Hibernate 프레임워크(Object Relation Mapping) 등을 이용하기 때문이다.
public class NewsDAO {
	MybatisConfig config = MybatisConfig.getInstance();
	
	// 모두 선택
	public List<News> selectAll() {
		SqlSession sqlSession = config.getSqlSession();
		List<News> list = sqlSession.selectList("News.selectAll");
		sqlSession.close();
		
		return list;
	}
	
	// 한 건 선택
	public News select(int news_id) {
		SqlSession sqlSession = config.getSqlSession();
		News news = sqlSession.selectOne("News.select", news_id);
		sqlSession.close();		
				
		return news;
	}
	
	// 한 건 입력
	public void insert(News news) throws NewsException {
		SqlSession sqlSession = config.getSqlSession();
		int result = sqlSession.insert("News.insert", news);
		if(result<1) {
			throw new NewsException("등록 실패");
		}
		
		sqlSession.commit();
		sqlSession.close();
	}
	
	// 한 건 수정
	public void update(News news) {
		
	}
	
	// 한 건 삭제
	public void delete(int news_id) {
		
	}
}
