package com.joonje.repository;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.joonje.domain.User;
@Repository
public class UserDao {
	@Autowired
	private SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public void save(User user) {
		Session session = this.getSession();
		session.save(user);
		session.flush();
		session.close();
		
	}
	public List<User> query() {
		Query q = this.getSession().createQuery("from User");
		return q.list();
	}
	private Session getSession() {
		return sessionFactory.openSession();
	}
	
}
