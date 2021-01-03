package com.OZ.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TableResto {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	private Integer numero;
	
	private Integer nbCouvert;
	private double supplement;

	private String type;
	@OneToMany(mappedBy = "Tab")
	private List<Ticket> tickets;
	
}
