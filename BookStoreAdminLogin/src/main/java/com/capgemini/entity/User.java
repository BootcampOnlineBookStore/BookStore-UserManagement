package com.capgemini.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicInsert
@DynamicUpdate
@Table(name="user_management")
public class User {
	@Id
	@Column(name="email_id")
	private String email;
	@Column(name="user_id",length=30)
	private String userId;
	@Column(name="full_name",length=30)
	private String fullName;
	@Column(name="password")
	private String password;
	@Column(name="updated_date")
	private LocalDate updatedDate;
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
	@Override
	public String toString() {
		return "email=" + email + ", userId=" + userId + ", fullName=" + fullName + ", password=" + password
				+ ", updatedDate=" + updatedDate;
	}
	
	
	
	

}
