package com.sinse.memberapp.mybatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

// Mybatis-config.xml을 읽어들여, 개발 시 쿼리문 수행 객체인 SqlSession을 SqlSessionFactory로부터 얻게 해주는 유틸 클래스
// Mybatis는 내부적으로 JDBC 사용, 하지만 개발자가 상투적인 JDBC 코드를 일일이 작성하지 않게 코드를 숨기고 대신 SqlSession을 통해 쿼리를 수행할 수 있도록 해줌
public class MybatisConfig {
	private static MybatisConfig instance;
	private SqlSessionFactory sqlSessionFactory;
	
	private MybatisConfig() {
		String resource = "com/sinse/memberapp/mybatis/mybatis-config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static MybatisConfig getInstance() {
		if(instance == null) {
			instance = new MybatisConfig();
		}
		return instance;
	}
	
	public SqlSession getSqlSession() {
		return sqlSessionFactory.openSession();
	}
}
