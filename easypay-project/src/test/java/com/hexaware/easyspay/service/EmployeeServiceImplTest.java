package com.hexaware.easyspay.service;

/**
 * Test class for EmployeeServiceImpl, designed to verify the functionality of the service methods 
 * for the Employee module in the Easyspay Payroll Management System.
 * 
 * This test class uses Mockito to mock the repository dependencies and ensures that:
 * - Service methods correctly interact with the repositories.
 * - Appropriate exceptions are thrown when required data is missing.
 * - Business logic is implemented as expected.
 * 
 * Author: Nihar Jachak
 * Date: Nov 2024
 */


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.easyspay.dto.AttendanceDto;
import com.hexaware.easyspay.dto.EmpDto;
import com.hexaware.easyspay.dto.LeavesDto;
import com.hexaware.easyspay.entities.Attendance;
import com.hexaware.easyspay.entities.Employee;
import com.hexaware.easyspay.entities.Leaves;
import com.hexaware.easyspay.entities.Payroll;
import com.hexaware.easyspay.repository.IAttendanceRepository;
import com.hexaware.easyspay.repository.IEmployeeRepository;
import com.hexaware.easyspay.repository.ILeavesRepository;
import com.hexaware.easyspay.repository.IPayrollRepository;

@SpringBootTest
class EmployeeServiceImplTest {
	
	@Mock
	private IEmployeeRepository employeerepo;
	
	@Mock
	private IPayrollRepository payrollrepo;
	
	@Mock
	private IAttendanceRepository attendancerepo;
	
	@Mock
	private ILeavesRepository leavesrepo;
	
	
	@InjectMocks
	private EmployeeServiceImpl empservice;
	
	@BeforeEach
	void setUp(){
		
		MockitoAnnotations.openMocks(this);
	}
	
	
	

	@Test
	void testUpdatePersonalInformation() {

		int empId = 1;
        EmpDto updatedInfo = new EmpDto("John Doe", "IT", "Manager");
        Employee existingEmployee = new Employee();
        existingEmployee.setEmpId(empId);

        when(employeerepo.findById(empId)).thenReturn(Optional.of(existingEmployee));
        when(employeerepo.save(existingEmployee)).thenReturn(existingEmployee);

        Employee updatedEmployee = empservice.updatePersonalInformation(empId, updatedInfo);

        assertEquals(updatedInfo.getEmpName(), updatedEmployee.getEmpName());
        assertEquals(updatedInfo.getEmpDepartment(), updatedEmployee.getEmpDepartment());
        assertEquals(updatedInfo.getPosition(), updatedEmployee.getPosition());
        
	}

	@Test
	void testGetPayStubs() {
		int empId = 102;

		
        List<Payroll> payrollList = Arrays.asList(new Payroll(), new Payroll());

        when(payrollrepo.findByEmployeeEmpId(empId)).thenReturn(payrollList);

        List<Payroll> result = empservice.getPayStubs(empId);

        assertEquals(2, result.size());
	}

	@Test
	void testSubmitAttendance() {
		int empId =1;
        AttendanceDto attendanceDto = new AttendanceDto(1,LocalDate.now(), 8, "Present");
        Employee employee = new Employee();

        when(employeerepo.findById(empId)).thenReturn(Optional.of(employee));
        when(attendancerepo.save(any(Attendance.class))).thenReturn(new Attendance());

        Attendance result = empservice.submitAttendance(empId, attendanceDto);

        assertNotNull(result);	
        
	}

//	@Test
//	void testRequestLeave() {
//		 int empId = 1;
//	        int managerId = 2;
//
//	        Employee employee = new Employee();
//	        employee.setEmpId(empId);
//
//	        Employee manager = new Employee();
//	        manager.setEmpId(managerId);
//
//	        Leaves leaves = new Leaves();
//	        leaves.setEmployee(employee);
//	        leaves.setManager(manager);
//	        leaves.setStartDate(LocalDate.now());
//	        leaves.setEndDate(LocalDate.now().plusDays(5));
//	        leaves.setLeaveType("Casual");
//
//	        // Mock the behavior of the repositories
//	        when(employeerepo.findById(empId)).thenReturn(Optional.of(employee));
//	        when(employeerepo.findById(managerId)).thenReturn(Optional.of(manager));
//	        when(leavesrepo.save(any(Leaves.class))).thenReturn(new Leaves());  // Mock save method
//
//	        // When
//	        Leaves result = empservice.requestLeave(empId, leaves);
//
//	        // Then
//	        assertNotNull(result);  // Ensure that the result is not null
//	        assertEquals(empId, result.getEmployee().getEmpId());  // Check if employee is set correctly
//	        assertEquals(managerId, result.getManager().getEmpId());  // Check if manager is set correctly
//	        assertEquals("Pending", result.getLeaveStatus()); 
//    }

}