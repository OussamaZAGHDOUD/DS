package com.OZ.services;

import java.util.List;

import com.OZ.entities.Dessert;
import com.OZ.entities.Entree;
import com.OZ.entities.Met;
import com.OZ.entities.Plat;

public interface IMetService {
	
	List<Met> listerMets();
	Met chercherMet(Met met);
	
	Plat ajouterPlat(Plat plat);
	Entree ajouterEntree(Entree	entree);
	Dessert ajouterDessert(Dessert Dessert);
	
	
	Plat supprimerPlat(Plat plat);
	Entree supprimerEntree(Entree	entree);
	Dessert supprimerDessert(Dessert Dessert);
	
	
	Plat modifierPlat(Plat plat);
	Entree modifierEntree(Entree entree);
	Dessert modifierDessert(Dessert Dessert);
	
	
	
}
