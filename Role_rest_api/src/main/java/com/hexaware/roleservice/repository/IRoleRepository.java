package com.hexaware.roleservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.roleservice.entity.Role;


@Repository
public interface IRoleRepository extends  JpaRepository<Role, Integer> {

	 public List <Role> findByRoleName(String roleName);
	
}
