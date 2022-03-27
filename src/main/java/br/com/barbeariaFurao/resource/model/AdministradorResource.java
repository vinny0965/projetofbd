package br.com.barbeariaFurao.resource.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AdministradorResource {
	
	@JsonProperty("nome")
	private String nome;
	
	@JsonProperty("cpf")
	private String cpf;
	
	@JsonProperty("login")
	private String login;
	
	@JsonProperty("senha")
	private String senha;
	
	@JsonProperty("email")
	private String email;
	
	@JsonProperty("sexo")
	private String sexo;
	
	@JsonProperty("telefone")
	private String telefone;
	
	@JsonProperty("data_nascimento")
	private String dataNascimento;
	
	@JsonProperty("id_endereco")
	private String endereco;

	public AdministradorResource(String nome, String cpf, String login, String senha, String email, String sexo,
			String telefone, String dataNascimento, String endereco) {
		this.nome = nome;
		this.cpf = cpf;
		this.login = login;
		this.senha = senha;
		this.email = email;
		this.sexo = sexo;
		this.telefone = telefone;
		this.dataNascimento = dataNascimento;
		this.endereco = endereco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		return "AdministradorResource [nome=" + nome + ", cpf=" + cpf + ", login=" + login + ", senha=" + senha
				+ ", email=" + email + ", sexo=" + sexo + ", telefone=" + telefone + ", dataNascimento="
				+ dataNascimento + ", endereco=" + endereco + "]";
	}
	
	

}
