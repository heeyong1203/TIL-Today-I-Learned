package com.sinse.hiberasync2.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConfig2 {
	private static HibernateConfig2 instance; 
	private SessionFactory sessionFactory;
	
	public HibernateConfig2() {
		sessionFactory = new Configuration().configure().buildSessionFactory();
	}
	
	public static HibernateConfig2 getInstance() {
		if(instance==null) {
			instance=new HibernateConfig2();
		}
		return instance;
	}
	
	public Session getSession() {
		return sessionFactory.openSession();
	}
}
