package com.hexaware.easyspay.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
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

import com.hexaware.easyspay.dto.ComplianceReportReceiveDTO;
import com.hexaware.easyspay.dto.EmployeeDto;
import com.hexaware.easyspay.dto.EmployeeReceiveDTO;
import com.hexaware.easyspay.entities.Benefits;
import com.hexaware.easyspay.entities.ComplianceReport;
import com.hexaware.easyspay.entities.Deductions;
import com.hexaware.easyspay.entities.Employee;
import com.hexaware.easyspay.entities.PayrollPolicy;
import com.hexaware.easyspay.entities.Role;
import com.hexaware.easyspay.entities.User;
import com.hexaware.easyspay.repository.IBenefitsRepository;
import com.hexaware.easyspay.repository.IComplianceReportRepository;
import com.hexaware.easyspay.repository.IDeductionsRepository;
import com.hexaware.easyspay.repository.IEmployeeRepository;
import com.hexaware.easyspay.repository.IPayrollPolicyRepository;
import com.hexaware.easyspay.repository.IRoleRepository;
import com.hexaware.easyspay.repository.IUserRepository;

class AdminHrManagerServiceImpTest {

    @Mock
    private IEmployeeRepository employeeRepo;

    @Mock
    private IPayrollPolicyRepository payrollPolicyRepo;

    @Mock
    private IComplianceReportRepository complianceReportRepo;

    @Mock
    private IUserRepository userRepo;
    
    @Mock
    private IDeductionsRepository deductionsRepo;

    @Mock
    private IBenefitsRepository benefitsRepo;

    @Mock
    private IRoleRepository roleRepo;

    @InjectMocks
    private AdminHrManagerServiceImp service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    // Employee Management
    @Test
    void testAddEmployee_Success() {
        // Arrange
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmpName("John Doe");
        employeeDto.setPosition("Developer");
        employeeDto.setEmpDepartment("IT");
        employeeDto.setEmpsalary(50000.0);
        employeeDto.setJoinDate(LocalDate.of(2023, 1, 1));
        employeeDto.setUserId(1);
        employeeDto.setDeductionId(1);
        employeeDto.setBenefitId(1);
        employeeDto.setRoleId(1);
        employeeDto.setManagerId(2);

        User mockUser = new User();
        Deductions mockDeductions = new Deductions();
        Benefits mockBenefits = new Benefits();
        Role mockRole = new Role();
        Employee mockManager = new Employee();
        Employee mockEmployee = new Employee();

        when(userRepo.findById(1)).thenReturn(Optional.of(mockUser));
        when(deductionsRepo.findById(1)).thenReturn(Optional.of(mockDeductions));
        when(benefitsRepo.findById(1)).thenReturn(Optional.of(mockBenefits));
        when(roleRepo.findById(1)).thenReturn(Optional.of(mockRole));
        when(employeeRepo.findById(2)).thenReturn(Optional.of(mockManager));
        when(employeeRepo.save(any(Employee.class))).thenReturn(mockEmployee);

        // Act
        Employee result = service.addEmployee(employeeDto);

        // Assert
        assertNotNull(result);
       
        verify(deductionsRepo).findById(1);
        verify(benefitsRepo).findById(1);
        verify(roleRepo).findById(1);
        verify(employeeRepo).findById(2);
        verify(employeeRepo).save(any(Employee.class));
    }

 

    @Test
    void testDeleteEmployee_Success() {
        service.deleteEmployee(1);
        verify(employeeRepo).deleteById(1);
    }

    @Test
    void testGetEmployeeById_Success() {
        Employee employee = new Employee();
        employee.setEmpId(1);
        employee.setEmpName("John Doe");

        when(employeeRepo.findById(1)).thenReturn(Optional.of(employee));

        EmployeeReceiveDTO result = service.getEmployeeById(1);

        assertNotNull(result);
        assertEquals("John Doe", result.getEmpName());
    }

    @Test
    void testGetAllEmployees_Success() {
        Employee employee1 = new Employee();
        Employee employee2 = new Employee();

        when(employeeRepo.findAll()).thenReturn(Arrays.asList(employee1, employee2));

        List<EmployeeReceiveDTO> result = service.getAllEmployees();

        assertNotNull(result);
        assertEquals(2, result.size());
    }

    // Payroll Policy Management
    @Test
    void testAddPayrollPolicy_Success() {
        PayrollPolicy policy = new PayrollPolicy();
        policy.setPolicyName("Standard Policy");

        when(payrollPolicyRepo.save(policy)).thenReturn(policy);

        PayrollPolicy result = service.addPayrollPolicy(policy);

        assertNotNull(result);
        assertEquals("Standard Policy", result.getPolicyName());
        verify(payrollPolicyRepo).save(policy);
    }

    @Test
    void testUpdatePayrollPolicy_Success() {
        PayrollPolicy existingPolicy = new PayrollPolicy();
        existingPolicy.setPolicyId(1);
        existingPolicy.setPolicyName("Old Policy");

        PayrollPolicy updatedPolicy = new PayrollPolicy();
        updatedPolicy.setPolicyId(1);
        updatedPolicy.setPolicyName("Updated Policy");

        when(payrollPolicyRepo.save(updatedPolicy)).thenReturn(updatedPolicy);

        PayrollPolicy result = service.updatePayrollPolicy(1, updatedPolicy);

        assertNotNull(result);
        assertEquals("Updated Policy", result.getPolicyName());
        verify(payrollPolicyRepo).save(updatedPolicy);
    }

    @Test
    void testDeletePayrollPolicy_Success() {
        service.deletePayrollPolicy(1);
        verify(payrollPolicyRepo).deleteById(1);
    }

    @Test
    void testGetPayrollPolicyById_Success() {
        PayrollPolicy policy = new PayrollPolicy();
        policy.setPolicyId(1);
        policy.setPolicyName("Policy Name");

        when(payrollPolicyRepo.findById(1)).thenReturn(Optional.of(policy));

        PayrollPolicy result = service.getPayrollPolicyById(1);

        assertNotNull(result);
        assertEquals("Policy Name", result.getPolicyName());
    }

    @Test
    void testGetAllPayrollPolicies_Success() {
        PayrollPolicy policy1 = new PayrollPolicy();
        PayrollPolicy policy2 = new PayrollPolicy();

        when(payrollPolicyRepo.findAll()).thenReturn(Arrays.asList(policy1, policy2));

        List<PayrollPolicy> result = service.getAllPayrollPolicies();

        assertNotNull(result);
        assertEquals(2, result.size());
    }



    @Test
    void testDeleteComplianceReport_Success() {
        service.deleteComplianceReport(1);
        verify(complianceReportRepo).deleteById(1);
    }

    @Test
    void testGetComplianceReportById_Success() {
        ComplianceReport report = new ComplianceReport();
        report.setReportId(1);
        report.setComplianceStatus("Compliant");

        when(complianceReportRepo.findById(1)).thenReturn(Optional.of(report));

        ComplianceReportReceiveDTO result = service.getComplianceReportById(1);

        assertNotNull(result);
        assertEquals("Compliant", result.getComplianceStatus());
    }

    @Test
    void testGetAllComplianceReports_Success() {
        ComplianceReport report1 = new ComplianceReport();
        ComplianceReport report2 = new ComplianceReport();

        when(complianceReportRepo.findAll()).thenReturn(Arrays.asList(report1, report2));

        List<ComplianceReport> result = service.getAllComplianceReports();

        assertNotNull(result);
        assertEquals(2, result.size());
    }
}
