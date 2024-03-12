package com.rent.service;

import com.rent.model.Booking;
import com.rent.sprite.BookingTable;

public class BookingServiceImpl implements BookingService {

	@Override
	public Boolean addBookingDetails(BookingTable bookingTable) {
		Booking book = new Booking();
		
		book.setName(bookingTable.getName());
		book.setEmail(bookingTable.getEmail());
		book.setMobileno(bookingTable.getMobileno());
		book.setComment(bookingTable.getComment());
		book.setRentType(bookingTable.getRentType());
		return null;
	}

}
