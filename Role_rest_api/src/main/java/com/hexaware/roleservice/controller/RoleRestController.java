package com.hexaware.roleservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.roleservice.entity.Role;
import com.hexaware.roleservice.service.IRoleService;

@RestController
@RequestMapping("/api/roles/")
public class RoleRestController {

    @Autowired
    private IRoleService roleService;

    @PostMapping("/addrole")
    public Role createRole(@Validated @RequestBody Role role) {
        return roleService.createRole(role);
    }

    @GetMapping("getrolebyid/{id}")
    public Role getRoleById(@PathVariable int id) {
        return roleService.getRoleById(id);
    }

    @GetMapping("getrolebyname/{name}")
    public List<Role> getRoleByName(@PathVariable String name) {
        return roleService.getRoleByName(name);
    }

    @GetMapping("getall")
    public List<Role> getAllRoles() {
        return roleService.getAllRoles();
    }

    @PutMapping("updaterole/{id}")
    public Role updateRole(@PathVariable int id, @Validated @RequestBody Role role) {
        return roleService.updateRole(id, role);
    }

    @DeleteMapping("deletebyid/{id}")
    public String deleteRole(@PathVariable int id) {
        roleService.deleteRole(id);
        return "Role deleted successfully.";
    }
}
