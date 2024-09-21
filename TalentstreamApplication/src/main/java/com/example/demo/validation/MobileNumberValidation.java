
package com.example.demo.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

 public class MobileNumberValidation implements ConstraintValidator<MobileNumberValidator, String> {

    private final String pattern = "^[789]\\d{9}$";

    @Override
    public boolean isValid(String mobileNumber, ConstraintValidatorContext context) {
        if (mobileNumber == null || mobileNumber.isBlank()) {
            addValidationError(context, "Mobile Number cannot be blank");
            return false;
        }

        if (mobileNumber.length() != 10) {
            addValidationError(context, "Mobile Number length must be exactly 10 digits");
            return false;
        }

        if (!mobileNumber.matches(pattern)) {
            addValidationError(context, "Mobile Number should start with 7, 8, or 9 and contain 10 digits");
            return false;
        }

        return true;
    }

    private void addValidationError(ConstraintValidatorContext context, String errorMessage) {
        context.disableDefaultConstraintViolation();  // Disable default error message
        context.buildConstraintViolationWithTemplate(errorMessage).addConstraintViolation();
    }
}

