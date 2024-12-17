package com.hexaware.easyspay.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.hexaware.easyspay.entities.*;
import com.hexaware.easyspay.repository.*;

class PayrollProcessorServiceImpTest {

    @Mock
    private IEmployeeRepository employeeRepo;

    @Mock
    private IPayrollRepository payrollRepo;

    @Mock
    private IPayrollPolicyRepository payrollPolicyRepo;

    @Mock
    private IBenefitsRepository benefitsRepo;

    @Mock
    private IDeductionsRepository deductionsRepo;

    @Mock
    private IAttendanceRepository attendanceRepo;

    @InjectMocks
    private PayrollProcessorServiceImp payrollService;

    private Employee mockEmployee;
    private PayrollPolicy mockPolicy;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        // Set up mock Employee
        mockEmployee = new Employee();
        mockEmployee.setEmpId(1);
        mockEmployee.setEmpsalary(50000.0);

        // Set up mock PayrollPolicy
        mockPolicy = new PayrollPolicy();
        mockPolicy.setPolicyId(1);
        mockPolicy.setOvertimeRate(200.0);
    }

    
    // Test Case: Calculate Payroll - Employee Not Found
    @Test
    void testCalculatePayroll_EmployeeNotFound() {
        when(employeeRepo.findById(1)).thenReturn(Optional.empty());

        Exception exception = assertThrows(RuntimeException.class, () ->
                payrollService.calculatePayroll(1, LocalDate.of(2024, 11, 1)));

        assertEquals("Employee not found with ID: 1", exception.getMessage());
    }



    // Test Case: Verify Payroll Data - Invalid
    @Test
    void testVerifyPayrollData_Invalid() {
        Payroll mockPayroll = new Payroll();
        mockPayroll.setGrossPay(-100.0); // Invalid gross pay

        boolean result = payrollService.verifyPayrollData(mockPayroll);
        assertFalse(result, "Payroll data verification should fail for invalid data");
    }

    // Test Case: Add Benefit - Success
    @Test
    void testAddBenefit_Success() {
        Benefits mockBenefit = new Benefits();
        mockBenefit.setBenifitName("Health Insurance");
        mockBenefit.setBenefitAmount(2000.0);

        when(benefitsRepo.save(mockBenefit)).thenReturn(mockBenefit);

        Benefits result = payrollService.addBenefit(mockBenefit);

        assertNotNull(result, "Benefit should be saved successfully");
        assertEquals("Health Insurance", result.getBenifitName(), "Benefit name mismatch");
    }

    // Test Case: Add Deduction - Success
    @Test
    void testAddDeduction_Success() {
        Deductions mockDeduction = new Deductions();
        mockDeduction.setDeductionName("Tax");
        mockDeduction.setDeductionAmount(3000.0);

        when(deductionsRepo.save(mockDeduction)).thenReturn(mockDeduction);

        Deductions result = payrollService.addDeduction(mockDeduction);

        assertNotNull(result, "Deduction should be saved successfully");
        assertEquals("Tax", result.getDeductionName(), "Deduction name mismatch");
    }


}
