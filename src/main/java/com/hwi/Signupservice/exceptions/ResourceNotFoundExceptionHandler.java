package com.hwi.Signupservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class ResourceNotFoundExceptionHandler {

	    @ExceptionHandler(ResourceNotFoundException.class)
	    public ResponseEntity<String> handleCustomException(ResourceNotFoundException ex) {
	        
	    	
	    	// Customize the error response
	        String errorMessage = ex.getMessage();
	        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
	        
	    }
	}



