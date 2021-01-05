package com.OZ.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.OZ.dto.ClientDto;
import com.OZ.entities.Client;
import com.OZ.exceptions.ClientNotFoundException;
import com.OZ.repositories.ClientRepository;

import lombok.AllArgsConstructor;
import lombok.Data;

@Service
@Data
@AllArgsConstructor
public class ClientService implements IClientService{
	private ClientRepository clientRepository;
	private ModelMapper mapper;

	@Override
	public ClientDto ajouterClient(ClientDto clientDto) {
		Client client = mapper.map(clientDto, Client.class);
		client = clientRepository.save(client);
		clientDto=mapper.map(client , ClientDto.class);
		return clientDto;
	}

	@Override
	public ClientDto modifierClient(ClientDto clientDto) {
		
		Client oldClient=this.chercherClient(clientDto.getId());		
		Client newClient=mapper.map(clientDto, Client.class);
		newClient.setTickets(oldClient.getTickets());
	    newClient= clientRepository.save(newClient);
		return mapper.map(newClient, ClientDto.class);
		
	}

	@Override
	public Client chercherClient(Integer id) {
		Optional<Client> opt =clientRepository.findById(id);
		Client client = opt.orElseThrow( () ->new ClientNotFoundException() ) ;
		return client;
	}

	@Override
	public void supprimerClient(ClientDto clientDto) {
		System.out.println(" Id             *********      ="+clientDto.getId());
		this.chercherClient(clientDto.getId());
		clientRepository.deleteById(clientDto.getId());
	}

	@Override
	public List<ClientDto> listerClients() {
		List<ClientDto> liste = clientRepository
						.findAll()
						.stream()
						.map(c->mapper.map(c,ClientDto.class))
						.collect(Collectors.toList());
		return liste;
	}
	
	

}
