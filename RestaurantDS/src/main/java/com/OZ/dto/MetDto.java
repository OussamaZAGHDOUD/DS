package com.OZ.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MetDto {

	private Integer id;
	@NotNull
	private String nom;
	@NotNull
	private double prix;
	@Pattern(regexp = "^(Plat|Entree|Dessert){1}$", message = "vous devez choisir type de plat valide")
	private String type;

}
