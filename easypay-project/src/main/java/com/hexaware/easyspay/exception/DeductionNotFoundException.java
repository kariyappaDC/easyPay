package com.hexaware.easyspay.exception;

/**
 * Custom exception class for handling cases where a deduction record is not found.
 * 
 * This exception is thrown when an operation attempts to access or modify a deduction 
 * that does not exist or cannot be located in the system.
 * 
 * Author: Kariyappa D C
 * Date: Nov 2024
 */

public class DeductionNotFoundException extends RuntimeException {
    public DeductionNotFoundException(String message) {
        super(message);
    }
}
