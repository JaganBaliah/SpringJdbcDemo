package org.jagan.springds.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HibernateDaoImpl {

	@Autowired
	private SessionFactory sessionFactory;
	
	public int getCircleCount() {
		String hql = "Select count(*) from Circle"; //Note: Circle is entity name and not table name
		Session openSession = getSessionFactory().openSession();
		Query<Long> query = openSession.createQuery(hql, Long.class);
		return query.uniqueResult().intValue();
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
}
