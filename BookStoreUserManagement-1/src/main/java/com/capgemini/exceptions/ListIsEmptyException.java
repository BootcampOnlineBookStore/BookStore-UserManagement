package com.capgemini.exceptions;

@SuppressWarnings("serial")
public class ListIsEmptyException extends Exception {

	public ListIsEmptyException() {
		super();
		
	}

	public ListIsEmptyException(String message) {
		super(message);
		
	}

}
