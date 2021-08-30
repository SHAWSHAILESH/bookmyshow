package com.bookmyshow.backend.dao.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.bookmyshow.backend.dao.models.CinemaMovieSlotMapping;
import com.bookmyshow.backend.dao.models.Movie;

public interface MovieRepository extends CrudRepository<Movie, Long> {
	@Query("FROM Movie m WHERE m.id=?1")
	Movie findAllWithDescriptionQuery(int id);

	List<Movie> findByIdIn(ArrayList<Integer> movie_ids);

	Movie findById(int movie_id);
}
