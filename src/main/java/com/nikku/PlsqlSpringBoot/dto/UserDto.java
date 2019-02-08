package com.nikku.PlsqlSpringBoot.dto;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class UserDto {
	private int userId;
	@NotBlank
	private String name;
	@NotBlank
	@Email
	private String email;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
