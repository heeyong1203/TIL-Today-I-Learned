package com.sinse.mall.spring.config;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.hibernate.SessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jndi.JndiTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/*
  스프링의 고전적 설정을 담당하는 xml을 대신하는 Config.java
 */

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages = {"com.sinse.mall.admin.controller", "com.sinse.mall.notice.model"})
public class AdminWebConfig {
	
	/*하위 컨트롤러가 3, 4단계를 수행한 후, DispatcherServlet에게 정확한 파일명이 아닌
	 	파일명의 일부 단서만 반환한다. (ModelAndView에 심어서 반환) 
	 	따라서 이 객체를 넘겨받은 DispatcherSerlvet은 일부 단서를 직접 해석하는 것이 아니라,
	 	View에 대한 해석을 담당하는 전담객체(ViewResolver)에게 맡긴다.
	 	JSP 사용 시 주로 사용되는 ViewResolver는 InternalResourceViewResolver
	 	
	 	하위 컨트롤러가 notice/list를 심어 보내면 /WEB-INF/views/notice/list.jsp
 	*/
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	//어떤 데이터베이스를 사용할 지 선택
	public DataSource dataSource() throws NamingException {
		JndiTemplate jndi = new JndiTemplate();
		return jndi.lookup("java:comp/env/jndi/mysql", DataSource.class);
	}
	
	/*------------------------------------------------------------
	 	Mybatis 관련
	------------------------------------------------------------*/
	//스프링을 사용하는 이유: 기업용 애플리케이션 개발 시, 개발자가 일일이 처리해야하는 반복 작업을 
	//대신 해주기 때문이다. 스프링 이전 시대에는 이 작업을 EJB 기술이었다.
	//규모가 큰 작업에서 개발자들의 반복 작업을 대신하는 대표적 업무(트랜잭션, 로깅, 보안 처리...)
	//JDBC 사용 시 DataSource가 결정되었다면, 그 다음은 적절한 트랜잭션 매니저를 등록해야 한다.
	//사용 기술이 JDBC 기반: DataSourceTransactionManager 객체를 등록해야 한다.
	//사용 기술이 Myabtis 기반: DataSourceTransactionManager 객체를 등록해야 한다.
	//사용 기술이 Hybernate 기반: HibernateTransactionManager 객체를 등록해야 한다.
	//1) 트랜잭션 개발자가 직접 처리하지 않아도 알아서 처리 (commit, rollback 호출 필요 없음)
	//2) 어떠한 기술을 사용하더라도, 코드에 변함이 없다. (일관된 코드)
	
	//Mybatis에 사용할 트랜잭션매니저 선택
	@Bean
	public PlatformTransactionManager platformTransactionManager(SqlSessionFactory sqlSessionFactory) {
		return new DataSourceTransactionManager(sqlSessionFactory.getConfiguration().getEnvironment().getDataSource());
	}
	
	//Mybatis의 SqlSession이 모여져 있는 SqlSessionFactory를 Bean으로 등록
	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setConfigLocation(new ClassPathResource("com/sinse/mall/mybatis/mybatis-config.xml"));
		
		//SqlSessionFactoryBean에게 사용할 DB를 알려주어야 한다.
		sqlSessionFactoryBean.setDataSource(dataSource());
		return sqlSessionFactoryBean.getObject();
	}
	
	//SqlSessionFactoryBean으로부터 쿼리문을 수행하는 객체의 원 명칭은 SqlSession이지만, mybatis-spring에서는
	//이 객체를 래핑한 객체인 SqlSessionTemplate 객체를 사용해야 한다.
	//순수 mybatis에서의 sqlSessionFactory → mybatis-spring에서의 명칭: sqlSessionFactoryBean으로 변경
	//순수 mybatis에서의 sqlSession → mybatis-spring에서의 명칭: sqlSessionTemplate으로 변경	
	//DAO가 사용할 SqlSessionTemplate 등록
	@Bean
	public SqlSessionTemplate sqlSessionTemplate() throws Exception {
		return new SqlSessionTemplate(sqlSessionFactory());
	}
	
	
	/*------------------------------------------------------------
	 	Hybernate 관련
	------------------------------------------------------------*/
	@Bean //SessionFactory 등록
	public LocalSessionFactoryBean sessionFactory() throws NamingException {
		LocalSessionFactoryBean factoryBean =  new LocalSessionFactoryBean();
		factoryBean.setConfigLocation(new ClassPathResource("com/sinse/mall/hybernate/hibernate.cfg.xml"));
		
		factoryBean.setDataSource(dataSource()); // 어떤 DB를 사용할지
		return factoryBean;
	}
	
	@Primary //여러 개의 트랜잭션 매니저 중 최우선 순위를 등록
	@Bean //트랜잭션 매니저 등록
	public  HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		return new HibernateTransactionManager(sessionFactory);
	}
	
	
	
}
