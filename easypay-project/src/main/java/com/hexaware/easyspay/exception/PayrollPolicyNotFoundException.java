package com.hexaware.easyspay.exception;

/**
 * Custom exception class for handling cases where a payroll policy is not found.
 * 
 * This exception is thrown when an operation attempts to retrieve a payroll policy 
 * that does not exist or is unavailable in the system.
 * 
 * Author: Kariyappa D C
 * Date: November 2024
 */


public class PayrollPolicyNotFoundException extends RuntimeException {
    public PayrollPolicyNotFoundException(String message) {
        super(message);
    }
}
