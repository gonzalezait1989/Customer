package com.gonzalezait.customer.controllers.advise;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.gonzalezait.customer.entities.model.dto.ErrorDTO;
import com.gonzalezait.customer.exceptions.AlreadyRegisteredException;
import com.gonzalezait.customer.exceptions.EmailIsRequiredException;
import com.gonzalezait.customer.exceptions.NotRegisteredException;
import com.gonzalezait.customer.exceptions.SloganPerUserLimitExceeded;
import com.gonzalezait.customer.exceptions.UserDoesNotExistException;

@RestControllerAdvice
public class ControllerAdvicer {

	@ExceptionHandler(AlreadyRegisteredException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorDTO processAlreadyRegisteredException(AlreadyRegisteredException e) {
        return createErrorDTO(HttpStatus.BAD_REQUEST, e.getMessage());
    }
	
	@ExceptionHandler(EmailIsRequiredException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorDTO processEmailIsRequiredException(EmailIsRequiredException e) {
        return createErrorDTO(HttpStatus.BAD_REQUEST, e.getMessage());
    }
	
	@ExceptionHandler(NotRegisteredException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorDTO processNotRegisteredException(NotRegisteredException e) {
        return createErrorDTO(HttpStatus.NOT_FOUND, e.getMessage());
    }
	
	@ExceptionHandler(SloganPerUserLimitExceeded.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorDTO processSloganPerUserLimitExceeded(SloganPerUserLimitExceeded e) {
        return createErrorDTO(HttpStatus.TOO_MANY_REQUESTS, e.getMessage());
    }
	
	@ExceptionHandler(UserDoesNotExistException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorDTO processUserDoesNotExistException(UserDoesNotExistException e) {
        return createErrorDTO(HttpStatus.NOT_FOUND, e.getMessage());
    }
	
    private ErrorDTO createErrorDTO(HttpStatus status, String message) {
    	return new ErrorDTO(status, message);
    }
    
}