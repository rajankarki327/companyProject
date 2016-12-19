package com.dao.spring;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.model.spring.UserSubscriberModel;

@Repository
public class UserSubscriberDao {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public void subscribe(UserSubscriberModel userSubscriberModel)
	{
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(userSubscriberModel);
	}
}
