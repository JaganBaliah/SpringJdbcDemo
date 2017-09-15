package org.jagan.springds;

import org.jagan.springds.dao.JdbcDaoImpl;
import org.jagan.springds.dao.SimpleJdbcDaoImpl;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JdbcDemo {

	public static void main(String[] args) {
		/*
		Circle circle = new JdbcClassicDaoImpl().getCircle(1);
		System.out.println(circle.getName());
		*/
		
		AbstractApplicationContext appContext = new ClassPathXmlApplicationContext("spring.xml");
		appContext.registerShutdownHook();
		
		/*
		JdbcDataSourceDaoImpl jdbcDaoImpl = appContext.getBean("jdbcDataSourceDaoImpl", JdbcDataSourceDaoImpl.class);
		Circle circle = jdbcDaoImpl.getCircle(1);
		System.out.println(circle.getName());
		*/
		
		JdbcDaoImpl jdbcDaoImpl = appContext.getBean("jdbcDaoImpl", JdbcDaoImpl.class);
		System.out.println("Count : " + jdbcDaoImpl.getCircleCount());
		System.out.println("Name : " + jdbcDaoImpl.getCircleName(1));
		
		System.out.println("Circle ID : " + jdbcDaoImpl.getCircleForId(1).getId());
		System.out.println("Circle Name : " + jdbcDaoImpl.getCircleForId(1).getName());
		
		System.out.println("All Circle Count: " + jdbcDaoImpl.getAllCircles().size());
	
		//jdbcDaoImpl.insertCircle(new Circle(4, "Fourth Circle"));
		
		//jdbcDaoImpl.createTriangleTable();
		
		SimpleJdbcDaoImpl simpleJdbcDaoImpl = appContext.getBean("simpleJdbcDaoImpl", SimpleJdbcDaoImpl.class);
		System.out.println("Simple Support Count : " + simpleJdbcDaoImpl.getCircleCount());
		
		
		appContext.close();
	}

}
