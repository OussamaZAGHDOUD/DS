package com.OZ.services;

import java.time.DayOfWeek;
import java.util.List;

import com.OZ.dto.ClientDto;
import com.OZ.entities.Client;

public interface IClientService {
	
	ClientDto ajouterClient(ClientDto clientDto);
	ClientDto modifierClient(ClientDto clientDto);
	Client chercherClient(Integer id) ;
	void supprimerClient(ClientDto clientDto);
	List<ClientDto> listerClients();
	
	
	ClientDto clientPlusFidele();

	DayOfWeek getJourPlusReserve(ClientDto clientDto);
	
}
