package br.com.barbeariaFurao.resource.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CupomDescontoResource {

	@JsonProperty("codigo")
	private String codigo;
	
	@JsonProperty("valor")
	private String valor;
	
	@JsonProperty("id_administrador")
	private String idAdministrador;

	public CupomDescontoResource(String codigo, String valor, String idAdministrador) {
		super();
		this.codigo = codigo;
		this.valor = valor;
		this.idAdministrador = idAdministrador;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getIdAdministrador() {
		return idAdministrador;
	}

	public void setIdAdministrador(String idAdministrador) {
		this.idAdministrador = idAdministrador;
	}

	
}
