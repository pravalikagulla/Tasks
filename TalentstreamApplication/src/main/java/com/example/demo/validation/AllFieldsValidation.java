package com.example.demo.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;		

@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = AllFieldsBlankValidation.class)
public @interface AllFieldsValidation {
    String message() default "All fields are required";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}


