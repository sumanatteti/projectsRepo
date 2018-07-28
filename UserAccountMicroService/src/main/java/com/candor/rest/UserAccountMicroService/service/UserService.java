package com.candor.rest.UserAccountMicroService.service;


import java.util.List;

import com.candor.rest.UserAccountMicroService.model.User;




public interface UserService {
	
	User findById(long id);
	
	User findByName(String name);
	
	void saveUser(User user);
	
	void updateUser(User user);
	
	void deleteUserById(long id);

	List<User> findAllUsers();
	
	void deleteAllUsers();
	
	boolean isUserExist(User user);
	
}
