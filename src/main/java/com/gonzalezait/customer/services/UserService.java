package com.gonzalezait.customer.services;

import com.gonzalezait.customer.entities.model.User;
import com.gonzalezait.customer.exceptions.AlreadyRegisteredException;
import com.gonzalezait.customer.exceptions.EmailIsRequiredException;
import com.gonzalezait.customer.exceptions.NotRegisteredException;

public interface UserService {
	
	

	/**
	 * Receives a User and creates it if not exists.
	 * @param user the user to create.
	 * @return the created user.
	 * @throws AlreadyRegisteredException if the user has been already registered with this mail.
	 * @throws EmailIsRequiredException if the email does not appear in the request.
	 */
	public User createUser(User user) throws AlreadyRegisteredException, EmailIsRequiredException;

	/**
	 * Receives a user and updates if exists.
	 * @param user the user to update.
	 * @return the updated user.
	 * @throws NotRegisteredException if the user does not exists.
	 * @throws EmailIsRequiredException if the email does not appear in the request.
	 */
	public User updateUser(User user) throws NotRegisteredException, EmailIsRequiredException;

	/**
	 * Gets a user by it's email.
	 * @param email the email of the user.
	 * @return the user with this email.
	 */
	public User getUserByEmail(String email);

}
