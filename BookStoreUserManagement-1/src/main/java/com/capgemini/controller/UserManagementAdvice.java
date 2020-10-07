package com.capgemini.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capgemeni.dto.ErrorInfo;
import com.capgemini.exceptions.ListIsEmptyException;
import com.capgemini.exceptions.LoginException;
import com.capgemini.exceptions.UserNotFoundException;

@RestControllerAdvice
public class UserManagementAdvice {
	@ExceptionHandler(UserNotFoundException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public ErrorInfo handleException1(UserNotFoundException ex) {
		return new ErrorInfo(HttpStatus.NOT_FOUND.toString(), ex.getMessage());
	}
	@ExceptionHandler(ListIsEmptyException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public ErrorInfo handleException2(ListIsEmptyException ex) {
		return new ErrorInfo(HttpStatus.NOT_FOUND.toString(), ex.getMessage());
	}
	@ExceptionHandler(LoginException.class)
	@ResponseStatus(code = HttpStatus.FORBIDDEN)
	public ErrorInfo handleLoginException(LoginException ex) {
		return new ErrorInfo(HttpStatus.FORBIDDEN.toString(), ex.getMessage());
	}
}
