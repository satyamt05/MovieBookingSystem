package com.capgemini.moviebookingsystem.service;

import java.util.List;

import com.capgemini.moviebookingsystem.model.Theatre;

public interface CustomerService {

	public Theatre getTheatreById(int id);

	public Theatre getTheatreByName(String name);

	public List<Theatre> getAllTheatres();

}
