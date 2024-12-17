package com.hexaware.roleservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.roleservice.entity.Role;
import com.hexaware.roleservice.repository.IRoleRepository;


@Service
public class RoleServiceImpl implements IRoleService {
	
	
	@Autowired
	private IRoleRepository roleRepository;

	@Override
	public Role createRole(Role role) {
		// TODO Auto-generated method stub
		return roleRepository.save(role);
	}

	@Override
	public Role getRoleById(int roleID) {
		// TODO Auto-generated method stub
		return roleRepository.findById(roleID).orElseThrow(null);
	}

	@Override
	public List<Role> getRoleByName(String roleName) {
		// TODO Auto-generated method stub
		return roleRepository.findByRoleName(roleName);
	}
	

	@Override
	public List<Role> getAllRoles() {
		// TODO Auto-generated method stub
		return roleRepository.findAll();
	}

	@Override
	public Role updateRole(int roleID, Role role) {
		Role existingRole = getRoleById(roleID);
		existingRole.setRoleName(role.getRoleName());
		
		return roleRepository.save(existingRole);
	}

	@Override
	public void deleteRole(int roleID) {
		roleRepository.deleteById(roleID);

	}

	

}
