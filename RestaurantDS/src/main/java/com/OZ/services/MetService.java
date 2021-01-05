package com.OZ.services;

import org.springframework.stereotype.Service;

import com.OZ.entities.Met;
import com.OZ.repositories.MetRepository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Service
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MetService implements IMetService{
	
	private MetRepository metRepository;
	
	@Override
	public Met ajouterMet(Met met) {
		return 	metRepository.save(met);
	}

}
