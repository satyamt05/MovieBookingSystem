package com.capgemini.moviebookingsystem.exception;

public class TheatreListEmptyException extends RuntimeException {
	
	
	public TheatreListEmptyException(String msg) {
		super(msg);
		System.err.println(msg);
	}

}
