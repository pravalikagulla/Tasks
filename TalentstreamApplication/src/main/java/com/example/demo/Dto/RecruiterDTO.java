package com.example.demo.Dto;

import com.example.demo.validation.CompanyNameValidator;
import com.example.demo.validation.MobileNumberValidator;
import com.example.demo.validation.PasswordValidator;
import com.example.demo.validation.UniqueEmailValidator;

public class RecruiterDTO {
	
@CompanyNameValidator	
private String companyname;

@UniqueEmailValidator
private String email;

@MobileNumberValidator
private String mobileNumber;

@PasswordValidator
private String password;

	public RecruiterDTO(String companyname, String email, String mobileNumber, String password) {
		this.companyname = companyname;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.password = password;
	}
	public RecruiterDTO() {
	}
	
	public String getCompanyname() {
		return companyname;
	}
	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}


}
