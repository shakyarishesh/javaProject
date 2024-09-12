package com.rent.dao;

import org.apache.log4j.Logger;

import java.util.UUID;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.rent.model.QRegister;
import com.rent.model.Register;

@Repository
public class RegisterDaoImpl implements RegisterDao {

	@Resource
	private EntityManagerFactory emf;
	JPAQueryFactory query ;
	private static final Logger logger = Logger.getLogger(RegisterDaoImpl.class);

	@Override
	public Boolean setRegisterDetail(Register register) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		try {
			em.persist(register);
			em.getTransaction().commit();
			logger.info("User details added");
			return true;
		} catch (Exception e) {
			logger.error("error to insert User Details " + e.getMessage());
		} finally {
			em.close();
		}

		return false;
	}

	@Override
	public String getEmail(String email) {
		EntityManager em = emf.createEntityManager();
		this.query = new JPAQueryFactory(em);
		em.getTransaction().begin();
		QRegister qRegister = QRegister.register;
		logger.info("email" + email);
		String e = null;

		try {
			e = query.select(qRegister.email).from(qRegister).where(qRegister.email.eq(email)).fetchOne();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return e;
	}

	@Override
	public String getPassword(String password) {
		EntityManager em = emf.createEntityManager();
		this.query = new JPAQueryFactory(em);
		em.getTransaction().begin();
		QRegister qRegister = QRegister.register;
		String p = null;

		try {
			p = query.select(qRegister.password).from(qRegister).where(qRegister.password.eq(password)).fetchOne();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return p;
	}
	
	@Override
	public Register getRegisterId(UUID regId) {
		EntityManager em = emf.createEntityManager();
		this.query = new JPAQueryFactory(em);
		em.getTransaction().begin();
		QRegister qRegister = QRegister.register;
		logger.info("regId: " + regId);
		Register e = null;

		try {
			e = query.select(qRegister).from(qRegister).where(qRegister.id.eq(regId)).fetchFirst();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return e;
	}
	
	@Override
	public UUID getIdByEmail(String email) {
		EntityManager em = emf.createEntityManager();
		this.query = new JPAQueryFactory(em);
		em.getTransaction().begin();
		QRegister qRegister = QRegister.register;
		UUID e = null;

		try {
			e = query.select(qRegister.id).from(qRegister).where(qRegister.email.eq(email)).fetchOne();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return e;
	}
}
