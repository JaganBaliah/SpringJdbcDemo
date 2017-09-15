package org.jagan.springds;

import org.jagan.springds.dao.HibernateDaoImpl;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringHibernateDemo {

	public static void main(String[] args) {
		AbstractApplicationContext appContext = new ClassPathXmlApplicationContext("spring.xml");
		appContext.registerShutdownHook();
		
		HibernateDaoImpl hibernateDaoImpl = appContext.getBean("hibernateDaoImpl", HibernateDaoImpl.class);
		System.out.println("Count : " + hibernateDaoImpl.getCircleCount());
		
		appContext.close();
	}

}
