package com.OZ.services;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.OZ.entities.TableResto;
import com.OZ.exceptions.TableNotFoundException;
import com.OZ.repositories.TableRepository;
import com.OZ.repositories.TicketRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TableService implements ITableService {
	private TableRepository tableRepository;
	private TicketRepository ticketRepository;

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
		return tableRepository.save(tableRestoInBase);

	}

	@Override
	public TableResto chercherTable(TableResto tableResto) {

		return tableRepository.findById(tableResto.getNumero()).orElseThrow(() -> new TableNotFoundException());
	}

	@Override
	public TableResto plusReserve() {

		List<TableResto> listOfTables = ticketRepository.findAll().stream().map(t -> t.getTableResto())
				.collect(Collectors.toList());
		List<TableResto> listOfTablesDistinct = listOfTables.stream().distinct().collect(Collectors.toList());

		HashMap<TableResto, Integer> hm = new HashMap<TableResto, Integer>();
		int max = 0;
		TableResto plusReservee = null;
		for (TableResto t : listOfTablesDistinct) {
			int x = Collections.frequency(listOfTables, t);
			hm.put(t, x);
			if (max < x) {
				max = x;
				plusReservee = t;
			}
		}

		return plusReservee;
	}

}
