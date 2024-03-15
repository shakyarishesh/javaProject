package com.rent.dao;

import com.rent.model.User;

public interface UserDao {

	Boolean addUser(User user);
	
	User getUser(Integer id);
	
	User getExistingUser(String email);//get email of User
	
	int getExistingUserId(String email);
}
