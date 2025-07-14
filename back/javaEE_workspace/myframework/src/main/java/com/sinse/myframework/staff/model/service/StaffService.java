package com.sinse.myframework.staff.model.service;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sinse.myframework.mybatis.MybatisConfig;
import com.sinse.myframework.staff.model.domain.Bio;
import com.sinse.myframework.staff.model.repository.BioDAO;
import com.sinse.myframework.staff.model.repository.StaffDAO;

//컨트롤러와 모델 영역 경계의 모호성을 해결하고자 나타난 개념 서비스 객체
//모델 파트의 업무를 추상화(단순화)하여 컨트롤러가 간단히 업무를 요청하게 하는 기능
public class StaffService {
	private Logger logger = LoggerFactory.getLogger(getClass());
	//두 개의 DAO를 트랜잭션으로 묶기 위하여 SqlSession을 공유한다.
	private MybatisConfig config = MybatisConfig.getInstance();
	
	//CRUD
	public void regist(Bio bio) {
		//두 개의 업무를 여기서 수행
		SqlSession sqlSession = config.getSqlSession();
		
		StaffDAO staffDAO = new StaffDAO();
		BioDAO bioDAO = new BioDAO();
		
		try {
			logger.debug("사원 등록 전의 staff_id= " + bio.getStaff().getStaff_id());
			staffDAO.insert(sqlSession, bio.getStaff()); //일 시키기
			
			logger.debug("사원 등록 후의 staff_id= " + bio.getStaff().getStaff_id());
			bioDAO.insert(sqlSession, bio);
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
		} finally {
			sqlSession.close();
		}
	}
}
