package com.OZ.services;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.OZ.dto.ClientDto;
import com.OZ.entities.Client;
import com.OZ.entities.Ticket;
import com.OZ.exceptions.ClientNotFoundException;
import com.OZ.repositories.ClientRepository;
import com.OZ.repositories.TicketRepository;

import lombok.AllArgsConstructor;
import lombok.Data;

@Service
@Data
@AllArgsConstructor
public class ClientService implements IClientService {
	private ClientRepository clientRepository;
	private TicketRepository ticketRepository;
	private ModelMapper mapper;

	@Override
	public ClientDto ajouterClient(ClientDto clientDto) {
		Client client = mapper.map(clientDto, Client.class);
		client = clientRepository.save(client);
		clientDto = mapper.map(client, ClientDto.class);
		return clientDto;
	}

	@Override
	public ClientDto modifierClient(ClientDto clientDto) {

		Client oldClient = this.chercherClient(clientDto.getId());
		Client newClient = mapper.map(clientDto, Client.class);
		newClient.setTickets(oldClient.getTickets());
		newClient = clientRepository.save(newClient);
		return mapper.map(newClient, ClientDto.class);

	}

	@Override
	public Client chercherClient(Integer id) {
		Optional<Client> opt = clientRepository.findById(id);
		Client client = opt.orElseThrow(() -> new ClientNotFoundException());
		return client;
	}

	@Override
	public void supprimerClient(ClientDto clientDto) {
		System.out.println(" Id             *********      =" + clientDto.getId());
		this.chercherClient(clientDto.getId());
		clientRepository.deleteById(clientDto.getId());
	}

	@Override
	public List<ClientDto> listerClients() {
		List<ClientDto> liste = clientRepository.findAll().stream().map(c -> mapper.map(c, ClientDto.class))
				.collect(Collectors.toList());
		return liste;
	}

	@Override
	public ClientDto clientPlusFidele() {
		List<Ticket> listOfTickets = ticketRepository.findAll();
		List<Client> listOfClients = listOfTickets.stream().map(t -> t.getClient()).collect(Collectors.toList());
		List<Client> listDist = listOfClients.stream().distinct().collect(Collectors.toList());
		int max = 0;
		Client plusF = null;
		for (Client c : listDist) {
			int frequence = Collections.frequency(listOfClients, c);
			if (max < frequence)
				max = frequence;
			plusF = c;
		}
		return mapper.map(plusF, ClientDto.class);
	}

	@Override
	public DayOfWeek getJourPlusReserve(ClientDto clientDto) {
		Client c = clientRepository.findById(clientDto.getId()).orElseThrow(() -> new ClientNotFoundException());
		List<Ticket> listOfTickets = ticketRepository.findAll().stream().filter(t->(t.getClient().getId()==c.getId()))
				.collect(Collectors.toList());

		List<DayOfWeek> listOfDays = listOfTickets.stream().map(t -> t.getDate().getDayOfWeek())
				.collect(Collectors.toList());
		
		int max = 0;
		DayOfWeek day = null;
		for (DayOfWeek d : listOfDays.stream().distinct().collect(Collectors.toList())) {

			int nbr = Collections.frequency(listOfDays, d);
			if (max < nbr) {
				max = nbr;
				day = d;
			}
		}

		return day;
	}

}
