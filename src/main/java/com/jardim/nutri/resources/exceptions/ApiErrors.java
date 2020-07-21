package com.jardim.nutri.resources.exceptions;

import java.util.Arrays;
import java.util.List;

public class ApiErrors {
	
	
	private List<String> errors;

	public ApiErrors(List<String> errors) {
		super();
		this.errors = errors;
	}

	public ApiErrors(String message) {
		this.errors = Arrays.asList(message);
	}

	public List<String> getErrors() {
		return errors;
	}

	 
}
