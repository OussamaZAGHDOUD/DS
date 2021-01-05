package com.OZ.services;

import java.time.LocalDate;
import java.util.List;

import com.OZ.dto.TicketDto;
import com.OZ.entities.Ticket;

public interface ITicketService {
	TicketDto ajouterTicket(TicketDto ticketDto);
	Ticket modifierTicket(Ticket ticket);
	Ticket supprimerTicket(TicketDto ticket);
	Ticket chercherTicket(TicketDto ticket);
	List<Ticket> listerTicket(LocalDate date);


}
