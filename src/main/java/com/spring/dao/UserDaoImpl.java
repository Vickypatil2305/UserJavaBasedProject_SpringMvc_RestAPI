package com.spring.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.spring.entity.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	SessionFactory sessionFactoryyyy;
	
	@Transactional
	public List<User> findAllUser() {
		Session session = sessionFactoryyyy.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<User> cq = cb.createQuery(User.class);
		Root<User> root = cq.from(User.class);
		cq.select(root);
		Query query = session.createQuery(cq);
		return query.getResultList();
	}

	@Transactional
	public User findOneUser(long personId) {
		Session session = this.sessionFactoryyyy.getCurrentSession();
		User oneUser = session.get(User.class,personId);
		return oneUser;
	}

	@Transactional
	public void addUser(User user) {
		Session session = sessionFactoryyyy.getCurrentSession();
		session.saveOrUpdate(user);
        System.out.println("User Added!!");
	}
	
	@Transactional
	public void deleteOneUser(long personId) {
		Session session = this.sessionFactoryyyy.getCurrentSession();
		User deleteUser = session.byId(User.class).load(personId);
		session.delete(deleteUser);
        System.out.println("Person Deleted!!");		
	}

}
