package br.com.barbeariaFurao.resource.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ServicoResource {
	
	@JsonProperty("tipo_servico")
	private String tipoServico;
	
	@JsonProperty("valor")
	private String valor;
	
	@JsonProperty("id_administrador")
	private String idAdministrador;

	public ServicoResource(String tipoServico, String valor, String idAdministrador) {
		super();
		this.tipoServico = tipoServico;
		this.valor = valor;
		this.idAdministrador = idAdministrador;
	}

	public String getTipoServico() {
		return tipoServico;
	}

	public void setTipoServico(String tipoServico) {
		this.tipoServico = tipoServico;
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
