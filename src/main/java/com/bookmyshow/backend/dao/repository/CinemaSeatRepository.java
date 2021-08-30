package com.bookmyshow.backend.dao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.bookmyshow.backend.dao.models.CinemaSeat;

public interface CinemaSeatRepository extends CrudRepository<CinemaSeat, Long> {
	@Query("FROM CinemaSeat cs WHERE cs.cinema.id=?1 AND cs.slot.id=?2")
	List<CinemaSeat> findAllWithDescriptionQuery(int cinema_id, int slot_id);
	@Query("FROM CinemaSeat cs WHERE cs.seat_id=?1")
	CinemaSeat findBySeat_Id(int seat_id);

}
