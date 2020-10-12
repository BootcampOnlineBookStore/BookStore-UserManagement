package com.capgemini.exceptions;
/**
 * LoginException is a class that is used for writing customized login exception, if the user gives wrong credentials
 * @author SAISHIVA
 *
 */
@SuppressWarnings("serial")
public class LoginException extends Exception{

	public LoginException() {
		super();
		
	}

	public LoginException(String arg0) {
		super(arg0);
	}

}
