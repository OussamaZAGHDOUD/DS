package com.OZ.services;

import com.OZ.entities.TableResto;

public interface ITableService {

	TableResto ajouterTable(TableResto tableResto);
	TableResto supprimerTable(TableResto tableResto);
	TableResto modifierTable(TableResto tableResto);
	TableResto chercherTable(TableResto tableResto);

}
