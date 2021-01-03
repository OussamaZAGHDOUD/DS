package com.OZ.repositories;

import org.springframework.data.repository.NoRepositoryBean;

import com.OZ.entities.Met;

@NoRepositoryBean
public interface MetRepository extends MetBaseRepository<Met> {

//  public Met findByEmail(String email);

}