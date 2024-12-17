package com.hexaware.easyspay.service;

/**
 * Service implementation for retrieving employee details and their associated role.
 * Fetches employee information from the repository and role details using RestTemplate to combine them into a single response.
 * 
 * Author: Kariyappa D C, Nihar
 * Date:23 November 2024
 */


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import com.hexaware.easyspay.dto.EmpMicroDto;
import com.hexaware.easyspay.dto.EmployeeRoleVO;
import com.hexaware.easyspay.entities.Role;
import com.hexaware.easyspay.repository.IEmployeeRepository;

@Service
public class RoleServiceImp implements IRoleService {

    @Autowired
    private IEmployeeRepository employeeRepo;
    
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public EmployeeRoleVO getEmployeeAndRoleById(int empId) {
        // Fetch only the necessary fields using the repository query
        EmpMicroDto empDto = employeeRepo.findEmployeeDetailsById(empId);

        // Use RestTemplate to get the Role details
        Role role = restTemplate.getForObject(
            "http://localhost:8282/api/roles/getrolebyid/" + empDto.getRoleId(), Role.class);

        // Map to EmployeeRoleVO
        EmployeeRoleVO employeeRoleVo = new EmployeeRoleVO();
        employeeRoleVo.setEmployee(empDto);
        employeeRoleVo.setRole(role);

        return employeeRoleVo;
    }
}

