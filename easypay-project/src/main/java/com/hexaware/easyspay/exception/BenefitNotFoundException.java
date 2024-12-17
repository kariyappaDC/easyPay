package com.hexaware.easyspay.exception;

/**
 * Custom exception class for handling cases where a benefit record is not found.
 * 
 * This exception is thrown when an operation attempts to access or modify a benefit 
 * that does not exist or cannot be located in the system.
 * 
 * Author: Kariyappa D C
 * Date: November 2024
 */



public class BenefitNotFoundException extends RuntimeException {
    public BenefitNotFoundException(String message) {
        super(message);
    }
}
