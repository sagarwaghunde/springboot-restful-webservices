package org.saga.springbootrestfulwebservices.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class EmailAlreadyExistsException extends RuntimeException {

	private static final long serialVersionUID = 1121L;
	private String message;
	
	public EmailAlreadyExistsException(String message) {
		super(message);
	}
}
