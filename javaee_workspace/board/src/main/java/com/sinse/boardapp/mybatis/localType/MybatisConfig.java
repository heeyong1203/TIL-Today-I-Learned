package com.sinse.boardapp.mybatis.localType;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/* Mybatis의 설정 파일인 xml을 읽어들여, 필요한 객체를 만들기 */
public class MybatisConfig {
	
	public MybatisConfig() {
		// 자바의 패키지라고 할 지라도, 대상 파일이 java가 아니면, 일반 디렉토리 취급하자.
		String resource = "com/sinse/boardapp/mybatis/mybatis-config.xml"; 
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
