package com.hexaware.easyspay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hexaware.easyspay.dto.EmpMicroDto;
import com.hexaware.easyspay.entities.Employee;


@Repository
public interface IEmployeeRepository extends JpaRepository<Employee,Integer> {

    @Query("SELECT new com.hexaware.easyspay.dto.EmpMicroDto(e.empName, e.empDepartment, e.position, e.role.roleID) " +
            "FROM Employee e WHERE e.empId = :empId")
     EmpMicroDto findEmployeeDetailsById(@Param("empId") int empId);
	


}
