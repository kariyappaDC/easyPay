package com.hexaware.easyspay.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.hexaware.easyspay.entities.User;



@Repository
public interface IUserRepository extends JpaRepository<User,Integer>{

	Optional<User> findByUserName(String username);
	
}
