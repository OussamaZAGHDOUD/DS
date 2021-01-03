package com.OZ.repositories;

import org.springframework.transaction.annotation.Transactional;

import com.OZ.entities.Entree;
@Transactional
public interface EntreeRepository extends MetBaseRepository<Entree> {

}
