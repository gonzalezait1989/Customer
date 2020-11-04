package com.gonzalezait.customer.exceptions;

public class EmailIsRequiredException extends Exception {

	private static final long serialVersionUID = 8033758940256525655L;

	public EmailIsRequiredException(String message) {
		super(message);
	}
}