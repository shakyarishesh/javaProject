package com.rent.dao;

import java.util.UUID;

import com.rent.model.User;

public interface UserDao {

	Boolean addUser(User user);
	
	User getUser(Integer id);
	
	User getExistingUser(String email);//get email of User
	
	int getExistingUserId(String email);
	
	UUID getRegisterId(Integer user_id);
	
	String District(Integer user_id);
}
