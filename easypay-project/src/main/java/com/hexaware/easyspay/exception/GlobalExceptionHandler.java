package com.hexaware.easyspay.exception;


/**
 * GlobalExceptionHandler is a centralized handler for managing exceptions across the application.
 * 
 * This class ensures that the application gracefully handles specific exceptions by providing
 * appropriate HTTP response codes and custom error messages for each scenario.
 * 
 * Authors:
 * - Kariyappa D C
 * - Nihar Jachak
 * 
 * Date: November 2024
 */

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    
    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<String> handleEmployeeNotFound(EmployeeNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> handleUserNotFound(UserNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PayrollPolicyNotFoundException.class)
    public ResponseEntity<String> handlePayrollPolicyNotFound(PayrollPolicyNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(ComplianceReportNotFoundException.class)
    public ResponseEntity<String> handleComplianceReportNotFound(ComplianceReportNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
    
    
    
    
      //exception for payroll.................
    
    
    
    @ExceptionHandler(PayrollNotFoundException.class)
    public ResponseEntity<String> handlePayrollNotFound(PayrollNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BenefitNotFoundException.class)
    public ResponseEntity<String> handleBenefitNotFound(BenefitNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DeductionNotFoundException.class)
    public ResponseEntity<String> handleDeductionNotFound(DeductionNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    

	@ExceptionHandler(LeavesRequestException.class)
	public ResponseEntity<String> handleLeavesRequestException (LeavesRequestException e){
		return  new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);	
	}
	
	public ResponseEntity<String> handleUnauthorizedActionException (UnAuthorizedActionException e){
		return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
	}
    
   
}
