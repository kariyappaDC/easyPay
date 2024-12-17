package com.hexaware.easyspay.service;


/**
 * Test class for ManagerServiceImpl, designed to verify the functionality of the service methods 
 * for the Manager module in the Easyspay Payroll Management System.
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
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
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

import com.hexaware.easyspay.dto.PayrollDTO;
import com.hexaware.easyspay.entities.Employee;
import com.hexaware.easyspay.entities.Leaves;
import com.hexaware.easyspay.entities.Payroll;
import com.hexaware.easyspay.repository.ILeavesRepository;
import com.hexaware.easyspay.repository.IPayrollRepository;

class ManagerServiceImplTest {
	
	@Mock
	private IPayrollRepository payrollrepo;
	
	@Mock
	private ILeavesRepository leavesrepo;
	
	@InjectMocks
	private ManagerServiceImpl managerService;
	
	
	@BeforeEach
	void setUp() {
		
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testReviewTeamPayrolls() {
		 // Mock data setup
        int managerId = 101;

        // Create a mock manager
        Employee manager = new Employee();
        manager.setEmpId(managerId);
        manager.setEmpName("Manager Name");

        // Create mock employees under the manager
        Employee emp1 = new Employee();
        emp1.setEmpId(1);
        emp1.setEmpName("Employee One");
        emp1.setManager(manager);

        Employee emp2 = new Employee();
        emp2.setEmpId(2);
        emp2.setEmpName("Employee Two");
        emp2.setManager(manager);

        // Create mock payrolls for the employees
        Payroll payroll1 = new Payroll();
        payroll1.setPayrollId(1);
        payroll1.setEmployee(emp1);
        payroll1.setGrossPay(5000);
        payroll1.setDeductions(300);
        payroll1.setBenefits(200);
        payroll1.setPayrollDate(LocalDate.now());

        Payroll payroll2 = new Payroll();
        payroll2.setPayrollId(2);
        payroll2.setEmployee(emp2);
        payroll2.setGrossPay(6000);
        payroll2.setDeductions(400);
        payroll2.setBenefits(300);
        payroll2.setPayrollDate(LocalDate.now());

        // Mock repository behavior
        when(payrollrepo.findByEmployeeManagerEmpId(managerId)).thenReturn(Arrays.asList(payroll1, payroll2));

        // Test the service method
        List<PayrollDTO> result = managerService.reviewTeamPayrolls(managerId);

        // Assertions
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(5000, result.get(0).getGrossPay());
        assertEquals(6000, result.get(1).getGrossPay());
        verify(payrollrepo, times(1)).findByEmployeeManagerEmpId(managerId);
    }
	

//	@Test
//	void testApproveLeaveRequest() {
//		
//		int managerId = 101;
//        int leaveId = 201;
//        String status = "Approved";
//        Employee manager = new Employee();
//        manager.setEmpId(managerId);
//
//        Leaves mockLeaveRequest = new Leaves();
//        mockLeaveRequest.setManager(manager);
//
//        when(leavesrepo.findById(leaveId)).thenReturn(Optional.of(mockLeaveRequest));
//        when(leavesrepo.save(mockLeaveRequest)).thenReturn(mockLeaveRequest);
//
//        Leaves result = managerService.approveLeaveRequest(managerId, leaveId, status);
//
//        assertEquals(status, result.getLeaveStatus());
//        verify(leavesrepo).save(mockLeaveRequest);

	
		
		
	//}

}