package com.hexaware.easyspay.service;

import java.time.LocalDate;
import java.util.List;

import com.hexaware.easyspay.entities.Benefits;
import com.hexaware.easyspay.entities.Deductions;
import com.hexaware.easyspay.entities.Payroll;
import com.hexaware.easyspay.exception.PayrollNotFoundException;
import com.hexaware.easyspay.exception.BenefitNotFoundException;
import com.hexaware.easyspay.exception.DeductionNotFoundException;

public interface IPayrollProcessorService {

    // Payroll Calculation
    Payroll calculatePayroll(int empId, LocalDate payrollDate) throws PayrollNotFoundException;

    // Payroll Data Verification
    boolean verifyPayrollData(Payroll payroll) throws PayrollNotFoundException;

    // Benefits Management
    Benefits addBenefit(Benefits benefit) throws BenefitNotFoundException;
    Benefits updateBenefit(int benefitId,Benefits benefit) throws BenefitNotFoundException;
    void deleteBenefit(int benefitId) throws BenefitNotFoundException;
    Benefits getBenefitById(int benefitId) throws BenefitNotFoundException;
    List<Benefits> getAllBenefits();

    // Deductions Management
    Deductions addDeduction(Deductions deduction) throws DeductionNotFoundException;
    Deductions updateDeduction(int deductionId,Deductions deduction) throws DeductionNotFoundException;
    void deleteDeduction(int deductionId) throws DeductionNotFoundException;
    Deductions getDeductionById(int deductionId) throws DeductionNotFoundException;
    List<Deductions> getAllDeductions();

    // Payment Processing
    void processPayment(int empId, LocalDate payrollDate) throws PayrollNotFoundException;
}
