package com.OZ.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.OZ.entities.Ticket;

public interface TicketRepository extends JpaRepository<Ticket	,Integer>{

}
