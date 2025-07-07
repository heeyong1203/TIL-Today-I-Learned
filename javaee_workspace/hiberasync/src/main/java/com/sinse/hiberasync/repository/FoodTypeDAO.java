package com.sinse.hiberasync.repository;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sinse.hiberasync.exception.FoodTypeException;
import com.sinse.hiberasync.hibernate.HibernateConfig;
import com.sinse.hiberasync.model.FoodType;

public class FoodTypeDAO {
	HibernateConfig config = HibernateConfig.getInstance();
	
	// 모든 업종 유형 가져오기
	public List selectAll() throws FoodTypeException {
		Transaction tx = null;
		List list = null;
		
		/* java7부터 try~with-resource 문법이 지원 
		  	 자원을 사용한 후 finally 영역에서 닫는 중복코드를 단순화 시키기 위한 목적
		  	 즉 언어 차원에서 개발자가 해야할 close() 메서드 호출을 자동으로 해준다.
		  	 ※ 모든 close() 메서드 대상이 아닌, Closeable을 구현한 객체만이 대상이 된다.
		  	     개발자는 try~catch만 집중하면 된다.
		*/
		try(Session session = config.getSession()){
			
			tx=session.beginTransaction(); // 트랜잭션 실행
			// ORM은 직접 테이블에 접근하지 않는다. 
			// 따라서 아래의 문장이 마치 table을 접근하는 것처럼 보이나,
			// from 절에 대상이 되는 객체는 테이블이 아닌 클래스이다.
			TypedQuery<FoodType> query = session.createQuery("from FoodType", FoodType.class);
			list = query.getResultList();
			tx.commit();
			
		} catch(Exception e) {
			e.printStackTrace();
			if(tx!=null)tx.rollback();
			
			throw new FoodTypeException("데이터 조회 실패", e);
		}
		return list;
	}
}
