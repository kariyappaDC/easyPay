package com.hexaware.easyspay.exception;

/**
 * Custom exception class for handling cases where a compliance report is not found.
 * 
 * This exception is thrown when an operation attempts to retrieve or process a compliance 
 * report that is unavailable or missing in the system.
 * 
 * Author: Kariyappa D C
 * Date: Nov 2024
 */

public class ComplianceReportNotFoundException extends RuntimeException {
    public ComplianceReportNotFoundException(String message) {
        super(message);
    }
}
