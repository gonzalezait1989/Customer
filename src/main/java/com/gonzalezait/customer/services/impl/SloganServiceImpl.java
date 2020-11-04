package com.gonzalezait.customer.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gonzalezait.customer.daos.SloganRepository;
import com.gonzalezait.customer.entities.model.Slogan;
import com.gonzalezait.customer.entities.model.User;
import com.gonzalezait.customer.exceptions.SloganPerUserLimitExceeded;
import com.gonzalezait.customer.exceptions.UserDoesNotExistException;
import com.gonzalezait.customer.services.SloganService;

@Service
public class SloganServiceImpl implements SloganService {

	@Autowired
	private SloganRepository sloganRepository;
	@Autowired
	private UserServiceImpl userService;
	
	@Override
	public List<Slogan> getSlogansByUserId(Long id) {
		User user = new User();
		user.setId(id);
		return this.sloganRepository.getByUser(user);
	}

	@Override
	public Slogan createSlogan(Long id, Slogan slogan) throws UserDoesNotExistException, SloganPerUserLimitExceeded {
		//First, we check if the user exists, if not, we throw an exception
		User user = this.userService.getUserById(id); 
		if(user == null) throw new UserDoesNotExistException("User with id " + id + " does not exist. Cannot create Slogan.");
		// First, we get all the user Slogan
		List<Slogan> slogans = this.sloganRepository.getByUser(user);
		//If the user already has 3 or more slogans, we do not allow it to save more slogans.
		if(slogans != null && slogans.size() >= 3) throw new SloganPerUserLimitExceeded("The User with id " + id + " has already 3 slogans registered.");
		
		//Saves the slogan
		slogan.setUser(user);
		return this.sloganRepository.save(slogan);
	}

}
