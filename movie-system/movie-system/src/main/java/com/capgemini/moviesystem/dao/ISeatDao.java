package com.capgemini.moviesystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.moviesystem.model.Seat;

@Repository
public interface ISeatDao extends JpaRepository<Seat, Integer> {

}