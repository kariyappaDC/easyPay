package com.hexaware.easyspay.exception;

/**
 * Custom exception class for handling cases where an employee is not found.
 * 
 * This exception is thrown when an operation attempts to retrieve an employee 
 * that does not exist or is unavailable in the system.
 * 
 * Author: Nihar Jachak , kariyappa D C 
 * Date: November 2024
 **/

public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(String message) {
        super(message);
    }
}
