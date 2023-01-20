 package com.example.demo.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class notfound extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public notfound(String Message) {
		super(Message);
	}
}
