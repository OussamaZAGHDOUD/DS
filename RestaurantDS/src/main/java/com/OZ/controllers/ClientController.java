package com.OZ.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.OZ.dto.ClientDto;
import com.OZ.entities.Client;
import com.OZ.exceptions.ClientNotFoundException;
import com.OZ.repositories.ClientRepository;
import com.OZ.services.IClientService;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@RestController
@RequestMapping("/client")
public class ClientController {
	private ClientRepository clientRepository;
	private IClientService iClientService;	
	
	
	/*
	 * @PostMapping("/ajouter") public ClientDto ajouter( @Valid @RequestBody
	 * ClientDto clientDto) {
	 * 
	 * return iClientService.ajouterClient(clientDto); }
	 */
	
	@PostMapping("/ajouter") 
	public ResponseEntity< ClientDto> ajouter( @Valid @RequestBody ClientDto clientDto) {
			 return new ResponseEntity<ClientDto>(iClientService.ajouterClient(clientDto), HttpStatus.CREATED) ;
			 }
	
	@DeleteMapping("/supprimer")
	public ResponseEntity<String> supprimer(@RequestBody ClientDto clientDto){
		System.out.println("id  *****    ="+ clientDto.getId());
		iClientService.supprimerClient(clientDto);
		return new ResponseEntity<String>("Client supprimé avec succes !", HttpStatus.OK);
		
	}
	
	@GetMapping("/listerClients")
	public List<ClientDto> ListerClients()
	{
		return iClientService.listerClients();
	}
	
	@PutMapping("/modifier")
	public ClientDto modifier( @Valid @RequestBody ClientDto clientDto) {
		return iClientService.modifierClient(clientDto);
	}
	
	@ExceptionHandler(ClientNotFoundException.class)
	public ResponseEntity<String> handleNoSuchElementException(ClientNotFoundException e) {
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	}
}
