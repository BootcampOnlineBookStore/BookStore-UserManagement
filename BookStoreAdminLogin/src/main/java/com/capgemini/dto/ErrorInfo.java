package com.capgemini.dto;

import java.util.List;
/**
 * the class ErrorInfo is used for modifying the HTTP error into the message understandable by the user
 * @author SAISHIVA
 *@version 1.0
 */
public class ErrorInfo {

	public String message;
	public String code;
	public List<String> messages;
	
	public List<String> getMessages() {
		return messages;
	}

	public void setMessages(List<String> messages) {
		this.messages = messages;
	}

	public ErrorInfo(String code, String message) {
		super();
		this.message = message;
		this.code = code;
	}
	
	public ErrorInfo(String code, List<String> messages) {
		super();
		this.messages = messages;
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
