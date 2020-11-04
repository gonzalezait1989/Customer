package com.gonzalezait.customer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gonzalezait.customer.entities.model.User;
import com.gonzalezait.customer.exceptions.AlreadyRegisteredException;
import com.gonzalezait.customer.exceptions.EmailIsRequiredException;
import com.gonzalezait.customer.exceptions.NotRegisteredException;
import com.gonzalezait.customer.services.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	//Not using DTO's to save time 
	@GetMapping("/api/user")
	@ResponseBody
	public User getUser(@RequestParam(name = "email") String email) {
		return this.userService.getUserByEmail(email);
	}
	//Not using DTO's to save time 
	@PostMapping("/api/user")
	@ResponseBody
	public User createUser(@RequestBody User user) throws AlreadyRegisteredException, EmailIsRequiredException {
		return this.userService.createUser(user);
	}
	//Not using DTO's to save time 
	@PutMapping("/api/user")
	@ResponseBody
	public User updateUser(@RequestBody User user) throws NotRegisteredException, EmailIsRequiredException {
		return this.userService.updateUser(user);
	}
}
