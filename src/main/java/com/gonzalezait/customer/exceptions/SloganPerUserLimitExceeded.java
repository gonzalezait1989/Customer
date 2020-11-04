package com.gonzalezait.customer.exceptions;

public class SloganPerUserLimitExceeded extends Exception {

	private static final long serialVersionUID = -1018486668734498053L;

	public SloganPerUserLimitExceeded(String message) {
		super(message);
	}
	
}