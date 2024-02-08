package com.stackroute.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	    @ExceptionHandler(BlogNotFoundException.class)
		public ResponseEntity<?> handleBlogNotFoundException(BlogNotFoundException exception){
			return new ResponseEntity<>(exception.getMessage(),HttpStatus.NOT_FOUND);
		}
	    
	    @ExceptionHandler(BlogAlreadyExistsException.class)
	    public ResponseEntity<?> handleBlogAlreadyExistsException(BlogAlreadyExistsException exception){
	    	return new ResponseEntity<>(exception.getMessage(),HttpStatus.CONFLICT);
	    }
	

}
