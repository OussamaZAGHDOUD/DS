package com.OZ.repositories;

import org.springframework.transaction.annotation.Transactional;

import com.OZ.entities.Plat;
@Transactional
public interface PlatRepository extends  MetBaseRepository<Plat> {

}
