package com.OZ.services;

import java.time.LocalDate;
import java.time.Period;
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

		List<MetDto> listMetDto = ticketDto.getMets();
		List<Met> lis = listMetDto.stream().map((s) -> iMetService.chercherMet(iMetService.metMapper(s)))
				.collect(Collectors.toList());
		ticketDto.setMets(null);
		Ticket ticket = mapper.map(ticketDto, Ticket.class);
		ticket.setMets(lis);
		ticket.setClient(client);
		ticket.setTableResto(table);
		ticket = ticketRepository.save(ticket);
		ticketDto = mapper.map(ticket, TicketDto.class);
		return ticketDto;
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

	public double getAdd(TicketDto ticket) {
		return chercherTicket(ticket).getAddition();
	}

	@Override
	public double getRevenue(LocalDate d, String s) {
		Period p;
		if (s.equalsIgnoreCase("jour"))
			p = Period.ofDays(1);
		else if (s.equalsIgnoreCase("semaine"))
			p = Period.ofWeeks(1);
		else if (s.equalsIgnoreCase("mois"))
			p = Period.ofMonths(1);
		else
			p = Period.ZERO;
		double revenue = ticketRepository.findAll().stream()
				.filter(t -> (t.getDate().toLocalDate().isAfter(d) || t.getDate().toLocalDate().isEqual(d))
						&& t.getDate().toLocalDate().isBefore(d.plus(p)))
				.mapToDouble(t -> t.getAddition()).sum();
		return revenue;
	}

	@Override
	public double getRevenuePourPeriode(LocalDate d1, LocalDate d2) {

		double revenue = ticketRepository.findAll().stream()
				.filter(t -> (t.getDate().toLocalDate().isAfter(d1) || t.getDate().toLocalDate().isEqual(d1))
						&& t.getDate().toLocalDate().isBefore(d2))
				.mapToDouble(t -> t.getAddition()).sum();
		return revenue;
	}
}
