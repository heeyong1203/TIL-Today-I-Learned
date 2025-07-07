package com.sinse.hiberasync2.repository;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sinse.hiberasync.model.FoodType;
import com.sinse.hiberasync2.exception.FoodTypeException;
import com.sinse.hiberasync2.hibernate.HibernateConfig2;

public class FoodTypeDAO {
	HibernateConfig2 config = HibernateConfig2.getInstance();
	
	// 모든 업종 유형 가져오기
	public List selectAll() throws FoodTypeException {
		Transaction tx = null;
		List list = null;
		
		try(Session session = config.getSession()){
			tx = session.beginTransaction();
			TypedQuery query = session.createQuery("from FoodType", FoodType.class);
			list = query.getResultList();
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if(tx!=null) tx.rollback();
			throw new FoodTypeException("데이터 조회 실패", e);
		}
		
		return list;
	}
}
