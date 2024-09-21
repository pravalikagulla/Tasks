//package com.example.demo.validation;
//
//import javax.validation.ConstraintValidator;
//
//import org.springframework.beans.factory.annotation.Autowired;
//
//import com.example.demo.repository.RecruiterRepository;
//
//// this class will have validations
//public class UniqueEmailValidation implements ConstraintValidator<UniqueEmailValidator, String>{
//	
//	public boolean isValid(String value, ConstraintValidator context)
//	
//	@Autowired
//	private RecruiterRepository rep;
//	public UniqueEmailValidation(RecruiterRepository rep)
//	{
//		this.rep=rep;
//	}
//	 if(rep.findByEmailAddress(value).size() == 0)
//	 {
//		 return true;
//	 }
//	 else {
//		 return false;
//	 }
//	
//}
package com.example.demo.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;



// this class will have validations
@Component
public class UniqueEmailValidation implements ConstraintValidator<UniqueEmailValidator, String> {

	private static final String pattern= "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

	@Override
	public boolean isValid(String email, ConstraintValidatorContext context)
	{
		 if(email.isEmpty()|| email.isBlank())
		    {
		    	context.disableDefaultConstraintViolation();
	            context.buildConstraintViolationWithTemplate("email is required")
	                   .addConstraintViolation();
	            return false;
		    }
	    if (!email.matches(pattern))
	    {
	           context.disableDefaultConstraintViolation();
	            context.buildConstraintViolationWithTemplate("Invalid email address format")
	                   .addConstraintViolation();
	            return false;
		  }
	    return true;
	    
	}
}


