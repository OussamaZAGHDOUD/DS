package com.OZ.services;

import java.time.LocalDate;
import java.util.List;

import com.OZ.dto.TicketDto;
import com.OZ.entities.Ticket;

public interface ITicketService {
	TicketDto ajouterTicket(TicketDto ticketDto);
	Ticket supprimerTicket(TicketDto ticketDto);
	Ticket chercherTicket(TicketDto ticketDto);
	List<Ticket> listerTicket(LocalDate date);

	public double getAdd(TicketDto ticket) ;
	
	public double getRevenue(LocalDate d,String s);
	
 public double	getRevenuePourPeriode(LocalDate d1,LocalDate d2);

}
