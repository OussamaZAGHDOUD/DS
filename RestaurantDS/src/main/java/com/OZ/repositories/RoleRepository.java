package com.OZ.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.OZ.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
