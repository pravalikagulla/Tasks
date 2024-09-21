package com.example.demo.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CompanyNameValidation implements ConstraintValidator<CompanyNameValidator,String> {

	@Override
	public boolean isValid(String companyname,ConstraintValidatorContext context) {
		if(companyname.isBlank()) {
			addValidationError(context,"CompanyName Should not be empty");
			return false;
			
		}
		if (companyname.startsWith(" ")) {
		    addValidationError(context, "CompanyName should not start with a space");
		    return false;
		}
		if(!companyname.matches("^[A-Za-z ]+$")) {
			addValidationError(context,"CompanyName should contain only alphabets");
			return false;
		}
				
		return true;
	}
	 private void addValidationError(ConstraintValidatorContext context, String errorMessage) {
	        context.disableDefaultConstraintViolation();  // Disable default error message
	        context.buildConstraintViolationWithTemplate(errorMessage).addConstraintViolation();
	    }
	}


	

