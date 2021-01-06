package com.OZ.services;

import java.time.LocalDate;
import java.util.List;

import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.OZ.dto.MetDto;
import com.OZ.dto.TicketDto;
import com.OZ.entities.Client;
import com.OZ.entities.Met;
import com.OZ.entities.TableResto;
import com.OZ.entities.Ticket;
import com.OZ.exceptions.TableNotFoundException;
import com.OZ.exceptions.TicketNotFoundException;
import com.OZ.repositories.TableRepository;
import com.OZ.repositories.TicketRepository;

import lombok.AllArgsConstructor;
import lombok.Data;

@Service
@Data
@AllArgsConstructor
public class TicketService implements ITicketService {
	private ModelMapper mapper;
	private TicketRepository ticketRepository;
	private IClientService iClientService;
	private IMetService iMetService;
	private TableRepository tableRepository;

	@Override
	public TicketDto ajouterTicket(TicketDto ticketDto) {
		
		Client client = iClientService.chercherClient(ticketDto.getClient().getId());
		TableResto table = tableRepository.findById(ticketDto.getTableResto().getNumero())
				.orElseThrow(() -> new TableNotFoundException());

		List<MetDto> listOfMetsDto = ticketDto.getMets();
		List<Met> listOfMets;
		Ticket ticket = mapper.map(ticketDto, Ticket.class);
		if (listOfMetsDto != null) {
			listOfMets = listOfMetsDto.stream().map(m -> iMetService.chercherMet(mapper.map(m, Met.class)))
					.collect(Collectors.toList());
			ticket.setMets(listOfMets);
		}

		ticket.setClient(client);
		ticket.setTableResto(table);
		ticket = ticketRepository.save(ticket);
		return mapper.map(ticket, TicketDto.class);
	}

	

	@Override
	public Ticket supprimerTicket(TicketDto ticketDto) {
		Ticket t = chercherTicket(ticketDto);
		ticketRepository.deleteById(ticketDto.getNumero());
		return t;
	}

	@Override
	public Ticket chercherTicket(TicketDto ticketDto) {
		Optional<Ticket> opt = ticketRepository.findById(ticketDto.getNumero());
		return opt.orElseThrow(() -> new TicketNotFoundException());
	}

	@Override
	public List<Ticket> listerTicket(LocalDate date) {
		return ticketRepository.findAll().stream().filter(t -> t.getDate().toLocalDate().equals(date))
				.collect(Collectors.toList());
	}

}
