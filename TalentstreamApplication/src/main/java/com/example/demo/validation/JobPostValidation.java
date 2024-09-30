package com.example.demo.validation;

import com.example.demo.Dto.JobPostDetailsDTO;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class JobPostValidation  implements ConstraintValidator<JobPostValidator,JobPostDetailsDTO>
{
	
	public boolean isValid(JobPostDetailsDTO jobPost, ConstraintValidatorContext context)
	{
		if(jobPost.getJobTitle()==null || jobPost.getJobTitle().isBlank()){
			addValidationError(context,"jobTitle cannot be empty");
			return false;
		}
		if(jobPost.getJobDescription()==null || jobPost.getJobDescription().isBlank()|| jobPost.getJobDescription().length()<=15)
		{
			addValidationError(context,"jobDescription cannot be empty and it should be greater than 15 characters");
			return false;
		}

		if(jobPost.getMinimumExperience()<jobPost.getMaximumExperience()) {
			addValidationError(context,"Maximum experience should be greater than or equal to minimum experience.");
			return false;
		}
		if(jobPost.getMinimumSalary()<jobPost.getMaximumSalary()) {
			addValidationError(context,"Maximum salary should be greater than or equal to minimum salary.");
			return false;
		}
		
		if(jobPost.getQualification()==null || jobPost.getQualification().isBlank()) {
			addValidationError(context,"qualification cannot be empty");
			return false;
		}
		if(jobPost.getSpecialization()==null || jobPost.getSpecialization().isBlank()) {
			addValidationError(context,"specialization cannot be empty");
			return false;
		}
		if(jobPost.getLocation()==null || jobPost.getLocation().isBlank()) {
			addValidationError(context, "location cannot be empty");
			return false;
		}
		if(jobPost.getIndustryType()==null || jobPost.getIndustryType().isBlank()) {
			addValidationError(context,"industry type cannot be empty");
			return false;
		}
		if(jobPost.getJobType()==null || jobPost.getJobType().isBlank()) {
			addValidationError(context,"jobtype cannot be empty");
			return false;
		}
		if(jobPost.getSkills().size()<1) {
			addValidationError(context,"skills must be atleast 1 ");
			return false;
		}
		return true;
	}
	 private void addValidationError(ConstraintValidatorContext context, String errorMessage) {
	        context.disableDefaultConstraintViolation();  // Disable default error message
	        context.buildConstraintViolationWithTemplate(errorMessage).addConstraintViolation();
	    }
}
