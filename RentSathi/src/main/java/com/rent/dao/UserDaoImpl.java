package com.rent.dao;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.rent.model.QUser;
import com.rent.model.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Resource
	private EntityManagerFactory emf;
	JPAQueryFactory query;
	private static final Logger logger = Logger.getLogger(RegisterDaoImpl.class);
	
	@Override
	public User getUser(Integer id) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		JPAQueryFactory query = new JPAQueryFactory(em);

		QUser quser = QUser.user;
		User user = query.selectFrom(quser).where(quser.id.eq(id)).fetchOne();

		em.getTransaction().commit();
		em.close();

		return user;
	}

	@Override
	public Boolean addUser(User user) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		try {
			em.persist(user);
			em.getTransaction().commit();
			logger.info("User added");
			return true;
		}catch (Exception e) {
			logger.error("error to insert User. " + e.getMessage());
		}finally {
			em.close();
		}
			
		return false;
	}

	@Override
	public User getExistingUser(String email) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		JPAQueryFactory query = new JPAQueryFactory(em);

		QUser quser = QUser.user;
		User user = query.selectFrom(quser).where(quser.email.eq(email)).fetchOne();

		em.getTransaction().commit();
		em.close();

		return user;
	}

	@Override
	public int getExistingUserId(String email) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		JPAQueryFactory query = new JPAQueryFactory(em);

		QUser quser = QUser.user;
		int user = query.select(quser.id).from(quser).where(quser.email.eq(email)).fetchOne();

		em.getTransaction().commit();
		em.close();

		return user;
	}



}
