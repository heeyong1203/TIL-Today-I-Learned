package com.sinse.mall.model.category;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sinse.mall.domain.TopCategory;

@Repository
@Qualifier("hibernateTopCategoryDAO")
public class HibernateTopCategoryDAO implements TopCategoryDAO{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public List selectAll() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from TopCategory", TopCategory.class);
		return query.getResultList();
	}

	@Override
	public TopCategory select(int topcategory_id) {
		return null;
	}
	
	
}
