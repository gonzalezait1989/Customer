package com.gonzalezait.customer.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gonzalezait.customer.entities.model.Slogan;
import com.gonzalezait.customer.exceptions.SloganPerUserLimitExceeded;
import com.gonzalezait.customer.exceptions.UserDoesNotExistException;
import com.gonzalezait.customer.services.SloganService;

@RestController
public class SloganController {

	@Autowired
	private SloganService sloganService;
	
	//Not using DTO's to save time 
	@GetMapping("/api/user/{id}/slogans")
	@ResponseBody
	public List<Slogan> getSlogansByUser(@PathVariable("id") Long id) {
		return this.sloganService.getSlogansByUserId(id);
	}
	
	//Not using DTO's to save time 
	@PostMapping("/api/user/{id}/slogans")
	@ResponseBody
	public Slogan createUser(@PathVariable("id") Long id, @RequestBody Slogan slogan) throws UserDoesNotExistException, SloganPerUserLimitExceeded  {
		return this.sloganService.createSlogan(id, slogan);
	}
}
