package com.capgemini.lms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

	@ExceptionHandler(BookNotFoundException.class)
	public ResponseEntity<Object> handleException(BookNotFoundException exception)
	{
		return new ResponseEntity<Object> (exception.getMessage(),HttpStatus.NOT_FOUND);
	}
}
