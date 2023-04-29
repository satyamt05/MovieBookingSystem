package com.capgemini.moviebookingsystem.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.moviebookingsystem.exception.TheatreListEmptyException;
import com.capgemini.moviebookingsystem.exception.TheatreNotFoundException;

@RestController
@ControllerAdvice
public class GlobalErrorHandler {

	Logger logger = LoggerFactory.getLogger(GlobalErrorHandler.class);

	@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Theatre with valid details not found")
	@ExceptionHandler(TheatreNotFoundException.class)
	public void handleTheatreNotFoundException() {
		logger.trace("Error Handler--Theatre Not Found");
		// Theater not found exception

	}

	@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Theatre list is empty")
	@ExceptionHandler(TheatreListEmptyException.class)
	public void handleTheatreListEmptyException() {
		logger.trace("Error Handler--Theatre List is Empty");
		// Theater list empty exception

	}

}
