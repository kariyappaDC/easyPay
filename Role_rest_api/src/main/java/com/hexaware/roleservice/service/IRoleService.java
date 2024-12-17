package com.hexaware.roleservice.service;

import java.util.List;



import com.hexaware.roleservice.entity.Role;


public interface IRoleService {
	
	
	Role createRole(Role role);
    Role getRoleById(int roleID);
    List<Role> getRoleByName(String roleName);
    List<Role> getAllRoles();
    Role updateRole(int roleID, Role role);
    void deleteRole(int roleID);

}
