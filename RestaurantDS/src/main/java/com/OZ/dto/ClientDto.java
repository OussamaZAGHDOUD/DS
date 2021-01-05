package com.OZ.dto;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDto {

	private Integer id=0;
	@NotBlank(message = "le nom est obligatoire !")
	private String nom;
	@NotBlank(message = "le prenom est obligatoire !")
	private String prenom;
	@Past(message = "la date est invalide ! ")
	private LocalDate dateNaissance;
	@Email(message = "L'adresse email est invalide !")
	private String courriel;
	@NotBlank(message = "le numero de téléphone est obligatoire !")
	private String telephone;

}
