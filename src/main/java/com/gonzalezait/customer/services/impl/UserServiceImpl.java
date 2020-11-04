package com.gonzalezait.customer.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gonzalezait.customer.daos.UserRepository;
import com.gonzalezait.customer.entities.model.User;
import com.gonzalezait.customer.exceptions.AlreadyRegisteredException;
import com.gonzalezait.customer.exceptions.EmailIsRequiredException;
import com.gonzalezait.customer.exceptions.NotRegisteredException;
import com.gonzalezait.customer.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User getUserByEmail(String email) {
		//If the email is null or blank, return null.
		if(email == null || email.isBlank()) return null;
		return this.userRepository.getByEmailAddress(email);
	}
	
	
	@Override
	public User createUser(User user) throws AlreadyRegisteredException, EmailIsRequiredException {
		//First, we need to check if the user email null so we only create users with email.
		if(!user.hasEmail()) throw new EmailIsRequiredException("Email is required for user registration.");
		//Then, we check if a user with this email already exists
		User userFromDB = this.getUserByEmail(user.getEmailAddress());
		if(userFromDB != null) throw new AlreadyRegisteredException("There is already exists a user with this mail.");
		//If not, we save the user
		return this.userRepository.save(user);
	}

	@Override
	public User updateUser(User user) throws NotRegisteredException, EmailIsRequiredException {
		//First, we need to check if the user email null so we only create users with email.
		if(!user.hasEmail()) throw new EmailIsRequiredException("Email is required for user update.");;
		//Then, we check if a user with this email already exists
		User userFromDB = this.getUserByEmail(user.getEmailAddress());
		if(userFromDB == null) throw new NotRegisteredException("There is no user registered with this mail.");
		//If exists, we make use of the same ID to update it
		user.setId(userFromDB.getId());
		return this.userRepository.save(user);
	}


	public User getUserById(Long id) {
		return this.userRepository.findById(id).orElse(null);
	}
	
}
