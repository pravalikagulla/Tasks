package com.example.demo.validation;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

 public class PasswordValidation implements ConstraintValidator<PasswordValidator, String> {

    private final String pattern1 = ".*[A-Z].*";
    private final String pattern2 = ".*[a-z].*";

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        if (password == null || password.isBlank()) {
            addValidationError(context, "password cannot be blank");
            return false;
        }
        if(password.length()<6)
        {
        	addValidationError(context,"password shouldnot be less than 6 characters");
        	return false;
        }
        

        if (!password.matches(pattern1)) {
            addValidationError(context, "password must contain atleast one uppercase letter");
            return false;
        }
        if(!password.matches(pattern2))
        {
        	addValidationError(context,"password must contain atleast one lower case letter");
        	return false;
        }
        if(!password.matches(".*\\d.*"))
        {
        	addValidationError(context,"password must contain atleast one digit");
        	return false;
        }
        if(!password.matches(".*[@$!%&].*"))
        {
        	addValidationError(context,"password must contain atleast one digit");
        	return false;
        }
       return true;
    }

    private void addValidationError(ConstraintValidatorContext context, String errorMessage) {
        context.disableDefaultConstraintViolation(); 
        context.buildConstraintViolationWithTemplate(errorMessage).addConstraintViolation();
    }
}


