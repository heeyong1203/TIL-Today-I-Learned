package com.sinse.hiberasync2.repository;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sinse.hiberasync2.exception.StoreException;
import com.sinse.hiberasync2.hibernate.HibernateConfig2;
import com.sinse.hiberasync2.model.Store;

public class StoreDAO {
	HibernateConfig2 config = HibernateConfig2.getInstance();
	
	public void insert(Store store) throws StoreException {
		Transaction tx = null;
		
		try(Session session = config.getSession()){
			tx = session.beginTransaction();
			session.save(store);		
			tx.commit();
		} catch(Exception e) {
			e.printStackTrace();
			if(tx!=null) tx.rollback();
			throw new StoreException("등록 실패", e); 
		}
	}
}
