package com.OZ.dto;

import java.util.List;

import com.OZ.entities.Ticket;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MetDto {
	
	private Integer id;
	private String nom;
	private double prix;

}
