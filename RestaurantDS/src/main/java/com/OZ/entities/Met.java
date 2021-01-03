package com.OZ.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorColumn(name = "Type")
@JsonSubTypes({ @Type(name = "Dessert", value = Dessert.class), @Type(name = "Entree", value = Entree.class),
	@Type(name = "Plat", value = Plat.class) })
public abstract class Met {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nom;
	private double prix;
	@ManyToMany(mappedBy = "mets")
	private List<Ticket> tickets;
}
