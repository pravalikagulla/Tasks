package com.example.demo.Dto;

import java.util.List;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class JobPostDetailsDTO {
	
@NotBlank(message = "please enter a valid jobTitle")
	private String jobTitle;

@Size(min = 15 , message = "Description is required and must be at least 15 characters long")
	private String jobDescription;
@Min(value = 0 ,message = "minimum experience is required")
	private int  minimumExperience;

@Min(value = 0 , message = "maximum experience is required")
	private int maximumExperience;

@Min(value = 0, message = "minimum salary is required")
	private double minimumSalary;
@Min(value = 0, message = "maximum salary is required")	
	private double maximumSalary;
@NotBlank(message = "qualification is required")	
	private String qualification;
@NotBlank(message = "specialization is required")	
	private String specialization;
@NotBlank(message = "location is required")	
	private String location;
@NotBlank(message = "industry type is required")	
	private String industryType;
@NotBlank(message = "job type is required")	
	private String jobType;
@NotBlank(message = "please select atleast one skill")
private List<String> skills;
	


	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public int getMinimumExperience() {
		return minimumExperience;
	}

	public void setMinimumExperience(int minimumExperience) {
		this.minimumExperience = minimumExperience;
	}

	public int getMaximumExperience() {
		return maximumExperience;
	}

	public void setMaximumExperience(int maximumExperience) {
		this.maximumExperience = maximumExperience;
	}

	public double getMinimumSalary() {
		return minimumSalary;
	}

	public void setMinimumSalary(float minimumSalary) {
		this.minimumSalary = minimumSalary;
	}

	public double getMaximumSalary() {
		return maximumSalary;
	}

	public void setMaximumSalary(float maximumSalary) {
		this.maximumSalary = maximumSalary;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getIndustryType() {
		return industryType;
	}

	public void setIndustryType(String industryType) {
		this.industryType = industryType;
	}

	public String getJobType() {
		return jobType;
	}

	public void setJobType(String jobType) {
		this.jobType = jobType;
	}

	
	public List<String> getSkills() {
		return skills;
	}

	public void setSkills(List<String> skills) {
		this.skills = skills;
	}
	public JobPostDetailsDTO() {
	}
	public JobPostDetailsDTO(String jobTitle, String jobDescription, int minimumExperience, int maximumExperience,
			double minimumSalary, double maximumSalary, String qualification, String specialization, String location,
			String industryType, String jobType, List<String> skills) {

		this.jobTitle = jobTitle;
		this.jobDescription = jobDescription;
		this.minimumExperience = minimumExperience;
		this.maximumExperience = maximumExperience;
		this.minimumSalary = minimumSalary;
		this.maximumSalary = maximumSalary;
		this.qualification = qualification;
		this.specialization = specialization;
		this.location = location;
		this.industryType = industryType;
		this.jobType = jobType;
		this.skills = skills;
	}
}
