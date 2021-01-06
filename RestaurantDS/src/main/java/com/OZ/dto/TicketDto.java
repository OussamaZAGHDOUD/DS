package com.OZ.dto;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import com.OZ.entities.Client;
import com.OZ.entities.Met;
import com.OZ.entities.TableResto;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
public class TicketDto {
	
	private Integer	numero;
	@PastOrPresent
	private LocalDateTime date;
	@Min(2)
	@Max(10)
	private Integer nbCouvert;
	private double addition;
	@NotNull
	private Client client;
	@NotNull
	private TableResto tableResto; 
	private List<MetDto> mets;
}
