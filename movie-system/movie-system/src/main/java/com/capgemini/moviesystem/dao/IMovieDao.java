package com.capgemini.moviesystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.moviesystem.model.Movie;

@Repository
public interface IMovieDao extends JpaRepository<Movie, Integer> {

	public Movie getByName(String name);

	public Movie getById(int id);

}
