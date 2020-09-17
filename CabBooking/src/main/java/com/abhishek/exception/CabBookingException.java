package com.abhishek.exception;
/**
 * 
 */

/**
 * @author Kishori
 *
 */
public class CabBookingException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1280794359872347L;

	public CabBookingException(String errorMessage) {
		super(errorMessage);
	}

	public CabBookingException(String errorMessage, Throwable throwable) {
		super(errorMessage, throwable);
	}
}
