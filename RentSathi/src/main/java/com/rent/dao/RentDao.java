package com.rent.dao;

import java.util.UUID;

import com.rent.model.Rent;
import com.rent.model.Status;

public interface RentDao {

	Boolean addUpload(Rent rent);
	
	Rent getRentId(UUID rent_id);
	
	String getRentType(UUID rent_id);
	
	Boolean updateRent(Rent rent);
	
	Boolean changestatus(UUID rentId, Status status);
}
