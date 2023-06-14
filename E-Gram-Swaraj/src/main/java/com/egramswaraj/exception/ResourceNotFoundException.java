package com.egramswaraj.exception;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResourceNotFoundException extends RuntimeException {


	private static final long serialVersionUID = 1L;


	public ResourceNotFoundException() {
		super();
	}

	
	public ResourceNotFoundException(String message) {
		super(message);
	}


}


