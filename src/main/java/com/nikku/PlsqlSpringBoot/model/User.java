package com.nikku.PlsqlSpringBoot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "PlsqlUserTable")
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(name = "getAllUsers_procedure",
                                    procedureName = "getAllUsers_procedure",
        resultClasses = User.class)
})
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", email=" + email + "]";
	}

	public User(int userId, @NotBlank String name, @NotBlank @Email String email) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

}