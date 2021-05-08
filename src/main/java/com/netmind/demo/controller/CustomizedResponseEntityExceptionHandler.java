package com.netmind.demo.controller;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.netmind.demo.model.EmployeeNotFoundException;
import com.netmind.demo.model.ErrorDetails;

//https://www.springboottutorial.com/spring-boot-exception-handling-for-rest-services

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler
		extends ResponseEntityExceptionHandler {
	@ExceptionHandler(EmployeeNotFoundException.class)
	public final ResponseEntity<ErrorDetails> handleUserNotFoundExeption(
			EmployeeNotFoundException ex, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(),
				ex.getMessage(), request.getDescription(false));

		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}
}
