package org.si.exception;
// this class used to throw custom exception
//add comment
//add comment 2
public class InvalidFeildException extends RuntimeException {

	private String message;

	public InvalidFeildException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
}
