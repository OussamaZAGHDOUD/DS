package com.OZ.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.OZ.entities.Met;

public interface MetBaseRepository<T extends Met> extends JpaRepository<T, Integer> {

}
