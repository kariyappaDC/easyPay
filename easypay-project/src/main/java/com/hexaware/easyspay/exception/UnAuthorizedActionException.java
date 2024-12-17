package com.hexaware.easyspay.exception;

/**
 * Custom exception class for handling unauthorized actions.
 * 
 * This exception is thrown when a user or manager attempts to perform an action 
 * they are not authorized to execute, such as modifying or accessing restricted data.
 * 
 * Author: Nihar Jachak
 * Date: Nov 2024
 */

public class UnAuthorizedActionException  extends RuntimeException{

	public UnAuthorizedActionException(String message) {
		super(message);
	}

	
}
