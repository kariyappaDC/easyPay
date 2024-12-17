package com.hexaware.easyspay.exception;

/**
 * Custom exception class for handling errors related to attendance submission.
 * 
 * This exception is thrown when there is a failure or issue in submitting attendance,
 * such as invalid input data or system-related errors during the attendance submission process.
 * 
 * Author: Nihar Jachak
 * Date: Nov 2024
 */

public class AttendanceSubmissionException extends RuntimeException {

	public AttendanceSubmissionException(String message) {
		super(message);
	}
	

}
