package com.jardim.nutri.services.exceptions;

public class UsuarioCadastradoException extends RuntimeException{
	
	public UsuarioCadastradoException() {
		super("Email já cadastrado.");
	}
}
