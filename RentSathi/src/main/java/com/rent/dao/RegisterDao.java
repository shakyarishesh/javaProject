package com.rent.dao;

import java.util.UUID;

import com.rent.model.Register;

public interface RegisterDao {

	Boolean setRegisterDetail(Register register);
	
	String getEmail(String email);
	
	String getPassword(String password);

	UUID getIdByEmail(String email);
	
	Register getRegisterId(UUID regId);
	
	
}
