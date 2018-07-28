package com.candor.rest.UserAccountMicroService.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.candor.rest.UserAccountMicroService.model.User;
import com.candor.rest.UserAccountMicroService.service.UserService;
import com.candor.rest.UserAccountMicroService.util.CustomErrorType;

@RestController
public class UserController {
	
	public static final Logger logger = LoggerFactory.getLogger(UserController.class);

	// Fetch All Users - GET
	// Fetch Details of Single User - GET 
	// Update Details of Single User - PUT
	// Delete a user - DELETE
	// Post Details of Single User - POST
	@Autowired
	UserService userService;
	
	@GetMapping("/users")
	public List<User> fetchAllUsers()
	{
		return userService.findAllUsers();
	}
	
	@GetMapping("/users/{userId}")
	public ResponseEntity<User> findUserById(@PathVariable long userId)
	{
		User user = userService.findById(userId);
		if (user == null) {
			logger.error("User with id {} not found.", userId);
			return new ResponseEntity(new CustomErrorType("User with id " + userId + " not found"), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

}
