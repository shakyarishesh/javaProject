package com.rent.dao;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.rent.model.QRent;
import com.rent.sprite.RentList;

@Repository
public class SearchDaoImpl implements SearchDao {

	@Resource
	private EntityManagerFactory emf;
	JPAQueryFactory query ;
	private static final Logger logger = Logger.getLogger(RegisterDaoImpl.class);
	

	@Override
	public Boolean test() {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public  List<RentList> getRentDetail() {
		EntityManager em = emf.createEntityManager();
		this.query = new JPAQueryFactory(em);
		em.getTransaction().begin();
		QRent qRent = QRent.rent;
	
		List<RentList> rentlist = new ArrayList<RentList>() ;

		try {
			List<Tuple> r = query.select(qRent.id, qRent.createdAt, qRent.title, qRent.price, qRent.PropertySpecification
					,qRent.imagePath, qRent.imageName, qRent.rentType, qRent.location )
					.from(qRent)
					.fetch();
			
			for (Tuple r1 : r)
			{
				RentList rr = new RentList();
				rr.setPropertySpecification(r1.get(qRent.PropertySpecification));
				rr.setTitle(r1.get(qRent.title));
				rr.setPrice(r1.get(qRent.price));
				rr.setCreated_at(r1.get(qRent.createdAt));
				rr.setRentType(r1.get(qRent.rentType));
				rr.setLocation(r1.get(qRent.location));
				rr.setRent_id(r1.get(qRent.id));
				
				//converting image byte[] datatype into base64 String
				String base64image = Base64.getEncoder().encodeToString(r1.get(qRent.imagePath));
				rr.setImgpath(base64image);
				rr.setImgname(r1.get(qRent.imageName));
			
				
				rentlist.add(rr);
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}finally
		{
			em.close();
		}

		return rentlist;
	}
	
	@Override
	public List<RentList> getRentDetailByHouse() {
		EntityManager em = emf.createEntityManager();
		this.query = new JPAQueryFactory(em);
		em.getTransaction().begin();
		QRent qRent = QRent.rent;
	
		List<RentList> rentlist = new ArrayList<RentList>() ;

		try {
			List<Tuple> r = query.select(qRent.id, qRent.createdAt, qRent.title, qRent.price, qRent.PropertySpecification
					,qRent.imagePath, qRent.imageName, qRent.rentType, qRent.location )
					.from(qRent)
					.where(qRent.rentType.equalsIgnoreCase("house"))
					.fetch();
			
			for (Tuple r1 : r)
			{
				RentList rr = new RentList();
				rr.setPropertySpecification(r1.get(qRent.PropertySpecification));
				rr.setTitle(r1.get(qRent.title));
				rr.setPrice(r1.get(qRent.price));
				rr.setCreated_at(r1.get(qRent.createdAt));
				rr.setRentType(r1.get(qRent.rentType));
				rr.setLocation(r1.get(qRent.location));
				rr.setRent_id(r1.get(qRent.id));
			
				//converting image byte[] datatype into base64 String
				String base64image = Base64.getEncoder().encodeToString(r1.get(qRent.imagePath));
				rr.setImgpath(base64image);
				rr.setImgname(r1.get(qRent.imageName));
			
				
				rentlist.add(rr);
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}finally
		{
			em.close();
		}

		return rentlist;
	}

	@Override
	public List<RentList> getRentDetailByFlat() {
		EntityManager em = emf.createEntityManager();
		this.query = new JPAQueryFactory(em);
		em.getTransaction().begin();
		QRent qRent = QRent.rent;
	
		List<RentList> rentlist = new ArrayList<RentList>() ;

		try {
			List<Tuple> r = query.select(qRent.id, qRent.createdAt, qRent.title, qRent.price, qRent.PropertySpecification
					,qRent.imagePath, qRent.imageName, qRent.rentType, qRent.location )
					.from(qRent)
					.where(qRent.rentType.equalsIgnoreCase("flat"))
					.fetch();
			
			for (Tuple r1 : r)
			{
				RentList rr = new RentList();
				rr.setPropertySpecification(r1.get(qRent.PropertySpecification));
				rr.setTitle(r1.get(qRent.title));
				rr.setPrice(r1.get(qRent.price));
				rr.setCreated_at(r1.get(qRent.createdAt));
				rr.setRentType(r1.get(qRent.rentType));
				rr.setLocation(r1.get(qRent.location));
				rr.setRent_id(r1.get(qRent.id));
				
				//converting image byte[] datatype into base64 String
				String base64image = Base64.getEncoder().encodeToString(r1.get(qRent.imagePath));
				rr.setImgpath(base64image);
				rr.setImgname(r1.get(qRent.imageName));
			
				
				rentlist.add(rr);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		finally
		{
			em.close();
		}

		return rentlist;
	}
	
	@Override
	public List<RentList> getRentDetailByRoom() {
		EntityManager em = emf.createEntityManager();
		this.query = new JPAQueryFactory(em);
		em.getTransaction().begin();
		QRent qRent = QRent.rent;
	
		List<RentList> rentlist = new ArrayList<RentList>() ;

		try {
			List<Tuple> r = query.select(qRent.id, qRent.createdAt, qRent.title, qRent.price, qRent.PropertySpecification
					,qRent.imagePath, qRent.imageName, qRent.rentType, qRent.location )
					.from(qRent)
					.where(qRent.rentType.equalsIgnoreCase("room"))
					.fetch();
			
			for (Tuple r1 : r)
			{
				RentList rr = new RentList();
				rr.setPropertySpecification(r1.get(qRent.PropertySpecification));
				rr.setTitle(r1.get(qRent.title));
				rr.setPrice(r1.get(qRent.price));
				rr.setCreated_at(r1.get(qRent.createdAt));
				rr.setRentType(r1.get(qRent.rentType));
				rr.setLocation(r1.get(qRent.location));
				rr.setRent_id(r1.get(qRent.id));
				
				//converting image byte[] datatype into base64 String
				String base64image = Base64.getEncoder().encodeToString(r1.get(qRent.imagePath));
				rr.setImgpath(base64image);
				rr.setImgname(r1.get(qRent.imageName));
			
				
				rentlist.add(rr);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		finally
		{
			em.close();
		}

		return rentlist;
	}

	@Override
	public List<RentList> getRentDetailByDistrict(String district, String rentType) {
		EntityManager em = emf.createEntityManager();
		this.query = new JPAQueryFactory(em);
		em.getTransaction().begin();
		QRent qRent = QRent.rent;
	
		List<RentList> rentlist = new ArrayList<RentList>() ;

		try {
			List<Tuple> r = query.select(qRent.id, qRent.createdAt, qRent.title, qRent.price, qRent.PropertySpecification
					,qRent.imagePath, qRent.imageName, qRent.rentType )
					.from(qRent)
					.where(qRent.location.eq(district)
							.and(qRent.rentType.eq(rentType)))
					.fetch();
			
			for (Tuple r1 : r)
			{
				RentList rr = new RentList();
				rr.setPropertySpecification(r1.get(qRent.PropertySpecification));
				rr.setTitle(r1.get(qRent.title));
				rr.setPrice(r1.get(qRent.price));
				rr.setCreated_at(r1.get(qRent.createdAt));
				rr.setRentType(r1.get(qRent.rentType));
				rr.setRent_id(r1.get(qRent.id));
				
				//converting image byte[] datatype into base64 String
				String base64image = Base64.getEncoder().encodeToString(r1.get(qRent.imagePath));
				rr.setImgpath(base64image);
				rr.setImgname(r1.get(qRent.imageName));
			
				
				rentlist.add(rr);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		finally
		{
			em.close();
		}

		return rentlist;
	}

}
