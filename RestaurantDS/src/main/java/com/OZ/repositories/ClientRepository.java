package com.OZ.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.OZ.entities.Client;

public interface ClientRepository extends JpaRepository<Client , Integer>{

}
