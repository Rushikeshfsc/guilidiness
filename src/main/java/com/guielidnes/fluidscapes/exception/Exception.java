package com.guielidnes.fluidscapes.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class Exception  extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6638304404756797013L;
	
	private String errormessage;
	
	public Exception(String errormessage) {
		super(errormessage);
	}
	
	public String getErrormessage() {
		return errormessage;
	}
	
	public void setErrormessage(String errormessage ) {
		this.errormessage=errormessage;
	}

}
