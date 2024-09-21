package com.example.demo.validation;

import com.example.demo.entity.Recruiter;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class AllFieldsBlankValidation implements ConstraintValidator<AllFieldsValidation, Recruiter> {

    public boolean isValid(Recruiter recruiter, ConstraintValidatorContext context) {
        if (recruiter.getCompanyname().isBlank() && recruiter.getEmail().isBlank() &&recruiter.getMobileNumber().isBlank() && recruiter.getPassword().isBlank()) {
            return false;
        }
        return true;
    }
}
