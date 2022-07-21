package com.tuhinmaji.rest.webservices.restfulwebservices;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {
	
	public UserNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

//	public UserNotFoundException(Throwable cause) {
//		super(cause);
//		// TODO Auto-generated constructor stub
//	}

}
