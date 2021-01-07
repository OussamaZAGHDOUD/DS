package com.OZ.controllers;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.OZ.dto.MetDto;
import com.OZ.entities.Dessert;
import com.OZ.entities.Entree;
import com.OZ.entities.Met;
import com.OZ.entities.Plat;
import com.OZ.services.IMetService;

import lombok.AllArgsConstructor;
import lombok.Data;

@RestController
@Data
@AllArgsConstructor
@RequestMapping("/met")
public class MetController {
	private IMetService metService;
	
	@PostMapping("/ajouter/plat")
	public Plat ajouterPlat( @RequestBody Plat plat) {	
		return metService.ajouterPlat(plat);
	}
	
	@PostMapping("/ajouter/entree")
	public Entree ajouterEntree(@Valid @RequestBody Entree entree) {	
		return metService.ajouterEntree(entree);
	}

	@PostMapping("/ajouter/dessert")
	public Dessert ajouterDessert(@Valid @RequestBody Dessert dessert) {	
		return metService.ajouterDessert(dessert);
	}
	
	
	
	@DeleteMapping("/supprimer/dessert")
	public Dessert supprimerDessert(@Valid @RequestBody Dessert dessert) {	
		return metService.supprimerDessert(dessert);
	}
	
	@DeleteMapping("/supprimer/entree")
	public Entree supprimerEntree(@Valid @RequestBody Entree entree) {	
		return metService.supprimerEntree(entree);
	}
	@DeleteMapping("/supprimer/plat")
	public Plat supprimerPlat(@Valid @RequestBody Plat plat) {	
		return metService.supprimerPlat(plat);
	}
	
	@PutMapping("/modifier/plat")
	public Plat modifierPlat(@Valid @RequestBody Plat plat) {
		System.out.println("++++++++++++plat = "+plat);
		return metService.modifierPlat(plat);
	}
	
	@PutMapping("/modifier/entree")
	public Entree modifierEntree(@Valid @RequestBody Entree entree) {
		return metService.modifierEntree(entree);
	}
	
	@PutMapping("/modifier/dessert")
	public Dessert modifierDessert(@Valid @RequestBody Dessert dessert) {
		return metService.modifierDessert(dessert);
	}
	@GetMapping("/listerMets")
	public List<Met> listerMets (){
		return metService.listerMets();
	}
	
	@GetMapping("/plusAcheter/{d1}/{d2}")
	public MetDto platPlusAcheter(@PathVariable("d1") String d1,@PathVariable("d2") String d2) {
		
		LocalDate dd1=LocalDate.parse(d1);
		LocalDate dd2=LocalDate.parse(d2);
		if(dd1.isAfter(dd2))
			throw new DateTimeException("Date invalide ");
		
		return metService.platPlusAcheter(dd1,dd2);
	}
	
	
	
}
