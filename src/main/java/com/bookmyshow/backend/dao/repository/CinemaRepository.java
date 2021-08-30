package com.bookmyshow.backend.dao.repository;

import org.springframework.data.repository.CrudRepository;

import com.bookmyshow.backend.dao.models.Cinema;

public interface CinemaRepository extends CrudRepository<Cinema, Long> {
	
}
