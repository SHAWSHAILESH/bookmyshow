package com.bookmyshow.backend.dao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.bookmyshow.backend.dao.models.CinemaMovieSlotMapping;

public interface CinemaMovieSlotMappingRepository extends CrudRepository<CinemaMovieSlotMapping, Long> {
	@Query("FROM CinemaMovieSlotMapping cms WHERE cms.cinema.city.id=?1")
	List<CinemaMovieSlotMapping> findAllWithDescriptionQuery(int id);
	@Query("FROM CinemaMovieSlotMapping cms WHERE cms.cinema.city.id=?1 AND cms.movie.id=?2")
	List<CinemaMovieSlotMapping> findAllWithDescriptionQuery(int city_id, int movie_id);
}
