package com.capgemini.exceptions;

@SuppressWarnings("serial")
public class UserNotFoundException extends Exception {

	public UserNotFoundException() {
		super();
		
	}

	public UserNotFoundException(String message) {
		super(message);
		
	}

}
