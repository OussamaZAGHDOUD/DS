package com.OZ.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer	numero;
	private LocalDate date;
	private Integer nbCouvert;
	private double addition;
	
	@ManyToOne
	private Client client;
	@ManyToOne
	private TableResto Tab; 
	@ManyToMany
	@JoinTable(name = "MET_Ticket",
		joinColumns = {@JoinColumn(name="Ticket_id")},
		inverseJoinColumns = {@JoinColumn(name="Met_id")	})
	private List<Met> mets;
}
