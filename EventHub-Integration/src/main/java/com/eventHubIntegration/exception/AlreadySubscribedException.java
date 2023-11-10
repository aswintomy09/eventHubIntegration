package com.eventHubIntegration.exception;

public class AlreadySubscribedException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AlreadySubscribedException(String message) {
		super(message);
	}

}
