package com.OZ.repositories;

import org.springframework.transaction.annotation.Transactional;

import com.OZ.entities.Dessert;
@Transactional
public interface DessertRepository extends MetBaseRepository<Dessert>{

}
