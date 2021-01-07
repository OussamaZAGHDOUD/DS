package com.OZ.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer	numero;
	private LocalDateTime date;
	private Integer nbCouvert;
	private double addition;
	
	@ManyToOne
	private Client client;
	@ManyToOne
	private TableResto tableResto; 
	@ManyToMany
	@JoinTable(name = "MET_Ticket",
		joinColumns = {@JoinColumn(name="Ticket_id")},
		inverseJoinColumns = {@JoinColumn(name="Met_id")	})
	private List<Met> mets;
	
	public double getAddition() {
		return mets.stream().mapToDouble(s->s.getPrix()).sum()   + this.tableResto.getSupplement();
		//return addition;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return numero+"  "+date+"  "+nbCouvert+"  "+addition;
	}
}
