package com.example.demo.entity;



import java.util.List;

import com.example.demo.validation.AllFieldsValidation;
import com.example.demo.validation.CompanyNameValidator;
import com.example.demo.validation.MobileNumberValidator;
import com.example.demo.validation.PasswordValidator;
import com.example.demo.validation.UniqueEmailValidator;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

@Entity
@AllFieldsValidation(message = "All fields are mandatory")
public class Recruiter {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank(message = "companyname is required")
	@CompanyNameValidator
	private String companyname;
	
	@NotBlank(message = "email is required")
	@Column(unique = true)
	@UniqueEmailValidator
	private String email;
	
 
    @NotEmpty(message = "mobilenumber is required")
    @MobileNumberValidator
    private String mobileNumber;
    
	@NotEmpty(message = "password is required")
    @PasswordValidator
	private String password;
	
@OneToMany (cascade = CascadeType.ALL)
private List<JobPostDetailsEntity> jobPosts;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public List<JobPostDetailsEntity> getJobPosts() {
		return jobPosts;
	}
	public void setJobPosts(List<JobPostDetailsEntity> jobPosts) {
		this.jobPosts = jobPosts;
	}
	public Recruiter() {
	}
	public Recruiter(int id, @NotBlank(message = "companyname is required") String companyname,
			@NotBlank(message = "email is required") String email,
			@NotEmpty(message = "mobilenumber is required") String mobileNumber,
			@NotEmpty(message = "password is required") String password, List<JobPostDetailsEntity> jobPosts) {
		super();
		this.id = id;
		this.companyname = companyname;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.password = password;
		this.jobPosts = jobPosts;
	}
	
	 
	 
	
	  

}
