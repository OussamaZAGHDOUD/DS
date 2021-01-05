package com.OZ.controllers;

import java.time.LocalDate;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.OZ.dto.TicketDto;
import com.OZ.entities.Met;
import com.OZ.entities.Ticket;
import com.OZ.exceptions.TicketNotFoundException;
import com.OZ.services.IMetService;
import com.OZ.services.ITicketService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/ticket")
@AllArgsConstructor
public class TicketController {

	private ITicketService iTicketService;
	private IMetService iMetService;
	@GetMapping("/lister")
	public List<Ticket> lister( @RequestParam(name = "d")  String d) {
		LocalDate xd=LocalDate.parse(d);
		return iTicketService.listerTicket(xd);
	}
	
	@GetMapping("/get")
	public Ticket afficherTicket( @RequestBody  TicketDto ticketDto) {
		return iTicketService.chercherTicket(ticketDto);
	}
	
	@PostMapping("/ajouter")
	public TicketDto ajouter(@Valid @RequestBody TicketDto ticketDto) {
		return 	iTicketService.ajouterTicket(ticketDto);
	}
	
	@DeleteMapping("/supprimer")
	public Ticket supprimerTicket(@RequestBody TicketDto ticketDto) {
		return iTicketService.supprimerTicket(ticketDto);
	}
	
	@PostMapping("/ajouterMet")
	public Met ajouter( @RequestBody Met met) {
		return 	iMetService.ajouterMet(met);
	}
	@ExceptionHandler(TicketNotFoundException.class)
	public ResponseEntity<String> handleNoSuchElementException(TicketNotFoundException e) {
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	
}
