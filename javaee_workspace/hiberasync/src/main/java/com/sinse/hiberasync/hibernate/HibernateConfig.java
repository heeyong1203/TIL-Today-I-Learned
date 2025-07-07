package com.sinse.hiberasync.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConfig {
	private static HibernateConfig instance;
	private SessionFactory sessionFactory;
	
	private HibernateConfig() {
		// hibernate는 설정 xml의 위치를 따로 명시하지 않는다.
		// 그 대신 개발자는 설정파일의 위치를 resources에 둬야 인식된다.
		sessionFactory = new Configuration().configure().buildSessionFactory();
	}
	
	public static HibernateConfig getInstance() {
		if(instance==null) {
			instance = new HibernateConfig();
		}
		return instance;
	}
	
	public Session getSession() {
		return sessionFactory.openSession();
	}
}
