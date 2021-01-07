package com.OZ.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.OZ.entities.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	Optional<User> findByUserName(String userName);
}
