package com.rent.dao;

import java.util.UUID;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.rent.model.QRent;
import com.rent.model.QUser;
import com.rent.model.Rent;
import com.rent.model.Status;
import com.rent.model.User;

@Repository
public class RentDaoImpl implements RentDao {

	@Resource
	private EntityManagerFactory emf;
	JPAQueryFactory query;
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

	@Override
	public Rent getRentId(UUID rent_id) {
		EntityManager em = emf.createEntityManager();
		JPAQueryFactory query = new JPAQueryFactory(em);

		QRent qRent = QRent.rent;
		Rent rent = null;

		try {
			rent = query.selectFrom(qRent).where(qRent.id.eq(rent_id)).fetchOne();
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}

		return rent;
	}

	@Override
	public String getRentType(UUID rent_id) {
		EntityManager em = emf.createEntityManager();
		JPAQueryFactory query = new JPAQueryFactory(em);

		QRent qRent = QRent.rent;
		String rent = null;
		try {
			rent = query.select(qRent.rentType).from(qRent).where(qRent.id.eq(rent_id)).fetchFirst();

			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}

		return rent;
	}

	@Override
	public Boolean updateRent(Rent rent) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		try {
			em.merge(rent);
			em.getTransaction().commit();
			logger.info("Rent details added");
			return true;
		} catch (Exception e) {
			logger.error("failed to update rent Details " + e.getMessage());
		} finally {
			em.close();
		}
		return false;
	}

	@Override
	public Boolean changestatus(UUID rentId, Status status) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		try {
			// Assuming Rent is the entity class and it has a field named status
			Rent rent = em.find(Rent.class, rentId);
			if (rent != null) {
				rent.setStatus(status); // Assuming setStatus is a method in Rent entity to set the status
				em.merge(rent);
				em.getTransaction().commit();
				logger.info("Rent details updated");
				return true;
			} else {
				logger.error("Rent not found for ID: " + rentId);
				return false;
			}
		} catch (Exception e) {
			logger.error("Failed to update rent details: " + e.getMessage());
			return false;
		} finally {
			em.close();
		}
	}
}
