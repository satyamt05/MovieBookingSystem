package com.capgemini.moviebookingsystem.service;





import java.util.List;

import com.capgemini.moviebookingsystem.model.Theatre;

public interface AdminService {

	public Theatre addTheatre(Theatre theatre);

	public void deleteTheatre(int id);

	public Theatre updateTheatre(Theatre theatre, int id);

	public Theatre getTheatreById(int id);

	public Theatre getTheatreByName(String name);

	public List getAllTheatres();

}
