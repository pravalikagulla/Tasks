
package com.example.demo.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;



@Target({ElementType.FIELD, ElementType.PARAMETER,ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordValidation.class) 

public @interface PasswordValidator {
	public String message() default "Invalid password";
	public Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {}; 
		
}
