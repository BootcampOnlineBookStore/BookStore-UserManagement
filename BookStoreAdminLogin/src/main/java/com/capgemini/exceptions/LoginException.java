package com.capgemini.exceptions;
/**
 * Class: LoginException
 * Description: LoginException is a class that is used for writing customized login exception, if the user gives wrong credentials
 * @author SAISHIVA
 * CreatedOn 2020-10-08
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
