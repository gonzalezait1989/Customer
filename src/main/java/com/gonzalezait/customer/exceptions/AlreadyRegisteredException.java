package com.gonzalezait.customer.exceptions;

public class AlreadyRegisteredException extends Exception {

	private static final long serialVersionUID = -1651260121241868152L;
	
	public AlreadyRegisteredException(String message) {
		super(message);
	}
}
