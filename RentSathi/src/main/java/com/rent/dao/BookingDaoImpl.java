package com.rent.dao;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.rent.model.Booking;

@Repository
public class BookingDaoImpl implements BookingDao {

	@Resource
	private EntityManagerFactory emf;
	JPAQueryFactory query;
	private static final Logger logger = Logger.getLogger(RegisterDaoImpl.class);

	@Override
	public Boolean setBookingDetails(Booking booking) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		try {
			em.persist(booking);
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

}
