package com.OZ.controllers;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.OZ.entities.TableResto;
import com.OZ.services.ITableService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/table")
public class TableController {

	private ITableService iTableService;

	@PostMapping("/ajouter")
	public TableResto ajouterTable(@Valid @RequestBody TableResto tableRsto) {
		return iTableService.ajouterTable(tableRsto);
	}
	
	@PutMapping("/modifier")
	public TableResto modifierTable(@Valid @RequestBody TableResto tableResto) {
		return iTableService.modifierTable(tableResto);
	}
	
	@DeleteMapping("/supprimer")
	public TableResto supprimerTable(@Valid @RequestBody  TableResto tableResto) {
		return iTableService.supprimerTable(tableResto);
	}
	
	@GetMapping("/chercher")
	public TableResto getTable(@Valid @RequestBody TableResto tableResto) {
		return iTableService.chercherTable(tableResto);
	}
	
	@GetMapping("/plusReservee")
	public TableResto plusReserve() {
		return iTableService.plusReserve();
	}
	
	
	
	

}
