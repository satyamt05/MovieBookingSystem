package com.capgemini.moviebookingsystem.exception;

public class TheatreNotFoundException extends RuntimeException {

	public TheatreNotFoundException(String msg) {
		super(msg);
		System.err.println(msg);
	}

}
