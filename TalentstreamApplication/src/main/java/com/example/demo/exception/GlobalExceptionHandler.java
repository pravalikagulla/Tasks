package com.example.demo.exception;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;



@ControllerAdvice
public class GlobalExceptionHandler {

@ExceptionHandler(MethodArgumentNotValidException.class)
@ResponseStatus(HttpStatus.UNAUTHORIZED)
public ResponseEntity<Map<String,String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
    	Map<String,String>m=new HashMap<>();
    	List<String> fieldOrder = Arrays.asList("companyname","email","mobileNumber","password");
    	boolean allFieldsEmpty = fieldOrder.stream().allMatch(field ->
    	         ex.getBindingResult().getFieldErrors().stream()
    	          .anyMatch(error -> error.getField().equals(field) && (error.getRejectedValue() == null || error.getRejectedValue().toString().trim().isEmpty())));
    		
    	if(allFieldsEmpty) {
    	    m.put("message", "All Fields are required");
    	    return new ResponseEntity<>(m, HttpStatus.UNAUTHORIZED);
    	    }
    	    
    for(String field:fieldOrder) {
     for(FieldError firstError:ex.getBindingResult().getFieldErrors()) {
           if(firstError.getField().equals(field)) {
        	 m.put(field,firstError.getDefaultMessage());
        	 return new ResponseEntity<>(m,HttpStatus.UNAUTHORIZED);
           }
     }
    }
      return new ResponseEntity<>(m, HttpStatus.UNAUTHORIZED);
    	}
@ExceptionHandler(CustomException.class)
public ResponseEntity<Map<String,String>> handleFieldValidationException(CustomException ex) {
    Map<String,String>m = new HashMap<>();
    m.put(ex.getField(), ex.getMessage());
    return new ResponseEntity<>(m, HttpStatus.BAD_REQUEST);
}
}

