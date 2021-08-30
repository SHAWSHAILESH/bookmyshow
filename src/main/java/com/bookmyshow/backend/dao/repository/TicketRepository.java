package com.bookmyshow.backend.dao.repository;

import org.springframework.data.repository.CrudRepository;

import com.bookmyshow.backend.dao.models.Ticket;

public interface TicketRepository extends CrudRepository<Ticket, Long> {

}
