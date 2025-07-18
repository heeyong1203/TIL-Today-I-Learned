package com.sinse.mall.model.category;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sinse.mall.domain.SubCategory;

@Qualifier("hibernateSubCategoryDAO")
@Repository
public class HibernateSubCategoryDAO implements SubCategoryDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public List selectAll() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from SubCategory", SubCategory.class);
		return query.getResultList();
	}

	@Transactional
	public List selectByTopCategoryId(int subcategory_id) {
		Session session = sessionFactory.getCurrentSession();
		return null;
	}
	
	@Override
	public SubCategory select(int subcategory_id) {
		return null;
	}

	
	
}
