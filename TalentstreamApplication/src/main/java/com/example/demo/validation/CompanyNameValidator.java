package com.example.demo.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;



@Target({ElementType.FIELD, ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CompanyNameValidation.class)
public @interface CompanyNameValidator {
    String message() default "Invalid company name";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
		
}


