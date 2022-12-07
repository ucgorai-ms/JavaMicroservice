package com.practice.custom.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExceptionDetails> handleAllExceptions(Exception ex, WebRequest request) throws Exception {
		
		ExceptionDetails exceptionDetails = new ExceptionDetails(LocalDateTime.now(), 
				ex.getMessage(), 
				request.getDescription(false)
				);
		
		return new ResponseEntity<ExceptionDetails>(exceptionDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<ExceptionDetails> handleUserNotFoundExceptions(Exception ex, WebRequest request) throws Exception {
		
		ExceptionDetails exceptionDetails = new ExceptionDetails(LocalDateTime.now(), 
				ex.getMessage(), 
				request.getDescription(false)
				);
		
		return new ResponseEntity<ExceptionDetails>(exceptionDetails, HttpStatus.BAD_REQUEST);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

		ExceptionDetails exceptionDetails = new ExceptionDetails(LocalDateTime.now(), 
				ex.getMessage(), 
				request.getDescription(false)
				);
		
		return new ResponseEntity<Object>(exceptionDetails, HttpStatus.BAD_REQUEST);
	}

}
