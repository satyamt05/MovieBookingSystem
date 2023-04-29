package com.capgemini.moviesystem.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capgemini.moviesystem.model.Show;

@Repository
public interface IShowDao extends JpaRepository<Show, Integer> {

	// query to fetch the details of show through movie id.
	@Query("select s from Show s where s.movieId.id=:id")
	public List<Show> getShowsByMovieId(@Param("id") int movieId);

}
