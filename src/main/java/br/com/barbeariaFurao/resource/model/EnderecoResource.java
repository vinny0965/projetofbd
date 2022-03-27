package br.com.barbeariaFurao.resource.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EnderecoResource {
	
	@JsonProperty("logradouro")
	private String logradouro;
	
	@JsonProperty("bairro")
	private String bairro;
	
	@JsonProperty("numero")
	private String numero;
	
	@JsonProperty("cep")
	private String cep;
	
	public EnderecoResource(String logradouro, String bairro, String numero, String cep) {
		super();
		this.logradouro = logradouro;
		this.bairro = bairro;
		this.numero = numero;
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	@Override
	public String toString() {
		return "EnderecoResource [logradouro=" + logradouro + ", bairro=" + bairro + ", numero=" + numero + ", cep="
				+ cep + "]";
	}
	
	
	
	

}
