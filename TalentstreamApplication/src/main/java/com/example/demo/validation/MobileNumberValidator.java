package com.example.demo.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;



@Target({ElementType.FIELD, ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MobileNumberValidation.class) 

public @interface MobileNumberValidator {
		
public String message() default "Invalid mobilenumber";
public Class<?>[] groups() default {};
public Class<? extends Payload>[] payload() default {}; 
		

	
	
	
	

}
