package com.capgemini.moviesystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.moviesystem.model.Theatre;

@Repository
public interface ITheatreDao extends JpaRepository<Theatre, Integer> {

	public Theatre getTheatreByName(String name);

	public Theatre getTheatreById(int id);

}
