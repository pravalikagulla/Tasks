package com.example.demo.Dto;

import com.example.demo.validation.PasswordValidator;
import com.example.demo.validation.UniqueEmailValidator;

public class RecruiterLoginDTO {
	@UniqueEmailValidator
	private String email;

	@PasswordValidator
	private String password;
	public RecruiterLoginDTO(String email, String password) {
		this.email = email;
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
