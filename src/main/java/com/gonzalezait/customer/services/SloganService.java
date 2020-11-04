package com.gonzalezait.customer.services;

import java.util.List;

import com.gonzalezait.customer.entities.model.Slogan;
import com.gonzalezait.customer.exceptions.SloganPerUserLimitExceeded;
import com.gonzalezait.customer.exceptions.UserDoesNotExistException;

public interface SloganService {

	/**
	 * Gets all Slogans created by User by the given User Id.
	 * @param id the Id of the user.
	 * @return a List of Slogans.
	 */
	public List<Slogan> getSlogansByUserId(Long id);

	/**
	 * Creates a Slogan proposed by a User.
	 * @param id the Id of the user.
	 * @param slogan the Slogan the user wants to create.
	 * @return the created Slogan.
	 * @throws UserDoesNotExistException if the user does not exists.
	 * @throws SloganPerUserLimitExceeded  if the user has already registered too many slogans.
	 */
	public Slogan createSlogan(Long id, Slogan slogan) throws UserDoesNotExistException, SloganPerUserLimitExceeded;

}
