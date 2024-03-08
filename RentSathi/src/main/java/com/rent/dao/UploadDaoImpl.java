package com.rent.dao;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.rent.model.Rent;

@Repository
public class UploadDaoImpl implements UploadDao{

	@Resource
	private EntityManagerFactory emf;
	JPAQueryFactory query ;
	private static final Logger logger = Logger.getLogger(RegisterDaoImpl.class);
	
	@Override
	public Boolean addUpload(Rent rent) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		try {
			em.persist(rent);
			em.getTransaction().commit();
			logger.info("Rent details added");
			return true;
		} catch (Exception e) {
			logger.error("error to insert rent Details " + e.getMessage());
		} finally {
			em.close();
		}
		return false;
	}

	

}
