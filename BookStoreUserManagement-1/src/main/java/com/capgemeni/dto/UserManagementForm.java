package com.capgemeni.dto;

import java.time.LocalDate;

public class UserManagementForm {
	
	
	private String email;
	private String userId;
	private String fullName;
	private String password;
	private LocalDate updatedDate;
	
	public UserManagementForm() {
		super();
		
	}

	public UserManagementForm(String email, String userId, String fullName, String password,
			LocalDate updatedDate) {
		super();
		this.email = email;
		this.userId = userId;
		this.fullName = fullName;
		this.password = password;
		this.updatedDate = updatedDate;
	}

	public UserManagementForm(String email, String fullName, String password, LocalDate updatedDate) {
		super();
		this.email = email;
		this.fullName = fullName;
		this.password = password;
		this.updatedDate = updatedDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDate getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDate updatedDate) {
		this.updatedDate = updatedDate;
	}
	}
