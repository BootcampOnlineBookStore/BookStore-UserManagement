package com.capgemini.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capgemini.dto.ErrorInfo;
import com.capgemini.exceptions.LoginException;
/**
 * LoginControllerAdvice is the class which handles the exceptions globally
 * @author SAISHIVA
 * @version 1.0
 * CreatedOn: 2020-10-07
 */
@RestControllerAdvice
@CrossOrigin(origins = {"http://localhost:4200"})
public class LoginControllerAdvice {
    
	/**
	 * Method: handleLoginException 
	 * Description: is  used to throw the exception when ever the user enters invalid credentials
	 * @param ex
	 * @return the message stating that credentials are not valid
	 */
	@ExceptionHandler(LoginException.class)
	@ResponseStatus(code = HttpStatus.FORBIDDEN)
	public ErrorInfo handleLoginException(LoginException ex) {
		return new ErrorInfo(HttpStatus.FORBIDDEN.toString(), ex.getMessage());
	}
}
