package com.rent.dao;

import java.util.List;

import com.rent.model.Booking;
import com.rent.sprite.RentList;

public interface BookingDao {
	
	Boolean setBookingDetails(Booking booking);
	
	public List<RentList> getRentDetailsByBooking(Integer user_id);


}
