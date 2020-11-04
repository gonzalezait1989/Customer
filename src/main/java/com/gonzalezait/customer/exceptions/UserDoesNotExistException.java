package com.gonzalezait.customer.exceptions;

public class UserDoesNotExistException extends Exception {

	private static final long serialVersionUID = 8652250486018734407L;

	public UserDoesNotExistException(String message) {
		super(message);
	}
	
}