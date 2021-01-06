package com.OZ.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.OZ.entities.Dessert;
import com.OZ.entities.Entree;
import com.OZ.entities.Met;
import com.OZ.entities.Plat;
import com.OZ.exceptions.MetNotFoundException;
import com.OZ.repositories.DessertRepository;
import com.OZ.repositories.EntreeRepository;
import com.OZ.repositories.MetRepository;
import com.OZ.repositories.PlatRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MetService implements IMetService {

	private MetRepository metRepository;
	private PlatRepository platRepository;
	private EntreeRepository entreeRepository;
	private DessertRepository dessertRepository;

	@Override
	public Plat ajouterPlat(Plat plat) {
		return platRepository.save(plat);
	}

	@Override
	public Entree ajouterEntree(Entree entree) {
		return entreeRepository.save(entree);
	}

	@Override
	public Dessert ajouterDessert(Dessert dessert) {
		return dessertRepository.save(dessert);
	}

	@Override
	public Plat supprimerPlat(Plat plat) {
		Met m = this.chercherMet(plat);
		metRepository.deleteById(plat.getId());
		return (Plat) m;
	}

	@Override
	public Entree supprimerEntree(Entree entree) {
		Met e = this.chercherMet(entree);
		metRepository.deleteById(entree.getId());
		return (Entree) e;
	}

	@Override
	public Dessert supprimerDessert(Dessert dessert) {
		Met d = this.chercherMet(dessert);
		metRepository.deleteById(dessert.getId());
		return (Dessert) d;
	}

	@Override
	public Met chercherMet(Met met) {
		if(met.getId()==null)
			throw new MetNotFoundException();
		
		Met m = metRepository.findById(met.getId()).orElseThrow(() -> new MetNotFoundException());
		return m;
	}

	@Override
	public Plat modifierPlat(Plat plat) {
		System.out.println("plat ======="+plat);
		Plat p=(Plat)this.chercherMet(plat);
		p.setNom(plat.getNom());
		p.setPrix(plat.getPrix());
		p.setTickets(plat.getTickets());
		return platRepository.save(p);
	}

	@Override
	public Entree modifierEntree(Entree entree) {
		Entree e=(Entree)this.chercherMet(entree);
		e.setNom(entree.getNom());
		e.setPrix(entree.getPrix());
		e.setTickets(entree.getTickets());
		return entreeRepository.save(e);
	}

	@Override
	public Dessert modifierDessert(Dessert dessert) {
		Dessert d=(Dessert)this.chercherMet(dessert);
		d.setNom(dessert.getNom());
		d.setPrix(dessert.getPrix());
		d.setTickets(dessert.getTickets());
		return dessertRepository.save(d);
	}

	@Override
	public List<Met> listerMets() {
		return metRepository.findAll();
	}

}
