package com.rent.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rent.controller.CommonController;
import com.rent.dao.BookingDao;
import com.rent.dao.RentDao;
import com.rent.dao.UserDao;
import com.rent.model.Booking;
import com.rent.model.Rent;
import com.rent.model.User;
import com.rent.sprite.BookingTable;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	BookingDao bookingDao;
	
	@Autowired
	RentDao rentDao;
	
	@Autowired
	UserDao userDao;
	
	@Override
	public Boolean addBookingDetails(BookingTable bookingTable, UUID rent_id, String user_email) {
		Rent rent = rentDao.getRentId(rent_id);
		String rent_type = rentDao.getRentType(rent_id);
		User user_id = userDao.getExistingUser(user_email);
		
		Booking book = new Booking();
		
		book.setName(bookingTable.getName());
		book.setEmail(bookingTable.getEmail());
		book.setMobileno(bookingTable.getMobileno());
		book.setComment(bookingTable.getComment());
		book.setRentType(rent_type);
		book.setCreatedAt(CommonController.getCurrentDateTime());
		book.setRent(rent);
		book.setUser(user_id);
		
		System.out.println("rent type:"+rent_type);
		
		
		return bookingDao.setBookingDetails(book);
	}

}
