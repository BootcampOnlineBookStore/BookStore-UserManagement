package com.capgemini.dto;

/**
 * Class: ErrorInfo
 * Description : the class ErrorInfo is used for modifying the HTTP error into the message understandable by the user
 * @author SAISHIVA
 *@version 1.0
 * CreatedOn: 2020-10-07
 */
public class ErrorInfo {

	public String message;
	public String code;
	
	
	
	public ErrorInfo(String code, String message) {
		super();
		this.message = message;
		this.code = code;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
		
}
