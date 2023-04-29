package com.capgemini.moviesystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.moviesystem.model.Screen;

@Repository
public interface IScreenDao extends JpaRepository<Screen, Integer> {

	public Screen getScreenById(int id);

	public Screen getScreenByName(String name);

}