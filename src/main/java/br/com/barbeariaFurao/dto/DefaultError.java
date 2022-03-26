package br.com.barbeariaFurao.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DefaultError {
	@JsonProperty
	private int code;
	@JsonProperty
	private String message;
	
	public DefaultError(int code, String message) {
		this.code = code;
		this.message = message;
	}
	
	
}
