package com.gonzalezait.customer.entities.model.dto;

import org.springframework.http.HttpStatus;

public class ErrorDTO {

	private HttpStatus status;
	private String message;
	
	public ErrorDTO(HttpStatus status, String message) {
		this.status = status;
		this.message = message;
	}
	
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}
