package com.capgemini.moviebookingsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.capgemini.moviebookingsystem.model.Theatre;

@Repository
public interface TheatreRepository extends JpaRepository<Theatre, Integer> {

	public Theatre getTheatreByName(String name);

	public Theatre getTheatreById(int id);

}
