package com.OZ.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter 
@Setter
public class TableResto {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	private Integer numero;
	
	private Integer nbCouvert;
	private double supplement;
	private String type;
	
	@OneToMany(mappedBy = "tableResto")
	@JsonIgnore
	private List<Ticket> tickets;
	
}
