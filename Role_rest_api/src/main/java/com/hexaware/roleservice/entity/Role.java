package com.hexaware.roleservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Role {

	@Id
	private int roleId;
	
	@NotBlank(message= "roleName cannot be blank")
	private String roleName;

	public Role() {
		super();
	}

	public Role(int roleId, @NotBlank(message = "roleName cannot be blank") String roleName) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
	}
	
	

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", roleName=" + roleName + "]";
	}
	
	
}


