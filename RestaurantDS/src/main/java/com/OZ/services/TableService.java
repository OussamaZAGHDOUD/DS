package com.OZ.services;

import org.springframework.stereotype.Service;

import com.OZ.entities.TableResto;
import com.OZ.exceptions.TableNotFoundException;
import com.OZ.repositories.TableRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TableService implements ITableService {
	private TableRepository tableRepository;

	@Override
	public TableResto ajouterTable(TableResto tableResto) {

		return tableRepository.save(tableResto);

	}

	@Override
	public TableResto supprimerTable(TableResto tableResto) {
		TableResto t = chercherTable(tableResto);
		tableRepository.deleteById(tableResto.getNumero());
		return t;
	}

	@Override
	public TableResto modifierTable(TableResto tableResto) {
		TableResto tableRestoInBase = chercherTable(tableResto);
		tableRestoInBase.setNbCouvert(tableResto.getNbCouvert());
		tableRestoInBase.setSupplement(tableResto.getSupplement());
		tableRestoInBase.setTickets(tableResto.getTickets());
		tableRestoInBase.setType(tableResto.getType());
		return 		tableRepository.save(tableRestoInBase);

	}

	@Override
	public TableResto chercherTable(TableResto tableResto) {

		return tableRepository.findById(tableResto.getNumero()).orElseThrow(() -> new TableNotFoundException());
	}

}
