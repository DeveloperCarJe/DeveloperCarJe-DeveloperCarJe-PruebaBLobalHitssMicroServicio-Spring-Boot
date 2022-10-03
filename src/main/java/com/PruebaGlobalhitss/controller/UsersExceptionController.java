package com.PruebaGlobalhitss.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.PruebaGlobalhitss.exception.UsersNotFoundException;

public class UsersExceptionController {

	@ExceptionHandler(value = UsersNotFoundException.class)
	public ResponseEntity<String> exception(UsersNotFoundException exception){
		return new ResponseEntity<String>("User not found", HttpStatus.NOT_FOUND);
	}
}
